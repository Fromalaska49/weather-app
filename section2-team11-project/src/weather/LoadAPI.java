package weather;

import java.awt.Image;
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
	 * Gets the location from the last API call
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
	 * alreadyLoaded returns true if two conditions have been met:
	 * the cache has been loaded within 15 minutes
	 * the location has not changed
	 */
	private boolean alreadyLoaded(String location){
		return Instant.now().getEpochSecond() - getUpdateTime() < 900 && location.equals(getLocation());
	}
	
	/* 
	 * getWeatherJSON fetches data from the Weather API
	 * in JSON format and returns the API response as a
	 * String value
	 */
	public boolean downloadJSON(String location){
		if(alreadyLoaded(location)){
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
		if(alreadyLoaded(location)){
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
	
	/*
	 * downloadRadar just downloads the radar as a gif
	 */
	public boolean downloadRadar(String location){
		if(alreadyLoaded(location)){
			//return true;
		}
		
		String
			width = "300", // Width of image in pixels: int
			height = "300", // Height of image in pixels: int
			newmaps = "1", // Transparent image (default) or show basemap: 0 (default), or 1
			rainsnow = "1", // Use a different color palette to show rain/mix/snow: 0 (default), or 1
			num = "10", // Number of frames in the animation: 1 (default) to 15
			delay = "50", // The duration of a radar frame in an animation, in hundredths of a second: 25 (default) to 100
			timelabel = "0", // Display the time of the radar frame: 0 (default) or 1
			timelabelx = "0", // Pixels from left: 0 (default) to image width
			timelabely = "0"; // Pixels from top: 0 (default) to image height
		
		String targetURL = "http://api.wunderground.com/api/d1b960fa65c6eccc/animatedradar/q/" + location + ".gif?width=" + width + "&height=" + height + "&newmaps=" + newmaps + "&rainsnow=" + rainsnow + "&timelabel=" + timelabel + "&timelabel.x=" + timelabelx + "&timelabel.y=" + timelabely + "&num=" + num + "&delay=" + delay;
		
		URL url = null;
		try {
			url = new URL(targetURL);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		InputStream in = null;
		try {
			in = new BufferedInputStream(url.openStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		OutputStream out = null;
		try {
			out = new BufferedOutputStream(new FileOutputStream("radar.gif"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		try {
			for ( int i; (i = in.read()) != -1; ) {
			    out.write(i);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
}