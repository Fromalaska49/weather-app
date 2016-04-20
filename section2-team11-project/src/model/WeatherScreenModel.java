package model;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import weather.LoadAPI;
import weather.ProcessData;

public class WeatherScreenModel {
	LoadAPI api;
	ProcessData data;
	private String weatherCondition;
	private String temp;
	private String tempSetting;
	private String city;
	private String state;
	private String time;
	private String todayIcon;
	private String icon;
	private String day;
	private String high;
	private String low;
	private String forecastCondition;
	private String windSpeed;
	private String windSetting;
	private OptionsScreenModel optionsModel;

	/**
	 * Constructor method for WeatherScreenModel
	 */
	public WeatherScreenModel(LoadAPI wApi, ProcessData wdata) {
		this.api = wApi;
		this.data = wdata;
		this.setTime();
		optionsModel = new OptionsScreenModel();
	}

	/**
	 * Returns a brief description of current weather e.g. "partly cloudy"
	 * @return
	 */
	public String getWeatherCondition() {
		return this.weatherCondition;
	}

	/**
	 * Calls on Process Data to get a description of current weather conditions
	 */
	public void setWeatherCondition() {
		this.weatherCondition = data.getWeatherCondition();
	}

	/**
	 * Returns temperature in F or C
	 * @return
	 */
	public String getTemp() {
		return this.temp;
	}

	/**
	 * Calls on Process Data class to get temperature in desired setting
	 */
	public void setTemp() {	
		if(tempSetting.equals("F"))
			this.temp = data.getTempF();
		else
			temp = data.getTempC();

	}

	/**
	 * Returns temperature setting as "C" or "F"
	 * @return
	 */
	public String getTempSetting() {
		return this.tempSetting;
	}

	/**
	 * Sets temperature setting to C or F based off of what was passed in parameter
	 * @param setting "C" or "F"
	 */

	public void setTempSetting(String setting) {  // uses parameteter passed from WeatherScreenController
		this.tempSetting = setting;
	}
	public void setTempSetting() {  // uses configurations in OptionsScreenModel
		this.tempSetting = optionsModel.getTempOpt();

	}

	/**
	 *  Returns city
	 * @return
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 * Calls on Process Data class to get current city
	 */
	public void setCity() {
		this.city = data.getCity();
	}

	/**
	 * Returns state
	 * @return
	 */
	public String getState() {
		return this.state;
	}

	/**
	 * Calls on Process Data class to get current state
	 */
	public void setState() {
		this.state = data.getStateName();
	}

	/** 
	 * Returns current time
	 * @return
	 */
	public String getTime() {
		return this.time;
	}

	/**
	 * Sets the current time
	 */
	public void setTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a"); // can change to military time with HH:mm
		time = sdf.format(cal.getTime());
	}

	/**
	 * Returns icon
	 * @return
	 */
	/*
	public String getForecastDay(int n) {
		return data.getForecastDayOfWeek(n);
	}*/


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

	/**
	 * Calls on Process Data to get icon that matches weather of the day, n, which is passed as parameter
	 * @param n, the day of the week
	 */
	public void setIcon(int n){
		this.icon= data.getForecastIconURL(n);
	}


	/**
	 * Returns the day of the week
	 * @return
	 */
	public String getDayOfWeek() {
		return this.day;
	}

	/**
	 * Calls on Process Data to get the name of the day, n, which is passed as the parameter
	 * @param n
	 */
	public void setDayOfWeek(int n) {
		this.day = data. getForecastDayOfWeek(n); // data. getForecastDayOfWeekShort(n)
	}

	/**
	 * Returns high temperature in F or C
	 * @return
	 */
	public String getForecastHigh() {
		return this.high;
	}

	/**
	 * Calls on Process Data to get highest temperature of the day, n, which is passed as parameter
	 * @param n
	 */
	public void setForecastHigh(int n) {
		// if f
		this.high = data.getForecastHighF(n);
		// else
		// this.high = data.getForecastHighC(n);
	}

	/**
	 * Returns low temperature in F or C
	 * @return
	 */
	public String getForecastlow() {
		return this.low;
	}

	/**
	 * Calls on Process Data to get lowest temperature of the day, n, which is passed as parameter
	 * @param n
	 */
	public void setForecastLow(int n) {
		// if f
		this.high = data.getForecastLowF(n);
		// else
		// this.high = data.getForecastLowC(n);
	}

	/**
	 * Returns forecast conditions of given day
	 */
	public String getForecastCondition() {
		return this.forecastCondition;
	}

	/**
	 * Calls on Process Data to get the forecast conditions of the day n, which is passed as parameter
	 */
	public void setForecastCondition(int n) {
		this.forecastCondition = data.getForecastConditions(n); // 
	}
	
	public String getWindSpeed() {
		return this.windSpeed;
	}
	
	public void setWindSpeed(int n) {
		if (this.windSetting.equals("MpH"))
			this.windSpeed = data.getForecastWindMPH(n);
		else 
			this.windSpeed = data.getForecastWindKPH(n);
	}
	
	public String getWindSettings() {
		return this.windSetting;
	}
	
	public void setWindSettings() {
		this.windSetting = optionsModel.getWindOpt();
	}


}
