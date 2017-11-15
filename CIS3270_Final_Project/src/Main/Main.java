package Main;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Objects.Citys.City;
import Objects.Users.Users;

public class Main {
static Users securityTest;//declares user object
	public static void main(String[] args) {
		
		
		ArrayList <Users> userlist = new ArrayList();
		
		
		
		
		City city = new City("Calgary", "Alberta", "YYC");
		System.out.println(city.toString());
		Scanner input =new Scanner(System.in);
		securityTest = new Users();
		securityTest.setPassword("Capn' Crunch");
		securityTest.setSecurityQuestion("What Class is this for?");
		securityTest.setSecurityAnswer("CIS3270");
		
	System.out.println("Please answer your security question: " + securityTest.getSecurityQuestion()); //prompts the user to enter answer to security question
	String answer = input.nextLine();//accepts input for answer
 System.out.println( passwordRetrieval(answer)); //passes answer to password retrieval method for comparison password if correct, or wrong answer message
	}
	
	
	
	//method that checks users input to security question and compares it to answer provided upon registration
	public static String passwordRetrieval(String Answer) { 
		String Wrong = "That is not the correct answer to your security question.";
		
		if (Answer.equals(securityTest.getSecurityAnswer())) {
		return "Your password is: "+securityTest.getPassword();
		}
		else {
			return Wrong;
		}
		
		
		
	}

}
