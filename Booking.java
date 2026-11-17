package cinebook;

public class Booking {
	private int bookingId;
	private Customer customer;
	private Show show;
	private int seatNumber;
	private double price;
	private boolean confirmed;
	
	
	public Booking (int bookingId, Customer customer, Show show, int seatNumber, double price) {
		this.bookingId = bookingId;
		this.customer = customer;
		this.show = show;
		this.seatNumber = seatNumber;
		this.price = price;
		// initially booking is not confirmed.
		this.confirmed = false;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public Customer getCustomer() {
		return customer;
	}
	public Show getShow() {
		return show;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public double getPrice() {
		return price;
	}
	public boolean isConfirmed() {
		return confirmed;
	}
	
	public void confirmBooking() {
		Seat seat = show.getScreen().getSeats().get(seatNumber -1);
		
		if ( seatNumber < 1 || seatNumber > show.getScreen().getSeats().size()) {
			System.out.println("Tnvalid seat number.");
			return;
		}
		Seat seats = show.getScreen().getSeats().get(seatNumber -1);
		
		if(seat.getStatus()==SeatStatus.AVAILABLE) {
			
			seat.bookSeat();
			
			confirmed = true;
			
			System.out.println("Booking confirmed succesfully.");
			}
		else {
			System.out.println("Booking failed Seat is already booked.");
		}
	}
	
	public void cancelBooking() {
		
		if(confirmed) {
			show.getScreen().cancelSeat(seatNumber);
			confirmed = false;
			System.out.println("Booking cancelled successfully.");
			}
		else {
			System.out.println("The booking is not confirmed.");
		}
	}
	
	
	
	public void displayBooking() {
		System.out.println("==================================================");
		
		System.out.println("Booking ID: " + bookingId);
		
		System.out.println("Customer: " + customer.getName());
		
		System.out.println("Movie: " + show.getMovie().gettitle());
		
		System.out.println("Screen: " + show.getScreen().getScreenNumber());
		
		System.out.println("Seat: " + seatNumber);
		
		System.out.println("Date: " + show.getDate());
		
		System.out.print("Time: " + show.getTime());
		
		System.out.println("Price: " + price);
		
		System.out.println("Confirmed: " + confirmed);
		
		System.out.println("====================================================");
		 
		}
	
	@Override
	public String toString() {
		return "Booking ID: " + bookingId + " | Customer: " + customer.getName() + " | Movie: " + show.getMovie().gettitle()  + "| Seat: " + seatNumber + " | Price: " + price + " | Confirmed: " + confirmed;
	}
	}
