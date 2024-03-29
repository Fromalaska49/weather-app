package weather;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.LocationScreenModel;
import model.OptionsScreenModel;
import model.WeatherScreenModel;
import model.ChangeLocationModel;
import model.ChangeUnitModel;

public class ScreenController {
	
	private Stage primaryStage;
	private LocationScreenModel locModel;
	
	/**
	 * Constructor method
	 * @param stage
	 */
	public ScreenController(Stage stage) {
		this.primaryStage = stage;
	}
	
	/**
	 * Returns primary stage
	 * @return
	 */
	public Stage getStage(){
    	return this.primaryStage;
    }
	
	/**
	 * Initializes controller class
	 */
	private void initialize() {
		
    }
	
	/**
	 * This method is called on by MainApp. It displays the first screen of the app, Location Screen.
	 * @param p
	 */
	public void showLocationScreen(Stage p) {
		primaryStage = p;
	  	this.locModel = new LocationScreenModel();
	  	LocationScreenView locView = new LocationScreenView(locModel, primaryStage);
	  	LocationScreenController locController = new LocationScreenController(locModel, locView, primaryStage);
	  	locView.start(primaryStage);
	}
	
	/**
	 * This method is called by LocationScreenController when the ok button is clicked. 
	 * @param p
	 */
	public void showWeatherScreen(Stage p, LocationScreenModel lmodel) {
		LoadAPI api = new LoadAPI(lmodel.getLocation());  
		ProcessData data = new ProcessData();                   
	
		Scene scene = p.getScene();
		WeatherScreenModel wModel = new WeatherScreenModel(api, data);
		WeatherScreenView wView = new WeatherScreenView(wModel);
		WeatherScreenController wController = new WeatherScreenController(wView, wModel);
		//System.out.println("Display Weather Screen");
		wView.start(primaryStage, scene);
	}

	/**
	 * This method is called by LocationScreenController when the ok button is clicked. 
	 * @param p
	 */
	public void showWeatherScreen(Stage p, ChangeLocationModel cModel) {
		LoadAPI api = new LoadAPI(cModel.getLocation());  
		ProcessData data = new ProcessData();                   
	
		Scene scene = p.getScene();
		WeatherScreenModel wModel = new WeatherScreenModel(api, data);
		WeatherScreenView wView = new WeatherScreenView(wModel);
		WeatherScreenController wController = new WeatherScreenController(wView, wModel);
		//System.out.println("Display Weather Screen");
		wView.start(primaryStage, scene);
	}
	
	/**
	 * This method is called by LocationScreenController when the ok button is clicked. 
	 * @param p
	 */
	public void showWeatherScreen(Stage p, String location) {
		LoadAPI api = new LoadAPI(location);  
		ProcessData data = new ProcessData();                   
	
		Scene scene = p.getScene();
		WeatherScreenModel wModel = new WeatherScreenModel(api, data);
		WeatherScreenView wView = new WeatherScreenView(wModel);
		WeatherScreenController wController = new WeatherScreenController(wView, wModel);
		//System.out.println("Display Weather Screen");
		wView.start(primaryStage, scene);
	}
	
	/**
	 * This method is called by LocationScreenController when the Settings button is clicked. 
	 * @param p
	 */
	public void showOptionsScreen(Stage stage){
		Scene scene = stage.getScene();
		
		
		OptionsScreenView oView = new OptionsScreenView(stage);
		OptionsScreenController oController = new OptionsScreenController(oView, stage);
		
		//System.out.println("Display Options Screen (Pretty Please)");
		oView.start(primaryStage, scene);
		
	}
	
	public void showChangeUnitScreen(Stage stage){
		Scene scene = stage.getScene();
	//	System.out.println("I'm in Show Screen!");
		ChangeUnitView cView = new ChangeUnitView(stage);
		ChangeUnitController cController = new ChangeUnitController(cView, stage);
		cView.start(primaryStage, scene);
	}
	
	public void showChangeLocationScreen(Stage stage){
		Scene scene = stage.getScene();
		ChangeLocationView lView = new ChangeLocationView(stage);
		ChangeLocationController lController = new ChangeLocationController(lView, stage);
		lView.start(primaryStage, scene);
	}
	
	public EventHandler<ActionEvent> getBackListener(Stage stagePrev, Scene scenePrev){
		EventHandler handler = new EventHandler<Event>(){
			
			public void handle(Event event){
				stagePrev.setScene(scenePrev);
				stagePrev.show();
			}
		};
		return handler;
	}

	}
