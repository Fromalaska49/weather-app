package weather;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.LocationScreenModel;

public class LocationScreenController {
	
    private TextField zipField;
	private Button okButton;
	private Button setButton;
	
    private MainApp mainApp;
    private static LocationScreenView view;
    private static LocationScreenModel model;
	private boolean okClicked = false;

    /**
     * The constructor is called before the initialize() method.
     * @param v 
     */
	
	//this needs to have 1 parameter, the model
    public LocationScreenController(LocationScreenModel m, LocationScreenView v) {
    		this.model = m;
    		this.view = v;
    }
    
    
    /**
     * Initializes the controller class. 
     */
    private void initialize() {
    }
    
    /*
     * Returns true if str is a numeric string
     */
	private boolean isNumeric(String str){
		for(int i = 0; i < str.length(); i++){
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
   
    
    /**
     * Determines if user entered valid city and state
     * @return true if the input is valid
     */
    private boolean isCSValid(String s) {
        String errorMessage = "";
        
        if (s == null || s.isEmpty()) {  
            errorMessage += "Did not enter a city and/or a state.\n"; 
        }   
        if (errorMessage.length() == 0) {
            return true;        
        } else {                                 
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Field.");
            alert.setHeaderText("Please enter a city and a state.");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        } 
    }
    
    /*
     * Validates the zipcode and returns true if valid or else false
     */
    private boolean isZipValid(String zipCode) {
		String errorMessage = "";
		boolean lengthError = false;
		boolean typeError = false;
		if (zipCode == null || zipCode.isEmpty()) {
			errorMessage += "Did not enter a zip code.";
			lengthError = true;
		}
		else if (zipCode.length() != 5){
			errorMessage += "Please enter a five digit zip code.";
			lengthError = true;
		}
		
		if (!isNumeric(zipCode)){
			typeError = true;
			if(lengthError){
				errorMessage += " Also, your zip code must be numeric.";
			}
			else{
				errorMessage += "Please enter a valid zipcode";
			}
		}
		
		if (!lengthError && !typeError) {
            return true;    
		} else {                                 
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Zip Code.");
            alert.setHeaderText("Please enter a five digit zip code.");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        } 
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


	public EventHandler<ActionEvent> getOkListener() {
		EventHandler handler = new EventHandler<Event>() {

				private Stage primaryStage;
				private ScreenController sController;

				@Override
				public void handle(Event event)  {
					if(view.getZipCode().isEmpty()) {  // checks if user only entered city and state
						if(isCSValid(view.getCity()) && isCSValid(view.getState())) {  
							model.setCity(view.getCity());
							model.setState(view.getState());
							ScreenController.showWeatherScreen(primaryStage);
						}
					} else { // user only entered zip code
						if(isZipValid(view.getZipCode())) {
							model.setZipCode(Integer.valueOf(view.getZipCode()));
							ScreenController.showWeatherScreen(primaryStage);
						}
					}					
				}
		};
		return handler; 
	}
	
}
