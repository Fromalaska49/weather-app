/**
 * 
 */
package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
import model.LocationScreenModel;
import model.OptionsScreenModel;

/**
 * @author Admin
 *
 */
public class OptionsScreenModel {
	
	private Formatter output;
	private String tempOpt;
	private String cityOpt;
	private String stateOpt;
	private String zipOpt;
	private Scanner input;
	private String configTemp;
	private String configCity;
	private String configState;
	private String configZip;
	private String configWindOpt;
	private String windOpt;
	/**
	 * 
	 */
	public OptionsScreenModel() {
		// TODO Auto-generated constructor stub
		readFromConfig();
    	
    	tempOpt = configTemp.substring(21);
    	cityOpt = configCity.substring(6);
    	//System.out.println(cityOpt);
    	stateOpt = configState.substring(7);
    	//System.out.println(stateOpt);
    	zipOpt = configZip.substring(5);
    	windOpt = configWindOpt.substring(12);
    	//System.out.println(zipOpt);
	}
	
	public void setTempOpt(String temp){
		this.tempOpt = temp;
	}
	
	public String getTempOpt(){
		return this.tempOpt;
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
	
	public void setWindOpt(String wind){
		this.windOpt = wind;
	}
	
	public String getWindOpt(){
		return this.windOpt;
	}
	
	public void openFileW(){
    	try{
        	//PrintWriter writer = new PrintWriter("weatherConfig.txt");
        	output = new Formatter("weatherConfig.txt");
        	}catch (IOException ioException) {
        		closeFile();
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
    }
    
    public void openFileR(){
    	try{
        	//PrintWriter writer = new PrintWriter("weatherConfig.txt");
        	input = new Scanner(Paths.get("weatherConfig.txt"));
        	}catch (IOException ioException) {
        		closeFile();
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
    }
    
    public void writeToConfig(){
    	openFileW();
    	try{
    		
    	output.format("Temperature Setting: %s\nCity: %s\nState: %s\nZip: %s\nWind Speed: %s", this.tempOpt, this.cityOpt, this.stateOpt, this.zipOpt, this.windOpt);

    	//System.out.println(this.tempOpt + " " + this.cityOpt + " " + this.stateOpt + " " + this.zipOpt);
    	
    	}catch (SecurityException securityException) {
    		closeFile();
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        }
    	closeFile();
    	readFromConfig();
    }
    
    public void readFromConfig(){
    	openFileR();
    	try {
            configTemp = input.nextLine();
            configCity = input.nextLine();
            configState = input.nextLine();
            configZip = input.nextLine();
            configWindOpt = input.nextLine();
            
        } catch (NoSuchElementException elementException) {
        	closeFile();
            System.err.println("File improperly formed. Terminating.");
        } catch (IllegalStateException stateException) {
        	closeFile();
            System.err.println("Error reading from file. Terminating.");
        }
    	closeFile(); 	
    }
    
    public void closeFile() {
        if (output != null)
            output.close();
        if (input != null)
            input.close();
    }
    
}
