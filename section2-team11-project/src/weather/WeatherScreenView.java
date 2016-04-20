package weather;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
import javafx.scene.image.ImageViewBuilder;
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
import model.WeatherScreenModel;
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
	private 
	WeatherScreenModel model;
	private TextField searchField = new TextField();

	//	private LocationScreenModel locModel;

	public WeatherScreenView(WeatherScreenModel wModel){	
		model = wModel;
	}
	
	public void start(Stage stage, Scene scene) {

		
		headerText =  TextBuilder.create().text(model.getWeatherCondition()).build();
		headerText.setFont(Font.font ("Sans Serif",  40));
		setWeatherNumerics(TextBuilder.create().text( model.getTemp()+ Character.toString((char) 176) + model.getTempSetting()).build());
		getWeatherNumerics().setFont(Font.font ("Consolas",  100));
		cityLabel =  TextBuilder.create().text(model.getCity()).build();
		cityLabel.setFont(Font.font ("Helvetica",  20));
		stateLabel =  TextBuilder.create().text(model.getState()).build();
		stateLabel.setFont(Font.font ("Helvetica",  20));
		timeLabel =  TextBuilder.create().text(model.getTime()).build();
		timeLabel.setFont(Font.font("Helvetica",  20));

//    	//ScreenController screenController = new ScreenController(stage);
//    	//Button backButton = new Button("< Back");
//    	backButton.setOnAction(screenController.getBackListener(stage, scene));
//    	topGrid = new GridPane();
//    	topGrid.setPadding(new Insets(10, 10, 10, 10));
//    	topGrid.setHgap(10);
//    	topGrid.setVgap(10);
//    	topGrid.setGridLinesVisible(false);
//    	topGrid.setAlignment(Pos.TOP_LEFT);
//    	topGrid.add(backButton, 0, 0);
    	
    	
		//		weatherNumerics.setText("49� C");
		//Image image = new Image("StartScreen.png");
		

		/*
    	WeatherScreenController wController = new WeatherScreenController(this, model);
    	Button backButton1 = new Button("< Back");
    	backButton1.setOnAction(wController.getBackListener(stage, scene));
    	topGrid = new GridPane();
    	topGrid.setPadding(new Insets(10, 10, 10, 10));
    	topGrid.setHgap(10);
    	topGrid.setVgap(10);
    	topGrid.setGridLinesVisible(false);
    	topGrid.setAlignment(Pos.TOP_LEFT);
    	topGrid.add(backButton1, 0, 0);
    	*/
		
		
    	WeatherScreenController wController = new WeatherScreenController(this, model);
    	Button searchButton = new Button("Search");
    	searchButton.setOnAction(wController.getBackListener(stage, scene));

    	WeatherScreenController weatherScreenController = new WeatherScreenController(this, this.model);
    	searchButton.setOnAction(weatherScreenController.getSearchListener(stage));
		
    	topGrid = new GridPane();
    	topGrid.setPadding(new Insets(10, 10, 10, 10));
    	topGrid.setHgap(10);
    	topGrid.setVgap(10);
    	topGrid.setGridLinesVisible(false);
    	topGrid.setAlignment(Pos.TOP_LEFT);
    	topGrid.add(searchField, 0, 0);
    	topGrid.add(searchButton, 1, 0);

		// simple displays ImageView the image as is
		Image image = new Image(new File("Capture.PNG").toURI().toString());
		
		//ImageView iv1 = new ImageView(getClass().getResource("StartScreen.png").toExternalForm());
		ImageView iv1,iv2,iv3,iv4,iv5,iv6,iv7,iv8;
		iv1 = new ImageView();
		iv2 = new ImageView();
		iv3 = new ImageView();
		iv4 = new ImageView();
		iv5 = new ImageView();
		iv6 = new ImageView();
		iv7 = new ImageView(); 
		iv8 = new ImageView();

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

		centerPanel.getChildren().add(getWeatherNumerics());
		centerPanel.setAlignment(Pos.CENTER);

		leftPanel.getChildren().add(cityLabel);
		leftPanel.getChildren().add(stateLabel);
		leftPanel.getChildren().add(timeLabel);
		leftPanel.setAlignment(Pos.BOTTOM_LEFT);
		
		
        
        ArrayList<ImageView> imageViewArray = new ArrayList<>();
        
        for(int i = 1; i <= 7; i++){
        	model.setIcon(i);
        	ImageView temp = ImageViewBuilder.create()
                    .image(new Image(model.getIcon()))
                    .build();
        	imageViewArray.add(temp);
        }
        
        int p = 0;
        for(ImageView iv : imageViewArray){
        	iv.setFitHeight(100);
        	iv.setFitWidth(100);
        	bottomPanel.add(iv, p, 1);
        	p++;
        }
		
		bottomPanel.setAlignment(Pos.CENTER);

		border.setTop(topPanel);
		border.setRight(rightPanel);
		border.setCenter(getWeatherNumerics());
		border.setLeft(leftPanel);
		border.setBottom(bottomPanel);


		border.setAlignment(topPanel, Pos.CENTER);
		border.setAlignment(rightPanel, Pos.CENTER_LEFT);
		border.setAlignment(getWeatherNumerics(), Pos.CENTER);
		border.setAlignment(leftPanel, Pos.BOTTOM_LEFT);
		border.setAlignment(bottomPanel, Pos.CENTER);



		border.setMargin(leftPanel, new Insets(0,50,50,25));
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

	
	public Text getWeatherNumerics() {
		return weatherNumerics;
	}
	
	public void setWeatherNumerics(Text weatherNumerics) {
		this.weatherNumerics = weatherNumerics;
	}
	
	/*
	 * Returns the value of the search field
	 */
	public String getSearchQuery(){
		return searchField.getText();
	}


}
