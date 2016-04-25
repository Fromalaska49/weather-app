package weather;

import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import javax.swing.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
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
	private Calendar dateToday = Calendar.getInstance();
	private WeatherScreenModel model;
	private TextField searchField = new TextField();
	private Button settingsButton = new Button();
	private Text windNumerics;
	private String BckGimg;
    private ArrayList<ImageView> imageViewArray = new ArrayList<>();
    private ArrayList<Label> sevenDaysWeather= new ArrayList<>();
    public ArrayList<Label> tempSevenDays = new ArrayList<>();

	//	private LocationScreenModel locModel;

	public WeatherScreenView(WeatherScreenModel wModel){	
		model = wModel;
	}
	
	public void clearBottomPanel(){
        for(Node node : bottomPanel.getChildren()){
        		if( tempSevenDays.contains(node)){
        			node.setVisible(false);
        		}
        }
	}
	
	public void setBottomPanel(){
		for(int i = 0; i < 7; i++){
			Label temps = new Label(model.getHighTemps().get(i).getText() + " / " + model.getLowTemps().get(i).getText());
			tempSevenDays.add(temps);
			bottomPanel.add(temps,	 i, 2);
		}
	}
	
	
	public void start(Stage stage, Scene scene) {

		
		headerText =  TextBuilder.create().text(model.getWeatherCondition()).build();

		headerText.setFont(Font.font ("Helvetica",  40));
		
		setWeatherNumerics((TextBuilder.create().text( model.getTemp()+ Character.toString((char) 176) + model.getTempSetting()).build()));
		getWeatherNumerics().setFont(Font.font ("Helvetica",  100));
		setWindNumerics((TextBuilder.create().text( model.getWindSpeed() + model.getWindSettings() ).build()));
		getWindNumerics().setFont(Font.font ("Helvetica", 50));
		
		
		cityLabel =  TextBuilder.create().text(model.getCity()+", "+model.getState()).build();
		cityLabel.setFont(Font.font ("Helvetica",  20));
		int timeStamp = Integer.parseInt(model.getData().getLocalTime());
		Date time = new Date((long) timeStamp * 1000);
		SimpleDateFormat stf = new SimpleDateFormat("EEE, h:mm a");
		stf.setTimeZone(TimeZone.getTimeZone("GMT" + model.getData().getTimeOffset())); 
		String formattedTime = stf.format(time);
		stateLabel =  TextBuilder.create().text(formattedTime).build();
		stateLabel.setFont(Font.font ("Helvetica",  15));
		
		SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT" + model.getData().getTimeOffset())); 
		String formattedDate = sdf.format(time);
		timeLabel =  TextBuilder.create().text(formattedDate).build();
		timeLabel.setFont(Font.font("Helvetica",  15));

		
    	WeatherScreenController wController = new WeatherScreenController(this, model);
    	Button searchButton = new Button("Search");
    	searchButton.setOnAction(wController.getBackListener(stage, scene));

    	WeatherScreenController weatherScreenController = new WeatherScreenController(this, this.model);
    	searchButton.setOnAction(weatherScreenController.getSearchListener(stage));

		settingsButton.setText("Settings");
		settingsButton.setOnAction(weatherScreenController.getSettingsListener(stage));
    	Button radarButton = new Button("Radar");
    	radarButton.setOnAction(wController.getRadarListener());
    	Button exitButton = new Button("Exit");
    	exitButton.setOnAction(wController.getExitListener());
		//Code for importing background image.
		BckGimg = model.getBckGImg();
		//imports background img into image
		String image = getClass().getResource(BckGimg).toExternalForm();
		
		
		
		
    	topGrid = new GridPane();
    	topGrid.setPadding(new Insets(10, 10, 10, 10));
    	topGrid.setHgap(10);
    	topGrid.setVgap(10);
    	topGrid.setGridLinesVisible(false);
    	topGrid.setAlignment(Pos.TOP_LEFT);
    	topGrid.add(searchField, 0, 1);
    	topGrid.add(searchButton, 1, 1);
    	topGrid.add(settingsButton, 4, 0);
    	model.setTodayIcon();
    	ImageView todayIcon = ImageViewBuilder.create()
                .image(new Image(model.getTodayIcon()))
                .build();
    	todayIcon.setFitHeight(200);
    	todayIcon.setFitWidth(200);
    	topGrid.add(todayIcon, 1, 0);

		toggleCF.setText("Toggle C/F");
		toggleCF.setOnAction(wController.getTempSettingListener());
		toggleHW.setText("Toggle Hourly/Weekly");
		toggleMI.setText("Toggle Kilometers/Miles");
		toggleMI.setOnAction(wController.getWindSettingListener());

		topPanel = new HBox();
		rightPanel = new VBox(20);
		centerPanel = new VBox();
		leftPanel = new VBox(5);
		bottomPanel = new GridPane();

		border = new BorderPane();
		border.setPadding(new Insets(25, 100, 100, 100));
		//set background img to border
		border.setStyle("-fx-background-image: url('" + image + "'); -fx-background-position: center center; -fx-background-repeat: stretch; -fx-background-size: 1600, 2160;");
		
		//topGrid.add(iv1, 2, 0);
		topGrid.add(headerText, 2, 0);
		
		bottomPanel.setHgap(15);
		bottomPanel.setVgap(15);
		
		topPanel.getChildren().add(topGrid);
		//topPanel.getChildren().add(iv1);
		//topPanel.getChildren().add(headerText);

		//topPanel.getChildren().add(imageView);
		//topPanel.getChildren().add(headerText);
		topPanel.setAlignment(Pos.TOP_LEFT);
		
		rightPanel.getChildren().add(radarButton);
		rightPanel.getChildren().add(toggleCF);
		//rightPanel.getChildren().add(toggleHW);
		rightPanel.getChildren().add(toggleMI);
		rightPanel.getChildren().add(exitButton);
		rightPanel.setAlignment(Pos.CENTER_LEFT);
		//		topPanel.setHgrow(iv1, Priority.ALWAYS);
		//	     topPanel.setHgrow(headerText, Priority.ALWAYS);

		centerPanel.getChildren().add(getWeatherNumerics());
		centerPanel.getChildren().add(getWindNumerics());
		centerPanel.setAlignment(Pos.CENTER);

		cityLabel.getStyleClass().add("readable-text");
		stateLabel.getStyleClass().add("readable-text");
		timeLabel.getStyleClass().add("readable-text");
		
		
		
		
		leftPanel.getChildren().add(cityLabel);
		leftPanel.getChildren().add(stateLabel);
		leftPanel.getChildren().add(timeLabel);
		leftPanel.setAlignment(Pos.BOTTOM_LEFT);
		
		
        

        
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
	        	Label dayLabel = new Label();
	        	dayLabel.setText(model.getForecastDay(p+1));
	        	sevenDaysWeather.add(p, dayLabel);
	        	bottomPanel.add(sevenDaysWeather.get(p), p, 0);
	        	Label temps = new Label(model.getHighTemps().get(p).getText() + " / " + model.getLowTemps().get(p).getText());
	        	tempSevenDays.add(temps);
	        	bottomPanel.add(temps, p, 2);
	        	p++;
	        }
		bottomPanel.setAlignment(Pos.CENTER);

		border.setTop(topPanel);
		border.setRight(rightPanel);
		//border.setCenter(getWeatherNumerics());
		border.setCenter(centerPanel);
		border.setLeft(leftPanel);
		border.setBottom(bottomPanel);


		border.setAlignment(topPanel, Pos.CENTER);
		border.setAlignment(rightPanel, Pos.CENTER_LEFT);
		//border.setAlignment(getWeatherNumerics(), Pos.CENTER);
		border.setAlignment(centerPanel, Pos.CENTER);
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


		Scene scene2 = new Scene(border, 1080, 700);

		//scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());

		//stage.setMaximized(true);
		stage.setTitle("Weather Conditions");
        scene2.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
		stage.setScene(scene2);
		stage.setMinWidth(1080);
		stage.show(); 


	}

	
	public Text getWeatherNumerics() {
		return weatherNumerics;
	}
	
	public void setWeatherNumerics(Text string) {
		this.weatherNumerics = string;
	}
	
	public Text getWindNumerics() {
		return windNumerics;
	}
	
	public void setWindNumerics(Text string) {
		this.windNumerics = string;
	}
	/*
	 * Returns the value of the search field
	 */
	public String getSearchQuery(){
		return searchField.getText();
	}


}