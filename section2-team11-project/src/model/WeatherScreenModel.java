package model;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.ImageViewBuilder;
import javafx.scene.text.TextBuilder;
import weather.LoadAPI;
import weather.ProcessData;

public class WeatherScreenModel {
	LoadAPI api;
	private ProcessData data;
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
	private String BckGImg;
	private OptionsScreenModel optionsModel;
	private ArrayList<Label> highTemps;
	private ArrayList<Label> lowTemps;

	/**
	 * Constructor method for WeatherScreenModel
	 */
	public WeatherScreenModel(LoadAPI wApi, ProcessData wdata) {
		this.api = wApi;
		this.setData(wdata);
		this.setTime();
		optionsModel = new OptionsScreenModel();
		highTemps= new ArrayList<>();
		lowTemps = new ArrayList<>();
	}

	/**
	 * @return the data
	 */
	public ProcessData getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(ProcessData data) {
		this.data = data;
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
		this.weatherCondition = getData().getWeatherCondition();
	}

	/**
	 * Returns temperature in F or C
	 * @return
	 */
	public String getTemp() {
		return this.temp;
	}
	
	public String getBckGImg(){
		String weatherCondition = getData().getIconName();
		String[] snow = {"chanceflurries", "snow", "chancesleet", "chancesnow", "flurries", "sleet"};
		String[] rain = {"chancerain","rain"};
		String[] clear = {"clear", "mostlysunny", "partlysunny", "sunny", "unknown"};
		String[] cloudy = {"cloudy","mostlycloudy"};
		String[] pCloudy = {"partlycloudy"};
		String[] fog = {"fog","hazy"};
		for(int i = 0; i < snow.length; i++){
			if(weatherCondition.equals(snow[i]))
				{
					return"snow.jpg";
				}
		}
		for(int i = 0; i < rain.length; i++){
			if(weatherCondition.equals(rain[i]))
				{
					return "rain.jpg";
				}
		}
		for(int i = 0; i < clear.length; i++){
			if(weatherCondition.equals(clear[i]))
				{
					return "clear.jpg";
				}
		}
		for(int i = 0; i < cloudy.length; i++){
			if(weatherCondition.equals(cloudy[i]))
				{
					return "cloudy.jpg";
				}
		}
		for(int i = 0; i < pCloudy.length; i++){
			if(weatherCondition.equals(pCloudy[i]))
				{
					return "partlycloudy.jpg";
				}
		}
		for(int i = 0; i < fog.length; i++){
			if(weatherCondition.equals(fog[i]))
				{
					return "fog.jpg";
				}
		}
		return "unknown.jpg";
	}
	/**
	 * Calls on Process Data class to get temperature in desired setting
	 */
	public void setTemp() {	
		if(tempSetting.equals("F"))
			this.temp = getData().getTempF();
		else
			temp = getData().getTempC();

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
		this.city = getData().getCity();
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
		this.state = getData().getStateName();
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
	public String getForecastDay(int n) {
		return getData().getForecastDayOfWeek(n);

	}


	public String getTodayIcon() {
		// TODO Auto-generated method stub
		return this.todayIcon;
		//Systemz.out.println(data.getForecastDayOfWeek(1));

	}
	public void setTodayIcon(){
		this.todayIcon= getData().getIconURL();
	}


	public String getIcon() {
		return this.icon;
	}

	/**
	 * Calls on Process Data to get icon that matches weather of the day, n, which is passed as parameter
	 * @param n, the day of the week
	 */
	public void setIcon(int n){
		this.icon= getData().getForecastIconURL(n);
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
		this.day = getData(). getForecastDayOfWeek(n); // data. getForecastDayOfWeekShort(n)
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
		this.high = getData().getForecastLowF(n);
		// else
		// this.high = data.getForecastLowC(n);
	}
	
	public void setHighTemps() {
		for(int i = 0; i <= 8; i++) {
			
			Label temp = new Label();
			if(this.tempSetting.equals("F"))  {
				temp.setText(data.getForecastHighF(i+1));
			}
			else
				temp.setText(data.getForecastHighC(i+1));
        		highTemps.add(i,temp);
        }
	}
	
	public ArrayList<Label> getHighTemps() {
		return this.highTemps;
	}
	
	
	public void setLowTemps() {
		for(int i = 0; i <= 8; i++) {
			
			Label temp = new Label();
			if(this.tempSetting.equals("F"))  {
				temp.setText(data.getForecastLowF(i+1));
			}
			else
				temp.setText(data.getForecastLowC(i+1));
        		lowTemps.add(i,temp);
        }
	}	
	public ArrayList<Label> getLowTemps() {
		return this.lowTemps;
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
		this.forecastCondition = getData().getForecastConditions(n); // 
	}
	
	public String getWindSpeed() {
		return this.windSpeed;
	}
	
	public void setWindSpeed(int n) {

		if (this.windSetting.equals("MPH"))
			this.windSpeed = data.getForecastWindMPH(n);
		else 
			this.windSpeed = getData().getForecastWindKPH(n);
	}
	
	public String getWindSettings() {
		return this.windSetting;
	}
	
	public void setWindSettings(String setting) {  // sets wind speed unit after toggle button has been clicked
		this.windSetting = setting;
	}
	
	public void setWindSettings() {  // sets wind speed unit according to what is in OptionsModel
		this.windSetting = optionsModel.getWindOpt();
	}


}
