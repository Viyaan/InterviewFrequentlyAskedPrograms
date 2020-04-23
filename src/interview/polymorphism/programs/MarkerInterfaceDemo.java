package interview.polymorphism.programs;

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