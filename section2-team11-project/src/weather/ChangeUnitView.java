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
public class ChangeUnitView {
	private ChoiceBox<String> tempField;
	private GridPane grid;
	private BorderPane border;
	private Label tempLabel;
	private Label windLabel;
	private ChoiceBox<String> windField;
	private ChangeUnitController ChangeUnitController;

	/**
	 * 
	 */
	public ChangeUnitView(Stage primaryStage) {
		this.ChangeUnitController = new ChangeUnitController(this, primaryStage);
	}
	
	
	 public void start(Stage primaryStage, Scene scene) {
		//store for back button
		Stage stagePrev = primaryStage;
	    Scene scenePrev = scene;
	    
	    primaryStage.setTitle("Change Unit Window");    
	    tempLabel = new Label("Temprature Unit: ");
	    windLabel = new Label("Wind Speed Unti: ");
	    OptionsScreenModel OSmodel = new OptionsScreenModel();
	    Button backBtn = new Button("Back");
	    Button saveBtn = new Button("Save");
	    
	    tempField = new ChoiceBox<String>(FXCollections.observableArrayList("F", "C"));
	    windField = new ChoiceBox<String>(FXCollections.observableArrayList("MpH", "KpH"));
	    
	    backBtn.setOnAction(ChangeUnitController.getBackListener(stagePrev, scenePrev));
    	saveBtn.setOnAction(ChangeUnitController.getSaveListener(tempField, windField, OSmodel));
    	
    	grid = new GridPane();
    	grid.add(windLabel, 0, 3);
    	grid.add(windField, 3, 3);
		grid.add(tempLabel, 0, 6);
    	grid.add(tempField, 3, 6);
    	grid.add(backBtn, 0, 7);
    	grid.add(saveBtn, 4, 7);
		grid.setAlignment(Pos.CENTER);
		
		tempField.setValue(OSmodel.getTempOpt());
		windField.setValue(OSmodel.getWindOpt());
		
		border = new BorderPane();
    	border.setCenter(grid);
    	
    	Scene Optscene = new Scene(border, 800, 700);

    	Optscene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
    	
    	primaryStage.setScene(Optscene);
    	primaryStage.show();
	 }
	 
}
