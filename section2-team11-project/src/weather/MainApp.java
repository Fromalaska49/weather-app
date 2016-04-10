package weather;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane root;
    private final int SIZE = 60;

    @Override
    public void start(Stage primaryStage) {
    	LocationScreen loc = new LocationScreen();
    	primaryStage.setMaximized(true);
    	loc.start(primaryStage);
    	
    		/*root = new BorderPane();

        root.setTop(getTopLabel());
        
        Scene scene = new Scene(root, 350, 300);
        primaryStage.setTitle("BorderPane");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    	
        //this.primaryStage = primaryStage;
        //this.primaryStage.setTitle("Weather App");
        //initRootLayout();
        //showLocationScreen();

    
  


    /**
     * Initializes the root layout.
     */
    /*
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("frontEnd/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     */
    /**
     * Shows the person overview inside the root layout.
     * @param model 
     */
    /*
    public void showLocationScreen() {
        try {
        	// Load person overview.
        	FXMLLoader loader = new FXMLLoader();
        	loader.setLocation(MainApp.class.getResource("frontEnd/LocationScreen2.fxml"));
        	AnchorPane locationScreen = (AnchorPane) loader.load();

        	// Set person overview into the center of root layout.
        	rootLayout.setCenter(locationScreen);

        	// Give the controller access to the main app.
        	LocationScreenController controller = loader.getController();
        	controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
    
    /**
     * Returns the main stage.
     * @return
     */
    }
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
