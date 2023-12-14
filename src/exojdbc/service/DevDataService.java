/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exojdbc.service;

// import java.util.logging.Level;
// import java.util.logging.Logger;
import beans.DevData;
import exojdbc.connexion.Connexion;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;

/**
 *
 * @author Bright
 */
//public class DevDataService implements IDao<DevData> {
public class DevDataService {

    public boolean create(DevData o) {
        try {
            String req
                    = "insert into client values (null,'"
                    + o.getDeveloppeur()
                    + "', '"
                    + o.getJour()
                    + "', '"
                    + o.getNbScripts()
                    + "')";
            Statement st = Connexion.getConnection().createStatement();
            if (st.executeUpdate(req) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Erreur d'ajout d'un client:" + ex.getMessage());
        }
        return false;
    }

   
    public boolean update(DevData o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public boolean delete(DevData o) {
        //   String req = "delete from client where id = "+ o.getDeveloppeur();
        //   try {
        //       Statement st = Connexion.getConnection().createStatement();
        //       st.executeUpdate(req);
        //       return true;
        //   } catch (SQLException ex) {
        //       System.out.println("Erreur de suppression d'un client:" +ex.getMessage());
        //   }
        return false;
    }

  
    public DevData findById(int id) {
        //   DevData client = null;
        //   ResultSet rs = null;
        //   String req = "select * from client where id = "+id;
        //   try {
        //       Statement st = Connexion.getConnection().createStatement();
        //       rs = st.executeQuery(req);
        //       if (rs.next()){
        //         client = new DevData(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getDate("date"));
        //       }
        //   } catch (SQLException ex) {
        //       System.out.println("Erreur findById client:" +ex.getMessage());
        //   }
        //   return client;
        return null;
    }

  
    public List<DevData> findAll() {
        // List<DevData> clients = new ArrayList<>();
        // ResultSet rs = null;
        // String req = "select * from client";
        // try {
        //   Statement st = Connexion.getConnection().createStatement();
        //   rs = st.executeQuery(req);
        //   while (rs.next()) {
        //     clients.add(
        //       new DevData(
        //         rs.getInt("id"),
        //         rs.getString("nom"),
        //         rs.getString("prenom"),
        //         rs.getDate("date")
        //       )
        //     );
        //   }
        // } catch (SQLException ex) {
        //   System.out.println("Erreur findAll client:" + ex.getMessage());
        // }
        // return devdata;
        return null;
    }
}
