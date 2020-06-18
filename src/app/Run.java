package app;

import java.util.Scanner;

import model.Time;

public class Run {

	public static void main(String[] args) {
		ApiService service = new ApiService();
		Scanner scan = new Scanner(System.in);

		String msg = " TYPE TIMEZONE (e.g.\"Europe/Warsaw\") TO GET TIME \n" + " TYPE \"exit\" TO QUIT \n" + " CONFIRM WITH ENTER \n";
		System.out.print(msg);

		String input = scan.next();
		while (!input.equals("exit")) {
			Time time;
			try {
				time = service.getTime(input);
				System.out.println(service.getFormatedDateTime(time));
			} catch (Exception e) {
				System.out.println("exception in Run");
				service.printTimezones();
			}
			input = scan.next();
		}

		scan.close();

	}

}
