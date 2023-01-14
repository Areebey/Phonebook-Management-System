package Phonebook;

/**
 *
 * @author Areeb Rafiq
 */
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;

public class EditData extends JFrame implements ActionListener
{
  JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
  JPanel p1,p2,p3;
  JButton bt1,bt2;
  Font f1,f2;
  JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
  
  EditData()
  {
      
  }
    
  EditData(int idno)
  {
      
     super("Edit Contact");
     setLocation(450,50);
     setSize(450,450);
     
     f1=new Font("Arial",Font.BOLD,25);
     f2=new Font("Arial",Font.BOLD,15);
     
     l1=new JLabel("Update Contact");
     l2=new JLabel("Name");
     l3=new JLabel("Nick Name ");
     l4=new JLabel("Ph Num");
     l5=new JLabel("Mobile Num");
     l6=new JLabel("Email");
     l7=new JLabel("Address");
     l8=new JLabel("Company");
     l9=new JLabel("Position");
     l10=new JLabel("Group_name");
     l11=new JLabel("Id");
     
     tf1=new JTextField();
     tf2=new JTextField();
     tf3=new JTextField();
     tf4=new JTextField();
     tf5=new JTextField();
     tf6=new JTextField();
     tf7=new JTextField();
     tf8=new JTextField();
     tf9=new JTextField();
     tf10=new JTextField();
     
     bt1=new JButton("Edit Contact");
     bt2=new JButton("Back");
     
     l1.setHorizontalAlignment(JLabel.CENTER);
     
     bt1.setBackground(Color.BLACK);
     bt1.setForeground(Color.RED);
     
     bt1.addActionListener(this);
     bt2.addActionListener(this);
     
     l1.setFont(f1);
     l2.setFont(f2);
     l3.setFont(f2);
     l4.setFont(f2);
     l5.setFont(f2);
     l6.setFont(f2);
     l7.setFont(f2);
     l8.setFont(f2);
     l9.setFont(f2);
     l10.setFont(f2);
     l11.setFont(f2);
     
     tf1.setFont(f2);
     tf2.setFont(f2);
     tf3.setFont(f2);
     tf4.setFont(f2);
     tf5.setFont(f2);
     tf6.setFont(f2);
     tf7.setFont(f2);
     tf8.setFont(f2);
     tf9.setFont(f2);
     tf10.setFont(f2);
        
     bt1.setFont(f2);
     bt2.setFont(f2);
     
     p1=new JPanel();
     p1.setLayout(new GridLayout (1,1,10,10));
     p1.add(l1);
        
     p2=new JPanel();
     p2.setLayout(new GridLayout(11,2,10,10));
     p2.add(l11);
     p2.add(tf10);
     p2.add(l2);
     p2.add(tf1);
     p2.add(l3);
     p2.add(tf2);
     p2.add(l4);
     p2.add(tf3);
     p2.add(l5);
     p2.add(tf4);
     p2.add(l6);
     p2.add(tf5);
     p2.add(l7);
     p2.add(tf6);
     p2.add(l8);
     p2.add(tf7);
     p2.add(l9);
     p2.add(tf8);
     p2.add(l10);
     p2.add(tf9);
     
  try
    {
     Connection_Class obj=new Connection_Class();
     String q1="select * from add_contact where Id='"+idno+"'";
     ResultSet rest1=obj.stm.executeQuery(q1);
     while(rest1.next())
     {
         tf10.setText(rest1.getString("id"));
         tf1.setText(rest1.getString("name"));
         tf2.setText(rest1.getString("nickname"));
         tf3.setText(rest1.getString("phone"));
         tf4.setText(rest1.getString("mobile"));
         tf5.setText(rest1.getString("email"));
         tf6.setText(rest1.getString("address"));
         tf7.setText(rest1.getString("company"));
         tf8.setText(rest1.getString("position"));
         tf9.setText(rest1.getString("group_name"));
                
     }
  }
    catch(Exception ex)
         {
            ex.printStackTrace();
         }
        tf10.setEditable(false);
        
       setLayout(new BorderLayout(10,10));
       add(p1,"North");
       add(p2,"Center");
}
  public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==bt1)
       {     
        int id=Integer.parseInt(tf10.getText());
        String name=tf1.getText();
        String nickname=tf2.getText();
        String phone=tf3.getText();
        String mobile=tf4.getText();
        String email=tf5.getText();
        String address=tf6.getText();
        String company=tf7.getText();
        String position=tf8.getText();
        String group_name=tf9.getText();
      try
      {
          Connection_Class obj=new Connection_Class();
          String q1="update add_contact set name='"+name+"''"+nickname+"''"+phone+"','"+mobile+"','"+email+"','"+address+"','"+company+"','"+position+"','"+group_name+"','"+id+"')";
          int aa=obj.stm.executeUpdate(q1);
              if(aa==1)
              {
                  JOptionPane.showMessageDialog(null,"Your Data Sucessfully Edit");
                  this.setVisible(false);
                  new SearchDataTableForEdit().setVisible(true);    
              }
              else{
                  JOptionPane.showMessageDialog(null,"Plz fill details carefully");
              }
         }
        catch(Exception ee)
                   {
                       ee.printStackTrace();
                   }
       }
    if(e.getSource()==bt2)
        {
            this.setVisible(false);
            new Home().setVisible(true);
        }
  }
   public static void main (String[]args){
      
     new EditData().setVisible(true);
     
  }
 }
   // part9 completed