package model;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import weather.LocationScreenView;


public class LocationScreenModel {
	private int zipCode;
	private String city;
	private String state;
	
	
	
	/**
	 * LocationScreenModel Constructor
	 */
	public LocationScreenModel() {
		zipCode = 0;
		city = "";
		state = "";

	}
	
	public int getZipCode() {
		return zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setZipCode(int z) {
        this.zipCode = z;
    }
	
	
	public void setCity(String s) {
        this.city = s;
    }
	
	public void setState(String s) {
        this.state = s;
    }
	
}
