package app;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import model.Time;

public class ApiService { //service for worldtimeapi.org

	private final String URL = "http://worldtimeapi.org/api";

	private String getResponse(String url) throws Exception {
		HttpURLConnection connection;
		InputStream response;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			if (connection.getResponseCode() == 404) {
				throw new Exception("Not found");
			}
			response = connection.getInputStream();
			Scanner scanner = new Scanner(response);
			String responseBody = scanner.useDelimiter("\\A").next();
			scanner.close();
			return responseBody;
		} catch (MalformedURLException e) {
			return "bad url";
		} catch (IOException e) {
			return "bad url";
		}
	}

	public Time getTime(String timezone) throws Exception {
		String url = URL + "/timezone/" + timezone;
		String json = getResponse(url);
		Time time = DeserializeToTime(json);
		return time;
	}

	private Time DeserializeToTime(String json) {
		Gson g = new Gson();
		Time time = g.fromJson(json, Time.class);
		return time;
	}

	public String getFormatedDateTime(Time time) {
		String dateTime = time.getDatetime();
		String formatedDateTime = dateTime.replace('T', ' ').substring(0, dateTime.indexOf('+'));
		return formatedDateTime;
	}

	public String[] getTimezones() throws Exception {
		String url = URL + "/timezone/";
		String[] timezones = {};
		String response = getResponse(url);
		timezones = response.substring(1, response.length() - 1).split(",");
		return timezones;
	}

	public void printTimezones() {
		String[] timezones;
		try {
			timezones = getTimezones();
			for (String timezone : timezones) {
				System.out.println(timezone);
			}
		} catch (Exception e) {
			System.out.println("Error: can't load timezones");
		}

	}

}
