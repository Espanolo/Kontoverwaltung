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


public class test extends JFrame {

	private JPanel contentPane;
	private JTextField txtVorname;
	private JTextField txtNachname;
	private JTextField txtStra§e;
	private JTextField txtPlz;
	private JTextField txtOrt;
	private JTextField txtKundennummer;

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
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(null);
		
		txtVorname = new JTextField();
		txtVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtVorname.setBounds(310, 169, 134, 28);
		panel.add(txtVorname);
		txtVorname.setColumns(10);
		
		txtNachname = new JTextField();
		txtNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtNachname.setBounds(310, 197, 134, 28);
		panel.add(txtNachname);
		txtNachname.setColumns(10);
		
		txtStra§e = new JTextField();
		txtStra§e.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtStra§e.setBounds(310, 249, 134, 28);
		panel.add(txtStra§e);
		txtStra§e.setColumns(10);
		
		txtPlz = new JTextField();
		txtPlz.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtPlz.setBounds(310, 277, 134, 28);
		panel.add(txtPlz);
		txtPlz.setColumns(10);
		
		txtOrt = new JTextField();
		txtOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtOrt.setBounds(310, 306, 134, 28);
		panel.add(txtOrt);
		txtOrt.setColumns(10);
		
		txtKundennummer = new JTextField();
		txtKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		txtKundennummer.setBounds(310, 140, 134, 28);
		panel.add(txtKundennummer);
		txtKundennummer.setColumns(10);
		
		JLabel lblKundennummer = new JLabel("Kundennummer");
		lblKundennummer.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblKundennummer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKundennummer.setBounds(129, 146, 151, 16);
		panel.add(lblKundennummer);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblVorname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVorname.setBounds(129, 175, 151, 16);
		panel.add(lblVorname);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblNachname.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNachname.setBounds(129, 203, 151, 16);
		panel.add(lblNachname);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblOrt.setHorizontalAlignment(SwingConstants.RIGHT);
		lblOrt.setBounds(129, 312, 151, 16);
		panel.add(lblOrt);
		
		JLabel lblPLZ = new JLabel("PLZ");
		lblPLZ.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblPLZ.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPLZ.setBounds(129, 283, 151, 16);
		panel.add(lblPLZ);
		
		JLabel lblStrasse = new JLabel("Stra\u00DFe");
		lblStrasse.setFont(new Font("KufiStandardGK", Font.PLAIN, 13));
		lblStrasse.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStrasse.setBounds(129, 255, 151, 16);
		panel.add(lblStrasse);
		
		JSeparator sepOben = new JSeparator();
		sepOben.setBackground(Color.BLACK);
		sepOben.setBounds(55, 360, 490, 20);
		panel.add(sepOben);
		
		JSeparator sepUnten = new JSeparator();
		sepUnten.setBackground(Color.BLACK);
		sepUnten.setBounds(55, 102, 490, 20);
		panel.add(sepUnten);
		
		JLabel lab = new JLabel(new ImageIcon("LOGO.jpg"));
		lab.setBounds(-11, 51, 300, 300);
		panel.add(lab);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(test.class.getResource("/pic/LOGO.jpg")));
		lblNewLabel.setBounds(200, 16, 214, 74);
		panel.add(lblNewLabel);
		
		JButton btnKundenAnlegen = new JButton("anlegen");
		btnKundenAnlegen.setBounds(231, 404, 134, 29);
		panel.add(btnKundenAnlegen);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Girokonto");
		rdbtnNewRadioButton.setBounds(442, 140, 141, 23);
		panel.add(rdbtnNewRadioButton);
		
		JList list = new JList();
		getContentPane().add(list, BorderLayout.CENTER);
		list.setBounds(50, 50, 20, 40);
		
	}
}
