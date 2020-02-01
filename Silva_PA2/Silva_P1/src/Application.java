import java.util.Scanner;

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
			while(n == 0) {
			System.out.print("Enter a four digit-number: ");
			n = userInput.nextInt();
				if(n < 0 ) {
					n = 0;
				}
				if(n > 9999) {
					n = 0;
				}
			}
			
			while (n > 0) {
				arr[i] = n % 10;
				i++;
				n = n /10;
			}
			
			int d = arr[0];
			int c = arr[1];
			int b = arr[2];
			int a = arr[3];
		
			
			promptEnterKeyForEncryptedNumber();
			Encrypter.encrypt(a, b, c, d);
			
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
		
			promptEnterKeyForDecryptedNumber();
			Decrypter.decrypt(a, b, c, d);
		
		}

	}

