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

public class test {

    public static void main(String[] args) {
        
        // Example usage of LoadAPI and ProcessData
        String location = "TX/San_Antonio";
        new LoadAPI(location);
        ProcessData data = new ProcessData();
        String city = data.getCity();
        String state = data.getState();
        String tempF = data.getTempF();
        String dataArray[] = new String[100];
        dataArray[0] = data.getCity();;
        dataArray[1] = data.getCurrentWeather();;
        dataArray[2] = data.getDewpointC();
        dataArray[3] = data.getDewpointF();
        dataArray[4] = data.getFeelsLikeC();
        dataArray[5] = data.getFeelsLikeF();
        dataArray[6] = data.getWindchillF();
        String dataCSV = dataArray[0];
        for(int i = 0; i< 7; i++){
        	dataCSV += ", " + dataArray[i];
        }
        System.out.println(dataCSV);
        System.out.println("The current temperature in "+city+", "+state+" is "+tempF+"F");
        
        
        
    }
/*
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


        
        
        Scene scene = new Scene(grid, 300, 275);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
       //scene.getStylesheets().add(this.getClass().getResource("startScreen.css").toExternalForm());
        primaryStage.setScene(scene);
        //scene.getStylesheets().add(test.class.getResource("Login.css").toExternalForm());
        primaryStage.show();
    }
    */
}