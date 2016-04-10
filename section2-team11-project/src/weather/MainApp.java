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
    	
    	GridPane root = new GridPane();
        root.setHgap(6);
        root.setVgap(6);
        root.setPadding(new Insets(5));
        
        ColumnConstraints cons1 = new ColumnConstraints();
        cons1.setHgrow(Priority.NEVER);
        root.getColumnConstraints().add(cons1);

        ColumnConstraints cons2 = new ColumnConstraints();
        cons2.setHgrow(Priority.ALWAYS);
        
        root.getColumnConstraints().addAll(cons1, cons2);
        
        RowConstraints rcons1 = new RowConstraints();
        rcons1.setVgrow(Priority.NEVER);
        
        RowConstraints rcons2 = new RowConstraints();
        rcons2.setVgrow(Priority.ALWAYS);  
        
        root.getRowConstraints().addAll(rcons1, rcons2);
        
        Label lbl = new Label("Name:");
        TextField field = new TextField();
        ListView view = new ListView();
        Button okBtn = new Button("OK");
        Button closeBtn = new Button("Close");

        GridPane.setHalignment(okBtn, HPos.LEFT);

        root.add(lbl, 0, 0);
        root.add(field, 1, 0, 3, 1);
        root.add(view, 0, 1, 4, 2);
        root.add(okBtn, 2, 3);
        root.add(closeBtn, 3, 3);
        
        Scene scene = new Scene(root, 280, 300);

        primaryStage.setTitle("New folder");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private Label getTopLabel() {

        Label lbl = new Label("Weather App");
        lbl.setPrefHeight(SIZE);
        lbl.prefWidthProperty().bind(root.widthProperty());
        lbl.setStyle("-fx-border-style: dotted; -fx-border-width: 0 0 1 0;-fx-border-color: gray; -fx-font-weight: bold;-fx-padding:30");        
        
        return lbl;
    }


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
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
