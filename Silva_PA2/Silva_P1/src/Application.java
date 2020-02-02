import java.util.Scanner;
/*
 * Your application should read a four-digit integer entered by the user
 * encrypt it as follows: Replace each digit with the result of adding 7 to the digit and getting the remainder after dividing the new value by 10.
 * swap the first digit with the third, and swap the second digit with the fourth.
 * Your application should also allow the user to enter an encrypted four-digit integer 
 * and then decrypt it (by reversing the encryption scheme) to form the original number
 */
public class Application {
		
		static Scanner userInput = new Scanner(System.in);
		
		public static void promptEnterKeyForEncryptedNumber() {
			System.out.printf("\nPress Enter to see your encrypted number...");
			Scanner Enter = new Scanner(System.in);
			Enter.hasNextLine();
		
		}
		public static void promptEnterKeyForDecryptedNumber() {
			System.out.printf("\nPress Enter to recieve your decrypted number...");
			Scanner Enter1 = new Scanner(System.in);
			Enter1.hasNextLine();
		
		}
		
		public static void main(String[] args) {
			int n= 0;
			int i=0;
			int[] arr = new int[4];
			int[] decryarr = new int[4];
			int n1 = 0;
			//read a four-digit integer entered by the user
			while(n == 0) {
			System.out.print("Enter a four digit-number: ");
			n = userInput.nextInt();
				if(n < 0 ) {
					n = 0;  //if use enters negative number it prompt the enter a four digit number
				}
				if(n > 9999) {
					n = 0; ////if use enters a number bigger than 4 digits it prompts the user again to enter a four digit number
				}
			}
			
			while (n > 0) {
				arr[i] = n % 10;
				i++;
				n = n /10;
			}
			//to get the single digits we have to use the mod operator then set those individual number equal to a place in an array
			int d = arr[0];
			int c = arr[1];
			int b = arr[2];
			int a = arr[3];
		
			//The encryption process, main method encrypts the user's value using Encrypter.encrypt
			promptEnterKeyForEncryptedNumber();
			Encrypter.encrypt(a, b, c, d);
			//application allows the user to enter an encrypted four-digit integer
			i = 0;
			while(n1 == 0) {
				System.out.print("\nEnter the 4-digit number you would like to decrypt: ");
				n1 = userInput.nextInt();
				if(n1 < 0 ) {
					n1 = 0;
				}
				if(n1 > 9999) {
					n1 = 0;
				}
			}
		
			while (n1 > 0) {
				decryarr[i] = n1 % 10;
				i++;
				n1 = n1 /10;
			}
			d = decryarr[0];
			c = decryarr[1];
			b = decryarr[2];
			a = decryarr[3];
			//The decryption process, main method decrypts the user's value using Decrypter.decrypt
			promptEnterKeyForDecryptedNumber();
			Decrypter.decrypt(a, b, c, d);
		
		}

	}

