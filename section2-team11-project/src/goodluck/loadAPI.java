package goodluck;

import java.io.*;
import java.net.*;
import java.lang.*;
import org.apache.commons.io.IOUtils;

public class loadAPI{
	public static void loadAPI(){
		return;
	}
	
	/* getWeatherJSON fetches data from the weather API
	 * in JSON format and returns the API response as a
	 * String value
	 */
	public String getWeatherJSON(String location){
		String targetURL = "http://api.wunderground.com/api/d1b960fa65c6eccc/conditions/q/" + location + ".json";
		String targetURLContents = "undefined";
		try {
			targetURLContents = IOUtils.toString(new URL(targetURL), "UTF-8");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetURLContents;
	}

	
	/* getWeatherXML fetches data from the weather API
	 * in XML format and returns the API response as a
	 * String value
	 */
	public String getWeatherXML(String location){
		String targetURL = "http://api.wunderground.com/api/d1b960fa65c6eccc/conditions/q/" + location + ".xml";
		String targetURLContents = "undefined";
		try {
			targetURLContents = IOUtils.toString(new URL(targetURL), "UTF-8");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targetURLContents;
	}
}