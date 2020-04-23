package interview.polymorphism.programs;

public class OverridingScenarios {

	Derived d = new Derived();

}

class Base {
	private void fun() {
		System.out.println("Base fun");
	}
}

class Derived extends Base {
	public void fun() {
		System.out.println("Derived fun");
	}

	public static void main(String[] args) {
		Base obj = new Derived();
		// obj.fun(); // this line throws compile time error
		/*
		 * Compile time error as private method cannot be overridden.
		 */
	}
}

class Base2 {
	public static void fun() {
		System.out.println("Base fun");
	}
}

class Derived2 extends Base2 {
	// Compile time error as static methods cannot be overridden,

	/*
	 * public void fun() { System.out.println("Derived fun"); }
	 */

	public static void main(String[] args) {
		Base2 obj = new Derived2();
		obj.fun();
	}
}

class Base3 {
	public static void fun() {
		System.out.println("Base fun");
	}

}

class Derived3 extends Base3 {
	public static void fun() {
		System.out.println("Derived fun");
	}

	public static void main(String[] args) {
		Base3 obj = new Derived3();
		obj.fun();

	}
}