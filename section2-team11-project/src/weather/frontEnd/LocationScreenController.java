package weather.frontEnd;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import weather.MainApp;
import model.LocationScreenModel;

public class LocationScreenController {
	@FXML
    private TextField zipField;
	
	@FXML
	private Button okButton;
	
	// Reference to the main application.
    private MainApp mainApp;
    private LocationScreenModel model;
	private boolean okClicked = false;
    
    /**
     * The constructor is called before the initialize() method.
     */
    public LocationScreenController() {
    	zipField = new TextField();
    }
    
    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	model = new LocationScreenModel(78240);
    	System.out.println("Zip code initially is.." + model.getZipCode());
    }
    
    /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }
    
    /**
     * Called when the user clicks on the ok button.
     */
    @FXML
    private void handleOk() {
    	System.out.println("Ok button clicked. Screen change call should be placed here..maybe");
    	Integer zip = Integer.valueOf(zipField.getText()); // test variable
    	if (isInputValid()) {
    		model.setZipCode(Integer.parseInt(zipField.getText())); 
    		okClicked = true;
    		System.out.println("Input is valid. Zip code entered is: " + zip);
    		System.out.println("Now model's zip code has been set to.. " + model.getZipCode());
    	}
    }
    
    /**
     * Validates the user input in the text fields.
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";
        
        if (zipField.getText() == null) {  // these need to be fixed, currently throws an exception
            errorMessage += "Did not enter a valid zip code.\n"; 
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(zipField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Zip code must be an integer.\n"; 
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {                                 // need to get this to work
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Field.");
            alert.setHeaderText("Please enter a correct field.");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        } 
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    
}
