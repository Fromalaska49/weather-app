/**
 * 
 */
package weather;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
		private static TextField stateField;
		private Button okBtn = new Button();
		private Button setBtn = new Button();
		
	public LocationScreenView(){
		
	}
	public void start(Stage primaryStage) {
		//primaryStage.setMaximized(true);

		
		headerText =  TextBuilder.create().text("Weather App").build();
		headerText.setFont(Font.font ("Sans Serif",  40));
		cityLabel = new Label("City:  ");
		stateLabel = new Label("State:  ");
		zipLabel = new Label("Zip Code:  ");
		orLabel = new Label(" -OR-");
		cityField = new TextField();
		stateField = new TextField();
		zipField = new TextField();
		stateField.setPrefWidth(80);
		cityField.setPrefWidth(80);
		okBtn.setText("OK");
		setBtn.setText("Settings");
		
		okBtn.setOnAction(LocationScreenController .getOkListener());
		
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
		bottomGrid.add(okBtn, 0, 0);
		bottomGrid.add(setBtn, 0, 1);
		bottomGrid.setAlignment(Pos.BOTTOM_CENTER);
		
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
        scene.getStylesheets().add(this.getClass().getResource("startScreen.css").toExternalForm());
		primaryStage.show();

	}
	
	public static String getCity(){
		return cityField.getText();
	}
	
	public static String getState(){
		return stateField.getText();
	}
	
	public static String getZipCode(){
		return zipField.getText();
	}
	

}