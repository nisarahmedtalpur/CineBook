package cinebook;
import java.util.ArrayList;

public class SeatManager {
	
	private ArrayList<Seat>seats;
	
	public SeatManager() {
		
		seats = new ArrayList();
	}
	
	public void addSeat(Seat seat) {
		
		seats.add(seat);
		
		System.out.println("Seat added successfully.");
			}
	
	public void displayAllSeats() {
		
		System.out.println();
		System.out.println("====================================================");
		System.out.println(" CINEBOOK SEATS");
		System.out.println("======================================================");
		
		if(seats.isEmpty()) {
			System.out.println("No seats avialable.");
			return;
		}	
		for (Seat seat : seats) {
			System.out.println(seat);
		}
		
		System.out.println("==============================================================");
		System.out.println("Total Seat: " + seats.size());
	}
	
	
	
	public Seat findSeat(int seatnumber) {
		for(Seat seat : seats) {
		if(seat.getseatNumber() == seatnumber) {
			
			return seat;
		}
		
		}
		return null;
	}
	
	public int getSeatCount() {
		
		return seats.size();
	}
	
	public boolean removeSeat(int seatNumber) {
		
		Seat seat = findSeat(seatNumber);
		 if(seat != null) {
			 seats.remove(seat);
			 System.out.println("Seat removed successfully.");
			 return true;
		 }
		 System.out.println("seat not found.");
		 return false;
	}
	
	}
