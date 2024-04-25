package AimsProject.hust.soict.globalict.aims.media;


public class DigitalVideoDisc extends Disc implements Playable{
	//Create the constructor

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	public DigitalVideoDisc(String title, float cost) {
		super(title, cost);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, int length, float cost) {
		super(title, category, length, cost);
	}
	public DigitalVideoDisc(String title, int length, float cost) {
		super(title, length, cost);
	}
	public boolean isMatch(String title) {
		String res = this.getTitle();
		return res.equals(title);
	}
	public String toString() {
        return "DVD" + " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() 
        		+ " - " + this.getLength() + " - " + this.getCost() + "$";
    }
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD Length: " + this.getLength());
	}
}
	
	