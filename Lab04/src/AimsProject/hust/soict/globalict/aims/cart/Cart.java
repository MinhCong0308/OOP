package AimsProject.hust.soict.globalict.aims.cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.Collections;
public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemOrdered = new ArrayList<Media>();
	public void addMedia(Media media) { //method to add media to cart
		if(itemOrdered.size() == MAX_NUMBER_ORDERED) {
			System.out.println("The cart is already full! Cannot add more products");
		}
		else {
			if(itemOrdered.contains(media)) {
				System.out.println("This product existed in your cart, Cannot add !");
			}
			else {
				itemOrdered.add(media);
				System.out.println("Add successful! Now you have " + itemOrdered.size() + " in your cart");
			}
		}
	}
	public void removeMedia(Media media) { //method to remove media from cart
		if(itemOrdered.size() == 0) {
			System.out.println("Your cart is empty, You cannot delete anything!");
		}
		else {
			if(itemOrdered.contains(media)) {
				itemOrdered.remove(media);
				System.out.println("Remove product from cart successfully, Now you have " + itemOrdered.size() + " in your cart");
			}
			else {
				System.out.println("The product you want remove does not exist in your cart");
			}
		}
	}
	public float totalCost() {
		float cost = 0;
		for(Media media : itemOrdered) {
			if(media != null) cost += media.getCost();
		}
		return cost;
	}
	public Media searchByTitle(String Title) {
		for(Media media : itemOrdered) {
			if(media.isMatch(Title)) {
				return media;
			}
		}
		return null;
	}
	public void printCartInfor() {
		System.out.println("*******************************CART*****************************");
		System.out.println("Ordered Items: ");
		int cnt = 1;
		for(Media item : itemOrdered) {
			if(item == null) break;
			System.out.println(cnt + " - " + item );
			cnt+=1;
		}
		System.out.println("Total Cost: " + totalCost());
		System.out.println("*****************************************************************");
	}
	public void sortByTitle() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	public void sortByCost() {
		Collections.sort(itemOrdered, Media.COMPARE_BY_COST_TITLE);
	}
}
