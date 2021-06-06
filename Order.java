package orders;

/**
 * Each order contains a product to be ordered, the amount of that product that is to be ordered, and the name of the
 * buyer who places the order. Each order made is stored in the master order.
 */
public class Order {
	/**
	 * The product to be ordered
	 */
	private String product;
	/**
	 * The buyer who placed this order
	 */
	private String buyer;
	/**
	 * The amount of the product that is being ordered in this order
	 */
	private int amount;

	/**
	 * Constructs a new Order object.
	 * @param p The product to be ordered
	 * @param b The buyer who placed this order
	 * @param a The amount of the product that is being ordered in this order
	 */
	public Order(String p, String b, int a) {
		product = p;
		buyer = b;
		amount = a;
	}

	/**
	 * Getter for the product
	 * @return The product to be ordered
	 */
	public String getProduct() {return product;}
	/**
	 * Getter for the buyer's name
	 * @return The name of the buyer who placed this order
	 */
	public String getBuyer() {return buyer;}
	/**
	 * Getter for the amount of the product being ordered
	 * @return The amount of the product that is being ordered
	 */
	public int getAmount() {return amount;}

	/**
	 * Returns this order object as a String.
	 * @return A string representation of an Order object
	 */
	public String toString() {
		if(amount > 0) {
			return "Order of " + amount + " " + product + "s";
		}
		return "Order of " + amount + " " + product;
	}
}
