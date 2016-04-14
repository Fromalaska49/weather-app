package weather;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class OptionsScreenView {
	public OptionsScreenView(){	
	}
    public void start(Stage primaryStage, Scene scene) {
    	Stage stagePrev = primaryStage;
    	Scene scenePrev = scene;
    	primaryStage.setTitle("Options Window");
    	final Popup optionsWindow = new Popup();
    	Button backBtn = new Button("Back");
    	backBtn.setOnAction(ScreenController .getBackListener(stagePrev, scenePrev));
    	
    	HBox layout = new HBox(10);
    	layout.setLayoutX(500);
    	layout.setLayoutY(500);
    	layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
    	layout.getChildren().addAll(backBtn);
    	primaryStage.setScene(new Scene(layout));
    	//primaryStage.show();
    	optionsWindow.show(primaryStage);
    	
    	
    }
}
