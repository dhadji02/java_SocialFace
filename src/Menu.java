import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public Menu(int user, MainClass conn ) {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 426);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Friends_Button = new JButton("Friends");
		Friends_Button.setForeground(new Color(0, 0, 0));
		Friends_Button.setFont(new Font("Segoe UI", Font.BOLD, 11));
		Friends_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Friends friends = new Friends(user,conn);
				friends.setVisible(true);
			}
		});
		Friends_Button.setBackground(Color.WHITE);
		Friends_Button.setBounds(113, 170, 89, 23);
		contentPane.add(Friends_Button);
		
		JButton User_Button = new JButton("User");
		User_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		User_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				User user1 = new User(user,conn);
				user1.setVisible(true);
			}
		});
		User_Button.setBackground(Color.WHITE);
		User_Button.setBounds(113, 204, 89, 23);
		contentPane.add(User_Button);
		
		JButton Photos_Button = new JButton("Photos");
		Photos_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Photos_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Photos photos = new Photos(user,conn);
				photos.setVisible(true);
			}
		});
		Photos_Button.setBackground(Color.WHITE);
		Photos_Button.setBounds(113, 238, 89, 23);
		contentPane.add(Photos_Button);
		
		JButton Albums_Button = new JButton("Albums");
		Albums_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Albums_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Albums albums = new Albums(user,conn);
				albums.setVisible(true);
			}
		});
		Albums_Button.setBackground(Color.WHITE);
		Albums_Button.setBounds(113, 272, 89, 23);
		contentPane.add(Albums_Button);
		
		JButton Videos_Button = new JButton("Videos");
		Videos_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Videos_Button.setBackground(Color.WHITE);
		Videos_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Videos videos = new Videos(user,conn);
				videos.setVisible(true);
			}
		});
		Videos_Button.setBounds(331, 171, 89, 23);
		contentPane.add(Videos_Button);
		
		JButton Events_Button = new JButton("Events");
		Events_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Events_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Events events = new Events(user,conn);
				events.setVisible(true);
			}
		});
		Events_Button.setBackground(Color.WHITE);
		Events_Button.setBounds(331, 204, 89, 23);
		contentPane.add(Events_Button);
		
		JButton Links_Button = new JButton("Links");
		Links_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Links_Button.setBackground(Color.WHITE);
		Links_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Links links = new Links(user,conn);
				links.setVisible(true);
				
			}
		});
		Links_Button.setBounds(331, 238, 89, 23);
		contentPane.add(Links_Button);
		
		JButton Logout_Button = new JButton("Log out");
		Logout_Button.setForeground(Color.WHITE);
		Logout_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Logout_Button.setBackground(new Color(51, 255, 0));
		Logout_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login login = new Login(conn);
				int option = JOptionPane.showConfirmDialog(Logout_Button,"Are you sure ?");	
				
				if(option == JOptionPane.YES_OPTION) {
					dispose();
					login.setVisible(true);
				}
				else {
					login.setVisible(false);
				}
				
			}
		});
		Logout_Button.setBounds(433, 42, 89, 23);
		contentPane.add(Logout_Button);
		
		JLabel lblNewLabel = new JLabel("Welcome to SocialFace");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(159, 38, 248, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_8 = new JButton("Search");
		btnNewButton_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Search search = new Search(user,conn);
				search.setVisible(true);
			}
		});
		btnNewButton_8.setBackground(Color.WHITE);
		btnNewButton_8.setBounds(331, 272, 89, 23);
		contentPane.add(btnNewButton_8);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(image));
		lblNewLabel_1.setBounds(10, 29, 89, 76);
		contentPane.add(lblNewLabel_1);
		
		JButton btnDatabaseManager = new JButton("DATABASE MANAGER");
		btnDatabaseManager.setBounds(185, 318, 173, 25);
		contentPane.add(btnDatabaseManager);
		btnDatabaseManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				DB_Manager search = new DB_Manager(user,conn);
				search.setVisible(true);
			}
		});
		
		
		
	}
}
