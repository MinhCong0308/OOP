package AimsProject.hust.soict.globalict.aims.media;
import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public CompactDisc(String title, String category, String artist, float cost) {
		super(title, category, cost);
		this.artist = artist;
	}
	
	
	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if(tracks.contains(track)) {
			System.out.println("This track existed in CD!! Cannot add");
		}
		else {
			tracks.add(track);
			System.out.println("Add successfully!");
		}
	}
	public void removeTrack(Track track) {
		if(tracks.contains(track)) {
			tracks.remove(track);
			System.out.println("Removed Completed!");
		}
		else {
			System.out.println("This track does not exist in CD");
		}
	}
	public void play() {
		System.out.println("The artist: " + artist);
		for (Track track : tracks) track.play();	
	}
	public int getLength() {
		int length = 0;
		for (Track track : tracks) {
			length+= track.getLength();
		}
		return length;
	}
	public boolean isMatch(String title) {
		return this.getTitle().equals(title);
	}

}
