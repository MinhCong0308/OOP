package AimsProject.hust.soict.globalict.aims.screen.customer.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import AimsProject.hust.soict.globalict.aims.store.Store;

import java.io.IOException;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.exception.PlayerException;
import AimsProject.hust.soict.globalict.aims.media.Media;
import AimsProject.hust.soict.globalict.aims.media.Playable;

public class CartController {
	private Cart cart;
	private Store store;
	
	public CartController(Cart cart, Store store) {
		this.cart = cart;
		this.store = store;
	}
	@FXML
    private Label costLabel;
    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Button btnPlaceOrder;

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnViewStore;

    @FXML
    private Button btnRemove;
    

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        try {
            Media media = tblMedia.getSelectionModel().getSelectedItem();
            Alert alert = new Alert(Alert.AlertType.INFORMATION, ((Playable) media).play().toString());
            alert.showAndWait();
        } catch (PlayerException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	costLabel.setText(cart.totalCost() + " $");
    }
    
    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/AimsProject/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            fxmlLoader.setController(new ViewStoreController(store, cart));
            Parent root = fxmlLoader.load();
            Stage nextStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            nextStage.setScene(new Scene(root));
            nextStage.setTitle("Store");
            nextStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
    	Alert alert = new Alert(Alert.AlertType.INFORMATION, "The total cost is " + cart.totalCost() + " $");
    	alert.showAndWait();
    	cart = new Cart();
    	costLabel.setText(cart.totalCost() + " $");
    	tblMedia.setItems(null);
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
        btnRemove.setVisible(false); // The button only be visible when we press to 1 products on cart
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
        	public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
        		updateButtonBar(newValue);
        	}
        });
        
        //add listener to tfFilter, it help the showFilter update following to our enter.
        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
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
    void showFilteredMedia(String filter) {
    	if(radioBtnFilterTitle.isSelected()) {
    		FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), null);
    		filteredList.setPredicate(media -> media.filterProperty(filter));
    		if (cart.getItemsOrdered() != null) {
    			tblMedia.setItems(filteredList);
    		}
    	}
    }


}
