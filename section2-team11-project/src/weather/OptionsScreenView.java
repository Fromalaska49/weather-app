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
import javafx.geometry.Insets;
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
	private GridPane topGrid;
	private BorderPane border;
	private Label tempLabel;
	private Scanner input;
	private String buff;
	private OptionsScreenController OptionsScreenController;
	/*
	public OptionsScreenView(Stage primaryStage){
		this.ScreenController = new ScreenController(primaryStage);
	}
<<<<<<< HEAD
	*/
	public OptionsScreenView(OptionsScreenModel model, Stage primaryStage){	
	this.OptionsScreenController = new OptionsScreenController(this, model, primaryStage);
	}

	public OptionsScreenView(){	
		// do nothing

	}


	
    public void start(Stage primaryStage, Scene scene) {
    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");    
    	tempLabel = new Label("Temprature Unit: ");
    	boolean inDev = false;
    	
    	ScreenController screenController = new ScreenController(primaryStage);
    	Button backBtn = new Button("< Back");
    	Button saveBtn = new Button("Save");
    	backBtn.setOnAction(OptionsScreenController.getBackListener(stagePrev, scenePrev));
    	saveBtn.setOnAction(getSaveListener());
    	tempField = new ChoiceBox(FXCollections.observableArrayList("F", "C"));
    	//tempField = "F";
    	//tempField(getTempSet());
    	setTempSet();
    	grid = new GridPane();
    	grid.setPadding(new Insets(10, 10, 10, 10));
    	grid.setHgap(10);
    	grid.setVgap(10);
    	//grid.add(backBtn, 0, 0);
    	grid.add(saveBtn, 3, 1);
    	grid.add(tempLabel, 0, 0);
    	grid.add(tempField, 3, 0);
    	grid.setAlignment(Pos.CENTER);
    	grid.setGridLinesVisible(inDev);

    	topGrid = new GridPane();
    	topGrid.setPadding(new Insets(10, 10, 10, 10));
    	topGrid.setHgap(10);
    	topGrid.setVgap(10);
    	topGrid.setGridLinesVisible(inDev);
    	topGrid.setAlignment(Pos.TOP_LEFT);
    	topGrid.add(backBtn, 0, 0);
    	
    	
    	border = new BorderPane();
    	//border.setTop(headerText);
    	border.setCenter(grid);
    	border.setTop(topGrid);
    	
    	
    	Scene Optscene = new Scene(border, 800, 700);
    	

        Optscene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	//writeToConfig();
    	//closeFile();
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
	    	output.format("Temprature Setting: %s", getTempSet());
	    	System.out.println("I printed to file");
    	}catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating.");
            System.exit(1); // terminate the program
        }
    	closeFileW();
    }
    
    public void readFromConfig(){
    	openFileR();
    	try {
            while (input.hasNextLine()) { 
            buff = input.nextLine();
            System.out.println(buff);
            }
        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }
    	closeFileR(); 	
    }
    
    public void closeFileW() {
        if (output != null){
            output.close();
        }
    }
    
    public void closeFileR() {
    	if (input != null){
            input.close();
    	}
    }
    
    public void setTempSet(){
    	readFromConfig();
    	if(buff.equals("Temprature Setting: F")){
	    	tempField.setValue("F");
	    	System.out.println("I found F");
    	}
    	else if(buff.equals("Temprature Setting: C")){
    		tempField.setValue("C");
        	System.out.println("I found C");
    	}
    	else{//No Config File or Config miss formated
    		tempField.setValue("F");
    		writeToConfig();//Create config if config missing
        	System.out.println("I found Nothing");
    	}
    	
    }
    public String getTempSet(){
		return tempField.getValue().toString();
	}
    
    public EventHandler<ActionEvent> getSaveListener(){
		EventHandler handler = new EventHandler<Event>(){
			private ScreenController sController;
			
			public void handle(Event event){
				writeToConfig();
			}
		};
		return handler;
	}
}
