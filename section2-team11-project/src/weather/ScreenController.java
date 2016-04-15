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
import model.WeatherScreenModel;

public class ScreenController {
	
	private Stage primaryStage;
	private LocationScreenModel locModel;
	
	public ScreenController(Stage stage) {
		this.primaryStage = stage;
	}
	
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
	  	System.out.println(locModel.getLocation());
	}
	
	/**
	 * This method is called by LocationScreenController when the ok button is clicked. 
	 * @param p
	 */
	public void showWeatherScreen(Stage p) {
		//LoadAPI load = new LoadAPI(locModel.getLocation());
		ProcessData data = new ProcessData();
		//System.out.println(data.getWindchillF());
		//System.out.println(this.locModel.getZipCode());
		
		Scene scene = p.getScene();
		WeatherScreenView wView = new WeatherScreenView();
		WeatherScreenModel wModel = new WeatherScreenModel();
		WeatherScreenController wController = new WeatherScreenController(wView, wModel);
		System.out.println("Display Weather Screen");
		wView.start(primaryStage, scene);
	}

	/*
	 * This function was either incomplete or partially
	 * deleted, so the name and parameters were instatiated
	 * and the body was commented out so that the code
	 * might hobble onwards through the merge commit.
	 */
	public void showOptionsScreen(Stage primaryStage){
		
		OptionsScreenView optView = new OptionsScreenView();
		
		System.out.println("Display Options Screen (Pretty Please)");
		optView.start(primaryStage, primaryStage.getScene());
		
	}
	
	/*
	 * Event listener for the Settings button.  If pressed will transition to Settings screen.
	 * @return Returns a handler object
	 */
	public EventHandler<ActionEvent> getSetListener(){
		EventHandler handler = new EventHandler<Event>(){
			private Stage primaryStage;


			@Override
			public void handle(Event event){
				showOptionsScreen(primaryStage);//Replace .show with settings java class.
			}	
		};
		return handler;
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
