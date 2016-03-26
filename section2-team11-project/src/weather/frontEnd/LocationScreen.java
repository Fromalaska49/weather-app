/**
 * 
 */
package weather.frontEnd;

import java.awt.*;
import javax.swing.*;

/**
 * @author Admin
 *
 */
public class LocationScreen extends JFrame {
	
		
	public LocationScreen(){
		this.setVisible(true);
		this.setSize(920, 480);
		JPanel north = new JPanel();
		JPanel south = new JPanel();
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(west,BorderLayout.WEST);
		add(east,BorderLayout.EAST);
		this.setTitle("Team Rocket's US Weather App");
		JLabel title = new JLabel("US Weather App");
		north.add(title);
		
		/*
		Title title = new Title(" Weather App");
		this.add(title);
		*/
	}

}
