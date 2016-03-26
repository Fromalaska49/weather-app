package weather;

public class weather {
	public static void main(String[] args) {
		System.out.println("Good luck to Team Rocket!!");
		loadAPI thingy = new loadAPI();
		String location = "TX/San_Antonio";
		//String location = "78249";
		System.out.println(thingy.getWeatherXML(location));
	}
}
