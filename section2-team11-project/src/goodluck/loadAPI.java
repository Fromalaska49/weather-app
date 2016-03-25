package goodluck;
package ui;

import java.net.*;
import java.io.*;

public class loadAPI{
	public static void main(){
		try {
		    URL url = new URL("http://api.wunderground.com/api/d1b960fa65c6eccc/conditions/q/TX/San_Antonio.json");
		    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
		    String line;

		    while ((line = reader.readLine()) != null) {
		        // ...
		    }
		    reader.close();

		} catch (MalformedURLException e) {
		    // ...
		} catch (IOException e) {
		    // ...
		}
	}
}