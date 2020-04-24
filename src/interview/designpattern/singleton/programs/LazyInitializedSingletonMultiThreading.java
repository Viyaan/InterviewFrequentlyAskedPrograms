package interview.designpattern.singleton.programs;

import java.io.Serializable;

class LazyInitializedSingletonMultiThreading implements Cloneable, Serializable {
	private static volatile LazyInitializedSingletonMultiThreading instance = null;

	private LazyInitializedSingletonMultiThreading() {
	}

	public static LazyInitializedSingletonMultiThreading getInstance() {
		if (instance == null) {
			synchronized (LazyInitializedSingletonMultiThreading.class) {
				if (instance == null) {
					instance = new LazyInitializedSingletonMultiThreading();
				}

			}
		}
		return instance;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	protected Object readResolve() {
		return getInstance();
	}
}
