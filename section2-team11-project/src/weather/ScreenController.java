package weather;

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
	
	}

}
