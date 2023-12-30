
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditAccount extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfname;
	private JTextField txtlname;
	private JTextField txtbday;
	private JTextField txtemail;
	private JTextField txtlink;
	private JTextField txtPassword;
	private JTextField txtUsername;
	private JTextField txtWebsite;
	private JTextField txtFull;

	public EditAccount(int user, MainClass conn, int p) {
		setTitle("Create/Edit Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 652);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("First name:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setBounds(30, 121, 87, 19);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Last name:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(30, 164, 87, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Birthday:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_2.setBounds(30, 210, 87, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Work:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_3.setBounds(30, 250, 46, 19);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Education:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_4.setBounds(30, 293, 55, 19);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5.setBounds(30, 343, 87, 19);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Hometown:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_6.setBounds(343, 335, 87, 19);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Location:");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_7.setBounds(343, 292, 87, 19);
		contentPane.add(lblNewLabel_7);

		txtfname = new JTextField();
		txtfname.setBounds(160, 115, 156, 20);
		contentPane.add(txtfname);
		txtfname.setColumns(10);

		txtlname = new JTextField();
		txtlname.setBounds(160, 158, 156, 20);
		contentPane.add(txtlname);
		txtlname.setColumns(10);

		txtbday = new JTextField();
		txtbday.setBounds(160, 204, 156, 20);
		contentPane.add(txtbday);
		txtbday.setColumns(10);

		txtemail = new JTextField();
		txtemail.setBounds(160, 337, 156, 19);
		contentPane.add(txtemail);
		txtemail.setColumns(10);

		JButton btnCreate = new JButton("Create Account");
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setBackground(new Color(0, 255, 51));
		btnCreate.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnCreate.setBounds(250, 557, 130, 19);
		contentPane.add(btnCreate);

		JComboBox<String> cmbhome = new JComboBox<String>();
		cmbhome.setBackground(Color.WHITE);
		cmbhome.setBounds(414, 337, 200, 21);
		contentPane.add(cmbhome);

		JComboBox<String> cmblocation = new JComboBox<String>();
		cmblocation.setBackground(Color.WHITE);
		cmblocation.setBounds(414, 292, 200, 21);
		contentPane.add(cmblocation);

		JLabel lblNewLabel_8 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(image));
		lblNewLabel_8.setBounds(287, 0, 117, 91);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_7_1 = new JLabel("Gender:");
		lblNewLabel_7_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_7_1.setBounds(343, 158, 87, 19);
		contentPane.add(lblNewLabel_7_1);

		JComboBox<String> cmbgender = new JComboBox<String>();
		cmbgender.setModel(new DefaultComboBoxModel<String>(new String[] { "Male", "Female" }));
		cmbgender.setBackground(Color.WHITE);
		cmbgender.setBounds(414, 165, 145, 21);
		contentPane.add(cmbgender);

		JCheckBox chkverified = new JCheckBox("Yes");
		chkverified.setBounds(160, 415, 96, 25);
		contentPane.add(chkverified);

		JLabel lblNewLabel_5_1 = new JLabel("Link:");
		lblNewLabel_5_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5_1.setBounds(343, 202, 87, 19);
		contentPane.add(lblNewLabel_5_1);

		txtlink = new JTextField();
		txtlink.setColumns(10);
		txtlink.setBounds(414, 209, 200, 19);
		contentPane.add(txtlink);

		JLabel lblInterests = new JLabel("Interests:");
		lblInterests.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblInterests.setBounds(343, 115, 87, 19);
		contentPane.add(lblInterests);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(102, 102, 255));
		btnNewButton_1.setBounds(12, 13, 72, 23);
		contentPane.add(btnNewButton_1);

		JLabel lblQuotes = new JLabel("Quotes:");
		lblQuotes.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblQuotes.setBounds(343, 249, 87, 19);
		contentPane.add(lblQuotes);

		JLabel lblNewLabel_5_2 = new JLabel("Verified:");
		lblNewLabel_5_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5_2.setBounds(30, 421, 87, 19);
		contentPane.add(lblNewLabel_5_2);

		JButton btnUpdate = new JButton("Update");

		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(0, 255, 51));
		btnUpdate.setBounds(250, 573, 130, 19);
		contentPane.add(btnUpdate);

		JComboBox<String> cmbQuotes = new JComboBox<String>();
		cmbQuotes.setBackground(Color.WHITE);
		cmbQuotes.setBounds(414, 247, 200, 21);
		contentPane.add(cmbQuotes);

		JComboBox<String> cmbInter = new JComboBox<String>();
		cmbInter.setBackground(Color.WHITE);
		cmbInter.setBounds(414, 115, 200, 21);
		contentPane.add(cmbInter);

		JComboBox<String> cmbWork = new JComboBox<String>();
		cmbWork.setBackground(Color.WHITE);
		cmbWork.setBounds(160, 247, 156, 21);
		contentPane.add(cmbWork);

		JComboBox<String> cmbEdu = new JComboBox<String>();
		cmbEdu.setBackground(Color.WHITE);
		cmbEdu.setBounds(160, 291, 156, 21);
		contentPane.add(cmbEdu);

		JLabel lblID = new JLabel("");
		lblID.setBounds(29, 75, 56, 16);
		contentPane.add(lblID);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(237, 524, 156, 20);
		contentPane.add(txtPassword);

		txtUsername = new JTextField();
		txtUsername.setColumns(10);
		txtUsername.setBounds(237, 467, 156, 20);
		contentPane.add(txtUsername);

		JLabel lblNewLabel_5_3 = new JLabel("Username:");
		lblNewLabel_5_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5_3.setBounds(237, 445, 87, 19);
		contentPane.add(lblNewLabel_5_3);

		JLabel lblNewLabel_5_3_1 = new JLabel("Password:");
		lblNewLabel_5_3_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5_3_1.setBounds(237, 500, 87, 19);
		contentPane.add(lblNewLabel_5_3_1);

		txtWebsite = new JTextField();
		txtWebsite.setColumns(10);
		txtWebsite.setBounds(414, 374, 200, 19);
		contentPane.add(txtWebsite);

		JLabel lblNewLabel_5_1_1 = new JLabel("Website:");
		lblNewLabel_5_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5_1_1.setBounds(343, 376, 87, 19);
		contentPane.add(lblNewLabel_5_1_1);

		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblFullName.setBounds(30, 381, 87, 19);
		contentPane.add(lblFullName);

		txtFull = new JTextField();
		txtFull.setColumns(10);
		txtFull.setBounds(160, 375, 156, 20);
		contentPane.add(txtFull);
		////// CREATE ACCOUNT
		Insert insert1 = new Insert();
		UpdatesQry updates = new UpdatesQry();
		Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
		String data1[] = obj1.showCity(conn);
		for (int i = 0; i < data1.length; i++) {
			cmblocation.addItem(data1[i]);
			cmbhome.addItem(data1[i]);
		}
		

		if (p == 0) {
			btnUpdate.setVisible(false);
			String workplace[] = obj1.showWorkusr(user, conn);
			String education[] = obj1.showEduusr(user, conn);
			String interests[] = obj1.showIntusr(user, conn);
			String quotes[] = obj1.showQuotesUsr(user, conn);

			for (int s = 0; s < quotes.length; s++)
				cmbQuotes.addItem(quotes[s]);
			for (int s = 0; s < interests.length; s++)
				cmbInter.addItem(interests[s]);
			for (int s = 0; s < workplace.length; s++)
				cmbWork.addItem(workplace[s]);
			for (int s = 0; s < education.length; s++)
				cmbEdu.addItem(education[s]);
			
			lblID.setText(String.valueOf(user));
			btnCreate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					boolean gender = false;
					if (cmbgender.getSelectedIndex() == 1)
						gender = true;
					insert1.insertUserMethod(txtFull.getText(), txtfname.getText(), txtlname.getText(),
							txtbday.getText(), txtemail.getText(), gender, txtWebsite.getText(), txtlink.getText(),
							chkverified.isSelected(), cmbhome.getSelectedIndex() + 1,
							cmblocation.getSelectedIndex() + 1, txtPassword.getText(), txtUsername.getText(), conn);
					JOptionPane.showMessageDialog(contentPane, "You have created account. Login now.");
					Login al = new Login(conn);
					dispose();
					al.setVisible(true);
				}
			});

			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Login al = new Login(conn);
					dispose();
					al.setVisible(true);
				}
			});
		} else {
			Show shows = new Show();
			String datauser[][] = shows.ShowUser(user, conn);
			lblID.setText(String.valueOf(user));
			int c = Integer.parseInt(datauser[0][11]) - 1;
			int b = Integer.parseInt(datauser[0][10]) - 1;
			cmblocation.setSelectedIndex(c);
			cmbhome.setSelectedIndex(b);
			String workplace[] = obj1.showWorkusr(user, conn);
			String education[] = obj1.showEduusr(user, conn);
			String interests[] = obj1.showIntusr(user, conn);
			String quotes[] = obj1.showQuotesUsr(user, conn);

			for (int s = 0; s < quotes.length; s++)
				cmbQuotes.addItem(quotes[s]);
			for (int s = 0; s < interests.length; s++)
				cmbInter.addItem(interests[s]);
			for (int s = 0; s < workplace.length; s++)
				cmbWork.addItem(workplace[s]);
			for (int s = 0; s < education.length; s++)
				cmbEdu.addItem(education[s]);
			txtPassword.setText(datauser[0][13]);
			txtUsername.setText(datauser[0][12]);
			txtFull.setText(datauser[0][1]);
			txtfname.setText(datauser[0][1]);
			txtlname.setText(datauser[0][3]);
			txtbday.setText(datauser[0][4]);
			txtemail.setText(datauser[0][5]);
			txtWebsite.setText(datauser[0][7]);
			txtlink.setText(datauser[0][8]);
			
			if (Integer.parseInt(datauser[0][9]) == 1) {
				chkverified.setSelected(true);
			}
			
			if (Integer.parseInt(datauser[0][6]) == 0)
				cmbgender.setSelectedIndex(0);
			else
				cmbgender.setSelectedIndex(1);

			btnCreate.setVisible(false);
			btnUpdate.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					boolean gender = false;
					if (cmbgender.getSelectedIndex() == 1)
						gender = true;
					updates.updateUserMethod(txtFull.getText(), txtfname.getText(), txtlname.getText(),
							txtbday.getText(), txtemail.getText(), gender, txtWebsite.getText(), txtlink.getText(),
							chkverified.isSelected(), cmbhome.getSelectedIndex() + 1,
							cmblocation.getSelectedIndex() + 1, txtPassword.getText(), txtUsername.getText(),user, conn);
					JOptionPane.showMessageDialog(contentPane, "Update Successful");
				}
			});

			btnNewButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					User al = new User(user, conn);
					dispose();
					al.setVisible(true);
				}
			});
		}

		JButton btnAddwork_1 = new JButton("Add Education/Interests/Quotes/Workplace");
		btnAddwork_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Inter_quote_show al = new Inter_quote_show(Integer.parseInt(lblID.getText()), conn);
				dispose();
				al.setVisible(true);
			}
		});
		btnAddwork_1.setForeground(Color.WHITE);
		btnAddwork_1.setBackground(new Color(102, 102, 255));
		btnAddwork_1.setBounds(299, 417, 315, 23);
		contentPane.add(btnAddwork_1);
	}
}
