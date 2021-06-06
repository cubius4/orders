package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cont.GUI;
import orders.MasterOrder;

/**
 * Listener for the clear by buyer button
 */
public class ClearBuyerListener implements ActionListener {
	/**
	 * The GUI that this listener belongs to
	 */
	private GUI gui;
	/**
	 * The master order that this listener modifies
	 */
	private MasterOrder order;

	/**
	 * Constructs a new ClearBuyerListener object
	 * @param g the GUI that this listener belongs to
	 */
	public ClearBuyerListener(GUI g) {
		gui = g;
		order = gui.getOrders();
	}

	/**
	 * When the clear by buyer button is pressed, this listener is triggered, clearing all of the specified buyer's
	 * orders.
	 * @param e The event triggered by the click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {	
			boolean on = true;
			int i = 0;
			while(on) {
				String buyer = gui.getText5().getText();
				if(buyer.equalsIgnoreCase(order.getOrders().get(i).getBuyer())) {
					gui.getOrders().clearBuyer(buyer);
					on = false;
				}
				i++;
			}
			int s = order.totalProducts();
			gui.getTotal().setText("Total number of products ordered: " + s);
			
			gui.getErrLabel3().setText("");
		}
		catch(IndexOutOfBoundsException ex) {
			gui.getErrLabel3().setText("Enter a valid buyer to be cleared!");
		}
	}
	
}

