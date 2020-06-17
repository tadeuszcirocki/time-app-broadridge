package app;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		RestService service = new RestService();
		Scanner scan = new Scanner(System.in);

		String msg = " TYPE TIMEZONE (e.g.\"Europe/Warsaw\") TO GET TIME \n" + " TYPE \"exit\" TO QUIT \n" + " CONFIRM WITH ENTER \n";
		System.out.print(msg);

		String input = scan.next();
		while (!input.equals("exit")) {
			System.out.println(service.getTime(input));
			input = scan.next();
		}

		scan.close();

	}

}
