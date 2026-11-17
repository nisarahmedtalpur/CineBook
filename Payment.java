package cinebook;

public class Payment  implements Payable {
	
	private int paymentId;
	private double amount;
	private PaymentMethod method;
	private boolean successful;
	
	public Payment(int paymentId, double amount, PaymentMethod method) {
		
		this.paymentId = paymentId;
		this.amount = amount;
		this.method = method;
		this.successful = false;
	}
	
	public int getPatmentId() {
		return paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public PaymentMethod getMethod() {
		return method;
	}
	public boolean isSuccessful() {
		return successful;
	}
	
	@Override
	public void processPayment() {
		System.out.println("Processing payment....");
		System.out.println("Payment Method: " + method);
		System.out.println("Amount: " + amount);
		successful = true;
		System.out.println("Payment successful.");
	}
	@Override
	public String toString() {
		return "Payment ID: " + paymentId + " | Amount: " + amount + " | Method: " + method + " | Successful: " + successful;
	}

}
