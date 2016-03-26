package weather;

public class Weather {
	public static void main(String[] args) {
		System.out.println("Good luck to Team Rocket!!!");
		LoadAPI thingy = new LoadAPI();
		//String location = "TX/San_Antonio";
		String location = "99508";
		//System.out.println(thingy.getWeatherJSON(location));
		//System.out.println(thingy.getWeatherXML(location));
		//ProcessData city = new ProcessData();
		//System.out.println(city.getCurrentCondition(location));
	}
}
