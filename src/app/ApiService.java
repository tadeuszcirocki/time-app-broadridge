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

	public String getFormatedDateTime(Time time) {
		String dateTime = time.getDatetime();
		String formatedDateTime = dateTime.replace('T', ' ').substring(0, dateTime.indexOf('+'));
		return formatedDateTime;
	}

	public Time getTime(String timezone) throws Exception {
		String url = URL + "/timezone/" + timezone;
		String json = getResponseJson(url);
		Time time = DeserializeToTime(json);
		return time;
	}

	private String getResponseJson(String url) throws Exception {
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

	private Time DeserializeToTime(String json) {
		Gson g = new Gson();
		Time time = g.fromJson(json, Time.class);
		return time;
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

	public void printTimezones() {
		String[] timezones = getTimezones();
		for (String timezone : timezones) {
			System.out.println(timezone);
		}
	}

}
