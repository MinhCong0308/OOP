package AimsProject.hust.soict.globalict.test.screen.customer.store;

import java.util.ArrayList;
import java.util.List;

import AimsProject.hust.soict.globalict.aims.media.Book;
import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.screen.customer.controller.ViewStoreController;
import AimsProject.hust.soict.globalict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {
    private static Store store = new Store(); // Initialize the store

    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/AimsProject/hust/soict/globalict/aims/screen/customer/view/Store.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
        ViewStoreController viewStoreController = new ViewStoreController(store);
        fxmlLoader.setController(viewStoreController);
        Parent root = fxmlLoader.load();
        
        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void addToStore(Store store) { // Testing Function
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        store.addItem(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addItem(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        store.addItem(dvd3);

        List<String> author1 = new ArrayList<>();
        author1.add("Munwind");
        author1.add("Lehau");

        List<String> author2 = new ArrayList<>();
        author2.add("Minh");
        author2.add("Kien");

        Book book1 = new Book("Munwind Finds His First Love", "No Real", 99.99f, author1);
        store.addItem(book1);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Kazuyuki Misses Her", "Romance", "Umarunn", 18, 19.97f);
        store.addItem(dvd4);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("LeHau Finds His nth Love", "Romance", "Umarunn", 2000, 19.97f);
        store.addItem(dvd5);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Munwind Finds His Second Love", "Romance", "LeHau007", 2000, 19.97f);
        store.addItem(dvd6);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Conan", "Romance", "LeHau007", 2000, 19.97f);
        store.addItem(dvd7);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Umaru", "Romance", "LeHau007", 2000, 19.97f);
        store.addItem(dvd8);
    }

    public static void main(String[] args) {
        addToStore(store);
        launch(args);
    }
}
