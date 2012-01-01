import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import java.awt.Color;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JComboBox;
import java.awt.List;


public class test extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(test.class.getResource("/icon/stift.gif")));
		getContentPane().add(btnNewButton, BorderLayout.CENTER);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon(test.class.getResource("/icon/view.png")));
		btnNewButton.setBounds(23, 133, 117, 79);
		getContentPane().add(btnNewButton);
		getContentPane().setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(354, 157, -231, 146);
		getContentPane().add(textArea_1);
		
		JTextArea textArea = new JTextArea();
		textArea.
		textArea.setBounds(100, 62, 1, 16);
		getContentPane().add(textArea);
		getContentPane().setLayout(null);
		
		List list = new List();
		list.setBounds(80, 51, 242, 204);
		getContentPane().add(list);
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.set
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		list.add("Test");
		
		
	}
}
