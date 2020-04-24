package interview.collections.programs;

import java.util.WeakHashMap;

/**
 * @author Viyaan
 * 
 *         A Hashtable-based Map implementation with weak keys. An entry in a
 *         WeakHashMap will automatically be removed when its key is no longer
 *         in ordinary use. More precisely, the presence of a mapping for a
 *         given key will not prevent the key from being discarded by the
 *         garbage collector, that is, made finalizable, finalized, and then
 *         reclaimed. 
 *         
 *         When a key has been discarded its entry is effectively
 *         removed from the map, so this class behaves somewhat differently than
 *         other Map implementations.
 *
 */
class WeakHashMapDemo {
	public static void main(String args[]) throws Exception {
		WeakHashMap<Demo, String> m = new WeakHashMap<Demo, String>();
		Demo d = new Demo();

// puts an entry into WeakHashMap
		m.put(d, " Hi ");
		System.out.println(m);
		d = null;

// garbage collector is called+
		System.gc();

// thread sleeps for 4 sec
		Thread.sleep(4000);

		System.out.println(m);
	}
}

class Demo {
	public String toString() {
		return "demo";
	}

// finalize method 
	public void finalize() {
		System.out.println("finalize method is called");
	}
}
