/*This file is to make a basic cryptography that can be applied to the real-world situations.
 In this project, now, I'm going to make an option so that users can select a choice to run a cryptography 
 program. Furthermore, if a user spaces or leaves blank spaces, I'll replace some specific alphabets
 into those areas. Therefore, it will prevent errors when users type or keystroke any message jumping 
 between letters.*/

import java.util.*;
import java.util.Random;

public class Crypto{
	
	//make key variables
	private static final String alphaCipher = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String keyCipher = "CDEFGHIJKLMNOPQRSTUVWXYZAB";
	static Scanner input = new Scanner(System.in);
	
	//build a constructor to initialize
	public Crypto() {
		//make variables
		boolean keepGoing = false;
		
		while(!keepGoing) {
			//make a menu function
			String option = menu();
			
			//give a specific condition if a user selects a choice
			if(option.equals("1")) {
				System.out.println("Please input the unencrypted phrase or message: ");
				encrypt();
			}
			else if(option.equals("2")) {
				System.out.println("Please input the encrypted phrase or message: ");
				decrypt();
			}
			else if(option.equals("0")) {
				System.out.println("Learn encryption and decryption! ");
				keepGoing = true;
			}
		}
	}
	
	//now, make a method for menu() function
	private static String menu() {
		System.out.println();
		//ask a user to choose an option
		System.out.println("Select an option: \n0) Quit\n1) Encryption\n2) Decryption ");
		//now, ask a user to input his or her choice
		System.out.println("Please keystroke your choice: ");
		String userChoice = input.nextLine();
		return userChoice;
	}
	
	//now, make a method for encrypt()
	private static void encrypt() {
		//make variables
		String plain = input.nextLine();
		plain = plain.toUpperCase();
		
		String encryption = "";
		int encmsg = 0;
		
		for(int i = 0; i < plain.length(); i++) {
			//if a user spaces or leaves blank spaces, replace some specific alphabets into those areas
			if(plain.charAt(i) == ' ') {
				encmsg = alphaCipher.indexOf(plain.charAt(i));
				
				encryption = encryption + keyCipher.charAt(4); //G
				encryption = encryption + keyCipher.charAt(5); //H
				encryption = encryption + keyCipher.charAt(6); //I
				encryption = encryption + keyCipher.charAt(7); //J
				encryption = encryption + keyCipher.charAt(8); //K
			}
			else { //if there is no space, then print it normally
				encmsg = alphaCipher.indexOf(plain.charAt(i));
				encryption = encryption + keyCipher.charAt(encmsg);
			}
		}
		//print the encrypted output
		System.out.println(encryption);
	}
	
	//now, make a method for decrypt() 
	private static void decrypt() {
		//make variables
		String code = input.nextLine();
		code = code.toUpperCase();
		
		String decryption = "";
		int decmsg = 0;
		
		for(int i = 0; i < code.length(); i++) {
			//To decrypt a message (specific alphabets), I need to do following
			if((code.charAt(i) == 'G') && (code.charAt(i+1) == 'H') && (code.charAt(i+2) == 'I') &&
					(code.charAt(i+3) == 'J') && (code.charAt(i+4) == 'K')) {
				
				decryption = decryption + ' ';
				i=i+4; //prints specific alphabets by jumping empty spaces for replacing specific alphabets
			}
			else { //if there is no space in encryption, in decoding, then it decrypts normally.
				decmsg = keyCipher.indexOf(code.charAt(i));
				decryption = decryption + alphaCipher.charAt(decmsg);
			}
		}
		//print the decrypted output
		System.out.println(decryption);
	}
	
	public static void main(String args[]) {
		//call the method to run a program
		new Crypto();
	}
}
