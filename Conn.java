package BankManagementSystem;

import java.sql.*;

public class Conn {

      //Step 1 Register the Driver
     //step 2 Create Connection
      //Step 3 Create Statement
      //Step 4 Execution Query
      // Step 5 Close Connection
    Connection c;
    Statement s;

    public Conn(){

        try{
           
             c=DriverManager.getConnection("jdbc:mysql:/// bankmanagementsystem","root","root");
             s=c.createStatement();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
