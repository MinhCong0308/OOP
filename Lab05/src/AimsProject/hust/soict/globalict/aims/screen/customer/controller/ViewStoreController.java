package AimsProject.hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import AimsProject.hust.soict.globalict.aims.cart.Cart;
import AimsProject.hust.soict.globalict.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;

public class ViewStoreController {
	private Store store;
	private Cart cart;
	public ViewStoreController(Store store, Cart cart) {
		this.store = store;
		this.cart = cart;
	}
	@FXML
	private Button viewCart;

	@FXML
	private GridPane gridPane;
	
	
    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/AimsProject/hust/soict/globalict/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(cart, store));
            Parent root = fxmlLoader.load();
            Stage nextStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            nextStage.setScene(new Scene(root));
            nextStage.setTitle("Cart");
            nextStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	@FXML
	public void initialize() {
		final String ITEM_FXML_FILE_PATH = "/AimsProject/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
		int col = 0;
		int row = 1;
		for(int i = 0; i < store.getItem().size(); i++) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
				ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);
                fxmlLoader.setController(itemController);
                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlLoader.load();
                itemController.setData(store.getItem().get(i));
                if(col == 3) {
                	col = 0;
                	row++;
                }
                gridPane.add(anchorPane, col++, row);
                GridPane.setMargin(anchorPane, new Insets(20,10,10,10));
				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
