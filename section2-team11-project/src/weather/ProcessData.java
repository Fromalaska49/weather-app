package weather;

public class ProcessData {
	public String getCurrentCondition(String location){
		String currentCondition = "undefined";
		LoadAPI weatherData = new LoadAPI();
		String weatherDataJSON = weatherData.getWeatherJSON(location);
		
		return currentCondition;
	}
}