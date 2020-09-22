import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import com.draco.ciphers.BealeCipher;
import com.draco.ciphers.CaesarCipher;
import com.draco.ciphers.Cipher;
import com.draco.ciphers.OneTimePad;

/**
 * The Runner class handles I/O and will make calls to different ciphers in
 * order to encrypt/decrypt messages.
 *
 * @author Mansour Najah 09.06.2020
 *
 */
public class Runner {

	// Grabs user input.
	public static Scanner console = new Scanner(System.in);

	// Answers will be given as integer values and used in conditional statements.
	public static int answer;

	/**
	 * Calls the start method.
	 *
	 * @param args array of arguments that may be used.
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		start();
	}

	/**
	 * Begins the program introduction and decides if the user wants to encrypt
	 * or decrypt a message.
	 *
	 * @throws InterruptedException
	 */
	public static void start() throws InterruptedException {
		System.out.println("Welcome traveler, I am Draco.");
		printWithDelays("...", 500);

		System.out.println();

		System.out.println("\nMy services entail the encryption and decryption of messages.");
		System.out.println("Now, which method would suit your purposes?");
		System.out.println("\n1. Encryption");
		System.out.println("2. Decryption");

		answer = console.nextInt();

		if (answer == 1) {
			runEncryption();
		}

		else if (answer == 2) {
			runDecryption();
		}
	}

	/**
	 * Runs encryption based on user's choice of algorithm/cipher.
	 */
	public static void runEncryption() {
		Cipher newCipher = null;

		System.out.println("\nCertainly! Now you must make your choice of cipher.");
		System.out.println("\n1. Caesar Cipher");
		System.out.println("2. Beale Cipher");
		System.out.println("3. One-Time Pad");

		answer = console.nextInt();

		System.out.println("\nAnd now for your message, what will it be?");

		String message = console.next();
		String key;

		switch(answer) {
			case 1:
				System.out.println("\nYes of course. What is the key? Choose a number between 0 and 25.");

				key = console.next();

				newCipher = new CaesarCipher(message, key);
				newCipher.encrypt();

				break;
			case 2:
				System.out.println("\nYes of course. What is the key? Do choose wisely.");

				key = console.next();

				newCipher = new BealeCipher(message, key);
				newCipher.encrypt();

				break;
			case 3:
				System.out.println("\nYes of course. What is the key? Do choose wisely.");

				key = console.next();

				newCipher = new OneTimePad(message, key);
				newCipher.encrypt();

				break;
		}

		System.out.println("\nYour encrypted message is: " + newCipher.getCipherText());
	}

	/**
	 * Runs decryption based on user's choice of algorithm/cipher.
	 */
	public static void runDecryption() {
		Cipher newCipher = null;

		System.out.println("\nCertainly! Now you must make your choice of cipher.");
		System.out.println("\n1. Caesar Cipher");
		System.out.println("2. Beale Cipher");
		System.out.println("3. One-Time Pad");

		answer = console.nextInt();

		System.out.println("\nAnd now for your message, recall what it was.");

		String message = console.next();
		String key;

		switch(answer) {
		case 1:
			System.out.println("\nYes of course. What was the key?");

			key = console.next();

			newCipher = new CaesarCipher(message, key);
			newCipher.decrypt();

			break;
		case 2:
			System.out.println("\nYes of course. What was the key?");

			key = console.next();

			newCipher = new BealeCipher(message, key);
			newCipher.decrypt();

			break;
		case 3:
			System.out.println("\nYes of course. What was the key?");

			key = console.next();

			newCipher = new OneTimePad(message, key);
			newCipher.decrypt();

			break;
		}

		System.out.println("\nYour decrypted message is: " + newCipher.getPlainText());
	}

	public static void printWithDelays(String data, long delay)
	        throws InterruptedException {
	    for (char ch:data.toCharArray()) {
	        System.out.print("\n" + ch + "\n");

	        TimeUnit.MILLISECONDS.sleep(delay);
	    }
	}

}
