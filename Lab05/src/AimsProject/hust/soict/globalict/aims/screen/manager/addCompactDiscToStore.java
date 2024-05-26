package AimsProject.hust.soict.globalict.aims.screen.manager;
import AimsProject.hust.soict.globalict.aims.media.*;
import AimsProject.hust.soict.globalict.aims.store.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class addCompactDiscToStore extends addItemToStoreScreen {
	public addCompactDiscToStore(Store store) {
		super(store);
		JPanel director = super.createSubPanel("Director");
		JPanel length = super.createSubPanel("Length");
		JPanel artist = super.createSubPanel("Artist");
		super.centerPanel.add(director, BorderLayout.CENTER);
		super.centerPanel.add(length, BorderLayout.CENTER);
		super.centerPanel.add(artist, BorderLayout.CENTER);
		buttonAdd.addActionListener(new btnAddListener());
		super.setTitle("Add Compact Disc");
	}
	public class btnAddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String title = null;
			String category = null;
			float cost = 0;
			String director = null;
			int length = 0; 
			String artist = null;
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
				if(tf.getName().equals("Artist")) {
					artist = tf.getText();
				}
			}
			CompactDisc cd = new CompactDisc(title, category, artist, cost);
			store.addItem(cd);
		}
	}
}