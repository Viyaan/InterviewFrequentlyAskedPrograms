package interview.polymorphism.programs;

/**
 * @author Viyaan
 * 
 *         In below example, we have created two empty interfaces Cheque and
 *         BankDraft. And Payment class implemented BankDraft interface. In
 *         MainClass class both interface behave as tag, output of MainClass
 *         depends on what interface you have implemented in Payment class.
 * 
 *         <pre>
 *         In below case, 
 *         public class Payment implements BankDraft
 *         That’s why output is
 *         Payment by Draft
 * 
 *         If you have change as follows 
 *         public class Payment implements Cheque
 * 
 *         Then new output will be 
 *         Payment by Cheque
 * 
 *         <pre>
 *
 */
public class MarkerInterfaceDemo {

	public static void main(String[] args) {
		Payment p = new Payment();

		if (p instanceof Cheque) {
			p.paymentByCheque();
		}

		if (p instanceof BankDraft) {
			p.paymentByBankDraft();
		}
	}

}

class Payment implements BankDraft {

	public void paymentByCheque() {
		System.out.println("Payment By Cheque");
	}

	public void paymentByBankDraft() {
		System.out.println("Payment by Draft");
	}
}