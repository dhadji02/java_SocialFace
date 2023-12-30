import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JTextField Password;
	int user;

	public Login(MainClass conn) {
		setTitle("SocialFace");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 571);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Username = new JTextField();
		Username.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Username.setText("");
			}
		});
		Username.setToolTipText("");
		Username.setBounds(117, 300, 179, 26);
		contentPane.add(Username);
		Username.setColumns(10);

		Password = new JPasswordField();
		Password.setBounds(117, 367, 179, 26);
		contentPane.add(Password);
		Password.setColumns(10);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel.setBackground(new Color(102, 102, 255));
		lblNewLabel.setBounds(170, 275, 80, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(169, 339, 81, 26);
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(102, 0, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String usern = Username.getText();
				String passw = Password.getText();

				// LOGIN QUERY
				loginQry obj = new loginQry();
				try {
					user = obj.UserLogin(usern, passw, conn);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (user != -1) {
					dispose();
					Menu men = new Menu(user, conn);
					JOptionPane.showMessageDialog(contentPane, "You are successfully logined");
					men.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Wrong username or password");
				}

			}
		});
		btnNewButton.setBounds(152, 417, 98, 26);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Create New Account");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(0, 255, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Insert insert=new Insert();
				insert.insertUserMethod(" ", " ", " ", " ", " ", true, " ", " ", false, 1, 1, " ", " ", conn);
				user = insert.giveID(conn);
				EditAccount account = new EditAccount(user, conn,0);
				account.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(117, 456, 179, 26);
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_3 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("logo.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(image));
		lblNewLabel_3.setBounds(98, 99, 218, 121);
		contentPane.add(lblNewLabel_3);

	}
}
