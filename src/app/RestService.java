package app;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Time;

public class RestService {

	public String getTime(String timezone) { //propably should return model.Time (not String)
												//but in this simple app I think it's ok 
		String url = "http://worldtimeapi.org/api/timezone/" + timezone;
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			if (connection.getResponseCode() == 404) {
				printTimezones();
				return "wrong timezone. valid ones^";
			}
			InputStream response = connection.getInputStream();
			Scanner scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			scanner.close();

			Gson g = new Gson(); //external library used for deserialization
			Time time = g.fromJson(responseBody, Time.class);
			String dateTime = time.getDatetime();
			String formatedDateTime = dateTime.replace('T', ' ').substring(0, dateTime.indexOf('+'));
			return formatedDateTime;

		} catch (MalformedURLException e) {
			return "bad url";
		} catch (IOException e) { //happens if no internet connection or api is off
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
