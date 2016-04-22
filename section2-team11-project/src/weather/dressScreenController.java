package weather;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import model.dressScreenModel;


	public class dressScreenController {

		private dressScreenView view;
		private dressScreenModel model;
		private Stage primaryStage;
		
		/**
		 * @param dModel, Stage stage 
		 * @param dView 
		 * 
		 */
		public dressScreenController(dressScreenView dView, dressScreenModel dModel, Stage stage) {
			this.model = dModel;
			this.view = dView;
			setStage(stage);
		}
		  /*
	     * returns the stage object
	     */
	    public Stage getStage(){
	    	return this.primaryStage;
	    }
		 /*
	     * sets the stage object in this class
	     */
	    public void setStage(Stage primaryStage){
	    	this.primaryStage = primaryStage;
	    }
	    
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
		}
	    
	    /*
		 * Event listener for the Back button.  If pressed will transition to previous screen.
		 * @return Returns a handler object
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