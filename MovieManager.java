package cinebook;

import java.util.ArrayList;

public class MovieManager {
	
	private ArrayList<Movie>movies;
	
	public MovieManager() {
		
		movies = new ArrayList<>();
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
		System.out.println("Movie added successfully.");
	}
	public void displayAllMovies() {
		
		System.out.println();
		System.out.println("===============================================================");
		System.out.println("CINEBOOK MOVIE LIST");
		
		System.out.println("=================================================================");
		  
		if(movies.isEmpty()) {
			
			System.out.println("No movies availble.");
			return;		
		}
		
		for (Movie movie : movies) {
			System.out.println("==================================================================");
		}
		System.out.println("Total Movies: " + movies.size());
	}
	
	public Movie findMovie(int movieId) {
		
		for (Movie movie : movies) {
			if (movie.getid()==movieId) {
				return movie;
			}
		}
		return null;
	}
	
	public boolean removeMovie(int movieId) {
		
		Movie movie = findMovie(movieId);
		
		 if(movie != null) {
			 movies.remove(movie);
			 System.out.println("Movie removed successfully.");
			 return true;
		 }
		 return false;
	}
	
	
	public int getMovieCount() {
		return movies.size();
	}
	}
