package Phonebook;

/**
 *
 * @author Areeb Rafiq
 */
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class SearchDataTable extends JFrame 
{
    String x[]={"Id","Name","Nick_Name","Phone","Mobile","Email","Address","Company","Position","Group_name"};
    String y[][]=new String [20][10];
    
    int i=0,j=0;
    JTable t;
    Font f;
    
    SearchDataTable()
    {
        
    }
    
    SearchDataTable(String name1)
    {
    super("Contact Information");
    setLocation(1,1);
    setSize(800,400);  
    
    f=new Font("Arial",Font.BOLD,20);
    
        try
        {
          Connection_Class obj=new Connection_Class();
          String q="select * from add_contact where name='"+name1+"'";
          ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
            {
               y[i][j++]=rest.getString("id");
               y[i][j++]=rest.getString("name");
               y[i][j++]=rest.getString("nickname");
               y[i][j++]=rest.getString("phone");
               y[i][j++]=rest.getString("mobile");
               y[i][j++]=rest.getString("email");
               y[i][j++]=rest.getString("address");
               y[i][j++]=rest.getString("company");
               y[i][j++]=rest.getString("position");
               y[i][j++]=rest.getString("group_name");
               
               i++;
               j=0;
            }
           
           t=new JTable(y,x);
           t.setFont(f);
           
        } 
           catch(Exception ex)
         {
            ex.printStackTrace();
         }
        
        JScrollPane sp=new JScrollPane(t);
        add(sp);
    
    }
    
public static void main(String[] args) {
   new SearchDataTable().setVisible(true);
 }
    
}
