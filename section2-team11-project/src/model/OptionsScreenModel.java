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
	private Scanner input;
	private String buff;
	/**
	 * 
	 */
	public OptionsScreenModel() {
		// TODO Auto-generated constructor stub
		readFromConfig();
    	if(buff.equals("Temprature Setting: F")){
    	this.tempOpt = "F";
    	//System.out.println("I found F");
    	}
    	else if(buff.equals("Temprature Setting: C")){
    		this.tempOpt = "C";
        	//System.out.println("I found C");
    	}
    	else{//No Config File or Config miss formated
    		this.tempOpt= "F";
    		writeToConfig();//Create config if config missing
        	//System.out.println("I found Nothing");
    	}
	}
	
	public void setTempOpt(String temp){
		this.tempOpt = temp;
	}
	
	public String getTempOpt(){
		return this.tempOpt;
	}
	
	
	public void openFileW(){
    	try{
        	//PrintWriter writer = new PrintWriter("weatherConfig.txt");
        	output = new Formatter("weatherConfig.txt");
        	}catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
    }
    
    public void openFileR(){
    	try{
        	//PrintWriter writer = new PrintWriter("weatherConfig.txt");
        	input = new Scanner(Paths.get("weatherConfig.txt"));
        	}catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
    }
    
    public void writeToConfig(){
    	openFileW();
    	try{
    		
    	output.format("Temprature Setting: %s", this.tempOpt);
    	
    	//System.out.println("I printed TempSetting: " + this.tempOpt);
    	
    	}catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        }
    	closeFileW();
    	readFromConfig();
    }
    
    public void readFromConfig(){
    	openFileR();
    	try {
            while (input.hasNextLine()) { 
            buff = input.nextLine();
            //System.out.println(buff);
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
    	closeFileR(); 	
    }
    
    public void closeFileW() {
        if (output != null)
            output.close();
    }
    
    public void closeFileR() {
    	if (input != null)
            input.close();
    }
}
