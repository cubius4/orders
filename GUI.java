package cont;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import listeners.*;
import orders.*;

/**
 * This class controls the GUI of the program.
 */
public class GUI{
	/*
		GUI components, which control various aspects of the GUI
	 */
	private JFrame frame;
	private JButton button;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JPanel panel;
	private JLabel l;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel label;
	private JLabel label2;
	private JLabel label3;
	private JTextField text;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JTextField text5;
	private JTextField text6;
	private JTextField text7;
	private JLabel errorLabel;
	private JLabel errLabel2;
	private JLabel errLabel3;
	private JLabel errLabel4;
	private JLabel list;
	private JLabel clearProduct;
	private JLabel clearBuyer;
	private JLabel remove;
	private JLabel totalProducts;

	/**
	 * The master order which controls all other orders within the program.
	 */
	private MasterOrder order;
	/**
	 * Listener for the order button
	 */
	private OrderListener o;
	/**
	 * Listener for the display orders button
	 */
	private DisplayListener d;
	/**
	 * Listener for the clear by product button
	 */
	private ClearProductListener cbp;
	/**
	 * Listener for the clear by buyer button
	 */
	private ClearBuyerListener cbb;
	/**
	 * Listener for the remove order button
	 */
	private RemoveListener r;
	/**
	 * The total amount of orders
	 */
	private int sum;
	/**
	 * Keeps track of what product is to be removed
	 */
	private int x;

	/**
	 * Constructs a new GUI object, setting each component to its correct position.
	 */
	public GUI() {
		frame = new JFrame();
		l = new JLabel("Welcome to Hardware Orders! Here you can order hardware for your computer.");
		l2 = new JLabel("Please order one of the things on the list.");
		l3 = new JLabel("");
		l4 = new JLabel("Mouse, Keyboard, Monitor");
		button = new JButton("Confirm Order");
		button2 = new JButton("Display Orders");
		button3 = new JButton("Clear By Product");
		label = new JLabel("Select a product.");
		label2 = new JLabel("Enter your name.");
		label3 = new JLabel("Enter the amount of the product that you want.");
		text = new JTextField(1);
		text2 = new JTextField(1);
		text3 = new JTextField(1);
		text4 = new JTextField(1);
		text5 = new JTextField(1);
		errorLabel = new JLabel("");
		errLabel2 = new JLabel("");
		errLabel3 = new JLabel("");
		panel = new JPanel();
		list = new JLabel("");
		clearProduct = new JLabel("Enter by what product you would like to clear, if you would like to clear.");
		clearBuyer = new JLabel("Enter by what buyer you would like to clear, if you would like to clear.");
		button4 = new JButton("Clear By Buyer");
		remove = new JLabel("Use the next 2 fields to remove an object. The first is for the PRODUCT, the second is for the BUYER.");
		text6 = new JTextField(1);
		text7 = new JTextField(1);
		button5 = new JButton("Remove Order");
		errLabel4 = new JLabel("");
		totalProducts = new JLabel("Total number of products ordered: " + sum);
		
		order = new MasterOrder();
		o = new OrderListener(this);
		d = new DisplayListener(this);
		cbp = new ClearProductListener(this);
		cbb = new ClearBuyerListener(this);
		r = new RemoveListener(this);
		x = 0;
		
		initPanel();
		initFrame();
	}

	/**
	 * Initializes the panel that will be mounted onto the window
	 */
	private void initPanel() {
		panel.setBorder(BorderFactory.createEmptyBorder(60, 60, 20, 60));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(l);
		panel.add(l2);
		panel.add(l3);
		panel.add(l4);
		panel.add(label);
		panel.add(text);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		text.setBounds(100, 20, 165, 25);
		panel.add(button);
		button.addActionListener(o);
		panel.add(errorLabel);
		panel.add(totalProducts);
		panel.add(button2);
		button2.addActionListener(d);
		panel.add(list);
		panel.add(clearProduct);
		panel.add(text4);
		panel.add(button3);
		button3.addActionListener(cbp);
		panel.add(errLabel2);
		panel.add(clearBuyer);
		panel.add(text5);
		panel.add(button4);
		button4.addActionListener(cbb);
		panel.add(errLabel3);
		panel.add(remove);
		panel.add(text6);
		panel.add(text7);
		panel.add(button5);
		button5.addActionListener(r);
		panel.add(errLabel4);
	}

	/**
	 * Initializes the window itself
	 */
	private void initFrame() {
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Hardware Orders");
		panel.setBackground(Color.CYAN);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
	}

	/*
		Getters for multiple instance variables
	 */
	public MasterOrder getOrders() {return order;}
	public JTextField getText1() {return text;}
	public JTextField getText2() {return text2;}
	public JTextField getText3() {return text3;}
	public JTextField getText4() {return text4;}
	public JTextField getText5() {return text5;}
	public JTextField getText6() {return text6;}
	public JTextField getText7() {return text7;}
	public JLabel getErrorLabel() {return errorLabel;}
	public JLabel getErrLabel2() {return errLabel2;}
	public JLabel getErrLabel3() {return errLabel3;}
	public JLabel getErrLabel4() {return errLabel4;}
	public JLabel getList() {return list;}
	public JLabel getTotal() {return totalProducts;}
	public int getInt() {return x;}
	public int getSum() {return sum;}

	/**
	 * Sets the sum
	 * @param s the new number that the sum will be set to
	 */
	public void setSum(int s) {sum = s;}

	/**
	 * Checks if the integer of a product is the same as the one to be removed
	 * @param product The type of product
	 * @param buyer The buyer in this order
	 * @param amount The amount that is being bought in this order
	 * @param amnt The amount as an int
	 * @return true if the ints are equal
	 */
	public boolean checkInt(String product, String buyer, String amount, int amnt) {	
		if(amount.contains("0") || amount.contains("1") || amount.contains("2") || 
				amount.contains("3") || amount.contains("4") || amount.contains("5") || 
				amount.contains("6") || amount.contains("7") || amount.contains("8") || 
				amount.contains("9")) {
			amnt = Integer.parseInt(amount);
			x = amnt;
			
			return true;
		}
		
		return false;
	}
}
