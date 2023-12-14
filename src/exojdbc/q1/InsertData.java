package exojdbc.q1;

import exojdbc.connexion.Connexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author akhmim
 */
public class InsertData {

    public static boolean insertData() {

        try {
//            String req = "INSERT INTO `DevData` VALUES('ALAMI', 'Lundi', 1);"
//                    + "INSERT INTO `DevData` VALUES('WAFI', 'Mardi', 2);"
//                    + "INSERT INTO `DevData` VALUES('SLAMI', 'Jeudi', 1);";

            String req1 = "INSERT INTO `DevData` VALUES('ALAMI', 'Lundi', 1); ";
            String req2 = "INSERT INTO `DevData` VALUES('WAFI', 'Lundi', 2);";
            String req3 = "INSERT INTO `DevData`(`Developpeur`, `Jour`, `NbScripts`) VALUES('SLAMI', 'Jeudi', 3);";

            Connection cn = Connexion.getConnection();
            Statement st = cn.createStatement();

            st.executeUpdate(req1);
            st.executeUpdate(req2);
            st.executeUpdate(req3);

            st.close();
            System.out.println("Success d'insertion des donnees");

//            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout des donnees:" + ex.getMessage());
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        try {
            insertData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
