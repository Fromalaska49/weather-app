package weather;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javafx.scene.image.Image;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import model.LocationScreenModel;
import javafx.scene.text.Font;

public class WeatherScreenView {


	private WeatherScreenController controller;
	private Text headerText;
	private BorderPane border;
	private Text cityLabel;
	private Text stateLabel;
	private Text timeLabel;
	private HBox topPanel;
	private VBox rightPanel;
	private VBox centerPanel;
	private VBox leftPanel;
	private GridPane bottomPanel;
	private GridPane topGrid;
	private Button okBtn = new Button();
	private Button toggleCF = new Button();
	private Button toggleHW = new Button();
	private Button toggleMI = new Button();
	private Text weatherNumerics;

	//	private LocationScreenModel locModel;

	public WeatherScreenView(){	
	}
	public void start(Stage stage, Scene scene) {

		
		headerText =  TextBuilder.create().text("Thunderstorm").build();
		headerText.setFont(Font.font ("Sans Serif",  40));
		weatherNumerics =  TextBuilder.create().text("49" + Character.toString((char) 176) + "C").build();
		weatherNumerics.setFont(Font.font ("Consolas",  100));
		cityLabel =  TextBuilder.create().text("San Antonio").build();
		cityLabel.setFont(Font.font ("Helvetica",  20));
		stateLabel =  TextBuilder.create().text("Texas").build();
		stateLabel.setFont(Font.font ("Helvetica",  20));
		timeLabel =  TextBuilder.create().text("7:46 PM").build();
		timeLabel.setFont(Font.font("Helvetica",  20));

    	ScreenController screenController = new ScreenController(stage);
    	Button backButton = new Button("< Back");
    	backButton.setOnAction(screenController.getBackListener(stage, scene));
    	topGrid = new GridPane();
    	topGrid.setPadding(new Insets(10, 10, 10, 10));
    	topGrid.setHgap(10);
    	topGrid.setVgap(10);
    	topGrid.setGridLinesVisible(false);
    	topGrid.setAlignment(Pos.TOP_LEFT);
    	topGrid.add(backButton, 0, 0);
    	
    	
		//		weatherNumerics.setText("49� C");
		//Image image = new Image("StartScreen.png");

		// simple displays ImageView the image as is
		Image image = new Image(new File("Capture.PNG").toURI().toString());
		//ImageView iv1 = new ImageView(getClass().getResource("StartScreen.png").toExternalForm());
		ImageView iv2,iv3,iv4,iv5,iv6,iv7,iv8;
		ImageView iv1 = new ImageView();
		iv2 = iv3 = iv4= iv5= iv6= iv7 = iv8 = iv1;
		iv1.setImage(image);
		iv1.setPreserveRatio(true);
		toggleCF.setText("Toggle C/F");
		toggleHW.setText("Toggle Hourly/Weekly");
		toggleMI.setText("Toggle Meters/Imperial");

		topPanel = new HBox();
		rightPanel = new VBox(20);
		centerPanel = new VBox();
		leftPanel = new VBox(5);
		bottomPanel = new GridPane();

		border = new BorderPane();
		border.setPadding(new Insets(25, 100, 100, 100));

		topPanel.getChildren().add(topGrid);
		topPanel.getChildren().add(iv1);
		topPanel.getChildren().add(headerText);
		topPanel.setAlignment(Pos.CENTER);

		rightPanel.getChildren().add(toggleCF);
		rightPanel.getChildren().add(toggleHW);
		rightPanel.getChildren().add(toggleMI);
		rightPanel.setAlignment(Pos.CENTER_LEFT);
		//		topPanel.setHgrow(iv1, Priority.ALWAYS);
		//	     topPanel.setHgrow(headerText, Priority.ALWAYS);

		centerPanel.getChildren().add(weatherNumerics);
		centerPanel.setAlignment(Pos.CENTER);

		leftPanel.getChildren().add(cityLabel);
		leftPanel.getChildren().add(stateLabel);
		leftPanel.getChildren().add(timeLabel);
		leftPanel.setAlignment(Pos.BOTTOM_LEFT);
//		bottomPanel.add(iv2, 0, 1);
//		bottomPanel.add(iv3, 0, 2);
//		bottomPanel.add(iv4, 0, 3);
//		bottomPanel.add(iv5, 0, 4);
//		bottomPanel.add(iv6, 0, 5);
//		bottomPanel.add(iv7, 0, 6);
//		bottomPanel.add(iv8, 0, 0);

		border.setTop(topPanel);
		border.setRight(rightPanel);
		border.setCenter(weatherNumerics);
		border.setLeft(leftPanel);
		border.setBottom(bottomPanel);


		border.setAlignment(topPanel, Pos.CENTER);
		border.setAlignment(rightPanel, Pos.CENTER_LEFT);
		border.setAlignment(weatherNumerics, Pos.CENTER);
		border.setAlignment(leftPanel, Pos.BOTTOM_LEFT);
		border.setAlignment(bottomPanel, Pos.CENTER);



		border.setMargin(leftPanel, new Insets(0,50,50,50));
		border.setMargin(rightPanel, new Insets(0,50,50,50));
		border.setMargin(centerPanel, new Insets(50,10,50,10));
		//border.setAlignment(weatherNumerics, Pos.CENTER );
		//border.setCenter(grid);
		//border.setBottom(okBtn);
		//border.setAlignment(headerText, Pos.CENTER);
		//border.setAlignment(okBtn, Pos.CENTER_RIGHT); 


		Scene scene2 = new Scene(border, 800, 700);

		//scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

		//stage.setMaximized(true);
		stage.setTitle("Weather Conditions");
        scene2.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene2);
		stage.show(); 


	}



}
