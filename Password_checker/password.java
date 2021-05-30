package passwordchck;
import java.io.*;
import java.util.Scanner;

public class password {
	public static void main(String []args) {
		int correctPasswords = 0;
		int a = 0;
		try { 
			File myObj = new File("D:\\EclipseWorkspace\\PasswordChecker\\bin\\passwordchck/input.txt");
			Scanner myReader = new Scanner(myObj);
		
			while(myReader.hasNextLine()) {
				a = a+1;
				 String data = myReader.nextLine();
				correctPasswords = correctPasswords + passwordCheck(data);
				//  System.out.println(data);
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("An error has occurred");
			e.printStackTrace();
		}
		System.out.println(correctPasswords);
	}
	
	private static int passwordCheck(String password) {
		String min = "",max = "",pass = "";
		char letter = 'a';
		
		for (int counter = 0,position = 0; counter < password.length(); counter++) {
			if(position == 0) {
				min = min + password.substring(counter,counter+1);
				if(password.charAt(counter + 1) == '-') {
					position++;
					counter++;
				} 
			}
			else if(position == 1) {
				max = max + password.substring(counter, counter+1);
				if(password.charAt(counter+1) == ' ') {
					position = position+1;
					counter = counter+2;
					letter = password.charAt(counter);
					counter = counter + 2;
				}
			}
			else {
				pass = pass + password.substring(counter, counter+1);
			}
			
		}
		boolean a = check1(Integer.parseInt(min),Integer.parseInt(max),letter,pass); 
		if(a == true) {
			return 1;
		}else {
			return 0;
		}
	}
	
	private static boolean check(int min, int max, char letter, String password){//checks is password has certain amount of a 
										     //types of letter between or equal to the min or the max amount
		int counter = 0;
		System.out.println(password);
		for(int loop = 0; loop < password.length(); loop++) {
			if(letter == password.charAt(loop)){
				counter = counter + 1;
				
			}
		}
		if(min<=counter&&counter<=max) {
			return true; 
		}
		return false; 
	}
	private static boolean check1(int min, int max, char letter, String password){//checks if the position of min or max in the password cointain the letter passed.
		
		if(letter == password.charAt(min-1) && letter == password.charAt(max-1)) {
			//System.out.println(letter +" " + password.charAt(min-1) + " " + password.charAt(max-1));
			return false; 
		}else if(letter == password.charAt(min-1) || letter == password.charAt(max-1)){
			return true;
		}
		else {return false;}
	}

}
