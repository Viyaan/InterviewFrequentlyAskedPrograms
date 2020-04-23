package interview.thread.programs;

/**
 * @author Viyaan
 * 
 *         <b> How to avoid deadlock<b><br>
 *         <p>
 *         I believe, the solution to any problem lies in identifying the root
 *         of the problem. In our case, it is the pattern of accessing the
 *         resources A and B, is main issue. So, to solve it, we will simply
 *         re-order the statements where the code is accessing
 *         </p>
 * 
 *         <b>Use Joins</b>
 *         <p>
 *         If possible try to use join() method, although it may refrain us from
 *         taking full advantage of multithreading environment because threads
 *         will start and end sequentially, but it can be handy in avoiding
 *         deadlocks.
 *         </p>
 *
 */
public class DeadLock {

	public static void main(String[] args) {
		DeadLock test = new DeadLock();

		final A a = test.new A();
		final B b = test.new B();

		// Thread-1
		Runnable block1 = () -> {
			synchronized (a) {
				try {
					// Adding delay so that both threads can start trying to lock resources
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// Thread-1 have A but need B also
				synchronized (b) {
					System.out.println("In block 1");
				}
			}

		};

		// Thread-2
		Runnable block2 = () -> {
			synchronized (b) {
				// Thread-2 have B but need A also
				synchronized (a) {
					System.out.println("In block 2");
				}
			}

		};

		new Thread(block1).start();
		new Thread(block2).start();
	}

	// Resource A
	private class A {
		private int i = 10;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
	}

	// Resource B
	private class B {
		private int i = 20;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}
	}

}
