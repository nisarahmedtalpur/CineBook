package cinebook;

public class Ticket {
	
	private int ticketId;
	private Booking booking;
	private Payment payment;
	
	
	public Ticket (int ticketId, Booking booking, Payment payment) {
		this.ticketId = ticketId;
		this.booking = booking;
		this.payment = payment;
	}
	
	public int getticketId() {
		return ticketId;
		
	}
	public Booking getBooking() {
		return booking;
	}
	public Payment  getPayment() {
		return payment;
	}
	
	public void displayTicket() {
		System.out.println("=========================================");
		
		System.out.println("CINEBOOK TICKET");
		
		System.out.println("==========================================");
		
		System.out.println("Ticket ID: " + ticketId);
		
		System.out.println("Customer: " + booking.getCustomer().getName());
		
		System.out.print("Movie: " + booking.getShow().getMovie().gettitle());
		
		System.out.println("Screen: " + booking.getShow().getScreen().getScreenNumber());
		
		System.out.println("Seat: " + booking.getSeatNumber());
		
		System.out.println("Date: " + booking.getShow().getDate());
		
		System.out.println("Time: " + booking.getShow(). getTime());
		
		System.out.print("Amount: " + payment.getAmount());
		
		System.out.println("Payment Method: " + payment.getMethod());
		
		System.out.print("Payment Successful:" + payment.isSuccessful());
		
		System.out.print("Booking Confirmed: " + booking.isConfirmed());
		
		System.out.println("=================================================");
		
	}
	
	@Override
	public String toString() {
		return "Ticket ID: " + ticketId + " | Customer: " + booking.getCustomer().getName() + " | Movie: " + booking.getShow().getMovie().gettitle() + " | Seat: " +  booking.getSeatNumber();
	}

	}
	
	
	
	
	
	
