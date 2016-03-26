package ui;
import java.awt.*;
import javax.swing.*;


public class View extends JFrame {

	
		private JLabel display;
		
		/**
		 *  the buttons of the options
		 */
		private JPanel buttonsPanel;
		
		/**
		 *  the menu of the app
		 */
		private JMenu exampleMenu;
		

		private Font font;
		
		/**
		 * Creates the panels and components for the JFrame
		 */
		public View() {
			super("Simple weather app");
			font = new Font("SanSerif", Font.BOLD, 30); 
			
			// create the menu
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			exampleMenu = new JMenu("Menu");
			menuBar.add(exampleMenu);

			JMenuItem exitButton = new JMenuItem("Exit");
			exampleMenu.add(exitButton);

			// create the display
			
			JPanel displayPanel = new JPanel();
			add(displayPanel, BorderLayout.NORTH);

			display = new JLabel("US Weather App");
			display.setFont(font);
			displayPanel.add(display);

		}
		
		/**
		 * Register the controller as the listener to the menu items
		 * and the buttons.
		 * @param controller The event handler for the calculator
		 */
		public void registerListener(Controller controller) {
			Component[] components = buttonsPanel.getComponents();
	
			components = exampleMenu.getMenuComponents();
			for (Component component : components) {
				if (component instanceof AbstractButton) {
					AbstractButton button = (AbstractButton) component;
					button.addActionListener(controller);
					button.setFont(font);
				}
			}
		}
		
	}


