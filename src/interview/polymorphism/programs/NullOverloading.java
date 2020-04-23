package interview.polymorphism.programs;

/**
 * @author Viyaan
 * 
 *         The reason why we get compile time error in the above scenario is,
 *         here the method arguments Integer and String both are not primitive
 *         data types in Java. That means they accept null values. When we pass
 *         a null value to the method1 the compiler gets confused which method
 *         it has to select, as both are accepting the null.
 *
 */
public class NullOverloading {
	// Overloaded methods
	public void fun(Integer i) {
		System.out.println("fun(Integer ) ");
	}

	public void fun(String name) {
		System.out.println("fun(String ) ");
	}

	// Driver code
	public static void main(String[] args) {
		NullOverloading mv = new NullOverloading();
		// mv.fun(null); //This line causes error

	}

}
