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
		JPanel center = new JPanel();
		add(north,BorderLayout.NORTH);
		add(south,BorderLayout.SOUTH);
		add(west,BorderLayout.WEST);
		add(east,BorderLayout.EAST);
		add(center, BorderLayout.CENTER);
		this.setTitle("Team Rocket's Weather App");
		JLabel title = new JLabel("Weather App");
		north.add(title);
		north.setLayout(new GridLayout(2,2));
		JLabel cityLabel = new JLabel("City:");
		center.add(cityLabel);
		JTextField cityInput = new JTextField();
		center.add(cityInput);
		JLabel stateLabel = new JLabel("State:");
		center.add(stateLabel);
		JTextField stateInput = new JTextField();
		center.add(stateInput);
		/*
		Title title = new Title(" Weather App");
		this.add(title);
		*/
	}

}
