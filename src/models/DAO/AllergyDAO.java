/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.DAO;

import database.Database;
import java.sql.ResultSet;
import java.util.Vector;
import models.Allergy;

/**
 *
 * @author zianwar
 */
public class AllergyDAO implements DAO<Allergy> {

    
    @Override
    public Allergy find(String id) {
        
        Allergy allergy = new Allergy();
        
        String findQuery = "SELECT * FROM allergies"
                        + " WHERE id_allergie =" + id + ";";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
            rs.next();
            allergy.setAllergyId(rs.getInt("id_allergie"));
            allergy.setAllergyName(rs.getString("nom_allergie"));
            
        } catch (Exception ex) {
            System.out.println("Error : AllergyDAO.find() " + ex);
        } 
        
        return allergy;
    }

    
    @Override
    public Vector<Allergy> all() {
        
        Vector<Allergy> allergies = new  Vector<Allergy>();
        
        String findQuery = "SELECT * FROM allergies";
        
        ResultSet rs = Database.getInstance().query(findQuery);
        
        try {
           while(rs.next())
           {
               Allergy allergy= new Allergy();
               
               allergy.setAllergyId(rs.getInt("Id_allergie"));
               allergy.setAllergyName(rs.getString("nom_allergie"));
               allergies.add(allergy);
           }
           
        } catch (Exception ex) {
            System.out.println("Error : AllergyDAO.all() " + ex);
        } 
        
        return allergies;    
    }
     

    @Override
    public boolean create(Allergy allergy) {
        
        String insertQuery = "INSERT INTO allergies(nom_allergie) VALUES("
                            + "'" + allergy.getAllergyName() + "'); ";
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);  
    }

    
    @Override
    public boolean update(Allergy allergy) {
        
        String insertQuery = "UPDATE allergies "
                           + "SET nom_allergie = '" + allergy.getAllergyName() + "' "
                           + "WHERE id_allergie = " + allergy.getAllergyId() + ";";      
        
        return (Database.getInstance().dmlQuery(insertQuery) != 0);
    }

    
    @Override
    public boolean delete(Allergy allergy) {
           
        String deleteQuery = "DELETE FROM allergies "
                           + "WHERE id_allergie = " +  allergy.getAllergyId() + ";";
        
        return (Database.getInstance().dmlQuery(deleteQuery) != 0);
    }
    
    
}
