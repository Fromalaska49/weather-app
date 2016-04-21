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
public class ChangeUnitModel {
	private Formatter output;
	private String tempOpt;
	private Scanner input;
	private OptionsScreenModel oModel;
	/**
	 * 
	 */
	public ChangeUnitModel() {
		oModel = new OptionsScreenModel();
		tempOpt = oModel.getTempOpt();
	}
	
	public String getTempOpt(){
		return this.tempOpt;
	}
	
	public void setTempOpt(String tOpt){
		this.tempOpt = tOpt;
	}

}
