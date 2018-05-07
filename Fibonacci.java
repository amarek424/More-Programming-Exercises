import java.util.Scanner;
import java.math.BigInteger; 
// Use BigInteger because normal int does not have enough bits to store big numbers

public class Fibonacci {
	public static BigInteger fibonacci(int n) {
		BigInteger x2 = BigInteger.valueOf(0);
		BigInteger x1 = BigInteger.valueOf(1);
		BigInteger x = BigInteger.valueOf(1);
		
		if (n == 0) {
			return x2;
		}	
		
		for (int i = 2; i <= n; i++) {
			x = x2.add(x1);
			x2 = x1;
			x1 = x;
		}
		
		return x;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter nth number to retrieve from the Fibonacci sequence: ");
		while (!sc.hasNextInt()) {
			System.out.println("Expecting an int...");
			sc.next();
		}
		int n = sc.nextInt();
		sc.close();
		
		System.out.printf("The %dth Fibonacci number is: %d", n, fibonacci(n));
	}
}
