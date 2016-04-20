/**
 * 
 */
package weather;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import model.LocationScreenModel;
import model.OptionsScreenModel;
import javafx.scene.text.Font;

/**
 * @author Admin
 *
 */
public class LocationScreenView extends Application  {
		
		
		private LocationScreenController controller;
		private Text headerText;
		private BorderPane border;
		private GridPane grid;
		private GridPane bottomGrid;
		private Label cityLabel;
		private Label stateLabel;
		private Label zipLabel;
		private Label orLabel;
		private static TextField zipField;
		private static TextField cityField;;
		private static ChoiceBox<String> stateField;
		private Button okBtn = new Button();
		private Button setBtn = new Button();
		private LocationScreenController locationScreenController;
		private OptionsScreenModel OSmodel;
		/**
		 * Constructor method for LocationScreenView
		 * @param model
		 * @param primaryStage
		 */	
	public LocationScreenView(LocationScreenModel model, Stage primaryStage){
		this.locationScreenController = new LocationScreenController(model, this, primaryStage);
	}
	/**
	 * Adds contents to the stage
	 */
	public void start(Stage primaryStage) {
		//primaryStage.setMaximized(true);

		
		headerText =  TextBuilder.create().text("Weather App").build();
		headerText.setFont(Font.font ("Sans Serif",  40));
		cityLabel = new Label("City:  ");
		stateLabel = new Label("State:  ");
		zipLabel = new Label("Zip Code:  ");
		orLabel = new Label(" -OR-");
		cityField = new TextField();
		stateField = new ChoiceBox(FXCollections.observableArrayList("AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY", "DC", "PR", "VI", "AS", "GU", "MP", "AA", "AE", "AP"));
		zipField = new TextField();
		stateField.setPrefWidth(80);
		cityField.setPrefWidth(80);
		okBtn.setText("OK");
		setBtn.setText("Settings");
		
		okBtn.setOnAction(locationScreenController.getOkListener());
		setBtn.setOnAction(locationScreenController.getSetListener());
		
		grid = new GridPane();
		grid.add(cityLabel, 0, 0);
		grid.add(stateLabel, 0, 1);
		grid.add(orLabel, 0, 2);
		grid.add(zipLabel, 0, 4);
		grid.add(cityField, 3, 0);
		grid.add(stateField, 3, 1);
		grid.add(zipField, 3, 4);
		grid.setAlignment(Pos.CENTER);
		
		bottomGrid = new GridPane();
		bottomGrid.setPadding(new Insets(10, 10, 10, 10));
		bottomGrid.setHgap(10);
		bottomGrid.setVgap(10);
		bottomGrid.add(okBtn, 0, 0);
		bottomGrid.add(setBtn, 0, 1);
		bottomGrid.setAlignment(Pos.BOTTOM_CENTER);
		
		//Creates Options Model which pulls settings from config file
		OSmodel = new OptionsScreenModel();
    	cityField.setText(OSmodel.getCityOpt());
    	stateField.setValue(OSmodel.getStateOpt());
    	zipField.setText(OSmodel.getZipOpt());
		

		border = new BorderPane();
		//border.setId("Startpane");
		border.setPadding(new Insets(25, 100, 100, 100));
		border.setTop(headerText);
		border.setCenter(grid);
		border.setBottom(bottomGrid);
		//border.setBottom(okBtn);
		//border.setBottom(setBtn);
		border.setAlignment(headerText, Pos.CENTER);
		border.setAlignment(okBtn, Pos.CENTER_RIGHT);
		border.setAlignment(setBtn, Pos.CENTER_LEFT);
		Scene scene = new Scene(border, 800, 700);


		primaryStage.setTitle("Weather App");
		primaryStage.setScene(scene);
        //scene.getStylesheets().add(this.getClass().getResource("startScreen.css").toExternalForm());
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		primaryStage.show();

	}
	
	/**
	 * Returns city field
	 * @return
	 */
	public String getCity(){
		return cityField.getText();
	}
	
	/**
	 * Returns state field
	 * @return
	 */
	public String getState(){
		return stateField.getValue().toString();
	}
	
	/**
	 * Returns zip code field
	 * @return
	 */
	public String getZipCode(){
		return zipField.getText();
	}
	

}