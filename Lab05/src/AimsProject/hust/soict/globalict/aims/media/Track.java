package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}



	@Override
	public StringBuffer play() throws PlayerException{
		if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());

            StringBuffer info = new StringBuffer("");
            info.append("Playing track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
            return info;
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
	}
	public boolean equals(Object obj) {
		if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Track other = (Track) obj;
        if (this.getTitle() == null){
            if(other.title != null){
                return false;
            }
        } else if (!title.equals(other.title)){
            return false;
        }
        return length == other.getLength();
    }

}
