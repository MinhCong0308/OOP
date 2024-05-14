package AimsProject.hust.soict.globalict.aims.media;

public abstract class Disc extends Media{
	private int length;
	private String director;
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	public Disc(String title, float cost) {
		super(title, cost);
	}
	public Disc(String title, int length, float cost) {
		super(title, cost);
		this.length = length;
	}
	
	public Disc(String title, String category, int length, float cost) {
		super(title, category, cost);
		this.length = length;
	}
	// Helps the CompactDisc constructors
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
	}
	
	public int getLength() {
		return length;
	}


	public String getDirector() {
		return director;
	}

}
