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

public class WeatherScreenView {
	
	
	private WeatherScreenController controller;
	private Text headerText;
	private BorderPane border;
	private GridPane grid;
	private Label cityLabel;
	private Label stateLabel;
	private Label timeLabel;

	private Button okBtn = new Button();
	
    public WeatherScreenView(){	
	}
    public void start(Stage secondStage) {
		secondStage.setMaximized(true);
		
		headerText =  TextBuilder.create().text("Weather App").build();
		headerText.setFont(Font.font ("Sans Serif",  40));
		cityLabel = new Label("model.LocationScreenModel.city");
		stateLabel = new Label("model.state");
		timeLabel = new Label("model.time");
		okBtn.setText("OK");
		
		
		okBtn.setOnAction(LocationScreenController .getOkListener());
		
		grid = new GridPane();
		grid.add(cityLabel, 0, 0);
		grid.add(stateLabel, 0, 1);
		grid.add(timeLabel, 0, 2);
		grid.setAlignment(Pos.BASELINE_LEFT);
		
		border = new BorderPane();
		border.setPadding(new Insets(25, 100, 100, 100));
		border.setTop(headerText);
		border.setCenter(grid);
		border.setBottom(okBtn);
		border.setAlignment(headerText, Pos.CENTER);
		border.setAlignment(okBtn, Pos.CENTER_RIGHT);
		

		Scene scene = new Scene(border, 300, 250);
    	scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		

		secondStage.setTitle("Weather App");

	}
	
	
	

}
		/*
		

	    -fx-background-image: url("background_image.jpg");
	    -fx-background-repeat: stretch;   
	    -fx-background-size: 900 506;
	    -fx-background-position: center center;
	    -fx-effect: dropshadow(three-pass-box, black, 30, 0.5, 0, 0); 
	    
	    */
