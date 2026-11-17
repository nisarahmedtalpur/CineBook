package cinebook;
import java.util.ArrayList;

public class Screen {
	private int screenNumber;
	
	private ArrayList<Seat>
	seats;
	//constructor
	public Screen(int screenNumber, int totalSeats) {
		this.screenNumber = screenNumber;
		//Arraylist create
		seats = new ArrayList<>();
		//Required number of seats automatically create
		
		for(int i =1;i<=totalSeats; i++) {
			
			seats.add(new Seat(i));
			}
	}
	
	//getter
	public int getScreenNumber() {
		return screenNumber;
	}
	//getter
	public ArrayList<Seat>
	getSeats(){
		return seats;
	}
	///method. displayseats
    //display sreen seats
	
	public void displaySeats() {
		System.out.println("Screen " + screenNumber + "Seats: ");
		
		for(Seat seat : seats) {
			System.out.println(seat);
		}
	}
	public void bookSeat(int seatNumber) {
		if (seatNumber < 1 || seatNumber > seats.size()) {
			System.out.println("Invalid seat number:");
			
		return;
		
	}
	Seat seat = seats.get(seatNumber -1);
	
	seat.bookSeat();
	}
	//method cancel seat()
  ///specific seat cancel
       public void cancelSeat(int seatNumber) {
    	   if (seatNumber < 1 || seatNumber > seats.size()) {
    		   System.out.println("Invali seat number.");
    		   return;
    		   }
    	   Seat seat = seats.get(seatNumber -1);
    	    seat.cancelSeat();
       }
       @Override
       public String toString() {
    	   return "Screen Number: " + screenNumber + " | Total Seats: " + seats.size();
       }
       }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

