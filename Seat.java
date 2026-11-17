package cinebook;

public class Seat {
	//encapsulation
	private int seatNumber;
	private SeatStatus status;
	//constructor
	public Seat(int seatNumber) {
		this.seatNumber = seatNumber;
		//Initialy every seat is avialable.
		this.status = SeatStatus.AVAILABLE;
	}
	//getter
	public int getseatNumber() {
		return seatNumber;
	}
	public SeatStatus getStatus() {
		return status;
	}
	
	public void bookSeat() {
		if (status == SeatStatus.AVAILABLE) {
			status = SeatStatus.BOOKED;
			System.out.println(seatNumber + "Has been booked.");
		} else {
			System.out.println("Seat " + seatNumber + "is already booked. ");
		}
	}



public void cancelSeat() {
	if (status == SeatStatus.BOOKED ) {
		status = SeatStatus.AVAILABLE;
		
		System.out.println("Seat " + seatNumber + "booking cancelled.");
	}
	else {
		System.out.println("Seat " + seatNumber + "is already available.");
		
	}
		
	}
@Override
public String toString() {
	return "Seat Number: " + seatNumber + " | Status: " + status;
	
}
}

































