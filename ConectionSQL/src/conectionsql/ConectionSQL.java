/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conectionsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gaia
 */
public class ConectionSQL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Funcionó
        //String url = "jdbc:sqlserver://LEFTO;DatabaseName=tfg";
        //String name = "admin";
        //String pass = "admin1";
        
        String url = "jdbc:sqlserver://LEFTO\\trabajo;DatabaseName=tfg"; //jdbc:sqlserver://localhost;integratedSecurity=true;
        String name = "sa";//sa
        String pass = "secret";//secret
        
        try {
            Connection conexion = DriverManager.getConnection(url, name, pass);
            System.out.println("Conectado.");
            
            String sql = "INSERT INTO prenda (id, tipo)"
                    + "VALUES (54, 'Java')";
            
            Statement s1 = conexion.createStatement();
            int i = s1.executeUpdate(sql);
            
            if (i>0){
                System.out.println("Fila insertada");
            }
            
            conexion.close();
            
        } catch (SQLException ex) {
            System.out.println("Error: ");
            ex.printStackTrace();
        }
        
        
        
    }
    
}
