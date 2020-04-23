package interview.polymorphism.programs;

class Parent {

	int memberVar1 = 1;

	public void call() {
		System.out.println("Parent method invoked");
	}
}

class Child extends Parent {
	int memberVar1 = 2;

	public void call() {
		System.out.println("Child method invoked");
	}

	public void call2() {
		System.out.println("Child method2 invoked");
	}
}

public class TestOverride {

	public static void main(String args[]) {
		Parent a = new Parent(); // Parent reference and object
		Parent b = new Child(); // Parent reference but Child object

		a.call();// runs the method in Parent class
		b.call();// Runs the method in Child class
		System.out.println(b.memberVar1); // Prints 1
// b.call2(); //Compile time error
	}
}