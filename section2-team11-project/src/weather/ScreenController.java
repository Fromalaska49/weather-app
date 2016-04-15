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
	
	private static Stage primaryStage;
	
	public ScreenController() {
		
	}
	
	private void initialize() {
		
    }
	
	public static void showLocationScreen(Stage p) {
		primaryStage = p;
	  	LocationScreenModel model = new LocationScreenModel();
	  	LocationScreenView view = new LocationScreenView();
	  	LocationScreenController controller = new LocationScreenController(model, view);
	  	view.start(primaryStage);
	}
	
	public static void showWeatherScreen(Stage p) {
		//primaryStage = p;
		Scene scene = primaryStage.getScene();
		
		WeatherScreenView wView = new WeatherScreenView();
		System.out.println("Display Weather Screen");
		wView.start(primaryStage, scene);
	}
	
	public static void showOptionsScreen(Stage p) {
		Scene scene = primaryStage.getScene();

		OptionsScreenView optView = new OptionsScreenView();
		
		System.out.println("Display Options Screen (Pretty Please)");
		optView.start(primaryStage, scene);
	}
	
	/*
	 * Event listener for the Settings button.  If pressed will transition to Settings screen.
	 * @return Returns a handler object
	 */
	public static EventHandler<ActionEvent> getSetListener(){
		EventHandler handler = new EventHandler<Event>(){
			private Stage primaryStage;


			@Override
			public void handle(Event event){
				ScreenController.showOptionsScreen(primaryStage);//Replace .show with settings java class.
			}	
		};
		return handler;
	}
	
	
	public static EventHandler<ActionEvent> getBackListener(Stage stagePrev, Scene scenePrev){
		EventHandler handler = new EventHandler<Event>(){
			
			public void handle(Event event){
				stagePrev.setScene(scenePrev);
				stagePrev.show();
			}
		};
		return handler;
	}
}