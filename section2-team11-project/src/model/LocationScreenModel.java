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
		this.zipCode = 0;
		this.city = "";
		this.state = "";
		return;
	}
	
	/**
	 * LocationScreenModel Constructor for zipcode
	 */
	public LocationScreenModel(int zip) {
		this.zipCode = zip;
		this.city = "";
		this.state = "";
		return;
	}
	
	/**
	 * LocationScreenModel Constructor for state/city
	 */
	public LocationScreenModel(String state, String city) {
		this.zipCode = 0;
		this.city = city;
		this.state = state;
		return;
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
	
	public String getLocation(){
		String location = "";
		if(getZipCode() > 0){
			location += this.zipCode;
		}
		else if(this.state.length() > 0 && this.city.length() > 0){
			location = this.state + "/" + this.city.replace(' ', '_');
		}
		else{
			System.out.println("Error: no location found (in LocationScreenModel)");
		}
		System.out.println("S");
		return location;
	}
}
