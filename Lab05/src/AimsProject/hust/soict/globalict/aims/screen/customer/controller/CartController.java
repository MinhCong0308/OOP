package AimsProject.hust.soict.globalict.aims.screen.customer.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import AimsProject.hust.soict.globalict.aims.media.comparator.*;
import java.awt.event.ActionEvent;
import java.util.Collections;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;

public class CartController {
	private Cart cart;
	
	public CartController(Cart cart) {
		this.cart = cart;
	}
	@FXML
    private Label costLabel;
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {
    	//some code nao do
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost() + " $");
    }
    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("Cost"));
        if(cart.getItemsOrdered() != null) {
        	tblMedia.setItems(cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false); // If the tblMedia is not empty then this 2 buttons visible
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
        	public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
        		updateButtonBar(newValue);
        	}
        });
        costLabel.setText(cart.totalCost() + " $");
        
    }
    void updateButtonBar(Media media) {
    	if(media == null) {
    		btnPlay.setVisible(false);
    		btnRemove.setVisible(false);
    	}
    	else {
    		btnRemove.setVisible(true);
    		if(media instanceof Playable) {
    			btnPlay.setVisible(true);
    		}
    		else {
    			btnPlay.setVisible(false);
    		}
    	}
    }

}
