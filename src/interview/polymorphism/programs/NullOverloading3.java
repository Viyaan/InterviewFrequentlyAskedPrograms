package interview.polymorphism.programs;

public class NullOverloading3 {

	public void fun(Object i) {
		System.out.println("fun(Object ) ");
	}

	public void fun(String name) {
		System.out.println("fun(String ) ");
	}

	// Driver code
	public static void main(String[] args) {
		NullOverloading3 mv = new NullOverloading3();
		mv.fun(null);
	}

}
