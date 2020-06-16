package model;

public class Time {

	//http://worldtimeapi.org/api/timezone/Europe/London

	private String abbreviation;
	private String client_ip;
	private String datetime;
	private float day_of_week;
	private float day_of_year;
	private boolean dst;
	private String dst_from;
	private float dst_offset;
	private String dst_until;
	private float raw_offset;
	private String timezone;
	private float unixtime;
	private String utc_datetime;
	private String utc_offset;
	private float week_number;

	// Getter Methods 

	public String getAbbreviation() {
		return abbreviation;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public String getDatetime() {
		return datetime;
	}

	public float getDay_of_week() {
		return day_of_week;
	}

	public float getDay_of_year() {
		return day_of_year;
	}

	public boolean getDst() {
		return dst;
	}

	public String getDst_from() {
		return dst_from;
	}

	public float getDst_offset() {
		return dst_offset;
	}

	public String getDst_until() {
		return dst_until;
	}

	public float getRaw_offset() {
		return raw_offset;
	}

	public String getTimezone() {
		return timezone;
	}

	public float getUnixtime() {
		return unixtime;
	}

	public String getUtc_datetime() {
		return utc_datetime;
	}

	public String getUtc_offset() {
		return utc_offset;
	}

	public float getWeek_number() {
		return week_number;
	}

	// Setter Methods 

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public void setDay_of_week(float day_of_week) {
		this.day_of_week = day_of_week;
	}

	public void setDay_of_year(float day_of_year) {
		this.day_of_year = day_of_year;
	}

	public void setDst(boolean dst) {
		this.dst = dst;
	}

	public void setDst_from(String dst_from) {
		this.dst_from = dst_from;
	}

	public void setDst_offset(float dst_offset) {
		this.dst_offset = dst_offset;
	}

	public void setDst_until(String dst_until) {
		this.dst_until = dst_until;
	}

	public void setRaw_offset(float raw_offset) {
		this.raw_offset = raw_offset;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public void setUnixtime(float unixtime) {
		this.unixtime = unixtime;
	}

	public void setUtc_datetime(String utc_datetime) {
		this.utc_datetime = utc_datetime;
	}

	public void setUtc_offset(String utc_offset) {
		this.utc_offset = utc_offset;
	}

	public void setWeek_number(float week_number) {
		this.week_number = week_number;
	}

}
