package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cont.GUI;
import orders.MasterOrder;
import orders.Order;

/**
 * Listener for the order button
 */
public class OrderListener implements ActionListener {
	/**
	 * The GUI that this OrderListener belongs to
	 */
	private GUI gui;
	/**
	 * The master order that this listener modifies
	 */
	private MasterOrder order;

	/**
	 * Creates a new OrderListener object.
	 * @param g The GUI that this OrderListener belongs to
	 */
	public OrderListener(GUI g) {
		gui = g;
		order = gui.getOrders();
	}

	/**
	 * When the order button is clicked, this listener is triggered and the requested order is put through and
	 * added to the master order
	 * @param e The event that triggers this OrderListener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String product = "";
		String buyer = "";
		String amount = "";
		int amnt = 0;
		
		if(!(gui.getText1().getText().equalsIgnoreCase("keyboard") || gui.getText1().getText().equalsIgnoreCase("mouse") || gui.getText1().getText().equalsIgnoreCase("monitor"))) {
			gui.getErrorLabel().setText("Sorry, we don't have that here.");
		}
		else if(gui.getText2().getText().equals("")) {
			gui.getErrorLabel().setText("Enter your name, please.");
		}
		else {
		
			product = gui.getText1().getText();
			buyer = gui.getText2().getText();
			amount = gui.getText3().getText();
			
			if(gui.checkInt(product, buyer, amount, amnt)) {
				amnt = gui.getInt();
				
				Order o = new Order(product, buyer, amnt);
				order.addOrder(o);
				
				int s = order.totalProducts();
				gui.getTotal().setText("Total number of products ordered: " + s);
				
				gui.getErrorLabel().setText("");
			}
			else {
				gui.getErrorLabel().setText("This order was not added because you did not enter a number for amount.");
			}
		}
	}	
}
