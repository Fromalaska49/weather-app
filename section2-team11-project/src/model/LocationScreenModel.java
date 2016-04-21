package model;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import jdk.internal.org.xml.sax.InputSource;
import weather.LocationScreenView;


public class LocationScreenModel {
	private int zipCode;
	private String city;
	private String state;
	

	
	/**
	 * LocationScreenModel Constructor
	 */
	public LocationScreenModel() {
		this.zipCode = 0;
		this.city = "";
		this.state = "";
		return;
	}
	
	/**
	 * LocationScreenModel Constructor for zipcode
	 */
	public LocationScreenModel(int zip) {
		this.zipCode = zip;
		this.city = "";
		this.state = "";
		return;
	}
	
	/**
	 * LocationScreenModel Constructor for zipcode
	 */
	public LocationScreenModel(String zip) {
		this.zipCode = Integer.parseInt(zip);
		this.city = "";
		this.state = "";
		return;
	}
	
	/**
	 * LocationScreenModel Constructor for state/city
	 */
	public LocationScreenModel(String state, String city) {
		this.zipCode = 0;
		this.city = city;
		this.state = state;
		return;
	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setZipCode(int z) {
        this.zipCode = z;
    }
	
	
	public void setCity(String s) {
        this.city = s;
    }
	
	public void setState(String s) {
        this.state = s;
    }
	
	public void setLocation(int zip){
		setZipCode(zip);
	}
	
	public void setLocation(String zip){
		setZipCode(Integer.parseInt(zip));
	}
	
	public void setLocation(String city, String state){
		setCity(city);
		setState(state);
	}

	private String getNode(String XPath, String fileName) {
		String value = "undefined";
		try {
			File inputFile = new File(fileName);
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
	
	public static Document loadXMLFromString(String xml) throws Exception
	{
		ByteArrayInputStream stream = new ByteArrayInputStream(xml.getBytes());
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(xml));
	    return builder.parse(stream);
	}
	
	public boolean isKnownLocation(){
		String targetURL = null;
		targetURL = "http://api.wunderground.com/api/d1b960fa65c6eccc/geolookup/q/" + this.getLocation() + ".xml";
		System.out.println(targetURL);
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

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = null;
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/*
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    InputSource is = new InputSource(new StringReader(targetURLContents));
		//dBuilder.parse(new InputSource(new StringReader(targetURLContents)));
		//dBuilder.parse(new InputSource(new StringReader(targetURLContents)));
		*/
		
		Document doc = null;
		try {
			doc = loadXMLFromString(targetURLContents);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		doc.getDocumentElement().normalize();
		XPath xPath =  XPathFactory.newInstance().newXPath();
		String errorsExist = null;
		try {
			errorsExist = (String) xPath.compile("boolean(//error)").evaluate(doc, XPathConstants.STRING);
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(errorsExist.equals("false")){
			return true;
		}
		else{
			System.out.println("erorsExist = "+errorsExist);
			return false;
		}
	}
	
	public String getLocation(){
		String location = "";
		if(getZipCode() > 0){
			location += this.zipCode;
		}
		else if(this.state.length() > 0 && this.city.length() > 0){
			location = this.state + "/" + this.city.replace(' ', '_');
		}
		else{
			System.out.println("Error: no location found (in LocationScreenModel)");
		}
		System.out.println("S");
		return location;
	}
	
}
