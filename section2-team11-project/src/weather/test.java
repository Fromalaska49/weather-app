package weather;
/*
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
*/
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        
        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        actiontarget.setId("actiontarget");
        
        //btn.setId("");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                actiontarget.setText("Sign in button pressed");
            }
        });


        /*
        
        DropShadow shadow = new DropShadow();
        shadow.setRadius(5.0);
        shadow.setOffsetX(3.0);
        shadow.setOffsetY(3.0);
        shadow.setColor(Color.color(0.4, 0.5, 0.5));
      //Adding the shadow when the mouse cursor is on
      btn.addEventHandler(MouseEvent.MOUSE_ENTERED, 
          new EventHandler<MouseEvent>() {
              @Override public void handle(MouseEvent e) {
            	  btn.setEffect(shadow);
          	  	System.out.println("hi");
              }
      });
      //Removing the shadow when the mouse cursor is off
      btn.addEventHandler(MouseEvent.MOUSE_EXITED, 
          new EventHandler<MouseEvent>() {
              @Override public void handle(MouseEvent e) {
            	  btn.setEffect(null);
          	  	System.out.println("bye");
              }
      });
        */
        
        
        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
       //scene.getStylesheets().add(this.getClass().getResource("startScreen.css").toExternalForm());
        primaryStage.setScene(scene);
        //scene.getStylesheets().add(test.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
}