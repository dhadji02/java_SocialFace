import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

public class Friends extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	int user;

	public Friends(int user, MainClass conn) {
		setTitle("Friends");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 387);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Friend Requests");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				//
				FriendRequests frR = new FriendRequests(user, conn);
				frR.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(77, 152, 159, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("All friends");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				AllFriends allFr = new AllFriends(user,conn);
				allFr.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(77, 186, 159, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_3 = new JButton("Mutual friends");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				MutualFriends mutF = new MutualFriends(user,conn);
				mutF.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(77, 222, 159, 23);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Average age");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel panel = new JPanel();
				friendQrys obj = new friendQrys();
				panel.add(new JLabel(String.valueOf(obj.avgAge(user, conn))));
				JOptionPane.showConfirmDialog(null, panel, "Average Age", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE);
			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(275, 152, 169, 23);
		contentPane.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Famous friends");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				FamousFriends famF = new FamousFriends(user,conn);
				famF.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(275, 186, 169, 23);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_7 = new JButton("Common interests");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				CommonInterests comI = new CommonInterests(user,conn);
				comI.setVisible(true);
			}
		});
		btnNewButton_7.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_7.setBackground(Color.WHITE);
		btnNewButton_7.setBounds(275, 222, 169, 23);
		contentPane.add(btnNewButton_7);

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(207, 25, 106, 89);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_8 = new JButton("BACK");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Menu men = new Menu(user, conn);
				men.setVisible(true);
			}
		});
		btnNewButton_8.setForeground(Color.WHITE);
		btnNewButton_8.setBackground(new Color(102, 102, 255));
		btnNewButton_8.setBounds(10, 11, 80, 23);
		contentPane.add(btnNewButton_8);
	}
}
