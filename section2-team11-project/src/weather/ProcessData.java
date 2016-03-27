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
	
	public String getCurrentCondition() {
		String XPath = "/response/current_observation/weather/text()";
		return getNode(XPath);
	}
}