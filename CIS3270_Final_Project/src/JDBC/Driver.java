package JDBC;
import java.sql.*;

import GUI_Design.Connection;
import GUI_Design.ResultSet;
import GUI_Design.Statement;
public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		try {
			//get a connection to the database
			Connection myConn = DriverManager.getConnection("jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root", "Tdgiheay12");
			//create a statement
			Statement myStat = myConn.createStatement();
			//execute a query
			ResultSet myRs =myStat.executeQuery("SELECT `city`.`id`,\r\n" + 
					"    `city`.`name`,\r\n" + 
					"    `city`.`location`\r\n" + 
					"FROM `flights`.`city`;\r\n" + 
					"");
			//process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("id"));
				
			}
			
		}
		catch (Exception exc){
			
		}
	}

}

//connection variable
	Connection myConn ; 
	//statement variable
	Statement myStat;
	//query variable
	ResultSet myRs;
