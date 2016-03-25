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
			super("Simple Calculator");
			font = new Font("SanSerif", Font.BOLD, 30); 
			
			// create the menu
			
			JMenuBar menuBar = new JMenuBar();
			setJMenuBar(menuBar);

			exampleMenu = new JMenu("Menu");
			menuBar.add(exampleMenu);

			JMenuItem twoDigitsButton = new JMenuItem("Two Decimal Digits");
			exampleMenu.add(twoDigitsButton);

			JMenuItem anyDigitsButton = new JMenuItem("Any Decimal Digits");
			exampleMenu.add(anyDigitsButton);

			JMenuItem exitButton = new JMenuItem("Exit");
			exampleMenu.add(exitButton);

			// create the display
			
			JPanel displayPanel = new JPanel();
			add(displayPanel, BorderLayout.NORTH);

			display = new JLabel("0.0");
			display.setFont(font);
			displayPanel.add(display);
			digits = -1;

			// create the buttons
			
			buttonsPanel = new JPanel();
			add(buttonsPanel, BorderLayout.CENTER);
			buttonsPanel.setLayout(new GridLayout(5, 5, 0, 0));

			String[] buttonStrings = {
					"C", "1",  "2",
			};
			
			for (String s : buttonStrings) {
				buttonsPanel.add(new JButton(s));
			}
		}
		
		/**
		 * Register the controller as the listener to the menu items
		 * and the buttons.
		 * @param controller The event handler for the calculator
		 */
		public void registerListener(CalculatorController controller) {
			Component[] components = buttonsPanel.getComponents();
			for (Component component : components) {
				if (component instanceof AbstractButton) {
					AbstractButton button = (AbstractButton) component;
					button.addActionListener(controller);
					button.setFont(font);
				}
			}

			components = exampleMenu.getMenuComponents();
			for (Component component : components) {
				if (component instanceof AbstractButton) {
					AbstractButton button = (AbstractButton) component;
					button.addActionListener(controller);
					button.setFont(font);
				}
			}
		}
		
		/**
		 * Display the value in the JLabel of the calculator.
		 * Round off the number of digits if needed.
		 * 
		 * @param value the value to be displayed
		 */
		public void update(String value) {
			if (digits < 0) {
				display.setText(value);
			} else {
				String format = "%." + digits + "f";
				String text = String.format(format, Double.valueOf(value));
				display.setText(text);
			}
		}
		
		/**
		 * Set the number of fractional digits to display.
		 * -1 means display them all.
		 * 
		 * @param digits the number of fractional digits to display or -1
		 */
		public void setDigits(int digits) {
			this.digits = digits;
		}
	}

}
