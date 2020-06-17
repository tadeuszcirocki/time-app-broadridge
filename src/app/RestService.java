package app;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Time;

public class RestService {

	public String getTime(String timezone) {
		String url = "http://worldtimeapi.org/api/timezone/" + timezone;
		try {
			InputStream response = new URL(url).openStream();
			Scanner scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			scanner.close();

			Gson g = new Gson();
			Time time = g.fromJson(responseBody, Time.class);
			return time.getDatetime();
		} catch (MalformedURLException e) {
			//e.printStackTrace();
			printTimezones();
			return "WRONG here's valid timezones^";
		} catch (IOException e) {
			//e.printStackTrace();
			return "can't connect to the server";
		}
	}

	public String[] getTimezones() {
		String url = "http://worldtimeapi.org/api/timezone/";
		String[] timezones = {};
		try {
			InputStream response = new URL(url).openStream();
			Scanner scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			scanner.close();
			timezones = responseBody.substring(1, responseBody.length() - 1).split(",");
			return timezones;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return timezones;
		} catch (IOException e) {
			e.printStackTrace();
			return timezones;
		}
	}

	public void printTimezones() { //could merge "get" and "print" in one method but
									//"get" may be usefull standalone
		String[] timezones = getTimezones();
		for (String timezone : timezones) {
			System.out.println(timezone);
		}
	}

}
