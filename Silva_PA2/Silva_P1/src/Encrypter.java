
public class Encrypter {
//Encrypter class contains a single class method called encrypt
		public static void encrypt(int a, int b, int c, int d) {
			int a1 = (a+7) % 10;
			int b1 = (b+7) % 10;
			int c1 = (c+7) % 10;
			int d1 = (d+7) % 10;
			//swaps a with c and b with d
			System.out.printf("\nThe encrypted number is : %d%d%d%d",c1,d1,a1,b1);
		}	
}

