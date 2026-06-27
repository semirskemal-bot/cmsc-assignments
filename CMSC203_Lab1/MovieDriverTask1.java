import java.util.Scanner;

public class MovieDriverTask1 {

	public static void main(String[] args) {
		Scanner keybaord = new Scanner(System.in);
		
		Movie m = new Movie();
		System.out.println("Enter title of movie: ");
		m.setTitle(keybaord.nextLine());
		System.out.println("Enter movie rating: ");
		m.setRating(keybaord.nextLine());
		System.out.println("Enter movie tickets sold: ");
		m.setSoldTickets(keybaord.nextInt());
		keybaord.close();
		System.out.println(m.toString());

		
		
		

		
		
		

	}

}
