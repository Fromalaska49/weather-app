package weather;

import org.w3c.dom.*;
import javax.xml.parsers.*;


public class ProcessData {
	
	public static void ProcessData() {
		return;
	}
	
	public String getCurrentCondition(String location) {
		String currentCondition = "undefined";
		
		try {
	        DocumentBuilderFactory dbFactory = 
	           DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse("data-xml.txt");
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();
			NodeList currentObservationList = root.getElementsByTagName("current_observation");
			Element currentObservation = (Element) currentObservationList.item(0);
			NodeList cityList = currentObservation.getElementsByTagName("weather");
			Element city = (Element) cityList.item(0);
			currentCondition = city.getTextContent();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return currentCondition;
	}
}