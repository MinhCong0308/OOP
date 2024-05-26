package AimsProject.hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;
public class Book extends Media{
	private List<String> authors = new ArrayList<String>();

	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}
	public List<String> getAuthors() {
		return authors;
	}
	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}
	public void addAuthor(String author) {
		if(authors.contains(author)) {
			System.out.println("Author appeared in List");
		}
		else {
			authors.add(author);
			System.out.println("Add author successfully!");
		}
	}
	public void removeAuthor(String author) {
		if(authors.contains(author)) {
			authors.remove(author);
			System.out.println("Remove author successfully");
		}
		else {
			System.out.println("Author you want remove does not exist in list");
		}
	}
	public String toString() {
		return "Book : title=" + this.getTitle() + ", category=" + this.getCategory() + 
				", cost=" + this.getCost() + ", authors=" + authors + "]";
	}
	
	public boolean isMatch(String title){
        return this.getTitle().equals(title);
    }
}
