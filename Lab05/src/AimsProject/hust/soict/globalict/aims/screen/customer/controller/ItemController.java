package AimsProject.hust.soict.globalict.aims.screen.customer.controller;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.exception.LimitExceededException;
import AimsProject.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	
	private Cart cart;
	private Media media;
	
	@FXML
	private Button btnAddtoCart;

	@FXML
	private Button btnPlay;

	@FXML
	private Label lblTitle;

	@FXML
	private Label lblCost;
	
    public ItemController(Cart cart) {
        this.cart = cart;
    }

	@FXML
	void btnAddtoCartClicked(ActionEvent event) {
	    try {
	    	int numAdded = cart.addMedia(media);
	    	} catch (LimitExceededException e) {
	    		Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
	            alert.showAndWait();
	            e.printStackTrace();
	        }
	}

	@FXML
	void btnPlayClicked(ActionEvent event) {
		try {
			Alert alert = new Alert(Alert.AlertType.INFORMATION,((Playable) media).play().toString());
	        alert.showAndWait();
	    } catch (PlayerException e) {
	    	Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
	        alert.showAndWait();
	    }
	}
	public void setData(Media media) {
		this.media = media;
		lblTitle.setText(media.getTitle());
		lblCost.setText(media.getCost() + " $");
		if (media instanceof Playable) {
			btnPlay.setVisible(true);
		}
		else {
			btnPlay.setVisible(false);
			HBox.setMargin(btnAddtoCart, new Insets(0,0,0, 60));
		}
	}
}
