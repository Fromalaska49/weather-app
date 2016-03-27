package weather;

import org.w3c.dom.*;

import java.io.File;

import javax.xml.parsers.*;
import javax.xml.xpath.*;


public class ProcessData {
	
	public static void ProcessData() {
		return;
	}
	
	public String getCurrentCondition(String location) {
		String currentCondition = "undefined";
		try {
			File inputFile = new File("data-xml.txt");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			XPath xPath =  XPathFactory.newInstance().newXPath();
			String expression = "/response/current_observation/weather/text()";
			currentCondition = (String) xPath.compile(expression).evaluate(doc, XPathConstants.STRING);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return currentCondition;
	}
}