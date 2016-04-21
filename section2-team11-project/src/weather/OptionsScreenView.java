package weather;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.sun.prism.Image;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import model.LocationScreenModel;
import model.OptionsScreenModel;

public class OptionsScreenView {
	private Formatter output;
	private Label tempField;
	private GridPane grid;
	private BorderPane border;
	private Label tempLabel;
	private Scanner input;
	private String buff;
	private OptionsScreenController OptionsScreenController;
	private Label cityLabel;
	private Label stateLabel;
	private Label zipLabel;
	private Label orLabel;
	private Label zipField;
	private Label cityField;
	private Label stateField;
	private Label windLabel;
	private Label windField;
	

	
	public OptionsScreenView(Stage primaryStage) {
		this.OptionsScreenController = new OptionsScreenController(this, primaryStage);
	}



    public void start(Stage primaryStage, Scene scene) {
    	

    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");    
    	tempLabel = new Label("Temprature Unit: ");
    	windLabel = new Label("Wind Speed Unit: ");
    	OptionsScreenModel OSmodel = new OptionsScreenModel();
    	Button backBtn = new Button("Back");
    	Button ChgUnBtn = new Button("Change Unit");
    	Button ChgLcBtn = new Button("Change Location");
    	tempField = new Label(OSmodel.getTempOpt());
    	cityField = new Label(OSmodel.getCityOpt());
    	stateField = new Label(OSmodel.getStateOpt());
    	zipField = new Label(OSmodel.getZipOpt());
    	windField = new Label(OSmodel.getWindOpt());
    	backBtn.setOnAction(OptionsScreenController.getBackListener(stagePrev, scenePrev));
    	ChgUnBtn.setOnAction(OptionsScreenController.getChangeUnitListener());
    	ChgLcBtn.setOnAction(OptionsScreenController.getChangeLocationListener());
    	
    	cityLabel = new Label("City:  ");
		stateLabel = new Label("State:  ");
		zipLabel = new Label("Zip Code:  ");
		orLabel = new Label(" -OR-");

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
    	grid.add(tempField, 3, 5);
    	grid.add(windLabel, 0, 7);
    	grid.add(windField, 3, 7);
    	grid.add(backBtn, 0, 8);
    	grid.add(ChgLcBtn, 2, 8);
    	grid.add(ChgUnBtn, 4, 8);
		grid.setAlignment(Pos.CENTER);
		
    	
    	
    	border = new BorderPane();
    	border.setCenter(grid);
    	

    	
    	Scene Optscene = new Scene(border, 800, 700);

    	Optscene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	
    }
  
}
