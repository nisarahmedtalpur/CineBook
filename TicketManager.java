package cinebook;

import java.util.ArrayList;

public class TicketManager {
	
	private ArrayList<Ticket>tickets;
	
    public TicketManager() {
    	tickets = new ArrayList<>();
    }
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		
		System.out.println("Ticket added successfully.");
		
	}
	
	public void displayAllTickets() {
		
		System.out.println();
		System.out.println("===================================================");
		System.out.println("==CINEBOOK TICKETS==");
		System.out.println("====================================================");
		
		if(tickets.isEmpty()) {
			
			System.out.println("No tickets avialable.");
			return;
		}
		for(Ticket ticket : tickets) {
			System.out.println(ticket);
		}
		
		System.out.println("==============================================================");
		System.out.println("Total Tickets: " + tickets.size());
	}
	
	public Ticket findticket(int ticketId) {
		for (Ticket ticket : tickets) {
			if(ticket.getticketId() == ticketId) {
				return ticket;
				
			}
		}
		return null;
	}
	
	public int getTicketCount() {
		return tickets.size();
	}
	
	public boolean removeTicket(int ticketId) {
		
		Ticket ticket = findticket(ticketId);
		if(ticket != null) {
			tickets.remove(ticket);
			
			System.out.println("Ticket removed successfully.");
			return true;
		}
		
		System.out.println("Ticket not found.");
		
		return false;
	} 
	
	
	public boolean removeTicketByBookingId(int bookingId) {
		for(Ticket ticket : tickets) {
			if(ticket.getBooking().getBookingId() == bookingId) {
				
				tickets.remove(ticket);
				
				System.out.println("Related ticket removed successfully.");
				
				return true;
			}
		}
		
		System.out.println("Related ticket not found.");
		return false;
	}
	
}
