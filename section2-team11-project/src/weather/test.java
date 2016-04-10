package weather;

import javafx.animation.RotateTransition;
import javafx.animation.RotateTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Saravanababu
 */
public class test extends Application {
	@Override
	public void start(final Stage stage) throws Exception {
		Label label = new Label("Rocket Weather");
		label.setWrapText(true);
		label.setMinWidth(400);
		label.setStyle(
			"-fx-padding: 10;"
			+"-fx-"+"background-color:;"
			+"-fx-"+"color:#FFFFFF;"
		);
		
		StackPane layout = new StackPane();
		layout.setMaxWidth(Double.POSITIVE_INFINITY);
		layout.setMaxHeight(Double.POSITIVE_INFINITY);
		layout.setStyle(
			"-fx-padding: 10;"
			+"-fx-"+"background-color:#FFFFFF;"
			+"-fx-"+"color:#000000;"
			+"-fx-"+"float:left;"
		);
		layout.getChildren().setAll(label);

		layout.setAlignment(label,Pos.TOP_CENTER);
		
		stage.setTitle("About");
		stage.setScene(new Scene(layout));
		stage.show();
	}
}