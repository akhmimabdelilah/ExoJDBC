package exojdbc.q2;

import exojdbc.connexion.Connexion;
import exojdbc.dao.IDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.DevData;
import java.sql.Connection;
/*
 * @author akhmim
 */

public class ExoJDBC implements IDao<DevData> {

    @Override
    public List<DevData> nbMaxScript() {
        List<DevData> devdata = new ArrayList<>();
        Statement st = null;

        try {
            String req = "SELECT Developpeur, Jour, MAX(NbScripts) FROM DevData GROUP BY Developpeur, Jour;";

            Connection cn = Connexion.getConnection();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                devdata.add(new DevData(
                        rs.getString("Developpeur"),
                        rs.getString("Jour"),
                        rs.getInt("NbScripts")));
            }
            st.close();
            System.out.println("Success d'affichage de nb max");

        } catch (SQLException ex) {
            System.out.println("Erreur d'execution de la requete: " + ex.getMessage());
        }
        return devdata;
    }

    @Override
    public List<DevData> triDeveloper() {
        // String db = "tp1";
        List<DevData> devdata = new ArrayList<>();

        try {
            String req = " SELECT Developpeur, SUM(NbScripts) as c FROM DevData group by Developpeur ORDER BY c DESC;";

            Statement st = Connexion.getConnection().createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                devdata.add(new DevData(
                        rs.getString("Developpeur"),
                        rs.getInt("NbScripts")));
            }
            st.close();
            System.out.println("Success de list de developpeur");

        } catch (SQLException ex) {
            System.out.println("Erreur d'execution de la requete: " + ex.getMessage());
        }
        return devdata;
    }

    @Override
    public List<DevData> NbScriptsSem(String Developpeur) {
        // String db = "tp1";

        List<DevData> devdata = new ArrayList<>();

        try {
            String req = "SELECT Developpeurs, SUM(NbScripts) as s FROM DevData WHERE Developpeur = " + Developpeur;

            Statement st = Connexion.getConnection().createStatement();
            System.out.println("Success de list de developpeur");
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                devdata.add(new DevData(
                        rs.getString("Developpeur"),
                        rs.getInt("s")));
            }

        } catch (SQLException ex) {
            System.out.println("Erreur d'execution de la requete: " + ex.getMessage());
        }
        return devdata;
    }

    public static void main(String[] args) throws Exception {

        try {
            ExoJDBC instance = new ExoJDBC();
            List<DevData> nbMaxScript = instance.nbMaxScript();
            System.out.println(nbMaxScript);

            List<DevData> triDeveloper = instance.triDeveloper();
            System.out.println(triDeveloper);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
