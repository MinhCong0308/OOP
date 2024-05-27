package AimsProject.hust.soict.globalict.aims.screen.customer.controller;

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
	
	private Media media;
	
	@FXML
	private Button btnAddtoCart;

	@FXML
	private Button btnPlay;

	@FXML
	private Label lblTitle;

	@FXML
	private Label lblCost;

	@FXML
	void btnAddtoCartClicked(ActionEvent event) {
		
	}

	@FXML
	void btnPlayClicked(ActionEvent event) {

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
