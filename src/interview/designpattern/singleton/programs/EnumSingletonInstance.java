package interview.designpattern.singleton.programs;

public enum EnumSingletonInstance {

	INSTANCE;

	private EnumSingletonInstance() {
		System.out.println("Here");
	}

	public void doStuff() {

		System.out.println("Singleton using Enum");
	}
}
