package model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;


public class LocationScreenModel {
	private int zipCode;
	//private final StringProperty city;    // once we add city and state functionality
	//private final StringProperty state;
	
	
	/**
	 * Constructor with zip code, need to add constructors with city/state
	 */
	public LocationScreenModel() {
		zipCode = 0;

	}


	public int getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(int zipField) {
        this.zipCode = zipField;;
    }

   

}
