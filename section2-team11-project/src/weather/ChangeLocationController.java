/**
 * 
 */
package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.OptionsScreenModel;

/**
 * @author Admin
 *
 */
public class ChangeLocationController {
	private ChangeLocationView view;
	
	private Stage primaryStage;
	/**
	 * 
	 */
	public ChangeLocationController(ChangeLocationView cView, Stage stage) {
		this.view = cView;
		setStage(stage);
	}

	public void setStage(Stage primaryStage){
    	this.primaryStage = primaryStage;
    }
	
	public Stage getStage(){
    	return this.primaryStage;
    }
	
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
	
	private boolean isZipValid(String s) {
		String errorMessage = "";
		if (s == null || s.isEmpty()) 
			errorMessage += "Did not enter a zip code.";
		
		if (s.length() != 5)
			errorMessage += "Please enter a five digit zip code.";
		
		if (errorMessage.length() == 0) {
            return true;    
		} else {                                 
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Field.");
            alert.setHeaderText("Please enter a five digit zip code.");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        } 
}
	
	public EventHandler<ActionEvent> getBackListener(Stage stagePrev, Scene scenePrev){
		EventHandler handler = new EventHandler<Event>(){
			ScreenController sController = new ScreenController(primaryStage);
			public void handle(Event event){
				sController.showOptionsScreen(primaryStage);
			}
		};
		return handler;
	}
	
	public EventHandler<ActionEvent> getSaveListener(TextField cityOpt, ChoiceBox<String> stateOpt, TextField zipOpt, OptionsScreenModel OSmodel){
		EventHandler handler = new EventHandler<Event>(){
			
			public void handle(Event event){
				//Ensures at least 1 valid field is populated
				if((isZipValid(zipOpt.getText()))|| (isCSValid(cityOpt.getText()) && isCSValid(stateOpt.getValue().toString()))){
				OSmodel.setCityOpt(cityOpt.getText());
				OSmodel.setStateOpt(stateOpt.getValue().toString());
				OSmodel.setZipOpt(zipOpt.getText());
				OSmodel.writeToConfig();
				}
			}
		};
		return handler;
	}
}
