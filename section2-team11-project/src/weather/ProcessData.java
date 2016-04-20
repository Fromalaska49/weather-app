package weather;

import org.w3c.dom.*;
import java.io.File;
import javax.xml.parsers.*;
import javax.xml.xpath.*;


public class ProcessData {
	
	public void ProcessData() {
		return;
	}
	
	/*
	 * Takes an xpath argument and fetches the referenced data from the XML file
	 * 
	 */
	private String getNode(String XPath, String fileName) {
		String value = "undefined";
		try {
			File inputFile = new File(fileName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xPath =  XPathFactory.newInstance().newXPath();
			value = (String) xPath.compile(XPath).evaluate(doc, XPathConstants.STRING);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	/*
	 * 
	 * For all of the forecast methods below, the index
	 * parameter is the number of days in the future that
	 * you want to get the forecasted data for.
	 * Example: If you wanted to get the forecasted high
	 * temperature for tomorrow, you would call:
	 * String highTomorrow = getForecastHighF(1);
	 * 
	 */
	
	
	
	
	/*
	 * Gets the data from the forecast
	 * Returns the day of the week at the given index
	 * i.e. if today is Wednesday, and index=0, then "Friday" will be returned
	 */
	public String getForecastDayOfWeek(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/weekday/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the day of the week at the given index
	 * i.e. if today is Wednesday, and index=0, then "Fri" will be returned
	 */
	public String getForecastDayOfWeekShort(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/weekday_short/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the year at the given index
	 */
	public String getForecastYear(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/year/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the month number at the given index
	 */
	public String getForecastMonth(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/month/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the day of the month at the given index
	 */
	public String getForecastDay(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/day/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the month at the given index
	 */
	public String getForecastMonthName(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/monthname/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the month abbreviation at the given index
	 */
	public String getForecastMonthNameShort(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/date/monthname_short/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the high in Farenheit at the given index
	 */
	public String getForecastHighF(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/high/farenheit/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the high in Celsius at the given index
	 */
	public String getForecastHighC(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/high/celsius/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the low in Farenheit at the given index
	 */
	public String getForecastLowF(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/low/farenheit/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the low in Celsius at the given index
	 */
	public String getForecastLowC(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/low/celsius/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the average windspeed in MPH at the given index
	 */
	public String getForecastWindMPH(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/avewind/mph/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the average windspeed in KPH at the given index
	 */
	public String getForecastWindKPH(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/avewind/kph/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the forecast wind direction at the given index
	 */
	public String getForecastWindDirection(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/avewind/dir/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the forecast humidity at the given index
	 */
	public String getForecastHumidity(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/avehumidity/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the forecast conditions at the given index
	 */
	public String getForecastConditions(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/conditions/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the icon name at the given index
	 */
	public String getForecastIcon(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/icon/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the data from the forecast
	 * Returns the url of the icon name at the given index
	 */
	public String getForecastIconURL(int index) {
		index++;
		String XPath = "/response/forecast/simpleforecast/forecastdays/forecastday["+index+"]/icon_url/text()";
		return getNode(XPath, "data-forecast-xml.txt");
	}
	
	/*
	 * Gets the name of the weather icon
	 */
	public String getIconName() {
		String XPath = "/response/current_observation/icon/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the URL of the weather icon
	 */
	public String getIconURL() {
		return "http://icons.wxug.com/i/c/i/" + getIconName() + ".gif";
	}
	
	/*
	 * Gets the current city name
	 */
	public String getCity() {
		String XPath = "/response/current_observation/display_location/city/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current state abbreviation
	 */
	public String getState() {
		String XPath = "/response/current_observation/display_location/state/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current state name
	 */
	public String getStateName() {
		String XPath = "/response/current_observation/display_location/state_name/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the zip code
	 */
	public String getZipCode() {
		String XPath = "/response/current_observation/display_location/zip/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current weather condition decription e.g. "partly cloudy"
	 */
	public String getWeatherCondition() {
		String XPath = "/response/current_observation/weather/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current temperature in farenhieght
	 */
	public String getTempF() {
		String XPath = "/response/current_observation/temp_f/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current temperature in centigrade
	 */
	public String getTempC() {
		String XPath = "/response/current_observation/temp_c/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current humidity
	 */
	public String getHumidity() {
		String XPath = "/response/current_observation/relative_humidity/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind description e.g. "calm"
	 */
	public String getWindDescription() {
		String XPath = "/response/current_observation/wind_string/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind direction e.g. "NW"
	 */
	public String getWindDirection() {
		String XPath = "/response/current_observation/wind_dir/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind speed in MPH
	 */
	public String getWindMPH() {
		String XPath = "/response/current_observation/wind_mph/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind gust speed in MPH
	 */
	public String getWindGustMPH() {
		String XPath = "/response/current_observation/wind_gust_mph/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind speed in KPH
	 */
	public String getWindKPH() {
		String XPath = "/response/current_observation/wind_kph/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind gust speed in KPH
	 */
	public String getWindGustKPH() {
		String XPath = "/response/current_observation/wind_gust_kph/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current atmospheric pressure in millibars
	 */
	public String getPressureMb() {
		String XPath = "/response/current_observation/pressure_mb/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current atmospheric pressure in inches of mercury
	 */
	public String getPressureIn() {
		String XPath = "/response/current_observation/pressure_in/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current dewpoint in farenheight
	 */
	public String getDewpointF() {
		String XPath = "/response/current_observation/dewpoint_f/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current dewpoint in centigrade
	 */
	public String getDewpointC() {
		String XPath = "/response/current_observation/dewpoint_c/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind chill in farenheight
	 */
	public String getWindchillF() {
		String XPath = "/response/current_observation/windchill_f/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current wind chill in centigrade
	 */
	public String getWindchillC() {
		String XPath = "/response/current_observation/windchill_c/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current "feels like" temp in farenheight
	 * Alias of getWindchillF()
	 */
	public String getFeelsLikeF() {
		return getWindchillF();
	}
	
	/*
	 * Gets the current "feels like" temp in centigrade
	 * Alias of getWindchillC()
	 */
	public String getFeelsLikeC() {
		return getWindchillC();
	}
	
	/*
	 * Gets the current visibility in miles
	 */
	public String getVisibilityMi() {
		String XPath = "/response/current_observation/visibility_mi/text()";
		return getNode(XPath, "data-xml.txt");
	}
	
	/*
	 * Gets the current visibility in kilometers
	 */
	public String getVisibilityKm() {
		String XPath = "/response/current_observation/visibility_km/text()";
		return getNode(XPath, "data-xml.txt");
	}
}