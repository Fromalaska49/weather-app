/**
 * 
 */
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
import model.ChangeUnitModel;
/**
 * @author Admin
 *
 */
public class ChangeLocationView {
	private Formatter output;
	private ChoiceBox<String> tempField;
	private GridPane grid;
	private BorderPane border;
	private Label tempLabel;
	private Scanner input;
	private String buff;
	private ChangeLocationController ChangeLocationController;
	private Label cityLabel;
	private Label stateLabel;
	private Label zipLabel;
	private Label orLabel;
	private TextField zipField;
	private TextField cityField;
	private ChoiceBox<String>stateField;
	/**
	 * 
	 */
	public ChangeLocationView(Stage primaryStage) {
		this.ChangeLocationController = new ChangeLocationController(this, primaryStage);
	}
	
	public void start(Stage primaryStage, Scene scene) {
		//store for back button
		Stage stagePrev = primaryStage;
	    Scene scenePrev = scene;
	    
	    primaryStage.setTitle("Change Location Window");    
	    OptionsScreenModel OSmodel = new OptionsScreenModel();
	    Button backBtn = new Button("Back");
	    Button saveBtn = new Button("Save");
	    
    	cityLabel = new Label("City:  ");
		stateLabel = new Label("State:  ");
		zipLabel = new Label("Zip Code:  ");
		orLabel = new Label(" -OR-");
		cityField = new TextField();
		stateField = new ChoiceBox<String>(FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "DC", "PR", "VI", "AS", "GU", "MP", "AA", "AE", "AP"));
		zipField = new TextField();
		stateField.setPrefWidth(80);
		cityField.setPrefWidth(80);
		
		backBtn.setOnAction(ChangeLocationController.getBackListener(stagePrev, scenePrev));
    	saveBtn.setOnAction(ChangeLocationController.getSaveListener(cityField, stateField, zipField, OSmodel));

    	grid = new GridPane();
		grid.add(cityLabel, 0, 0);
		grid.add(stateLabel, 0, 1);
		grid.add(orLabel, 0, 2);
		grid.add(zipLabel, 0, 4);
		grid.add(cityField, 3, 0);
		grid.add(stateField, 3, 1);
		grid.add(zipField, 3, 4);
		grid.add(backBtn, 0, 7);
    	grid.add(saveBtn, 4, 7);
		grid.setAlignment(Pos.CENTER);
		
		cityField.setText(OSmodel.getCityOpt());
    	stateField.setValue(OSmodel.getStateOpt());
    	zipField.setText(OSmodel.getZipOpt());
    	
    	border = new BorderPane();
    	border.setCenter(grid);
    	
    	Scene Optscene = new Scene(border, 800, 700);

    	Optscene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
	}
}
