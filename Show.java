package cinebook;

import java.time.LocalDate;
import java.time.LocalTime;

public class Show {
	
	private int showId;
	
	private Movie movie;
	
	private Screen screen;
	
	private LocalDate date;
	
	private LocalTime time;
	
	public Show(int showId, Movie movie, Screen screen, LocalDate date, LocalTime time) {
		
		this.showId = showId;
		this.movie = movie;
		this.screen = screen;
		this.date = date;
		this.time = time;
		
	}
	
	public int getShowId() {
		return showId;
	}
	public Movie getMovie() {
		return movie;
		}
	public Screen getScreen() {
		return screen;
	}
	public LocalDate getDate() {
		return date;
	}
	public LocalTime getTime() {
		return time;
	}
	
	public void displayShow() {
		System.out.println("Show ID: " + showId);
		
		System.out.println("Movie: " + movie.gettitle());
		
		System.out.println("Genre: " + movie.getGenre());
		System.out.println("Screen: " + screen.getScreenNumber());
		System.out.println("Date: " + date);
		System.out.println("Time: " + time);
		}
	
	@Override
	
	public String toString() {
		return "Show ID: " + showId + " | Movie: " + movie.gettitle() + " | Screen: " + screen.getScreenNumber() + " | Date: " + date + " | Time: " + time; 
	}
	
	}
