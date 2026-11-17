package cinebook;

public class BookingService {
	
	private BookingManager bookingManager;
	private TicketManager ticketManager;
	

	
	
	public BookingService(BookingManager bookingManager, TicketManager ticketManager) {
		
		this.bookingManager = bookingManager;
		this.ticketManager = ticketManager;
	}
	
	public Ticket creatBooking(Booking booking, Payment payment, int ticketId) {
		System.out.println();
		System.out.println("====================================================");
		System.out.println("CREATING BOOKING");
		System.out.println("==============================================");
		
		
		booking.confirmBooking();
		
		if(!booking.isConfirmed()) {
			
			System.out.println("Booking failed");
			return null;
		}
		
		payment.processPayment();
		if(!payment.isSuccessful()) {
			
			System.out.println("Payment failed.");
			
			booking.cancelBooking();
			return null;
		}
		
		bookingManager.addBooking(booking);
		
		
		Ticket ticket = new Ticket( ticketId,booking,payment);
		
		
		ticketManager.addTicket(ticket);
		
		System.out.println("Booking process completed successfully.");
		return ticket;
	}
	
	///public boolean cancelBooking(int bookingId) {
		
		//System.out.println();
		
		//System.out.println("===================================================");
	//	System.out.println("CANCELLING BOOKING");
		
	//	System.out.println("=======================================================");
		
	//return bookingManager.cancelBooking(bookingId);
	//}
	
	public boolean cancelBooking(int bookingId) {
		
		System.out.println();
		
		System.out.println("===================================");
		System.out.println("CANCELLINH BOOKING");
		System.out.println("====================================");
		
		
		boolean bookingCancelled = bookingManager.cancelBooking(bookingId);
		
		 if(!bookingCancelled) {
			 
			 System.out.println("Cancellation failed.");
			 return false;
		 }
		 
		 
		 ticketManager.removeTicketByBookingId(bookingId);
		 
		 System.out.println("Booking cancellation completed.");
		 
		 return true;
		
		
	
      }
	}
