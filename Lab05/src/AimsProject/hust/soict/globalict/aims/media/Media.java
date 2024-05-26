package AimsProject.hust.soict.globalict.aims.media;
import AimsProject.hust.soict.globalict.aims.media.comparator.*;
import java.util.Comparator;
public abstract class Media {
	private String title;
	private String category;
	private float cost;
	public static final Comparator <Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator <Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}	
	
	public Media(String title, float cost) {
		super();
		this.title = title;
		this.cost = cost;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public abstract boolean isMatch(String title);
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null) {
			return false;
		}
		Media new_m = (Media) obj;
		if(this.getTitle() == null) {
			return new_m.getTitle() == null;
		}
		else return title.equals(new_m.title);
	}
	public String toString() {
		return "Media [title=" + title + ", category=" + category + ", cost=" + cost + "]";
	}
}
