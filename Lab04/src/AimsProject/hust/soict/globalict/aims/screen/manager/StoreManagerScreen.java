package AimsProject.hust.soict.globalict.aims.screen.manager;
import AimsProject.hust.soict.globalict.aims.store.Store;
import AimsProject.hust.soict.globalict.aims.media.Book;
import AimsProject.hust.soict.globalict.aims.media.DigitalVideoDisc;
import AimsProject.hust.soict.globalict.aims.media.Media;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class StoreManagerScreen extends JFrame{
	private Store store;
	JPanel centerPanel;
	public StoreManagerScreen(Store store) {
		this.store = store;
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		centerPanel = createCenter();
		cp.add(centerPanel, BorderLayout.CENTER);
		
		setTitle("Store");
		setSize(1024, 728);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	public JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenuItem viewStore = new JMenuItem("View Store");
		viewStore.addActionListener(new btnMenuListener());
		menu.add(viewStore);
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		addBook.addActionListener(new btnMenuListener());
		smUpdateStore.add(addBook);
		JMenuItem addCD = new JMenuItem("Add CD");
		addCD.addActionListener(new btnMenuListener());
		smUpdateStore.add(addCD);
		JMenuItem addDVD = new JMenuItem("Add DVD");
		addDVD.addActionListener(new btnMenuListener());
		smUpdateStore.add(addDVD);
		
		menu.add(smUpdateStore);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	public JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setForeground(Color.RED);
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}
	public JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,3,2,2)); //(x,y,wedth, height)
		ArrayList<Media> mediaInStore = store.getItem();
		for(int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		} 
		return center;
	}
	public static void main(String []args) {
		Store store = new Store();
		addToStore(store);
		new StoreManagerScreen(store);
	}
	
	public static void addToStore(Store store) { //Testing Function
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addItem(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addItem(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addItem(dvd3);
		
		List <String> author1 = new ArrayList<String>();
		author1.add("Munwind");
		author1.add("Lehau");
		
		List <String> author2 = new ArrayList<String>();
		author2.add("Minh");
		author2.add("Kien");
		
		Book book1 = new Book("Munwind finds his first love", "No real", 99.99f, author1);
		store.addItem(book1);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Kazuyuki misses her", "Romance", "Umarunn", 18, 19.97f);
		store.addItem(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("LeHau finds his first love", "Romance", "Umarunn", 2000, 19.97f);
		store.addItem(dvd5);
		
		//Test for deleting Item from store
		//store1.removeItem(dvd2);
		
	}
	private class btnMenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Add DVD")) {
                new addDigitalVideoDiscToStoreScreen(store).setVisible(true);
            } else if (command.equals("Add Book")) {
                new addBookToStoreScreen(store).setVisible(true);
            } else if (command.equals("Add CD")) {
                new addCompactDiscToStore(store).setVisible(true);
            } else if (command.equals("View Store")) {
                new StoreManagerScreen(store);
            }
            dispose();
        }
    }
	
}
