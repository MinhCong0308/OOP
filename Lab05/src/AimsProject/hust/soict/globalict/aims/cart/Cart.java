package AimsProject.hust.soict.globalict.aims.cart;

import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

import AimsProject.hust.soict.globalict.aims.exception.LimitExceededException;
import AimsProject.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.hust.soict.globalict.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Iterator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    
    private ObservableList<Media> itemsOrdered =
            FXCollections.observableArrayList();
    
    public ObservableList <Media> getItemsOrdered() {
    	return itemsOrdered;
    }
    
    public int addMedia(Media media) throws LimitExceededException {
    	if(itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
    		itemsOrdered.add(media);
    		System.out.println("The media has been added to your carts");
    		return 1;
    	}
    	else {
    		throw new LimitExceededException("Your cart is full now !");
    	}
    }
    public int addMedia(Media media1, Media media2) throws LimitExceededException {
        int countAdded = 0;
        try {
            countAdded += addMedia(media1);
            countAdded += addMedia(media2);
        } catch (LimitExceededException e) {
            throw e;
        }

        return countAdded;
    }
    public int addMedia(ArrayList<Media> medias) throws LimitExceededException {
        int countAdded = 0;
        for (Media media : medias) {
            try {
                countAdded += addMedia(media);
            } catch (LimitExceededException e) {
                throw e;
            }
        }
        return countAdded;
    }
    
    public float totalCost() {
        float totalCost = 0;
        for (Media d : itemsOrdered) {
            if (d != null) {
                totalCost += d.getCost();
            }
        }
        return totalCost;
    }



    public int removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed from the cart");
            return 1;
        }
        System.out.println("The media is not in the cart");
        return 0;
    }

    public void printCartInfor() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int index = 0;
        for (Media d : itemsOrdered) {
            if (d != null) {
                index++;
                System.out.println(index + ". " + d);
            }
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("**************************************************");
    }
    
    public void playMedia(String title) throws PlayerException {
        for (Media d : itemsOrdered) {
            if (d.getTitle().equals(title)) {
                ((Playable)d).play();
            }
        }
    }

    public void search(String title) {
        int count = 0;
        for (Media d : itemsOrdered) {
            if (d != null && d.isMatch(title)) {
                count++;
                System.out.println("Found a DVD of the title: " + d);
            }
        }
        if (count == 0) {
            System.out.println("Cannot find any DVD of the title!");
        }
    }
}