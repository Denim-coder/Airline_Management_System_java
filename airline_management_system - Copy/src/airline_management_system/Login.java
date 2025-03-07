package airline_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Login  extends JFrame implements ActionListener{
    JButton Submit , Reset , Close;
    JTextField tfUserName;
    JPasswordField tfPassWord;
    
    public Login(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel lblUserName = new JLabel("UserName");
        lblUserName.setBounds(600,50,100,20);
        lblUserName.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(lblUserName);
        
        tfUserName = new JTextField();
        tfUserName.setBounds(700, 50, 200, 20);
        add(tfUserName);
        
        JLabel lblPassWord = new JLabel("PassWord");
        lblPassWord.setBounds(600,80,100,20);
        lblPassWord.setFont(new Font("Tahoma" , Font.BOLD , 15));
        add(lblPassWord);
        
        tfPassWord= new JPasswordField();
        tfPassWord.setBounds(700, 80, 200, 20);
        add(tfPassWord);
        
        
        Reset = new JButton("Reset");
        Reset.setBounds(650, 150, 120 , 20);
        Reset.addActionListener(this);
        add(Reset);
        
        Submit = new JButton("Submit");
        Submit.setBounds(800, 150, 120 , 20);
        Submit.addActionListener(this);
        add(Submit);
        
        Close = new JButton("Close");
        Close.setBounds(730, 200, 120 , 20);
        Close.addActionListener(this);
        add(Close);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("airline_management_system/icons/loginimage.jpg"));
        JLabel image = new JLabel(i2);
        image.setBounds(0,0,1000,425);
        add(image);
        
        setSize(1000,425);
        setLocation(600,250);
        setVisible(true);
        
    }@Override
 public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Submit){
            String username = tfUserName.getText();
            String password = tfPassWord.getText();
            try{
                Conn c = new Conn();
                
                String query = "select * from Login where username = '"+ username +"'and password = '" + password +"'" ;
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Home();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password ");
                    setVisible(false);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }else if(e.getSource() == Close){
            setVisible(false);
        }else if(e.getSource() == Reset){
            tfUserName.setText("");
            tfPassWord.setText("");
        }
    }
  
    public static void main(String[] args){
        new Login();
    }
}

   
   

   

   