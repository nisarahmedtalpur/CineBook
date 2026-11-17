package cinebook;
import java.util.ArrayList;

public class BookingManager {
	
	private ArrayList<Booking>bookings;
	
	public BookingManager() {
		bookings = new ArrayList<>();
	}
	//method add booking
	
	public void addBooking(Booking booking) {
		//bookings.add(booking);
		//System.out.println("Booking added successfully.");
	//
		if(booking.isConfirmed()) {
			bookings.add(booking);
			
			System.out.println("Booking added successfully.");
			}
		else {
			System.out.println("Booking was not added because it is not confirmed.");
		}
		}
	//method getbookingcount()

	public int getBookingCount() {
		return bookings.size();
	}
	//method dispaly all booking()
	public void displayAllBooking() {
		System.out.println();
		
		System.out.println("==========================================");
		System.out.println("=== ALL CINEBOOK BOOKINGS===");
		
		System.out.println("==============================================");
		
		if(bookings.isEmpty()) {
			System.out.println("No booking found.");
			return;
		}
		for (Booking booking: bookings) {
			System.out.println(booking);
			System.out.println("===========================================");
			
			
		}
		System.out.println("Total Bookings: ");
	}
	
	
	public  Booking findBooking(int bookingId) {
		for(Booking booking: bookings) {
			
			if (booking.getBookingId()==bookingId) {
				
				return booking;
			}
		}
		return null;
		
	}
	public  boolean removeBooking(int bookingId) {
		
		Booking booking = findBooking(bookingId);
		
		if(booking !=null) {
			
			bookings.remove(booking);
			
			System.out.println("Booking removed successfully.");
			return true;
		}
		System.out.println("Booking not found.");
		return false;
	}
	   public boolean cancelBooking(int bookingId) {
		
		Booking booking = findBooking(bookingId);
		
		if(booking == null) {
			System.out.println("Booking not found.");
			return false;
		}
		booking.cancelBooking();
		bookings.remove(booking);
		
		
		System.out.println("Booking removed from Booking Manager.");
		
		return true;
		
		
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


