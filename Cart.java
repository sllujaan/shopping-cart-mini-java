import java.util.*;  
import javax.swing.JOptionPane;

public class Cart {
	
	static public int itemsGUI() {
		String mainInput = JOptionPane.showInputDialog(null, "Please Enter\n"
				+ "1 to Add 'Orange ($2.0)'\n"
				+ "2 to Add 'Grapes ($2.5)'\n"
				+ "3 to Add 'Banana ($1.5)'\n"
				+ "4 to Add 'Mango ($3.0)'\n"
				+ "5 to Add 'Done'\n",  "Add item(s) in Cart", JOptionPane.INFORMATION_MESSAGE);
		int itemId = Integer.parseInt(mainInput);
		return itemId;
		
	}
	
	static public int quantityGUI() {
		String itemInputTitle = "Please Specify the quantity (1 to 10)";
		String itemQantityInput = JOptionPane.showInputDialog(null, itemInputTitle, "Quantity", JOptionPane.INFORMATION_MESSAGE);
		int quantity = Integer.parseInt(itemQantityInput);
		return quantity;
		
	}
	
	static public void invalidInputGUI() {
		JOptionPane.showMessageDialog(null, "invalid input");
	}
	
	Cart(){
		items = new ArrayList<Product>();
	}
	
	
	static public String getCartItemsTest() {
		String str = "";
		
		if(items.size() > 0) {
			int quantity = 0;
			double price = 0;
			for(int i=0; i < items.size(); i++) {
				items.get(i);
				str += (i+1 +". "+ items.get(i).getName()+ ": $" + items.get(i).getPrice() + " x "+ items.get(i).getQuantity() + " = $"+ (items.get(i).getPrice() * items.get(i).getQuantity()) + "\n");
				quantity += items.get(i).getQuantity();
				price += (items.get(i).getPrice() * items.get(i).getQuantity());
			}
			str += "\nNo. of Items: "+quantity+" - Total Bill: $"+price;
			return str;
		}else {
			return "Cart is empty";
		}
		
		
		
	}
	
	
	static public String getCartItemsToRemove() {
		String str = "Please Enter\n";
		
		if(items.size() > 0) {
			for(int i=0; i < items.size(); i++) {
				items.get(i);
				str += (i+1+" to remove : '" + items.get(i).getName()+ "'" + "\n");
			}
			return str;
		}else {
			return "Cart is empty";
		}
		
		
		
	}

	static public void setCartItems() {
		int itemId = itemsGUI();
	}
	
	
	//this function gives the index in arrayList of an item by giving it the item id
	static public int getIndex(int id) {
		int itemId = -1;
		for(int i=0; i < items.size(); i++) {
			itemId = items.get(i).getId();
			if(id == itemId) {
				return i;
			}
		}return -1;
	}
	
	static public void addItemTest(int item){
		int size = items.size();
		int quantity = quantityGUI();
		
		if(quantity < 1 || quantity > 10) {
			invalidInputGUI();
		}
		else {
			if(item == 1) {
				try {
					int index = getIndex(1);
					items.get(index);
					items.set(index, new Product(1, "Orange", 2.0, quantity));
				} catch ( IndexOutOfBoundsException e ) {
					items.add(new Product(1, "orange", 2.0, quantity));
				}
			}
			else if(item == 2) {
				try {
					int index = getIndex(2);
					items.get(index);
					items.set(index, new Product(2, "Grapes", 2.5, quantity));
				} catch ( IndexOutOfBoundsException e ) {
					items.add(new Product(2, "grapes", 2.5, quantity));
				}
			}
			else if(item == 3) {
				try {
					int index = getIndex(3);
					items.get(index);
					items.set(index, new Product(3, "Banana", 1.5, quantity));
				} catch ( IndexOutOfBoundsException e ) {
					items.add(new Product(3, "Banana", 1.5, quantity));
				}
			}
			else if(item == 4) {
				try {
					int index = getIndex(4);
					items.get(index);
					items.set(index, new Product(4, "Mango", 3.0, quantity));
				} catch ( IndexOutOfBoundsException e ) {
					items.add(new Product(4, "Mango", 3.0, quantity));
				}
			}
			else if(item == 5) {
				JOptionPane.getRootFrame().dispose();
			}
		}
		
		
	}
	
	
	static public void removeItemGUI(){
		if(items.size() > 0) {
			String id = JOptionPane.showInputDialog(null, getCartItemsToRemove(), "Remove an item", JOptionPane.INFORMATION_MESSAGE);
			int removeId = Integer.parseInt(id);
			if(removeId > 0 && removeId <= items.size()) {
				try {
					String name = items.get(removeId-1).getName();
					items.remove(removeId-1);
					JOptionPane.showMessageDialog(null, name+" removed successfully");
				}catch ( IndexOutOfBoundsException e ) {
					JOptionPane.showMessageDialog(null, "invalid input "+e);
				}
			}
			else {
				invalidInputGUI();
			}
		}else {
			JOptionPane.showMessageDialog(null, getCartItemsTest());
		}
		
	}
	
	static public void removeAll() {
		if(items.size() > 0) {
			items.clear();
			JOptionPane.showMessageDialog(null, "All items removed successfully", "Empty the Cart", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	static private ArrayList<Product> items;
	private Product product;
	
}
