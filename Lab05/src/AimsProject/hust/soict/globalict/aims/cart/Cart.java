package AimsProject.hust.soict.globalict.aims.cart;

import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;
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