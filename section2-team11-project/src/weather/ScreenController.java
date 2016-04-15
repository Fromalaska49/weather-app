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

public class ScreenController {
	
	private Stage primaryStage;
	
	public ScreenController(Stage stage) {
		this.primaryStage = stage;
	}
	
	public Stage getStage(){
    	return this.primaryStage;
    }
	
	private void initialize() {
		
    }
	
	public void showLocationScreen(Stage p) {
		primaryStage = p;
	  	LocationScreenModel model = new LocationScreenModel();
	  	LocationScreenView view = new LocationScreenView(model, primaryStage);
	  	LocationScreenController controller = new LocationScreenController(model, view, primaryStage);
	  	view.start(primaryStage);
	}
	
	public void showWeatherScreen(Stage p) {
		//primaryStage = p;
		Scene scene = p.getScene();
		
		WeatherScreenView wView = new WeatherScreenView();
		System.out.println("Display Weather Screen");
		wView.start(primaryStage, scene);
	}

	/*
	 * This function was either incomplete or partially
	 * deleted, so the name and parameters were instatiated
	 * and the body was commented out so that the code
	 * might hobble onwards through the merge commit.
	 */
	public void showOptionsScreen(Stage stage){
		OptionsScreenView optView = new OptionsScreenView();
		Scene scene = stage.getScene();
		
		System.out.println("Display Options Screen (Pretty Please)");
		optView.start(primaryStage, scene);
		
	}
	
	/*
	 * Event listener for the Settings button.  If pressed will transition to Settings screen.
	 * @return Returns a handler object
	 */
	/*
	public EventHandler<ActionEvent> getSetListener(){
		EventHandler handler = new EventHandler<Event>(){
			//private Stage primaryStage;
			Stage primaryStage = getStage();
			ScreenController sController = new ScreenController(primaryStage);

			@Override
			public void handle(Event event){
				ScreenController screenController = new ScreenController(primaryStage);
				System.out.println("Setting button");
				ScreenController.showOptionsScreen(primaryStage);
				//showOptionsScreen(primaryStage);//Replace .show with settings java class.
				//showOptionsScreen(primaryStage);
			}	
		};
		return handler;
	}
	*/
	
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
