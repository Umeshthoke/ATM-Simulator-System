package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JButton login, signup, Clear;    //globally defined
    JTextField cardTextField,pinTextField;
    JPasswordField pinText;


    Login (){

        setTitle("Automated Teller Machine");

        //layout null
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));   //insert image on the form
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70, 10, 100,100);
        add(label);

        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
     cardno.setBounds(120,150,150,40);
        add(cardno);

        cardTextField =new JTextField();
        cardTextField.setBounds(300,150,230,30);//text box
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);


        JLabel pin= new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

         pinTextField =new  JPasswordField();
        pinTextField.setBounds(300,220,230,30);  //text box
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login =new JButton("SIGN IN");
        login.setBounds(300,300,100,30);  //SIGN IN BUTTON
        login.setBackground(Color.black);
        login.setForeground(Color.WHITE); //name of on buton color
        login.addActionListener(this);
        add(login);

        Clear =new JButton("CLEAR");
        Clear.setBounds(430,300,100,30);  //Clear IN BUTTON
        Clear.setBackground(Color.black);
        Clear.setForeground(Color.WHITE); //name of on buton color
        Clear.addActionListener(this);
        add(Clear);

        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);  //Clear IN BUTTON
        signup.setBackground(Color.black);
        signup.setForeground(Color.WHITE); //name of on buton color
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(800,480);      //Showing frame
        setVisible(true);
        setLocation(350,200);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()== Clear) {
            cardTextField.setText("");
            pinTextField.setText("");

        }else if(ae.getSource()==login){
            Conn conn=new Conn();

            String cardnumber =cardTextField.getText();
            String pinnumber =pinTextField.getText();

            String query ="Select * from login where cardnumber ='"+cardnumber+"' and pin='"+pinnumber+"'";
            try {
               ResultSet rs= conn.s.executeQuery(query);
               if (rs.next()){
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
               }else{
                   JOptionPane.showMessageDialog(null,"Incorrect Card Number Or Pin");
               }
            }catch (Exception e){

                System.out.println(e);
            }



        }else if(ae.getSource()==signup){
            setVisible(false);                      //for transfering login page to Signup frame
            new Signupone().setVisible(true);

        }







    }

    public static void main(String[]args){

        new Login();





    }
}
