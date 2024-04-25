package AimsProject.hust.soict.globalict.aims.store;
import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store1 = new Store();
		
		//Test for adding Item to store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Minh yêu em", "Romance", "Umarunn", 18, 19.97f);
		store1.addItem(dvd1);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Munwind tìm mối tình đầu", "Romance", "Umarunn", 2000, 19.97f);
		store1.addItem(dvd2);
		//Test for deleting Item from store
		store1.removeItem(dvd2);
	}

}
