/**
 * 
 */
package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.*;

/**
 * @author Admin
 *
 */
public class OptionsScreenController {

	private OptionsScreenView view;
	
	private Stage primaryStage;
	
	/**
	 * @param oModel, Stage stage 
	 * @param oView 
	 * 
	 */
	public OptionsScreenController(OptionsScreenView oView, Stage stage) {
		
		this.view = oView;
		setStage(stage);
	}
	
	 /*
     * sets the stage object in this class
     */
    public void setStage(Stage primaryStage){
    	this.primaryStage = primaryStage;
    }
    
    /*
     * returns the stage object
     */
    public Stage getStage(){
    	return this.primaryStage;
    }
	
	
    /*
	 * Event listener for the Settings button.  If pressed will transition to Settings screen.
	 * @return Returns a handler object
	 *//*
	public EventHandler<ActionEvent> getSetListener(){
		EventHandler handler = new EventHandler<Event>(){
			Stage primaryStage = getStage();
			ScreenController sController = new ScreenController(primaryStage);
			@Override
			public void handle(Event event) {
				// TODO Auto-generated method stub
				sController.showOptionsScreen(primaryStage);
			}
			
		};
		return handler;
	}*/
	/*
	 * Event listener for the Back button.  If pressed will transition to previous screen.
	 * @return Returns a handler object
	 */
	public EventHandler<ActionEvent> getBackListener(Stage stagePrev, Scene scenePrev){
		EventHandler handler = new EventHandler<Event>(){
			
			public void handle(Event event){
			//	System.out.println("Back Button Pressed");
				stagePrev.setScene(scenePrev);
				stagePrev.show();
			}
		};
		return handler;
	}
	//Will be unused
	 public EventHandler<ActionEvent> getSaveListener(ChoiceBox<String> tempField, OptionsScreenModel OSmodel){
			EventHandler handler = new EventHandler<Event>(){
				public void handle(Event event){
					String buff = tempField.getValue().toString();
					//System.out.println("Listener received " + buff);
					OSmodel.setTempOpt(tempField.getValue().toString());
					OSmodel.writeToConfig();
				}
			};
			return handler;
		}
	 
	 public EventHandler<ActionEvent> getChangeUnitListener(){
		 EventHandler handler = new EventHandler<Event>(){
			 
			Stage primaryStage = getStage();
			ScreenController sController = new ScreenController(primaryStage); 
			 public void handle(Event event){
				// System.out.println("ChangeUnit button pressed!");
				 sController.showChangeUnitScreen(primaryStage);
			 }
		 };
		return handler;
	 }
	 
	 public EventHandler<ActionEvent> getChangeLocationListener(){
		 EventHandler handler = new EventHandler<Event>(){
			 Stage primaryStage = getStage();
			 ScreenController sController = new ScreenController(primaryStage);
			 public void handle(Event event){
				 sController.showChangeLocationScreen(primaryStage);
			 }
		 };
		 return handler;
	 }
}
