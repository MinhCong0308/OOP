package Aims;
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) { //method to add dvd to cart
		if(qtyOrdered == MAX_NUMBER_ORDERED) {
			System.out.println("The cart is already full! Cannot add more products");
		}
		else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			if(qtyOrdered >= MAX_NUMBER_ORDERED - 4) {
				System.out.println("Be careful, the cart is almost full");
				int slot = MAX_NUMBER_ORDERED - qtyOrdered;
				System.out.println("You have only " + slot + " slots!!");
			}
			else {
				System.out.println("Add successfully!");
			}
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) { //method to remove DVD from cart
		if(qtyOrdered == 0) {
			System.out.println("Your cart is empty, You cannot delete anything!");
		}
		else {
			int idx = -1;
			for(int i = 0; i <= qtyOrdered; i++) {
				if(itemsOrdered[i].equals(disc)) { //exist the disc need removing on the cart
					idx = i;
					break;
				}
			}
			if(idx == -1) { ///meaning that it's not any DVD that need deleting in cart
				System.out.println("It does not exist any disc that you want to delete in cart");
			}
			else if(idx == qtyOrdered) {
				
			}
			else {
				for(int i = idx+1; i <= qtyOrdered; i++) {
					itemsOrdered[i-1] = itemsOrdered[i]; //Moving the recent data from idx to the left.
				}
				
				System.out.println("Delete Complete");
				qtyOrdered--;				
				System.out.println("Now your cart have "+ qtyOrdered + " discs");
			}
		}
	}
	public float totalCost() {
		float cost = 0;
		for(int i = 0; i <= qtyOrdered; i++) {
			if(itemsOrdered[i] != null) {
				cost+= itemsOrdered[i].getCost();
			}
		}
		return cost;
	}
	
}
