package interview.polymorphism.programs;

public class LoadingBlocks {
	static {
		System.out.println("Inside static");
	}

	{
		System.out.println("Inside init");
	}

	public static void main(String args[]) {
		new LoadingBlocks();
		new LoadingBlocks();
		new LoadingBlocks();
	}
}
