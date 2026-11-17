package cinebook;

import java.util.ArrayList;

public class CinemaManager {
	
	private ArrayList<Cinema>cinemas;
	
	public CinemaManager() {
		cinemas = new ArrayList<>();
	}
	
	public void addCinema(Cinema cinema) {
		
		cinemas.add(cinema);
		
		System.out.println("Cinema added successfully.");
		
	}
	
	public void displayAllCinemas() {
		System.out.println();
		
		System.out.println("=================================================");
		System.out.println("CINEBOOK CINEMAS");
		System.out.println("===================================================");
		
		if (cinemas.isEmpty()) {
			
			System.out.println("No cinemas avialable.");
			return;
		}
		
		for (Cinema cinema : cinemas) {
			 System.out.println(cinema);
		}
		
		System.out.println("==============================================");
		
		System.out.println("Total Cinemas:" + cinemas.size());
	}
	
	public Cinema findCinema(int cinemaId) {
		for(Cinema cinema : cinemas) {
			if (cinema.getCinemaId() == cinemaId) {
				return cinema;
			}
		}
		return null;
	}
	
	public boolean removeCinema(int cinemaId) {
		Cinema cinema = findCinema(cinemaId);
		if(cinema != null) {
			
			cinemas.remove(cinema);
			
			System.out.println("Cinema removed successfully.");
			return true;
		}
		System.out.println("Cinema not found.");
		
		return false;
	}
	
	public int getcinemaCount() {
		
		return cinemas.size();
	}
	}
