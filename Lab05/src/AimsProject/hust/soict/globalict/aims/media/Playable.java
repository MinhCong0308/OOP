package AimsProject.hust.soict.globalict.aims.media;

import AimsProject.hust.soict.globalict.aims.exception.PlayerException;

public interface Playable {
    public StringBuffer play() throws PlayerException;
}