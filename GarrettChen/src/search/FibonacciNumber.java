package search;

public class FibonacciNumber {

	public static void main(String[] args) {
		for(int i = 0; i < 50; i++) {
			System.out.println(i+ ". "+
		fibonacci(i));
		}
	}
	
	public static int fibonacci(int n) {
		if(n == 0 || n == 1) {
			return 1;
		}else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}
