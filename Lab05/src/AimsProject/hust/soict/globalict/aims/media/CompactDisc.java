package AimsProject.hust.soict.globalict.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track exists in the CD! Cannot add.");
        } else {
            tracks.add(track);
            System.out.println("Added successfully!");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed successfully!");
        } else {
            System.out.println("This track does not exist in the CD.");
        }
    }

    @Override
    public StringBuffer play() throws PlayerException {
        if (this.getLength() > 0) {
            StringBuffer info = new StringBuffer();
            info.append("Playing CD: " + this.getTitle() + "\n" + "Total length: " + this.getLength() + "\n");
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = iter.next();
                try { 
                	nextTrack.play(); 
                } catch(PlayerException e) { 
                	throw e; 
                } 
            }
            return info;
        } else {
            throw new PlayerException("ERROR: This CD has a non-positive length!");
        }
    }

    @Override
    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public boolean isMatch(String title) {
        return this.getTitle().equalsIgnoreCase(title);
    }
}
