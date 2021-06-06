package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cont.GUI;
import orders.MasterOrder;

/**
 * Listener for the clear by product button
 */
public class ClearProductListener implements ActionListener {
	/**
	 * The GUI that this listener belongs to
	 */
	private GUI gui;
	/**
	 * The master order that this listener modifies
	 */
	private MasterOrder order;

	/**
	 * Constructs a new ClearProductListener object
	 * @param g the GUI that this listener belongs to
	 */
	public ClearProductListener(GUI g) {
		gui = g;
		order = gui.getOrders();
	}

	/**
	 * When the clear by buyer button is pressed, this listener is triggered and clears all orders containing the
	 * specified product.
	 * @param e The event triggered by the click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {	
			boolean on = true;
			int i = 0;
			while(on) {
				String product = gui.getText4().getText();
				if(product.equalsIgnoreCase(order.getOrders().get(i).getProduct())) {
					gui.getOrders().clearProduct(product);
					on = false;
				}
				i++;
			}
			int s = order.totalProducts();
			gui.getTotal().setText("Total number of products ordered: " + s);
			
			gui.getErrLabel2().setText("");
		}
		catch(IndexOutOfBoundsException ex) {
			gui.getErrLabel2().setText("Enter a valid product to be cleared!");
		}
	}
	
}
