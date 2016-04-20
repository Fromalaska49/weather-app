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

}
