package AimsProject.hust.soict.globalict.test;
import AimsProject.hust.soict.globalict.aims.media.Book;
import AimsProject.hust.soict.globalict.aims.media.CompactDisc;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import java.util.List;
import java.util.ArrayList;
public class Polymorphirm {
	public static void main(String args[]) {
		List <Media> mediae = new ArrayList<Media>();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("Munwind finds for the first love", "Comedy", 0f);
		mediae.add(dvd1);
		Book book1 = new Book("LeHau finds for the first love", "Comedy", 2f);
		mediae.add(book1);
		CompactDisc cd1 = new CompactDisc("The love story of KienRam", "Romance", "KienRam", 20f);
		mediae.add(cd1);
		for(Media item : mediae) {
			System.out.println(item.toString());
		}
	}
	
}
