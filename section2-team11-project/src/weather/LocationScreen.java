/**
 * 
 */
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
public class LocationScreen extends Application  {
		private boolean unit = true;//           used for toggle c/f

	public LocationScreen(){

	}
	public void start(Stage primaryStage) {
		primaryStage.setMaximized(true);

		double height = primaryStage.getMaxHeight();
		double width = primaryStage.getMaxWidth();
		System.out.println(height+ ""+ width);
		Label headerTextField = new Label("Weather App");
		Button btn = new Button();

		btn.setText("Toggle C / F");
		btn.setOnAction(new EventHandler<ActionEvent>() {


			public void handle(ActionEvent event) {
				if(unit == true)
					System.out.println("C");
				else
					System.out.println("F");
				unit = !unit;
			}
		});
		StackPane root = new StackPane();
		root.setAlignment(headerTextField, Pos.TOP_CENTER);
		root.getChildren().add(btn);
		root.getChildren().add(headerTextField);
		Scene scene = new Scene(root, 300, 250);

		primaryStage.setTitle("Weather App");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	public static void main(String[] args) {
		launch(args);
	}


}







/*
	    public void start(Stage primaryStage) {
	    	primaryStage.setMaximized(true);

	    	double height = primaryStage.getMaxHeight();
	    	double width = primaryStage.getMaxWidth();
	    	System.out.println(height+ ""+ width);
	    	TextField headerTextField = new TextField("Weather App");
	        Button btn = new Button();

	        btn.setText("Toggle C / F");
	        btn.setOnAction(new EventHandler<ActionEvent>() {


	            public void handle(ActionEvent event) {
	                if(unit == true)
	                	System.out.println("C");
	                else
	                	System.out.println("F");
	                unit = !unit;
	            }
	        });

	        StackPane root = new StackPane();
	        root.getChildren().add(btn);

	 Scene scene = new Scene(root, 300, 250);

	        primaryStage.setTitle("Weather App");
	        primaryStage.setScene(scene);
	        primaryStage.show();

	    }
	 public static void main(String[] args) {
	        launch(args);
	    }

	}
 ***************************************************************
 *GridPane root = new GridPane();
	    root.setHgap(10);
	    root.setVgap(10);
	    root.setPadding(new Insets(2));

	    ColumnConstraints cons1 = new ColumnConstraints();
	    cons1.setHgrow(Priority.ALWAYS);
	    root.getColumnConstraints().add(cons1);

	    ColumnConstraints cons2 = new ColumnConstraints();
	    cons2.setHgrow(Priority.ALWAYS);

	    root.getColumnConstraints().addAll(cons1, cons2);

	    RowConstraints rcons1 = new RowConstraints();
	    rcons1.setVgrow(Priority.ALWAYS);

	    RowConstraints rcons2 = new RowConstraints();
	    rcons2.setVgrow(Priority.ALWAYS);  

	    root.getRowConstraints().addAll(rcons1, rcons2);

	    Label lbl = new Label("Weather App");
	    TextField field = new TextField();
	    ListView view = new ListView();
	    Button okBtn = new Button("OK");
	    Button closeBtn = new Button("Close");
	    root.setGridLinesVisible(true);
	    GridPane.setHalignment(okBtn, HPos.RIGHT);
	    GridPane.setHalignment(lbl, HPos.CENTER);
	    GridPane.setValignment(lbl, VPos.CENTER);

	    root.add(lbl,3,0);
	    //root.add(field, 1, 0, 1, 1);
	    //root.add(view, 0, 1, 4, 2);
	    root.add(okBtn, 2, 3);
	    root.add(closeBtn, 3, 3);

	    Scene scene = new Scene(root, 280, 300);

	    primaryStage.setTitle("New folder");
	    primaryStage.setScene(scene);
	    primaryStage.show();






 */		




//		JPanel north = new JPanel();
//		JPanel south = new JPanel();
//		JPanel west = new JPanel();
//		JPanel east = new JPanel();
//		JPanel center = new JPanel();
//		add(north,BorderLayout.NORTH);
//		add(south,BorderLayout.SOUTH);
//		add(west,BorderLayout.WEST);
//		add(east,BorderLayout.EAST);
//		add(center, BorderLayout.CENTER);
//		this.setTitle("Team Rocket's Weather App");
//		JLabel title = new JLabel("Weather App");
//		north.add(title);
//		north.setLayout(new GridLayout(2,2));
//		JLabel cityLabel = new JLabel("City:");
//		center.add(cityLabel);
//		JTextField cityInput = new JTextField();
//		center.add(cityInput);
//		JLabel stateLabel = new JLabel("State:");
//		center.add(stateLabel);
//		JTextField stateInput = new JTextField();
//		center.add(stateInput);
/*
			Title title = new Title(" Weather App");
			this.add(title);
 */
