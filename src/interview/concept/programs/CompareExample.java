package interview.concept.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CompareExample {

	public static void main(String args[]) {

		Fruit[] fruits = new Fruit[4];

		Fruit pineappale = new Fruit("Pineapple", "Pineapple description", 70);
		Fruit apple = new Fruit("Apple", "Apple description", 100);
		Fruit orange = new Fruit("Orange", "Orange description", 80);
		Fruit banana = new Fruit("Banana", "Banana description", 90);

		fruits[0] = pineappale;
		fruits[1] = apple;
		fruits[2] = orange;
		fruits[3] = banana;

		// Java 7
		System.out.println("***********Java 7 Traditional For Loop *********************");
		Arrays.sort(fruits, new Comparator<Fruit>() {
			@Override
			public int compare(Fruit f1, Fruit f2) {
				return f1.getFruitName().compareTo(f2.getFruitName());
			}
		});

		int i = 0;
		for (Fruit temp : fruits) {
			System.out.println("fruits " + ++i + " : " + temp.getFruitName() + ", Quantity : " + temp.getQuantity());
		}

		// Java 8
		System.out.println("***********Java 8 Streams *********************");
		List<Fruit> fruitsList = Arrays.asList(fruits);
		fruitsList.sort(new Comparator<Fruit>() {
			@Override
			public int compare(Fruit o1, Fruit o2) {
				return o1.getFruitName().compareTo(o2.getFruitName());
			}
		});

		// or

		fruitsList.sort((Fruit o1, Fruit o2) -> o1.getFruitName().compareTo(o2.getFruitName()));
		// or a more better way
		fruitsList.sort((o1, o2) -> o1.getFruitName().compareTo(o2.getFruitName()));

		fruitsList.forEach((fruit) -> System.out
				.println("fruits " + " : " + fruit.getFruitName() + ", Quantity : " + fruit.getQuantity()));
	}
}

class Fruit {

	private String fruitName;
	private String fruitDesc;
	private int quantity;

	public Fruit(String fruitName, String fruitDesc, int quantity) {
		super();
		this.fruitName = fruitName;
		this.fruitDesc = fruitDesc;
		this.quantity = quantity;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public String getFruitDesc() {
		return fruitDesc;
	}

	public void setFruitDesc(String fruitDesc) {
		this.fruitDesc = fruitDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}