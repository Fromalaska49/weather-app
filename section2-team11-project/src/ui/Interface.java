package ui;
import javax.swing.JFrame;
public class Interface {
		public static void main(String[] args) {
			/* create new model, view and controller */
			Model model = new Model();
			View view = new View();
			Controller controller = new Controller(model, view);
			
			/* register controller as listener */
			view.registerListener(controller);
			
			/* start it up */
			view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			view.setSize(600, 400);
			view.setVisible(true);
			System.out.print("INSTRUCTIONS:\n~ All Unary operations must be followed by <=>\n  For instance, inverse of 2 would be <2> <1/x> <=>\n~ UNARY OPERATORS: <1/x>,<x^2>,<x^3>,<MR>,<M+>,<M->,<MC>\n~ <C> can only be used on the result of an operation, it does not have backspace functionality");
		}
}
