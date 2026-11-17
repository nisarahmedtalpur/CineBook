package cinebook;
public class Movie{
	private int id;
	private String title;
	private String genre;
	private int durationMinutes;


	public Movie(int id, String title, String genre, int durationMinutes) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.durationMinutes = durationMinutes;
		}
	 public int getid() {
		 return id;
	 }
	 public String gettitle() {
		 return title;
	 }
	 public String getGenre() {
		 return genre;
	 }
	 public int getDurationMinutes() {
		 return durationMinutes;
	 }
	 
	 @Override
	 public String toString() {
		 return "Movie ID: " + id + "| Title:" + title + "| Genre:" + genre + "| Duration: " + durationMinutes + "minutes"; 
		  


	
	 
	 }
}
	 
	 
	 




































      



