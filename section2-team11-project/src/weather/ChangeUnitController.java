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
import model.ChangeUnitModel;
import model.OptionsScreenModel;
/**
 * @author Admin
 *
 */
public class ChangeUnitController {
	private ChangeUnitView view;
	
	private Stage primaryStage;
	/**
	 * 
	 */
	public ChangeUnitController(ChangeUnitView cView, Stage stage) {
		this.view = cView;
		setStage(stage);
	}
	
	public void setStage(Stage primaryStage){
    	this.primaryStage = primaryStage;
    }
	
	public Stage getStage(){
    	return this.primaryStage;
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
	
	public EventHandler<ActionEvent> getSaveListener(ChoiceBox<String> tempField, ChoiceBox<String> windField, OptionsScreenModel OSmodel){
		EventHandler handler = new EventHandler<Event>(){
			
			public void handle(Event event){
				String buff = tempField.getValue().toString();
				//System.out.println("Listener received " + buff);
				OSmodel.setWindOpt(windField.getValue().toString());
				OSmodel.setTempOpt(tempField.getValue().toString());
				OSmodel.writeToConfig();
			}
		};
		return handler;
	}
	
}
