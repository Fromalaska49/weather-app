package weather;

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
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.LocationScreenModel;
import model.OptionsScreenModel;

public class OptionsScreenView {
	private Formatter output;
	private ChoiceBox<String> tempField;
	private GridPane grid;
	private BorderPane border;
	private Label tempLabel;
	private Scanner input;
	private String buff;
	private OptionsScreenController OptionsScreenController;
	private OptionsScreenModel OSmodel;
	private Label cityLabel;
	private Label stateLabel;
	private Label zipLabel;
	private Label orLabel;
	private static TextField zipField;
	private static TextField cityField;;
	private static ChoiceBox<String> stateField;
	
	public OptionsScreenView(Stage primaryStage) {
		this.OptionsScreenController = new OptionsScreenController(this, primaryStage);
	}
	/*
	public OptionsScreenView(OptionsScreenModel model, Stage primaryStage){	
		this.OptionsScreenController = new OptionsScreenController(this, model, primaryStage);
	}
	*/
	public void start(Stage primaryStage, Scene scene) {
    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");    
    	tempLabel = new Label("Temprature Unit: ");
    	OSmodel = new OptionsScreenModel();
    	Button backBtn = new Button("Back");
    	Button saveBtn = new Button("Save");

    	tempField = new ChoiceBox<String>(FXCollections.observableArrayList("F", "C"));
    	

    	backBtn.setOnAction(OptionsScreenController.getBackListener(stagePrev, scenePrev));
    	saveBtn.setOnAction(OptionsScreenController.getSaveListener(tempField, OSmodel));
    	
    	cityLabel = new Label("City:  ");
		stateLabel = new Label("State:  ");
		zipLabel = new Label("Zip Code:  ");
		orLabel = new Label(" -OR-");
		cityField = new TextField();
		stateField = new ChoiceBox<String>(FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "DC", "PR", "VI", "AS", "GU", "MP", "AA", "AE", "AP"));
		zipField = new TextField();
		stateField.setPrefWidth(80);
		cityField.setPrefWidth(80);
    	
		grid = new GridPane();
		grid.add(cityLabel, 0, 0);
		grid.add(stateLabel, 0, 1);
		grid.add(orLabel, 0, 2);
		grid.add(zipLabel, 0, 4);
		grid.add(cityField, 3, 0);
		grid.add(stateField, 3, 1);
		grid.add(zipField, 3, 4);
		grid.add(tempLabel, 0, 5);
    	grid.add(tempField, 3, 6);
    	grid.add(backBtn, 0, 7);
    	grid.add(saveBtn, 4, 7);
		grid.setAlignment(Pos.CENTER);
		
    	tempField.setValue(OSmodel.getTempOpt());
    	cityField.setText(OSmodel.getCityOpt());
    	stateField.setValue(OSmodel.getStateOpt());
    	zipField.setText(OSmodel.getZipOpt());
    	
    	border = new BorderPane();
    	
    	border.setCenter(grid);

    	
    	Scene Optscene = new Scene(border, 800, 700);
    	
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	
    }
  
}
