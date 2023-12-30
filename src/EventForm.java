import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class EventForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDesc;
	private JTextField txtStart;
	private JTextField txtEnd;
	private JTextField txtVen;

	public EventForm(int user, MainClass conn, int up, int p) {
		setTitle("Event Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 658);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(189, 11, 101, 79);
		contentPane.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBounds(170, 174, 149, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setBounds(170, 226, 149, 20);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtStart = new JTextField();
		txtStart.setBounds(170, 335, 149, 20);
		contentPane.add(txtStart);
		txtStart.setColumns(10);

		txtEnd = new JTextField();
		txtEnd.setBounds(170, 389, 149, 20);
		contentPane.add(txtEnd);
		txtEnd.setColumns(10);

		txtVen = new JTextField();
		txtVen.setBounds(170, 494, 149, 20);
		contentPane.add(txtVen);
		txtVen.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Event ID:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(31, 131, 82, 17);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(31, 177, 82, 17);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Description:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(31, 229, 82, 17);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Privacy:");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(31, 284, 82, 17);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Start date time:");
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(31, 338, 101, 17);
		contentPane.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_5 = new JLabel("End date time:");
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(31, 392, 82, 17);
		contentPane.add(lblNewLabel_1_5);

		JLabel lblNewLabel_1_6 = new JLabel("City:");
		lblNewLabel_1_6.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_6.setBounds(31, 443, 82, 17);
		contentPane.add(lblNewLabel_1_6);

		JLabel lblID = new JLabel("");
		lblID.setBounds(170, 128, 149, 20);
		contentPane.add(lblID);
		JLabel lblNewLabel_1_7 = new JLabel("Venue:");
		lblNewLabel_1_7.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_7.setBounds(31, 497, 82, 17);
		contentPane.add(lblNewLabel_1_7);
		JComboBox<String> cmbPrivacy = new JComboBox<String>();
		cmbPrivacy.setModel(new DefaultComboBoxModel<String>(new String[] { "OPEN", "CLOSED", "FRIEND", "NETWORK" }));
		cmbPrivacy.setBounds(170, 281, 149, 22);
		contentPane.add(cmbPrivacy);

		JComboBox<String> cmbLoc = new JComboBox<String>();
		cmbLoc.setBounds(170, 440, 149, 22);
		contentPane.add(cmbLoc);
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Events event1 = new Events(user, conn);
				dispose();
				event1.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 69, 20);
		contentPane.add(btnNewButton);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert addEvent = new Insert();
				Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
				String data1[] = obj1.showCity(conn);
				for (int i = 0; i < data1.length; i++)
					cmbLoc.addItem(data1[i]);
				addEvent.insertHappeningMethod(txtName.getText(), txtDesc.getText(), txtStart.getText(),
						txtEnd.getText(), ((cmbPrivacy.getSelectedIndex())), txtVen.getText(), user,
						cmbLoc.getSelectedIndex() + 1, conn);
				JOptionPane.showMessageDialog(contentPane, "Added successfully");
				Events al = new Events(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdd.setBackground(new Color(102, 255, 51));
		btnAdd.setBounds(189, 578, 113, 20);
		contentPane.add(btnAdd);

		JButton btnUp = new JButton("Update");
		if (up == 1) {
			// Update Album
			btnAdd.setEnabled(false);
			btnAdd.setVisible(false);

			Show obj = new Show();
			String data[][] = obj.ShowEvent(user, conn);
			lblID.setText(data[p][0]);
			txtName.setText(data[p][1]);
			txtDesc.setText(data[p][2]);
			txtStart.setText(data[p][3]);
			txtEnd.setText(data[p][4]);
			txtVen.setText(data[p][6]);
			Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
			String data1[] = obj1.showCity(conn);
			for (int i = 0; i < data1.length; i++)
				cmbLoc.addItem(data1[i]);
			int c = Integer.parseInt(data[p][8]) - 1;
			cmbLoc.setSelectedIndex(c);
			lblID.setText(data[p][0]);
			cmbPrivacy.setSelectedIndex(Integer.parseInt(data[p][5]));
			
			btnUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UpdatesQry updateEv = new UpdatesQry();
					updateEv.updateHappeningMethod(txtName.getText(), txtDesc.getText(), txtStart.getText(),txtEnd.getText(), ((cmbPrivacy.getSelectedIndex())), txtVen.getText(), user, cmbLoc.getSelectedIndex() + 1, Integer.parseInt(lblID.getText()),conn);
					JOptionPane.showMessageDialog(contentPane, "Updated successfully");
					Events al = new Events(user, conn);
					dispose();
					al.setVisible(true);
				}
			});

		} else {
			lblID.setText("AUTO");
			btnUp.setEnabled(false);
			btnUp.setVisible(false);
			Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
			String data1[] = obj1.showCity(conn);
			for (int i = 0; i < data1.length; i++)
				cmbLoc.addItem(data1[i]);
		}
		btnUp.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUp.setBackground(new Color(102, 153, 255));
		btnUp.setBounds(189, 559, 113, 20);
		contentPane.add(btnUp);

	}
}
