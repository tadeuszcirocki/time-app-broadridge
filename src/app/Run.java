package app;

import java.util.Scanner;

import model.Time;

public class Run {

	private final static String MSG = " TYPE TIMEZONE (e.g.\"Europe/Warsaw\") TO GET TIME \n" + " TYPE \"exit\" TO QUIT \n"
			+ " CONFIRM WITH ENTER \n";

	public static void main(String[] args) {
		ConsoleRun();
	}

	private static void ConsoleRun() {
		ApiService service = new ApiService();
		Scanner scan = new Scanner(System.in);
		Time time;

		System.out.print(MSG);

		String input = scan.next();
		while (!input.equals("exit")) {
			try {
				time = service.getTime(input);
				System.out.println(service.getFormatedDateTime(time));
			} catch (Exception e) {
				if (e.getMessage().equals("Not found")) {
					service.printTimezones();
					System.out.println("Wrong timezone, valid ones^");
				} else {
					System.out.println("API is not responding");
				}
			}
			input = scan.next();
		}
		scan.close();
	}

}
