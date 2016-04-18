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
    	
    	tempField.setValue(OSmodel.getTempOpt());
    	backBtn.setOnAction(OptionsScreenController.getBackListener(stagePrev, scenePrev));
    	saveBtn.setOnAction(OptionsScreenController.getSaveListener(tempField, OSmodel));
    	grid = new GridPane();
    	grid.add(backBtn, 0, 0);
    	grid.add(saveBtn, 1, 0);
    	grid.add(tempLabel, 0, 1);
    	grid.add(tempField, 3, 1);
    	grid.setAlignment(Pos.CENTER);
    	
    	border = new BorderPane();
    	
    	border.setCenter(grid);
    	
    	
    	Scene Optscene = new Scene(border, 800, 700);
    	
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	
    }
  
}
