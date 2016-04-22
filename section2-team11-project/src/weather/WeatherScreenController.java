package weather;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	private boolean windSettingBtn;

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
		windSettingBtn = false;
		setVariables();
	}
	
	/**
	 * This method calls on the WeatherScreenModel class to set all the variables that will be displayed on WeatherScreenView
	 */
	public void setVariables() {
		model.setWeatherCondition();
		model.setTempSetting(); // uses settings from OptionsScreenModel
		model.setTemp();
		model.setCity();
		model.setState();
		model.setTime();
		model.setWindSettings(); // uses settings form OptionsScreenModel
		model.setHighTemps();
        model.setLowTemps();
	}
	
	/**
	 * Creates an event handler for the toggle temperature settings button
	 */
	
	public EventHandler<ActionEvent> getTempSettingListener(){
		EventHandler handler = new EventHandler<Event>(){
					
			public void handle(Event event){
				if(tempSettingBtn == false) {
					model.setTempSetting("C");
					System.out.println("Change to celcius");
				} else {
					model.setTempSetting("F");
					System.out.println("Change back to fahrenheit");
				}
				model.getTempSetting();
				model.setTemp();
				model.setHighTemps();
				model.setLowTemps();
				view.getWeatherNumerics().setText(model.getTemp() + Character.toString((char) 176) + model.getTempSetting());
				view.clearBottomPanel();
				view.setBottomPanel();
				tempSettingBtn = !tempSettingBtn;
				
			}
		};
		return handler;
	}
	
	/**
	 * Creates an event handler for the toggle wind settings button
	 */
	
	public EventHandler<ActionEvent> getWindSettingListener(){
		EventHandler handler = new EventHandler<Event>(){
					

			public void handle(Event event){
				if(windSettingBtn == false) {
					model.setWindSettings("km/h");
					model.getWindSettings();
					model.setWindSpeed(0);
					view.getWindNumerics().setText(model.getWindSpeed() +  " " + model.getWindSettings());
					System.out.println("Change to km/h");
				}
				else {
					model.setWindSettings("mph");
					model.getWindSettings();
					model.setWindSpeed(0);
					view.getWindNumerics().setText(model.getWindSpeed() + " " + model.getWindSettings());
					System.out.println("Change back to mph");
				}
				windSettingBtn = ! windSettingBtn;
				
			}
		};
		return handler;
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
	
	public EventHandler<ActionEvent> getRadarListener(){
		EventHandler handler = new EventHandler<Event>(){
			
			public void handle(Event event){
				URL url;
				try {
					//url = new URL("radar.gif");
				
				url = WeatherScreenController.class.getResource("radar.gif");
			    Icon icon = new ImageIcon(url);
			    JLabel label = new JLabel(icon);

			    JFrame f = new JFrame("Animation");
			    f.getContentPane().add(label);
			    f.pack();
			    f.setLocationRelativeTo(null);
			    f.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Well, Shit.");
				}
			}
		};
		return handler;
	}
	
	public EventHandler<ActionEvent> getExitListener(){
		EventHandler handler = new EventHandler<Event>(){
			public void handle(Event event){
				System.exit(0);
			}
		};
		return handler;
	}
}
