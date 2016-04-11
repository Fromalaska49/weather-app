package weather;


	import java.awt.*;
	import javax.swing.*;
	import javafx.application.Application;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.geometry.HPos;
	import javafx.geometry.Insets;
	import javafx.geometry.Pos;
	import javafx.geometry.VPos;
	import javafx.scene.Scene;
	import javafx.scene.control.Button;
	import javafx.scene.control.Label;
	import javafx.scene.control.ListView;
	import javafx.scene.control.TextField;
	import javafx.scene.layout.AnchorPane;
	import javafx.scene.layout.ColumnConstraints;
	import javafx.scene.layout.GridPane;
	import javafx.scene.layout.HBox;
	import javafx.scene.layout.Priority;
	import javafx.scene.layout.RowConstraints;
	import javafx.scene.layout.StackPane;
	import javafx.scene.text.Text;
	import javafx.stage.Stage;

	/**
	 * @author Admin
	 *
	 */

	public class WeatherScreen extends Application{	
		public void start(Stage SecondStage) {
			SecondStage.setMaximized(true);

			double height = SecondStage.getMaxHeight();
			double width = SecondStage.getMaxWidth();
			System.out.println(height+ ""+ width);
			Label headerTextField = new Label("Weather App");
			Label cityLabel = new Label("City");
		}

}



