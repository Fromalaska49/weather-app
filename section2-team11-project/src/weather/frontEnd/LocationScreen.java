/**
 * 
 */
package weather.frontEnd;

import java.awt.*;
import javax.swing.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Admin
 *
 */
public class LocationScreen extends Application  {
	private boolean unit = true;
		
	public LocationScreen(){
	}
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
