package weather;

public class Weather {
	
	public static void main(String[] args) {
		System.out.println("Good luck to Team Rocket!!!");
		LoadAPI thingy = new LoadAPI();
		//String location = "TX/San_Antonio";
		String location = "99508";
		thingy.loadData(location);
		ProcessData weather = new ProcessData();
		//LocationScreen view = new LocationScreen();
		
		System.out.println("Maybe it was the classpath...");
		return;
	}
}
