import java.util.*;  
import javax.swing.JOptionPane;

public class Main {
	
	Main(){
		myCart = new Cart();
	}
	
	static public void showGUI() {
		String mainInput = JOptionPane.showInputDialog(null, "Please Enter\n"
				+ "1 for 'Add Item(s) to Cart'\n"
				+ "2 for 'Remove an Item from Cart'\n"
				+ "3 for 'Go to Checkout'\n"
				+ "4 for 'Empty the Cart'\n"
				+ "5 for 'Exit the Program'\n",  "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);
		int mainId = Integer.parseInt(mainInput);
		
		if(mainId == 1) {
			addItem();
		}
		else if(mainId == 2) {
			removeItem();
		}
		else if(mainId == 3) {
			checkOutCart();
		}
		else if(mainId == 4) {
			removeAll();
		}
		if(mainId == 5) {
			developerInfo();
			JOptionPane.getRootFrame().dispose();
		}
		else {
			JOptionPane.getRootFrame().dispose();
		}
	}
	
	static public void addItem(){
		int item = 0;
		do {
			item = myCart.itemsGUI();
			if(item < 1 || item > 5) {
				myCart.invalidInputGUI();
				showGUI();
			}
			if(item == 5) {
				showGUI();
			}
			myCart.addItemTest(item);
		}while(item == 1 || item == 2 || item == 3 || item == 4);
	}
	
	static public void removeItem(){
		myCart.removeItemGUI();
		showGUI();
	}
	static public void checkOutCart(){
		JOptionPane.showMessageDialog(null, myCart.getCartItemsTest());
		showGUI();
	}
	static public void removeAll(){
		JOptionPane.showMessageDialog(null, myCart.getCartItemsTest());
		myCart.removeAll();
		showGUI();
	}
	static public void developerInfo(){
		JOptionPane.showMessageDialog(null, "Developed by: M.Salman Altaf (bc170401495)",  "Developer Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	public static void main(String args[]) {
		try {
			Main main = new Main();
			main.showGUI();
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);	
		}
		
	}
	
	static private Cart myCart;
	
}
