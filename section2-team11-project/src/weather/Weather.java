package weather;

import weather.frontEnd.LocationScreen;

public class Weather {
	
	public static void main(String[] args) {
		System.out.println("Good luck to Team Rocket!!!");
		LoadAPI thingy = new LoadAPI();
		//String location = "TX/San_Antonio";
		String location = "98439";
		thingy.downloadXML(location);
		thingy.downloadRadar(location);
		ProcessData weather = new ProcessData();
		LocationScreen view = new LocationScreen();
		
		System.out.println("Nishant, don't use Eclipse on VDI.");
		return;
	}
}
