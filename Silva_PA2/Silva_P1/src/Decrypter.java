
public class Decrypter {

		public static void decrypt(int a,int b,int c,int d) {
			int a2 = (a+3) % 10;
			int b2 = (b+3) % 10;
			int c2 = (c+3) % 10;
			int d2 = (d+3) % 10;
			System.out.printf("\nThe decrypted number is : %d%d%d%d",c2,d2,a2,b2);
		}
	}

