package interview.polymorphism.programs;

/**
 * @author Viyaan
 * 
 *         we are specifying that the argument is of type Integer, hence the
 *         compiler selects the method1(Integer i) and will execute the code
 *         inside that.
 *
 */
public class NullOverloading2 {

	// Overloaded methods
	public void fun(Integer i) {
		System.out.println("fun(Integer ) ");
	}

	public void fun(String name) {
		System.out.println("fun(String ) ");
	}

	// Driver code
	public static void main(String[] args) {
		NullOverloading2 mv = new NullOverloading2();

		Integer arg = null;
		mv.fun(arg);
	}

}
