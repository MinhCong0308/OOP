package hust.soict.globalict.swing;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SwingAccumulator extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JTextField tfInput;
	private JTextField tfOutput;
	private int sum = 0;
	public SwingAccumulator() {
		// TODO Auto-generated constructor stub
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2,2));
		cp.add(new JLabel("Enter the integer: "));
		tfInput = new JTextField(10);
		tfInput.addActionListener(this);
		cp.add(tfInput);
		
		cp.add(new JLabel("The accumulated sum: "));
		tfOutput = new JTextField(10);
		tfOutput.setEditable(false);
		cp.add(tfOutput);
		
		setTitle("Swing Accumulator");
		setVisible(true);
		setSize(350,120);
		
	}

	public static void main(String[] args) {
		new SwingAccumulator();

	}
	public void actionPerformed(ActionEvent e) {
		int numberIn = Integer.parseInt(tfInput.getText());
		sum += numberIn;
		tfInput.setText("");
		tfOutput.setText(sum + "");
	}
}
