/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconexion {
      Connection con;
    public DBconexion (){
        
       
        try {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario","root","12345678");
        } catch (Exception e) {
            
        }
    }
    public Connection getConnection(){
        
        return con;
    }
}
