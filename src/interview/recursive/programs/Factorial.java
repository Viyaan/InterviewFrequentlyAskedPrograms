package interview.recursive.programs;

public class Factorial {
	
	static int factorial(int n)
	{
		if (n == 0)
			return 1;		
		return n*factorial(n-1);
	}

	public static void main(String args[]) {
		//10*9*8*7*6*5*4*3*2*1
		System.out.println(factorial(10));
	}

}
