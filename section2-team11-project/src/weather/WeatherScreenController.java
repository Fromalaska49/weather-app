package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.WeatherScreenModel;

public class WeatherScreenController {

	public WeatherScreenController(WeatherScreenView wView, WeatherScreenModel wModel) {
		// TODO Auto-generated constructor stub
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
