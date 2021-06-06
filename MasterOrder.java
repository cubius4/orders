package orders;

import java.util.ArrayList;

/**
 * The master order, which logs all orders made.
 */
public class MasterOrder {
	/**
	 * Log of all orders
	 */
	private ArrayList<Order> orders;

	/**
	 * Constructs a new MasterOrder object
	 */
	public MasterOrder() {
		orders = new ArrayList<Order>();
	}

	/**
	 * Gets all the orders stored in this master order.
	 * @return A list of all orders stored in this master order
	 */
	public ArrayList<Order> getOrders() {return orders;}

	/**
	 * Adds an order to the master order.
	 * @param o The order to be added
	 */
	public void addOrder(Order o) {
		orders.add(o);
	}

	/**
	 * Creates a String containing all the orders stored on the master order.
	 * @return A String containing a text representation of all the orders stored on the master order
	 */
	public String printOrders() {
		String orderStr = "| ";
		for(Order o : orders) {
			//Change this to whatever your controller/view is
			orderStr += o;
			orderStr += " | ";
		}
		return orderStr;
	}

	/**
	 * Adds up the amount of products across all orders on this master order.
	 * @return The sum of all the products in the master order
	 */
	public int totalProducts() {
		int sum = 0;
		for(Order o : orders) {
			sum += o.getAmount();
		}
		return sum;
	}

	/**
	 * Clears all orders containing a specified product from the master order.
	 * @param product All orders which contain this product are to be removed
	 * @return A list of the removed orders
	 */
	public ArrayList<Order> clearProduct(String product) {
		ArrayList<Order> removed = new ArrayList<Order>();
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getProduct().equalsIgnoreCase(product)) {
				removed.add(orders.get(i));
				orders.remove(i);
				i--;
			}
		}
		return removed;
	}

	/**
	 * Clears all orders made by a specified buyer from the master order.
	 * @param buyer All orders made by this buyer are to be removed
	 * @return A list of the removed orders
	 */
	public ArrayList<Order> clearBuyer(String buyer) {
		ArrayList<Order> removed = new ArrayList<Order>();
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getBuyer().equalsIgnoreCase(buyer)) {
				removed.add(orders.get(i));
				orders.remove(i);
				i--;
			}
		}
		return removed;
	}

	/**
	 * Finds a specific order made by the specified buyer and containing the specified product, and if found removes
	 * that order from the master order and returns it.
	 * @param product The product that is contained in the order to be removed.
	 * @param buyer The buyer in the order that is to be removed.
	 * @return If it exists, an order containing the specified product and ordered by the specified buyer after being
	 * removed from the master order; else, the method returns null.
	 */
	public Order remove(String product, String buyer) {
		Order o = null;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getBuyer().equalsIgnoreCase(buyer) && orders.get(i).getProduct().equalsIgnoreCase(product)) {
				o = orders.remove(i);
			}
		}
		return o;
	}
	
}
