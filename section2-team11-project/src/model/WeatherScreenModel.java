package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import weather.LoadAPI;
import weather.ProcessData;

public class WeatherScreenModel {
	LoadAPI api;
	ProcessData data;
	private String temp;
	private String tempSetting;
	private String city;
	private String state;
	private String time;
	
	/**
	 * Constructor method
	 */
	public WeatherScreenModel(LoadAPI wApi, ProcessData wdata) {
		this.api = wApi;
		this.data = wdata;
		this.setTime();
	}

	public String getTemp() {
		return temp;
	}
	
	public void setTemp() {	
		// if F
		temp = data.getTempF();
		// else
		// temp = data.getTempC();
	}
	
	public String getTempSetting() {
		return tempSetting;
	}
	
	public void setTempSetting() {  // for now returns F.. probably need to call OptionsScreen? 
		// if F
		tempSetting = "F";
		// if C
		// tempSetting = "C";
	}
	
	public String getCity() {
		return city;
	}

	public void setCity() {
		city = data.getCity();
	}

	public String getState() {
		return state;
	}

	public void setState() {
		state = data.getStateName();
	}
	public String getTime() {
		return time;
	}
	
	public void setTime() {
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mma"); // can change to military time with HH:mm
        time = sdf.format(cal.getTime());
	}
	

}
