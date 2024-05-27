package AimsProject.hust.soict.globalict.aims.screen.customer.controller;

import java.io.IOException;

import AimsProject.hust.soict.globalict.aims.store.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ViewStoreController {
	private Store store;
	public ViewStoreController(Store store) {
		this.store = store;
	}
	@FXML
	private Button viewCart;

	@FXML
	private GridPane gridPane;
	@FXML
	public void initialize() {
		final String ITEM_FXML_FILE_PATH = "/Lab05/src/AimsProject/hust/soict/globalict/aims/screen/customer/view/Item.fxml";
		int col = 0;
		int row = 1;
		for(int i = 0; i < store.getItem().size(); i++) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));
				ItemController itemController = new ItemController();
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
