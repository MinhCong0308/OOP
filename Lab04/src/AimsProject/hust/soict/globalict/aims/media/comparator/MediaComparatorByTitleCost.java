package AimsProject.hust.soict.globalict.aims.media.comparator;

import AimsProject.hust.soict.globalict.aims.media.Media;
import java.util.Comparator;
public class MediaComparatorByTitleCost implements Comparator <Media>{
	//Uu tien cost truoc, title sau
	public int compare(Media item1, Media item2) {
		String item1_title = item1.getTitle();
		String item2_title = item2.getTitle();
		int titleDiff = item1_title.compareTo(item2_title);
		Double costItem1 = (double) item1.getCost();
		Double costItem2 = (double) item2.getCost();
		return titleDiff == 0 ? costItem1.compareTo(costItem2) : titleDiff;
	}

}
