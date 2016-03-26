package weather;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
		
		Path file = Paths.get("data-json.txt");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(targetURLContents, 0, targetURLContents.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
			
		return true;
	}
	
	/* getWeatherJSON fetches data from the Weather API
	 * in JSON format and returns the API response as a
	 * String value
	 */
	public boolean downloadXML(String location){
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
		
		Path file = Paths.get("data-xml.txt");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(targetURLContents, 0, targetURLContents.length());
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
			
		return true;
	}
}