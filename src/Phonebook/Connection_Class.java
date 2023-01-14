package Phonebook;

/**
 *
 * @author Areeb Rafiq
 */
    //import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.awt.*;
import java.sql.*;
public class Connection_Class {
    
   Connection con;
   Statement stm;
      
   Connection_Class()
   {
       try
       {
         Class.forName("com.mysql.cj.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebookmanagement", "root", "yahoo.com12");
         stm=con.createStatement();
         
       }
      
       catch (Exception ex) 
       {
          ex.printStackTrace();
       }
   }
    public static void main(String[] args) {
        
     new Connection_Class();   
    }
}
 
