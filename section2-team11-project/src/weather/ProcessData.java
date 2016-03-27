package weather;

import org.w3c.dom.*;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.xpath.*;


public class ProcessData {
	
	public static void ProcessData() {
		return;
	}
	
	private String getNode(String XPath) {
		String value = "undefined";
		try {
			File inputFile = new File("data-xml.txt");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xPath =  XPathFactory.newInstance().newXPath();
			value = (String) xPath.compile(XPath).evaluate(doc, XPathConstants.STRING);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return value;
	}
	
	public String getIconURL() {
		String XPath = "/response/current_observation/icon_url/text()";
		return getNode(XPath);
	}
	
	public String getCity() {
		String XPath = "/response/current_observation/city/text()";
		return getNode(XPath);
	}
	
	public String getState() {
		String XPath = "/response/current_observation/state/text()";
		return getNode(XPath);
	}
	
	public String getStateName() {
		String XPath = "/response/current_observation/state_name/text()";
		return getNode(XPath);
	}
	
	public String getCurrentWeather() {
		String XPath = "/response/current_observation/weather/text()";
		return getNode(XPath);
	}
	
	public String getTempF() {
		String XPath = "/response/current_observation/temp_f/text()";
		return getNode(XPath);
	}
	
	public String getTempC() {
		String XPath = "/response/current_observation/temp_c/text()";
		return getNode(XPath);
	}
	
	public String getRelativeHumidity() {
		String XPath = "/response/current_observation/relative_humidity/text()";
		return getNode(XPath);
	}
	
	public String getWindDescription() {
		String XPath = "/response/current_observation/wind_string/text()";
		return getNode(XPath);
	}
	
	public String getWindDirection() {
		String XPath = "/response/current_observation/wind_dir/text()";
		return getNode(XPath);
	}
	
	public String getWindMPH() {
		String XPath = "/response/current_observation/wind_mph/text()";
		return getNode(XPath);
	}
	
	public String getWindGustMPH() {
		String XPath = "/response/current_observation/wind_gust_mph/text()";
		return getNode(XPath);
	}
	
	public String getWindKPH() {
		String XPath = "/response/current_observation/wind_kph/text()";
		return getNode(XPath);
	}
	
	public String getWindGustKPH() {
		String XPath = "/response/current_observation/wind_gust_kph/text()";
		return getNode(XPath);
	}
	
	public String getPressureMb() {
		String XPath = "/response/current_observation/pressure_mb/text()";
		return getNode(XPath);
	}
	
	public String getPressureIn() {
		String XPath = "/response/current_observation/pressure_in/text()";
		return getNode(XPath);
	}
	
	public String getDewpointF() {
		String XPath = "/response/current_observation/dewpoint_f/text()";
		return getNode(XPath);
	}
	
	public String getDewpointC() {
		String XPath = "/response/current_observation/dewpoint_c/text()";
		return getNode(XPath);
	}
	
	public String getWindchillF() {
		String XPath = "/response/current_observation/windchill_f/text()";
		return getNode(XPath);
	}
	
	public String getWindchillC() {
		String XPath = "/response/current_observation/windchill_c/text()";
		return getNode(XPath);
	}
	
	public String getVisibilityMi() {
		String XPath = "/response/current_observation/visibility_mi/text()";
		return getNode(XPath);
	}
	
	public String getVisibilityKm() {
		String XPath = "/response/current_observation/visibility_km/text()";
		return getNode(XPath);
	}
}