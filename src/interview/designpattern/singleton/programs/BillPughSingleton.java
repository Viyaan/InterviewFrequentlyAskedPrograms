package interview.designpattern.singleton.programs;

import java.io.Serializable;

public class BillPughSingleton implements Serializable{

	private BillPughSingleton() {
	}

	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}

	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
	
	protected Object readResolve() {
		return getInstance();
	}
}
