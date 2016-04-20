package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.WeatherScreenModel;

public class WeatherScreenController {
	static WeatherScreenView view;
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
		model.setWeatherCondition();
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
				ScreenController sController = new ScreenController(stagePrev);			
			
			public void handle(Event event){
				sController.showLocationScreen(stagePrev);
			}
		};
		return handler;
	}

	private boolean isZipCode(String str){
		if(str.length() == 5){
			for(int i = 0; i < 5; i++){
				if(!Character.isDigit(str.charAt(i))){
					return false;
				}
			}
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean isCity(String str){
		if(str.length() > 4 && (str.charAt(str.length() - 4) == ',' && str.charAt(str.length() - 3) == ' ')){
			for(int i = 0; i < str.length() - 4; i++){
				if(!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' '){
					return false;
				}
			}
			return true;
		}
		else if(str.length() > 3 && str.charAt(str.length() - 3) == ','){
			for(int i = 0; i < str.length() - 3; i++){
				if(!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' '){
					return false;
				}
			}
			return true;
		}
		else{
			//not comma separated
			return false;
		}
	}

	private boolean isValidLocation(String str){
		return isZipCode(str) || isCity(str);
	}
	
	public EventHandler<ActionEvent> getSearchListener(Stage stage) {
		EventHandler handler = new EventHandler<Event>() {

			//Stage primaryStage = getStage();
			//ScreenController sController = new ScreenController(primaryStage);

			@Override
			public void handle(Event event)  {
				//ScreenController screenController = new ScreenController(primaryStage);
				String location = view.getSearchQuery();
				if(isValidLocation(location)){
					ScreenController sController = new ScreenController(stage);	
					sController.showWeatherScreen(stage, location);
				}
				else{ 
					//invalid location
					System.out.println("Error: invalid location detected: '"+location+"'");
				}					
			}
	};
	return handler; 
	}
	
}
