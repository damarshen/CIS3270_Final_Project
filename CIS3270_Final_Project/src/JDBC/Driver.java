package JDBC;
import java.sql.*;

import GUI_Design.Login;


public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String usernameId = "";
		try {
			Connection myConn;
			myConn = DriverManager.getConnection(
					"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
					"Tdgiheay12");

			String sqlUserCheck = "SELECT * FROM `flights`.`users` where username = 'ojallow1'";
			// create a statement
			Statement myStat = myConn.createStatement();
			// execute a query
			ResultSet myRs;
			myRs = myStat.executeQuery(sqlUserCheck);
	

			// Creates a variable for future checking
			int count = 0;
			while (myRs.next()) {
				count = count + 1;
				usernameId = myRs.getString("id");
				System.out.println(usernameId);

			}
			
		}
		catch (Exception exc){
			
		}
	}

}