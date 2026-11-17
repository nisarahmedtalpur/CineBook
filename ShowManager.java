package cinebook;

import java.util.ArrayList;

public class ShowManager {
	
	private ArrayList<Show>shows;
	//constracter
	
	public ShowManager() {
		
		shows = new ArrayList<>();
	}
	//method addshow()
	
	public void addShow(Show show) {
		
		shows.add(show);
		
		System.out.println("Show added successfully:");
	}
	
	public void displayAllShows() {
		
		System.out.println();
		
		System.out.println("==========================================================");
		
		System.out.println("CINEBOOK SHOWS");
		
		System.out.println("=============================================================");
		
		  if(shows.isEmpty()) {
			  System.out.println("No shows available.");
			  
			  return;
		  }
		  
		  for (Show show : shows) {
			  
			  System.out.println(show);
		  }
		  
		  System.out.println("===============================================================");
		  
		  System.out.println("Total Shows: " + shows.size());
	}
	
	public Show findShow(int showId) {
		for (Show show : shows) {
			if ( show.getShowId() == showId) {
				
				return show;
			}
		}
		return null;
	}
	 
	public boolean removeShow(int showId) {
		
		Show show = findShow(showId);
		   
		if (show != null) {
			shows.remove(show);
			System.out.println(" Show removed successfully.");
			
			return true;
		}
		System.out.println("Show not found.");
		return false;
	}
	
	public int getShowCount() {
		
		return shows.size();
	}
	
	
	
	
	

}
