package cinebook;
import java.util.ArrayList;

public class Cinema {
	
	private int cinemaId;
	private String name;
	
	//one cinema can have multiple Screens.
	private ArrayList<Screen>screens;
	//constructor
	public Cinema(int cinemaId,String name) {
		this.cinemaId = cinemaId;
		this.name = name;
		//arrayList
		screens = new ArrayList<>();
		}
	//getter methodes
	public int getCinemaId() {
		return cinemaId;
	}
	
	public String getName() {
		return name;
	}
	public ArrayList<Screen>getScreens(){
		return screens;
	}
	
	//methode add screen
	
	public void addScreen(Screen screen) {
		screens.add(screen);
		System.out.println("Screen" + screen.getScreenNumber() + "added successfully.");
		}
	public void displayScreens() {
		System.out.println("Cinema: " + name);
		System.out.println("Total Screens: " + screens.size());
		
		for (Screen screen : screens) { 
			System.out.println(screen);
		}
	}
	
	public Screen getScreen(int screenNumber) {
		for (Screen screen : screens) {
            if (screen.getScreenNumber()==screenNumber) {
            	return screen;
            }
		}
		return null;
		
	}
	@Override
	public String toString () {
		return "Cinema ID: " + cinemaId + " | Name: " + name + " | Screens: " +screens.size();
		
	    }
	 }
