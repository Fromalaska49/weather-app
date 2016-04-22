package weather;

import java.util.Formatter;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.dressScreenModel;

public class dressScreenView {

	
	private GridPane grid;
	private BorderPane border;
	private dressScreenController dressScreenController;
	private Label tempLabel;	
	private Label orLabel;
	private Stage primaryStage;

	

	public dressScreenView(dressScreenModel model, Stage primaryStage){	
		this.dressScreenController = new dressScreenController(this, model, primaryStage);
		}

		public void start(Stage stage, Scene scene) {
			Stage stagePrev = primaryStage;
	    	Scene scenePrev = scene;  
	    	primaryStage.setTitle("Dress Window");    
	    	tempLabel = new Label("You Should wear");
	    	Button backBtn = new Button("Back");
	    	Group root = new Group();//Added for Radar
	    	
	    	
	    	
	    	backBtn.setOnAction(dressScreenController.getBackListener(stagePrev, scenePrev));
	
	    	
			
			grid = new GridPane();

			grid.add(orLabel, 0, 2);

	    	grid.add(backBtn, 0, 7);
			grid.setAlignment(Pos.CENTER);
	
	    	
	    	border = new BorderPane();
	    	border.setCenter(grid);
	    	
	    	Scene Optscene = new Scene(border, 800, 700);

	    	Optscene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
	    	
	    	primaryStage.setScene(Optscene);
	    	primaryStage.show();
	    	
		}

}