/**
 * 
 */
package model;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import jdk.internal.org.xml.sax.InputSource;
import model.LocationScreenModel;
import model.OptionsScreenModel;
/**
 * @author Admin
 *
 */
public class ChangeLocationModel {
	private Formatter output;
	private String cityOpt;
	private String stateOpt;
	private String zipOpt;
	private Scanner input;
	private String configCity;
	private String configState;
	private String configZip;
	private OptionsScreenModel oModel;
	/**
	 * 
	 */
	public ChangeLocationModel() {
		oModel = new OptionsScreenModel();
		cityOpt = oModel.getCityOpt();
		stateOpt = oModel.getStateOpt();
		zipOpt = oModel.getZipOpt();
	}
	
	public String getCityOpt(){
		return this.cityOpt;
	}
	
	public void setCityOpt(String city){
		this.cityOpt = city;
	}
	
	public String getStateOpt(){
		return this.stateOpt;
	}
	
	public void setStateOpt(String state){
		this.stateOpt = state;
	}
	
	public String getZipOpt(){
		return this.zipOpt;
	}
	
	public void setZipOpt(String zip){
		this.zipOpt = zip;
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
		if(getZipOpt().length() == 5){
			location += this.getZipOpt();
		}
		else if(this.getStateOpt().length() > 0 && this.getCityOpt().length() > 0){
			location = this.getStateOpt() + "/" + this.getCityOpt().replace(' ', '_');
		}
		else{
			System.out.println("Error: no location found (in ChangeLocationModel)");
		}
		//System.out.println("S");
		return location;
	}
}
