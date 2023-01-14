package Phonebook;

/**
 *
 * @author Areeb Rafiq
 */
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class EditContact extends JFrame implements ActionListener
{
   JLabel l1,l2;
   JTextField tf1;
   JButton bt1,bt2;
   Font f,f1;
   JPanel p1,p2;
   int id=0;
   
   EditContact()
   {
      super("Search Name For Edit Contact");
      setLocation(450,50);
      setSize(470,180);
      
      f=new Font("Arial",Font.BOLD,25);
      f1=new Font("Arial",Font.BOLD,18);
       
      l1=new JLabel("Edit Contact");
      l1=new JLabel("Enter Name");
       
      l1.setHorizontalAlignment(JLabel.CENTER);
        
      tf1=new JTextField();
       
      bt1=new JButton("Search Name For Edit Contact");
      bt2=new JButton("Back");
       
      bt1.addActionListener(this);
      bt2.addActionListener(this);
      
       l1.setFont(f);
       l2.setFont(f1);
       tf1.setFont(f1);
       bt1.setFont(f1);
       bt2.setFont(f1);
       
       p1=new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10));
       p1.add(l1);
       
       p2=new JPanel();
       p2.setLayout(new GridLayout(2,2,10,10));
       p2.add(l2);
       p2.add(tf1);
       p2.add(bt1);
       p2.add(bt2);
       
       setLayout(new BorderLayout(10,20));
       add(p1,"North");
       add(p2,"Center");
   }  
    public void actionPerformed(ActionEvent e)
     {
      String name=tf1.getText();
     
      if(e.getSource()==bt1)
      {
          try
        {
          Connection_Class obj=new Connection_Class();
          String q="select name from add_contact where name='"+name+"'";
          ResultSet rest=obj.stm.executeQuery(q);
         if(rest.next())
            {
                String name1=rest.getString("name");
                new SearchDataTableForEdit(name1).setVisible(true);
                this.setVisible(false);
            }
            else{
                id=0; 
                JOptionPane.showMessageDialog(null,"Your Contact is not found");
                this.setVisible(false);
                this.setVisible(true);
            }
            
         }
           catch(Exception ex)
         { 
            ex.printStackTrace();
         }
     }
        if(e.getSource()==bt2)
         {
            this.setVisible(false);
            new Home().setVisible(true);
         }
   }       
      
public static void main(String[] args) {
    new EditContact().setVisible(true);
    
    // complete
    }
   
   }
    

