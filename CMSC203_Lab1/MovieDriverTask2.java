import java.util.Scanner;

public class MovieDriverTask2 {

	public static void main(String[] args) {
		char response = 'y';
		while (response=='y') {
			Scanner keyboard = new Scanner(System.in);
			Movie m = new Movie();
			System.out.println("Enter title of movie: ");
			m.setTitle(keyboard.nextLine());
			System.out.println("Enter movie rating: ");
			m.setRating(keyboard.nextLine());
			System.out.println("Enter movie tickets sold: ");
			m.setSoldTickets(keyboard.nextInt());
			System.out.println(m.toString());
			System.out.println("Would you like to enter another? (y or n): ");
			response = (keyboard.next().toLowerCase().charAt(0));


		}



	}

}
