package AimsProject.hust.soict.globalict.aims.screen.manager;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class playScreen {
	JDialog dialog;
	public playScreen(String title) {
		dialog = new JDialog((Frame)null, "Playing Media", true);
		dialog.setLayout(new BorderLayout());
		dialog.setSize(400,250);
		dialog.setLocationRelativeTo(null);
		
		JLabel message = new JLabel("You are watching " + title);
		message.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new btnBack());
		
		//Label for image (if it is video then it will be more awesome one)
		JLabel image = new JLabel();
		image.setHorizontalAlignment(SwingConstants.CENTER);
		try {
            BufferedImage originalImage = ImageIO.read(getClass().getResourceAsStream("/image/umarun.png"));
            Image resizedImage = originalImage.getScaledInstance(200, 150, Image.SCALE_SMOOTH); // Set the desired size
            ImageIcon imageIcon = new ImageIcon(resizedImage);
            image.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
		//Panel for button
		JPanel panelButton = new JPanel();
		panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
		panelButton.add(buttonBack);
		dialog.add(message, BorderLayout.NORTH);
		dialog.add(image, BorderLayout.CENTER);
		dialog.add(panelButton, BorderLayout.SOUTH);
		
		dialog.setVisible(true);
		
	}
	private class btnBack implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
		}
	}
}
