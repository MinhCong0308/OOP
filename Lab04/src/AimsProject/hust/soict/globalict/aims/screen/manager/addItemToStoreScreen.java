package AimsProject.hust.soict.globalict.aims.screen.manager;
import javax.swing.*;
import AimsProject.hust.soict.globalict.aims.store.Store;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public abstract class addItemToStoreScreen extends JFrame{
	Store store;
	JButton buttonAdd;
	JPanel centerPanel;
	ArrayList<JTextField> tfs = new ArrayList<JTextField>();
	public addItemToStoreScreen(Store store) {
		this.store = store;
		setSize(1024,728);
		setVisible(false);
		setLocationRelativeTo(null);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createMenuBar(), BorderLayout.NORTH);
		JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonAdd = new JButton("Add");
        btnPanel.add(buttonAdd);
        btnPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cp.add(btnPanel, BorderLayout.SOUTH);
        centerPanel = createCenter();
        cp.add(centerPanel, BorderLayout.CENTER);

	}
	public JPanel createSubPanel(String txt) {
		JPanel subPanel = new JPanel(new FlowLayout());
        JTextField tf = new JTextField(50);
        tf.setName(txt);
        tfs.add(tf);
        JLabel lbTextField = new JLabel(txt);

        subPanel.add(lbTextField);
        subPanel.add(tf);
        subPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        return subPanel;
	}
	public JPanel createCenter() {
		JPanel center = new JPanel(new GridLayout(7,1,4,4));
		
		JPanel title = createSubPanel("Title");
		JPanel category = createSubPanel("Category");
		JPanel cost = createSubPanel("Cost");
		
		center.add(title);
		center.add(category);
		center.add(cost);
		
		return center;
	}
	public JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Option");
		JMenuItem back = new JMenuItem("Back");
		menu.add(back);
		back.addActionListener(new btnListener());
		JMenuItem viewMenuStore = new JMenuItem("View the store");
		menu.add(viewMenuStore);
		viewMenuStore.addActionListener(new btnListener());
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	public class btnListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Back")) {
		        dispose();
		    } 
			else if (command.equals("View the store")) {
		       new StoreManagerScreen(store).setVisible(true);
		       dispose();
		    }
		}
	}
	
}
