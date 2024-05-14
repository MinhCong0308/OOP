package AimsProject.hust.soict.globalict.test;
import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;



public class CartTest {
	public static void main(String args[]) {
		Cart cart = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87, 19.95f);
		cart.addMedia(dvd1);
		Media dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 19.95f);
		cart.addMedia(dvd2);
		Media dvd3 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87, 24.95f);
		cart.addMedia(dvd3);
		
		
		cart.printCartInfor();
	}
}
