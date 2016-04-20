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
	private ChoiceBox<String> tempField;
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
	private TextField zipField;
	private TextField cityField;
	private ChoiceBox<String>stateField;
	

	
	public OptionsScreenView(Stage primaryStage) {
		this.OptionsScreenController = new OptionsScreenController(this, primaryStage);
	}


	//public void start(Stage primaryStage, Scene scene) {


	public OptionsScreenView(OptionsScreenModel model, Stage primaryStage){	
	this.OptionsScreenController = new OptionsScreenController(this, primaryStage);
	}

	public OptionsScreenView(){	
		// do nothing
	}

    public void start(Stage primaryStage, Scene scene) {
    	

    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");    
    	tempLabel = new Label("Temprature Unit: ");
    	OptionsScreenModel OSmodel = new OptionsScreenModel();
    	Button backBtn = new Button("Back");
    	Button saveBtn = new Button("Save");
    	Group root = new Group();//Added for Radar
    	
    	
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
    	/*
		//start
		URL url;
		Icon icon;
	    JLabel label;
		try {
			url = new URL("http://api.wunderground.com/api/d1b960fa65c6eccc/animatedradar/q/78249.gif?width=300&height=300&newmaps=1&rainsnow=1&timelabel=0&timelabel.x=0&timelabel.y=0&num=10&delay=50");
			icon = new ImageIcon(url);
		    label = new JLabel(icon);
		    
		    Image img = new Image("javafx.png");
		    final ImageView imv = new ImageView();
	    	final HBox pictureRegion = new HBox();
		    
		    JFrame f = new JFrame("Animation");
		    f.getContentPane().add(label);
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    f.pack();
		    f.setLocationRelativeTo(null);
		    f.setVisible(true);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	    */
		
		grid = new GridPane();
		//grid.add(label, 0, 0);
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
    	
    	
        
       // pictureRegion.getChildren().add((Node) icon);
       // grid.add(pictureRegion, 1, 1);
    	
    	Scene Optscene = new Scene(border, 800, 700);

    	Optscene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
    	
    }
  
}
