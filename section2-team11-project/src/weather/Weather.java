package weather;

public class Weather {
	public static void main(String[] args) {
		System.out.println("Good luck to Team Rocket!!!");
		LoadAPI thingy = new LoadAPI();
		String location = "TX/San_Antonio";
		//String location = "78249";
		System.out.println(thingy.getWeatherXML(location));
	}
}
