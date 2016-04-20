package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.WeatherScreenModel;

public class WeatherScreenController {
	WeatherScreenView view;
	WeatherScreenModel model;
	
	/**
	 * Constructor method for WeatherScreenController
	 * @param wView
	 * @param wModel
	 */
	public WeatherScreenController(WeatherScreenView wView, WeatherScreenModel wModel) {
		this.view = wView;
		this.model = wModel;
		setVariables();
	}
	
	/**
	 * This method calls on the WeatherScreenModel class to set all the variables that will be displayed on WeatherScreenView
	 */
	public void setVariables() {
		model.setTemp();
		model.setTempSetting();
		model.setCity();
		model.setState();
		model.setTime();
	}
	
	/**
	 * Creates an event handler for the back button.
	 * @param stagePrev
	 * @param scenePrev
	 * @return
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
