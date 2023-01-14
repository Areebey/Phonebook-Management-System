package Phonebook;

/**
 *
 * @author Areeb Rafiq
 */
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteContact extends JFrame implements ActionListener
{
  String x[]={"Id","Name","Nick Name","Phone","Mobile","Email","Address","Company","Position","Group_name"};
  String y[][]=new String [20][10];
    
  int i=0,j=0;
  JTable t;
  Font f,f1;
  JLabel l1;
  JButton bt1;
  JTextField tf1;
  JPanel p1,p2;
  
DeleteContact()
{
    super("Contact Information");
    setLocation(1,1);
    setSize(800,400);  
    
    f=new Font("Arial",Font.BOLD,15);
    
    try
        {
          Connection_Class obj=new Connection_Class();
          String q="select * from add_contact";
          ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
            {
               y[i][j++]=rest.getString("Id");
               y[i][j++]=rest.getString("Name");
               y[i][j++]=rest.getString("NickName");
               y[i][j++]=rest.getString("Phone");
               y[i][j++]=rest.getString("Mobile");
               y[i][j++]=rest.getString("Email");
               y[i][j++]=rest.getString("Address");
               y[i][j++]=rest.getString("Company");
               y[i][j++]=rest.getString("Position");
               y[i][j++]=rest.getString("Group_name");
               
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
        
        l1=new JLabel("Enter Contact Id for Delete");
        tf1=new JTextField();
        bt1=new JButton("Delete");
        
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.RED);
        bt1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(bt1);
        
       setLayout(new BorderLayout(10,10));
       add(p1,"South");
       add(sp,"Center");   
}
public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==bt1)
     {     
     int idno=Integer.parseInt(tf1.getText());
     try
     {
        Connection_Class obj=new Connection_Class();
        String q0="Delete from add_contact where id='"+idno+"'";
        int res=obj.stm.executeUpdate(q0);
        
        if(res==1)
        {
          JOptionPane.showMessageDialog(null,"Your contact sucessfully deleted");
                  this.setVisible(false);
                  new DeleteContact().setVisible(true);    
              }
              else{
                  JOptionPane.showMessageDialog(null,"Your Contact did not deleted");
                  this.setVisible(false);
                  new DeleteContact().setVisible(true);    
              }  
        }
     catch(Exception ex)
                   {
                       ex.printStackTrace();
                   }
     }
     
     }
    public static void main(String[] args) {
        new DeleteContact().setVisible(true);
    }
   }

// part10 completed