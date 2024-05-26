package AimsProject.hust.soict.globalict.aims.screen.manager;
import AimsProject.hust.soict.globalict.aims.media.*;
import AimsProject.hust.soict.globalict.aims.screen.manager.addCompactDiscToStore.btnAddListener;
import AimsProject.hust.soict.globalict.aims.store.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class addDigitalVideoDiscToStoreScreen extends addItemToStoreScreen{
	public addDigitalVideoDiscToStoreScreen(Store store) {
		super(store);
		JPanel director = super.createSubPanel("Director");
		JPanel length = super.createSubPanel("Length");
		centerPanel.add(director, BorderLayout.CENTER);
		centerPanel.add(length, BorderLayout.CENTER);
		buttonAdd.addActionListener(new btnAddListener());
		setTitle("Add Digital Video Disc");
	}
	public class btnAddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String title = null;
			String category = null;
			float cost = 0;
			String director = null;
			int length = 0; 
			for(JTextField tf : tfs) {
				if(tf.getName().equals("Title")) {
					title = tf.getText();
				}
				if(tf.getName().equals("Category")) {
					category = tf.getText();
				}
				if(tf.getName().equals("Cost")) {
					cost = Float.parseFloat(tf.getText());
				}
				if(tf.getName().equals("Director")) {
					director = tf.getText();
				}
				if(tf.getName().equals("Length")) {
					length = Integer.parseInt(tf.getText());
				}
			}
			DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
			store.addItem(dvd);
		}
	}
	
}
