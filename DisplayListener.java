package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import cont.GUI;
import orders.MasterOrder;

/**
 * Listener for the display orders button
 */
public class DisplayListener implements ActionListener {
	/**
	 * The GUI that this listener belongs to
	 */
	private GUI gui;
	/**
	 * The master order that this listener modifies
	 */
	private MasterOrder order;

	/**
	 * Constructs a new DisplayListener object.
	 * @param g The GUI that this DisplayListener belongs to
	 */
	public DisplayListener(GUI g) {
		gui = g;
		order = gui.getOrders();
	}

	/**
	 * When the display orders button is clicked, this listener is triggered and the orders are displayed.
	 * @param e The event triggered by the click
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = order.printOrders();
		gui.getList().setText(s);
	}
}
