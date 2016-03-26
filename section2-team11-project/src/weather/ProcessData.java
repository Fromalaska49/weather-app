package weather;

import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;


public class ProcessData {
	public static void ProcessData(){
		return;
	}
	public String getCurrentCondition(String location){
		String currentCondition = "undefined";
		LoadAPI weatherData = new LoadAPI();
		String weatherDataXML = weatherData.getWeatherXML(location);
		
		try{
	        DocumentBuilderFactory dbFactory = 
	           DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(weatherDataXML);
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();
			NodeList currentObservationList = root.getElementsByTagName("current_observation");
			Element currentObservation = (Element) currentObservationList;
			NodeList cityList = currentObservation.getElementsByTagName("city");
			Element city = (Element) cityList;
			currentCondition = city.getTextContent();
			/*
			
	         System.out.print("Root element: ");
	         System.out.println(doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("supercars");
	         System.out.println("----------------------------");
	         for(int temp = 0; temp < nList.getLength(); temp++){
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :");
	            System.out.print(nNode.getNodeName());
	            if(nNode.getNodeType() == Node.ELEMENT_NODE){
	               Element eElement = (Element) nNode;
	               System.out.print("company : ");
	               System.out.println(eElement.getAttribute("company"));
	               NodeList carNameList = eElement.getElementsByTagName("carname");
	               for(int count = 0; count < carNameList.getLength(); count++){	 
	                  Node node1 = carNameList.item(count);
	                  if(node1.getNodeType() == node1.ELEMENT_NODE){
	                     Element car = (Element) node1;
	                     System.out.print("car name : ");
	                     System.out.println(car.getTextContent());
	                     System.out.print("car type : ");
	                     System.out.println(car.getAttribute("type"));
	                  }
	               }
	            }
	         }
	         */
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return currentCondition;
	}
}