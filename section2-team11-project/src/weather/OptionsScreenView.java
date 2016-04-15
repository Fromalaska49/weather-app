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

public class OptionsScreenView {
	private static Formatter output;
	private static ChoiceBox<String> tempField;
	private GridPane grid;
	private BorderPane border;
	private Label tempLabel;
	private static Scanner input;
	private static String buff;
	
	public OptionsScreenView(){	
	}
    public void start(Stage primaryStage, Scene scene) {
    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");    
    	tempLabel = new Label("Temprature Unit: ");
    	
    	
    	Button backBtn = new Button("Back");
    	Button saveBtn = new Button("Save");
    	backBtn.setOnAction(ScreenController .getBackListener(stagePrev, scenePrev));
    	saveBtn.setOnAction(getSaveListener());
    	tempField = new ChoiceBox(FXCollections.observableArrayList("F", "C"));
    	//tempField = "F";
    	//tempField(getTempSet());
    	setTempSet();
    	grid = new GridPane();
    	grid.add(backBtn, 0, 0);
    	grid.add(saveBtn, 1, 0);
    	grid.add(tempLabel, 0, 1);
    	grid.add(tempField, 3, 1);
    	grid.setAlignment(Pos.CENTER);
    	
    	border = new BorderPane();
    	//border.setTop(headerText);
    	border.setCenter(grid);
    	
    	
    	Scene Optscene = new Scene(border, 800, 700);
    	
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	//writeToConfig();
    	//closeFile();
    }
    
    public static void openFileW(){
    	try{
        	//PrintWriter writer = new PrintWriter("weatherConfig.txt");
        	output = new Formatter("weatherConfig.txt");
        	}catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
    }
    
    public static void openFileR(){
    	try{
        	//PrintWriter writer = new PrintWriter("weatherConfig.txt");
        	input = new Scanner(Paths.get("weatherConfig.txt"));
        	}catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(1);
            }
    }
    
    public static void writeToConfig(){
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
    
    public static void readFromConfig(){
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
    
    public static void closeFileW() {
        if (output != null)
            output.close();
    }
    
    public static void closeFileR() {
    	if (input != null)
            input.close();
    }
    
    public static void setTempSet(){
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
    public static String getTempSet(){
		return tempField.getValue().toString();
	}
    
    public static EventHandler<ActionEvent> getSaveListener(){
		EventHandler handler = new EventHandler<Event>(){
			private ScreenController sController;
			
			public void handle(Event event){
				writeToConfig();
			}
		};
		return handler;
	}
}
