package interview.collections.programs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomerNoHashCodeExample {
	private String crmID;
	private int nameSpace;

	public CustomerNoHashCodeExample(String crmID, int nameSpace) {
		super();
		this.crmID = crmID;
		this.nameSpace = nameSpace;
	}

	@Override
	public String toString() {
		return "CustomerID [crmID=" + crmID + ", nameSpace=" + nameSpace + "]";
	}

	public boolean equals(Object obj) {
		// null instanceof Object will always return false
		if (!(obj instanceof CustomerNoHashCodeExample))
			return false;
		if (obj == this)
			return true;
		return this.crmID == ((CustomerNoHashCodeExample) obj).crmID
				&& this.nameSpace == ((CustomerNoHashCodeExample) obj).nameSpace;

	}
	/*
	 * public int hashCode() { return 0; }
	 */

	public static void main(String[] args) {
		Map<CustomerNoHashCodeExample, String> m = new HashMap<CustomerNoHashCodeExample, String>();
		Set<CustomerNoHashCodeExample> s = new HashSet<CustomerNoHashCodeExample>();
		m.put(new CustomerNoHashCodeExample("Hello", 0), "Jeff Smith");
		m.put(new CustomerNoHashCodeExample("Babe", 0), "Jeff Smith1");
		m.put(new CustomerNoHashCodeExample("Babe", 0), "Jeff Smith2");
		s.add(new CustomerNoHashCodeExample("Babe", 0));
		s.add(new CustomerNoHashCodeExample("Babe", 0));
		System.out.println(m.get(new CustomerNoHashCodeExample("Hello", 0)));
		for (CustomerNoHashCodeExample set : s) {
			System.out.println("Entries " + set);
		}
	}
}