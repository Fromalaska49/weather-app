package weather;

import java.io.*;
import java.net.*;
import java.lang.*;
import org.apache.commons.io.IOUtils;

public class LoadAPI{
	public static void loadAPI(){
		return;
	}
	
	/* getWeatherJSON fetches data from the Weather API
	 * in JSON format and returns the API response as a
	 * String value
	 */
	public boolean downloadJSON(String location){
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
		BufferedWriter out = null;
		try{
			FileWriter fstream = new FileWriter("data.json", false);
			out = new BufferedWriter(fstream);
			out.write(targetURLContents);
		}catch(IOException e){
			System.err.println("Error: " + e.getMessage());
		}finally{
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
		return true;
	}

	
	/* getWeatherXML fetches data from the Weather API
	 * in XML format and returns the API response as a
	 * String value
	 */
	public String downloadXML(String location){
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