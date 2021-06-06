package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cont.GUI;
import orders.*;

/**
 * Listener for the remove order button
 */
public class RemoveListener implements ActionListener {
	/**
	 * The GUI that this RemoveListener belongs to
	 */
	private GUI gui;
	/**
	 * The master order that this listener modifies
	 */
	private MasterOrder order;

	/**
	 * Constructs a new RemoveListener object.
	 * @param g The GUI that this RemoveListener belongs to
	 */
	public RemoveListener(GUI g) {
		gui = g;
		order = gui.getOrders();
	}

	/**
	 * When the remove orders button is clicked, this listener is triggered and the specified order with the buyer and
	 * product is removed.
	 * @param e The event that triggers this listener
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String product = gui.getText6().getText();
		String buyer = gui.getText7().getText();
		
		Order o = order.remove(product, buyer);
		gui.getErrLabel4().setText("");
		if(o == null) {
			gui.getErrLabel4().setText("Order not found.");
		}
		int s = order.totalProducts();
		gui.getTotal().setText("Total number of products ordered: " + s);
	}
}
