package weather;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.lang.*;
import org.apache.commons.io.IOUtils;

public class LoadAPI{
	
	public static void loadAPI(){
		return;
	}
	
	/*
	 * Used to update the timestamp whenever a new call to the API is made
	 */
	private boolean setUpdateTime(){
		String updateTime = "" + Instant.now().getEpochSecond();
		Path file = Paths.get("UpdateTime.txt");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(updateTime, 0, updateTime.length());
		    return true;
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return false;
	}
	
	/*
	 * Gets amount of time since the last API call
	 */
	private int getUpdateTime(){
		String text = "";
		Path file = Paths.get("UpdateTime.txt");
		try (InputStream in = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				text += line;
			}
		} catch (IOException x) {
			System.err.println(x);
			return 0;
		}
		int updateTime = 0;
		if(text.length() > 0){
			updateTime = Integer.parseInt(text);
		}
		return updateTime;
	}
	
	/*
	 * Used to update the location whenever a new call to the API is made
	 */
	private boolean setLocation(String location){
		Path file = Paths.get("Location.txt");
		Charset charset = Charset.forName("UTF-8");
		try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
		    writer.write(location, 0, location.length());
		    return true;
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return false;
	}
	
	/*
	 * Gets the location of the last API call
	 */
	private String getLocation(){
		String location = "";
		Path file = Paths.get("Location.txt");
		try (InputStream in = Files.newInputStream(file);
			BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				location += line;
			}
		} catch (IOException x) {
			System.err.println(x);
			return "undefined";
		}
		return location;
	}
	
	
	/* 
	 * getWeatherJSON fetches data from the Weather API
	 * in JSON format and returns the API response as a
	 * String value
	 */
	public boolean downloadJSON(String location){
		if(Instant.now().getEpochSecond() - getUpdateTime() < 900 && location.equals(getLocation())){
			//less than 15 minutes since last API request
			//and same location
			return true;
		}
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
		    setUpdateTime();
		    setLocation(location);
		    return true;
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		return false;
	}
	
	/* 
	 * getWeatherJSON fetches data from the Weather API
	 * in JSON format and returns the API response as a
	 * String value
	 */
	public boolean downloadXML(String location) {
		if(Instant.now().getEpochSecond() - getUpdateTime() < 900 && location.equals(getLocation())){
			//less than 15 minutes since last API request
			//and same location
			return true;
		}
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
		    setUpdateTime();
		    setLocation(location);
		    return true;
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
		
		return false;
	}
}