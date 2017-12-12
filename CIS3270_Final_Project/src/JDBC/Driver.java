package JDBC;
import java.sql.*;

import GUI_Design.Login;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;


public class Driver extends Application implements EventHandler<ActionEvent> {
	private Date depDate;
	private Date arrDate;
	private Time depTime;
	private Time arrTime;
	private Timestamp depTimestamp;
	private Timestamp arrTimestamp;
	

	public Date getDepDate() {
		return depDate;
	}


	public  void setDepDate(Date depDate) {
		this.depDate = depDate;
	}


	public Date getArrDate() {
		return arrDate;
	}


	public void setArrDate(Date arrDate) {
		this.arrDate = arrDate;
	}


	public Time getDepTime() {
		return depTime;
	}


	public void setDepTime(Time depTime) {
		this.depTime = depTime;
	}


	public Time getArrTime() {
		return arrTime;
	}


	public void setArrTime(Time arrTime) {
		this.arrTime = arrTime;
	}


	public Timestamp getDepTimestamp() {
		return depTimestamp;
	}


	public void setDepTimestamp(Timestamp depTimestamp) {
		this.depTimestamp = depTimestamp;
	}


	public Timestamp getArrTimestamp() {
		return arrTimestamp;
	}


	public void setArrTimestamp(Timestamp arrTimestamp) {
		this.arrTimestamp = arrTimestamp;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
		
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		Date depDate;
		Time depTime;
		Date arrDate;
		Time arrTime;
		
		try {
			Connection myConn;
			myConn = DriverManager.getConnection(
					"jdbc:mysql://35.193.248.221:3306/?verifyServerCertificate=false&useSSL=true", "root",
					"Tdgiheay12");

			String sqlUserCheck = "SELECT `departure_date`, `departure_time`, `arrival_date`, `arrival_time` FROM `flights`.`flight` where flight.id ='1' ";
			// create a statement
			Statement myStat = myConn.createStatement();
			// execute a query
			ResultSet myRs;
			myRs = myStat.executeQuery(sqlUserCheck);


			// Creates a variable for future checking
			int count = 0;
			while (myRs.next()) {
				count = count + 1;
				setDepDate(myRs.getDate("departure_date"));
				setArrDate (myRs.getDate("arrival_date"));
				setDepTime(myRs.getTime("departure_time"));
				setArrTime(myRs.getTime("arrival_time"));
				

			}
			
		}
		catch (SQLException exc){
			System.out.println(exc.getMessage());
		}
		
		
		 java.sql.Timestamp departure =  java.sql.Timestamp.valueOf(getDepDate().toString().concat(" "+getDepTime().toString()));
		 java.sql.Timestamp arrival =  java.sql.Timestamp.valueOf(getArrDate().toString().concat(" "+getArrTime().toString()));
		 System.out.println(departure + "\n" + arrival);
		 System.out.println(arrival.compareTo(departure));
		 
		 if(arrival.compareTo(departure)<0) {
			 System.out.println("less than");
			 
		 }
		 if(arrival.compareTo(departure)>0) {
			 System.out.println("more than");
			 
		 }
		 
		 if(arrival.compareTo(departure)==0) {
			 System.out.println("=");
			 
		 }
		
		
	}


	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int schedulingCheck(Timestamp d, Timestamp a) {
		
			if (d.compareTo(a)>=0) {
				return 1;
			}
			else {
				return 0;
			}
		
	}
	
	
	public int conflictCheck(Timestamp d, Timestamp a, Timestamp d1) {
		
		if (d1.after(d)&& d1.before(a)) {
			return 1;
		}
		else {
			return 0;
		}
	
	}
	

}