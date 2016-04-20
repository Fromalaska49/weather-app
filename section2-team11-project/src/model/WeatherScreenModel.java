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
	private String todayIcon;
	private String icon;
	private String day;

	/**
	 * Constructor method for WeatherScreenModel
	 */
	public WeatherScreenModel(LoadAPI wApi, ProcessData wdata) {
		this.api = wApi;
		this.data = wdata;
		this.setTime();
	}

	/**
	 * Returns temperature
	 * @return
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * Calls on Process Data class to get temperature in desired setting
	 */
	public void setTemp() {	
		// if F
		temp = data.getTempF();
		// else
		// temp = data.getTempC();
	}

	/**
	 * Returns temperature setting 
	 * @return
	 */
	public String getTempSetting() {
		return tempSetting;
	}

	/**
	 * Sets temperature setting to C or F
	 */
	public void setTempSetting() {  // for now returns F.. probably need to call OptionsScreen? 
		// if F
		tempSetting = "F";
		// if C
		// tempSetting = "C";
	}

	/**
	 *  Returns city
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Calls on Process Data class to get current city
	 */
	public void setCity() {
		city = data.getCity();
	}

	/**
	 * Returns state
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * Calls on Process Data class to get current state
	 */
	public void setState() {
		state = data.getStateName();
	}

	/** 
	 * Returns current time
	 * @return
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Sets the current time
	 */
	public void setTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a"); // can change to military time with HH:mm
		time = sdf.format(cal.getTime());
	}
	public String getForecastDay(int n) {
		return data.getForecastDayOfWeek(n);
	}


	public String getTodayIcon() {
		// TODO Auto-generated method stub
		return this.todayIcon;
		//Systemz.out.println(data.getForecastDayOfWeek(1));

	}
	public void setTodayIcon(){
		this.todayIcon= data.getIconURL();
	}

	public String getIcon() {
		return this.icon;

	}
	public void setIcon(int n){
		this.icon= data.getForecastIconURL(n);
	}

	public String getWeatherCondition() {
		// TODO Auto-generated method stub
		return data.getWeatherCondition();
		
	}

}
