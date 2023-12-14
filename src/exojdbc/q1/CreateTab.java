package exojdbc.q1;

import exojdbc.connexion.Connexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/*
 * @author akhmim
 */
public class CreateTab {

    public static boolean createTab() {

        try {
            String req = "CREATE TABLE DevData (`Developpeur` VARCHAR(32), `Jour` CHAR(11), `NbScripts` INTEGER);";
            Connection cn = Connexion.getConnection();
            Statement st = cn.createStatement();
            st.executeUpdate(req);
            st.close();
            System.out.println("Table has been created successfully!");
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'une table:" + ex.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        try {
            createTab();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
