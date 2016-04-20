package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import model.LocationScreenModel;
import model.WeatherScreenModel;

public class WeatherScreenController {
	WeatherScreenView view;
	WeatherScreenModel model;
	private boolean tempSettingBtn;

	private LocationScreenModel locationScreenModel = new LocationScreenModel();

	
	/**
	 * Constructor method for WeatherScreenController
	 * @param wView
	 * @param wModel
	 */
	public WeatherScreenController(WeatherScreenView wView, WeatherScreenModel wModel) {
		this.view = wView;
		this.model = wModel;
		tempSettingBtn = false;
		setVariables();
	}
	
	/**
	 * This method calls on the WeatherScreenModel class to set all the variables that will be displayed on WeatherScreenView
	 */
	public void setVariables() {
		model.setWeatherCondition();
		model.setTempSetting("F"); // default is F unless settings changed or toggle button clicked
		model.setTemp();
		model.setCity();
		model.setState();
		model.setTime();
	}
	
	/**
	 * 
	 */
	
	public EventHandler<ActionEvent> getTempSettingListener(){
		EventHandler handler = new EventHandler<Event>(){
					
			
			public void handle(Event event){
				if(tempSettingBtn == false) {
					model.setTempSetting("C");
					model.getTempSetting();
					model.setTemp();
					view.getWeatherNumerics().setText(model.getTemp() + Character.toString((char) 176) + model.getTempSetting());
					//view.setWeatherNumerics(TextBuilder.create().text(model.getTemp() + Character.toString((char) 176) + model.getTempSetting()).build());
					//view.getWeatherNumerics().setFont(Font.font ("Consolas",  100));
					System.out.println("Change to celcius");
				}
				else {
					model.setTempSetting("F");
					model.getTempSetting();
					model.setTemp();
					view.getWeatherNumerics().setText(model.getTemp() + Character.toString((char) 176) + model.getTempSetting());
					System.out.println("Change back to fahrenheit");
				}
				tempSettingBtn = !tempSettingBtn;
				
			}
		};
		return handler;
		//model.setWeatherForecast();
		//model.setTodayIcon();
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
		/*else if(str.length() > 3 && str.charAt(str.length() - 3) == ','){
			for(int i = 0; i < str.length() - 3; i++){
				if(!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' '){
					return false;
				}
			}
			return true;
		}*/
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
					if(isZipCode(location)){
						locationScreenModel.setLocation(location);
					}
					else{
						String state = location.substring(location.length() - 2);
						String city = location.substring(0, location.length() - 4);
						locationScreenModel.setLocation(city, state);
					}
					if(locationScreenModel.isKnownLocation()){
						ScreenController sController = new ScreenController(stage);	
						sController.showWeatherScreen(stage, locationScreenModel.getLocation());
					}
					else{
						System.out.println("Error: unkown location: "+locationScreenModel.getLocation());
					}
				}
				else{ 
					//invalid location
					System.out.println("Error: invalid location detected: '"+location+"'");
				}					
			}
	};
	return handler; 
	}

	public EventHandler<ActionEvent> getSettingsListener(Stage stage) {
		EventHandler handler = new EventHandler<Event>(){
			ScreenController sController = new ScreenController(stage);
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				sController.showOptionsScreen(stage);
			}
			
		};
		return handler;
	}
	
}
