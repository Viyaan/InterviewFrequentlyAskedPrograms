package interview.string.programs;

public class StringManipulationUsingSubString {

	public static void main(String[] args) {
		String s = new String("trythisexample");
		System.out.println(s.substring(s.length()));
		System.out.println(s.substring(s.length(), s.length()));
		System.out.println(s.substring(s.length() + 1));
		System.out.println(s.substring(2, 1));
		System.out.println(s.substring(-2, 4));
	}

}
