package interview.concept.programs;

import java.util.Arrays;
import java.util.Date;

/**
 * To create an immutable class following steps should be followed:<br>
 * 1. Create a final class. <br>
 * 2. Set the values of properties using constructor only.<br>
 * 3. Make the properties of the class final and private. <br>
 * 4. Do not provide any setters for these properties. <br>
 * 5. If the instance fields include references to mutable objects, don't allow
 * those objects to be changed: <br>
 * 6. Don't provide methods that modify the mutable objects. <br>
 * 7. Don't share references to the mutable objects. Never store references to
 * external, mutable objects passed to the constructor; if necessary, create
 * copies, and store references to the copies. Similarly, create copies of your
 * internal mutable objects when necessary to avoid returning the originals in
 * your method
 *
 */
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

//The class is final so we cannot create the subclass.
final class ImmutableClass {
	// The instance variable of the class is final i.e. we cannot change the value
	// of it after creating an object.
	private final String a;
	private int[] myArray;
	private final Date dateObj;

	public ImmutableClass(String a, int[] myArray, Date newDate) {
		super();
		this.a = a;
		this.myArray = myArray.clone();
		this.dateObj = new Date(newDate.getTime());
	}

//There is no setter methods i.e. we have no option to change the value of the instance variable.
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