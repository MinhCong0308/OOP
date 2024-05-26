package AimsProject.hust.soict.globalict.aims.store;
import AimsProject.hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public ArrayList<Media> getItem() {
		return itemsInStore;
	}
	public void addItem(Media item) {
		itemsInStore.add(item);
		System.out.println("Add items successful to our store");
		System.out.println("Now our store has " + itemsInStore.size() + " type of items");
	}
	public void removeItem(Media item) {
		// checking the existence of item in store
		if(itemsInStore.contains(item)) {
			itemsInStore.remove(item);
			System.out.println("Remove successfully!");
			System.out.println("Now our store has " + itemsInStore.size() + " type of items");
		}
		else {
			System.out.println("The items you want to remove does not exist in our store");
		}
	}
	public Media searchByTitle(String title) {
		for(Media item : itemsInStore) {
			if(title.equals(item.getTitle())) {
				return item;
			}
		}
		return null;
	}
	
}
