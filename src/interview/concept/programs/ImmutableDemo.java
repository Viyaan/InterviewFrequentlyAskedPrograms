package interview.concept.programs;

import java.util.Arrays;
import java.util.Date;

public class ImmutableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = { 4, 4 };
		Date date = new Date();
		ImmutableClass immutableObj = new ImmutableClass("hello", array, date);
		System.out.println("Before " + immutableObj);
		array[1] = 5;
		date.setMonth(date.getMonth() + 1);
		System.out.println("After " + immutableObj);
	}
}

final class ImmutableClass {
	private final String a;
	private int[] myArray;
	private final Date dateObj;

	public ImmutableClass(String a, int[] myArray, Date newDate) {
		super();
		this.a = a;
		this.myArray = myArray.clone();
		this.dateObj = new Date(newDate.getTime());
	}

	public String getA() {
		return a;
	}

	public int[] getMyArray() {
		return myArray;
	}

	public Date getDateObj() {
		return new Date(this.dateObj.getTime());
	}

	@Override
	public String toString() {
		return "ImmutableClass [a=" + a + ", myArray=" + Arrays.toString(myArray) + ", dateObj=" + dateObj + "]";
	}
}