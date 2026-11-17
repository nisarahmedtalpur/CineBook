package cinebook;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
	public static void main(String [] args) {
	Movie movie1 = new  Movie(1,"Avengers","Action",150);
		System.out.println(movie1);
		
		System.out.println("Movie Name: " + movie1.gettitle());
		
		System.out.println("Genre: " + movie1.getGenre());
//		
		System.out.println("Duration:" + movie1.getDurationMinutes());
//		
//		
//		
		Movie movie2 = new Movie(2, "Game of Thrones", "Action", 180);
	   System.out.println(movie2);
           System.out.println("Movie Name: " + movie2.gettitle());
           System.out.println("Genre: " + movie2.getGenre());
           System.out.println("Duration: " + movie2.getDurationMinutes());
//       
		Customer customer = new Customer(101,"Ali", "ali12@gmail.com");
//		
		Admin admin = new Admin(201, "Ahmed", "ahmed45@gmail.com");
//		//customer information
		System.out.println(customer);
//		//Admin information
		System.out.println(admin);
//		
		System.out.println("---------------------------------------------------");
//		
//		
		User user1 = new Customer(102, "Nisar Ahmed", "nisar4@gmail.com");
//		
		User user2 = new Admin(202, "Manager", "manager@cinebook.com");
//		
		System.out.println("User:1 Role: " + user1.getRole());
		System.out.println("User:2 Role: " + user2.getRole());
//		
		Seat seat1 = new Seat(1);
//		
		System.out.println(seat1);
//		
		seat1.bookSeat();
		System.out.println(seat1);
//		
		seat1.bookSeat();
		seat1.cancelSeat();
//		
		System.out.println(seat1);
//		
		System.out.println("...............................................................");
//		
	  Screen screen1 = new Screen(1,5);
//	  
	  System.out.println(screen1);
//	  
	  screen1.displaySeats();
//	  
	  System.out.println("------------------------------------------------------------");
//	  
	  screen1.bookSeat(3);
//	  
	  screen1.displaySeats();
//	  
	  System.out.println("----------------------------------------------------------------------------");
//	  
	  screen1.cancelSeat(3);
//	  
	  screen1.displaySeats();
//	  
//	  
	  Show show1 = new Show(1,movie1, screen1, LocalDate.of(2026, 8, 25 ), LocalTime.of(19, 0));
//	  
	  System.out.println("--------------------------------------------------------------");
//	  
	  show1.displayShow();
//	  
	//  Booking booking1 = new Booking(1001,customer,show1,3,1200.0);
//	  //booking ki initial information
//	  
	 // booking1.displayBooking();
//	  
	  System.out.println("-----------------------------------------------------------");
//	  //confirmed booking 
//	  
	 // booking1.confirmBooking();
//	  
	  System.out.println("----------------------------------------------------------------");
//	  //Conformation booking information
//	  
	  //booking1.displayBooking();
//	  
	  System.out.println("--------------------------------------------------------------");
//	  
//	  // trying again book same seat  
	  
	 // Booking booking2 = new Booking(1002,customer,show1,3,1200.0);
//	  
	  //booking2.confirmBooking();
//	  
	  System.out.println("------------------------------------------------------------------");
//	  // first booking cancel
//	  
	 // booking1.cancelBooking();
	  System.out.println("-----------------------------------------------------------------");
//	  
	 // booking1.displayBooking();
//	  
	  Cinema cinema1 = new Cinema(1, "CineBook Cinema");
//	  //creat screens 
	  Screen screen2 = new Screen(2,5);
	  Screen screen3 = new Screen(3,5);
//	  
	   //screens add in cinema.
//	  
	  cinema1.addScreen(screen2);
	  cinema1.addScreen(screen3);
//	  
//	  //display cinema's information
	  
	  System.out.println("--------------------------------------------------------------------");
	  
	  System.out.println(cinema1);
	  
	  System.out.println("-------------------------------------------------------------------");
	  
	  cinema1.displayScreens();
	  
	  //Scpecific screen find
	  
	  System.out.println("----------------------------------------------------------------");
	  
	  Screen foundScreen = cinema1.getScreen(2);
	  
	  if (foundScreen != null) {
		  System.out.print("Found Screen: " + foundScreen);
	  }
	  else {
		  System.out.println("Screen not found. ");
	  }
		  
		  Payment payment1 = new Payment(5001,1200.0,PaymentMethod.CARD);
		  
		  //initail information of payment
		  
		  System.out.println("--------------------------------------------------------------");
		  System.out.println(payment1);
		  
		  // payment process
		  System.out.println("----------------------------------------------------------------");
		  
		  payment1.processPayment();
		  
		  // payment information
		  
		  System.out.println("-----------------------------------------------------------------");
		  System.out.println(payment1);
		  
		  Customer ticketCustomer = new Customer(301,"Nisar","nisar2cinebook.com");
		  
		  Booking ticketBooking = new Booking(2001,ticketCustomer,show1,4,1200.0);
		  // step 3 confirming booking
		  
		  System.out.println("======================================================================");
		  
		  System.out.println("Step 1: CONFIRMING BOOKING");
		  
		  System.out.println("=====================================================================");
		  
		  ticketBooking.confirmBooking();
		  // step 4: Payment 
		  
		  Payment ticketPayment = new Payment(6001,1200,PaymentMethod.CARD);
		  
		  System.out.println();
		  System.out.println("=====================================================================");
		  
		  System.out.println("Step 2: PROCESSING PAYMENT");
		  System.out.println("======================================================================");
		  
		  ticketPayment.processPayment();
		  //step 5: creat ticket
		  
		  Ticket ticket1 = new Ticket(9001,ticketBooking,ticketPayment); 
		  
		  // step 6 Display final ticket
		  
		  System.out.println();
		  System.out.println("=================================================");
		  System.out.println("STEP 3: TICKET GENERATED");
		  System.out.println("===================================================");
		  
		  ticket1.displayTicket();
		  
		  BookingManager manager = new BookingManager();
		  
		  Customer customer1 =new Customer(401,"Ali","ali@gmail.com");
		  
		  Booking booking1 = new Booking(3001,customer,show1,1,1200.0);
		  
		  booking1.confirmBooking();
		  
		  manager.addBooking(booking1);
		  
		  Customer customer2 = new Customer(402,"Ahmed","ahmed@gmail.com");
		  
		  Booking booking2 = new Booking(3002,customer2,show1,2,1200.0);
		  
		  booking2.confirmBooking();
		  
		  manager.addBooking(booking2);
		  System.out.println();
		  
		  manager.displayAllBooking();
		  
		  //System.out.println();
		  //System.out.println("Searching for Booking ID: 3001");
		  
		  //Booking foundBooking = manager.findBooking(3001);
		  
		  //if(foundBooking !=null) {
			//  System.out.println("Booking Found");
			//  System.out.println(foundBooking);
		  //} else {
			//  System.out.println("Booking not found");
		 // }
		  
		 // System.out.println();
		  //System.out.println("Total Bookings: " + manager.getBookingCount());
		  
		  System.out.println();
		  
		  System.out.println("Total Booking: " + manager.getBookingCount()); 
		  
		  MovieManager movieManager = new MovieManager();
		  // add exixting Movie objects
		  
		  movieManager.addMovie(movie1);
		  movieManager.addMovie(movie2);
		  //dispaly movie all id
		  movieManager.displayAllMovies();
		  // Search Movie by Id
		  
		  System.out.println();
		  System.out.println("Search for Movie ID: 1");
		  
		  Movie foundMovie = movieManager.findMovie(1);
		  
		  if (foundMovie != null) {
			  System.out.println("Movie Found: " + foundMovie);
		  } else {
			  System.out.println("Movie not found.");
		  }
		  
		  // total Movies
		  System.out.println();
		  System.out.println("Total Movies: " + movieManager.getMovieCount());	
		  
		  
		  
		  ShowManager showManager = new ShowManager();
		  
		  
		  showManager.addShow(show1);
		  
		  Show show2 = new Show(102,movie2,screen1, java.time.LocalDate.now(), java.time.LocalTime.of(21,0));
		  
		  showManager.addShow(show2);
		  
		  
		  showManager.displayAllShows();
		  
		  
		  System.out.println();
		  System.out.println("Searching for Show ID: 1");
		  
		  Show foundShow = showManager.findShow(1);
		  
		  if (foundShow != null) {
		      System.out.println("Show Found: ");
		  } else {
			  System.out.println("Show not found.");
		  }
		  
		  
		  System.out.println();
		  
		  System.out.println("Total Shows: " + showManager.getShowCount());
		  
		  
		  CinemaManager cinemaManager = new CinemaManager();
		  
		  Cinema cinemaManagerTest1 = new Cinema(1,"CineBook Cinema");
		  
		  Cinema cinemaManagerTest2 = new Cinema(2,"CineBook Premium Cinema");
		  
		  
		  
		  cinemaManager.addCinema(cinemaManagerTest1);
		  
		  cinemaManager.addCinema(cinemaManagerTest2);
		  
		  cinemaManager.displayAllCinemas();
		  
		  System.out.println();
		  System.out.println("Searching for Cinema ID 1");
		  
		  Cinema foundCinema = cinemaManager.findCinema(1);
		  
		  if (foundCinema != null) {
			  System.out.println("Cinema Found:");
			  System.out.println(foundCinema);
		  } else {
			  System.out.println("Cinema not found.");
		  }
		  
		  System.out.println();
		  
		  System.out.println("Total Cinemas: " + cinemaManager.getcinemaCount());
		  
		  SeatManager seatManager = new SeatManager();
		  
		  Seat seatManagerTest1 = new Seat(1);
		  Seat seatManagerTest2 = new Seat(2);
		  Seat seatManagerTest3 = new Seat(3);
		  Seat seatManagerTest4 = new Seat(4);
		  
		  ///add seat
		  /// 
		  
		  seatManager.addSeat(seatManagerTest1);
		  seatManager.addSeat(seatManagerTest2);
		  seatManager.addSeat(seatManagerTest3);
		  seatManager.addSeat(seatManagerTest4);
		  
		  
		  seatManager.displayAllSeats();
		  
		 //find seat
		  
		  System.out.println();
		  System.out.println("Searching for Seat Number: 2");
		  
		  Seat foundSeat = seatManager.findSeat(2);
		    if(foundSeat != null) {
		    	System.out.println("Seat Found:");
		    	System.out.println(foundSeat);
		    	} 
		    else {
		    	System.out.println("Seat not found.");
		    	}
		    
		    
		    System.out.println();
		    System.out.println("Total Seat: " + seatManager.getSeatCount());
		    
		    
		    TicketManager ticketManager = new TicketManager();
		    
		    System.out.println();
		    System.out.println("====================================================");
		    System.out.println("  TICKET MANAGER TEST ");
		    System.out.println("===================================================");
		    
		    
		    Ticket ticketManagerTest1 = new Ticket(1,booking1, payment1);
		    
		    ticketManager.addTicket(ticketManagerTest1);
		    
		    ticketManager.displayAllTickets();
		    
		    System.out.println();
		    System.out.println("Searching for Ticket ID: 1");
		    
		    Ticket foundTicket = ticketManager.findticket(1);
		    
		    if(foundTicket != null) {
		    	System.out.println("Ticket Found:");
		    	System.out.println(foundTicket);
		    	}
		    else {
		    	System.out.println("Ticket not found.");
		    }
		    
		    System.out.println();
		    System.out.println("Total Tickets: " + ticketManager.getTicketCount());
		    
		    
		    
		    
		    UserManager userManager = new UserManager();
		    
		    System.out.println();
		    System.out.println("=====================================================");
		    System.out.println("		USER MANAGER TEST" );
		    System.out.println("=======================================================");
		    
		    
		    userManager.addUser(customer1);
		    userManager.addUser(admin);
		    
		    userManager.displayAllUsers();
		    
		    System.out.println();
		    System.out.println("Total Users: " + userManager.getUserCount());
		    
		    BookingManager bookingManager = new BookingManager();
		    //TicketManager ticketManager = new TicketManager();
		    BookingService bookingService = new BookingService(bookingManager,ticketManager);
		    
		    System.out.println();
		    System.out.println("===========================================================");
		    System.out.println("		BOOKING SERVICE TEST");
		    System.out.println("=============================================================");
		    
		   // Ticket serviceTicket = bookingService.creatBooking(booking1, payment1, 2);
		    Booking bookingServiceTest1 = new Booking(3, customer1 ,show1, 3, 1200.0);
		   // Booking(int bookingId,Customer customer, Show show, double price);
		    Payment paymentServiceTest1 = new Payment(1,1200.0,PaymentMethod.CARD);
		    
		    Ticket serviceTicket = bookingService.creatBooking(bookingServiceTest1, paymentServiceTest1,2);
		    
		    if(serviceTicket != null) {
		    	
		    	System.out.println();
		    	System.out.println("Booking Service Result:");
		    	
		    	serviceTicket.displayTicket();
		    	}
		    else {
		    	System.out.println("Booking Service failed.");
		    }
		    
		    System.out.println();
		    System.out.println("=============================================");
		    System.out.println("BOOKING CANCELLATION TEST");
		    System.out.println("===============================================");
		    
		    boolean cancellationResult = bookingService.cancelBooking(3);
		    
		    if(cancellationResult) {
		    	System.out.println("Cancellation successfull.");
		    }
		    else {
		    	System.out.println("Cancellation failed.");
		    }
		    
		    System.out.println();
		    System.out.println("Ticket After Cancellation:");
		    	ticketManager.displayAllTickets();
		    	
		    	System.out.println();
		    	System.out.println("Bookings After Cancellation:");
		    	
		    	//bookingManager.displayAllBookings();
		    
		    
		  }
}
























