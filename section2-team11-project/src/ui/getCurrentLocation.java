/**
 * 
 */
package ui;

/**
 * @author Admin
 *
 */
public class getCurrentLocation {
	/*
	 * Needs to return current city in format: "TX/San_Antonio" or
	 * zipcode (possibly 2 separate functions)
	 * http://api.wunderground.com/api/d1b960fa65c6eccc/conditions/q/TX/San_Antonio.json
	 */
	
	private String stateI;
	private String stateN;
	private Int zip;
	
	public void getCurrentLocation(){
		stateI = "";
		stateN = "";
		zip = 0;
	}
	
	public void setLocation(int zipC){
		zip = zipC;
	}
	
	public void setLocation(String stateIn, String stateNa){
		stateI = stateIn;
		stateN = stateNa;
	}
	public String getLocation(){
		return "/" + zip;
	}
	
	public String getLocation(){
		return "/" + stateI + "/" + stateN;
	}
	}
}
