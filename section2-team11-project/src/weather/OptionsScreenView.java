package weather;

import java.io.PrintWriter;

import javafx.collections.FXCollections;
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
	
	private static ChoiceBox<String> tempField;
	private GridPane grid;
	private BorderPane border;
	private Label tempLabel;
	
	public OptionsScreenView(){	
	}
    public void start(Stage primaryStage, Scene scene) {
    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");    
    	tempLabel = new Label("Temprature Unit: ");
    	
    	
    	Button backBtn = new Button("Back");
    	backBtn.setOnAction(ScreenController .getBackListener(stagePrev, scenePrev));
    	tempField = new ChoiceBox(FXCollections.observableArrayList("F", "C"));
    	//tempField = "F";
    	//tempField(getTempSet());
    	setTempSet();
    	grid = new GridPane();
    	grid.add(backBtn, 0, 0);
    	grid.add(tempLabel, 0, 1);
    	grid.add(tempField, 3, 1);
    	grid.setAlignment(Pos.CENTER);
    	
    	border = new BorderPane();
    	//border.setTop(headerText);
    	border.setCenter(grid);
    	
    	
    	Scene Optscene = new Scene(border, 800, 700);
    	
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	
    	
    }
    /*
    public static void writeToConfig(){
    	try{
    	PrintWriter writer = new PrintWriter("the-file-name.txt");
    	writer.close();
    	}catch(EXCEPTION e){
    		
    	}
    }
    */
    public static void setTempSet(){
    	tempField.setValue("F");
    }
    public static String getTempSet(){
		return tempField.getValue().toString();
	}
}
