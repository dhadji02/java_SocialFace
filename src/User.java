import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

public class User extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public User(int user,MainClass conn) {
		setTitle("User");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 305);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Show updates");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel fields = new JPanel(new GridLayout(2, 2));
				JTextField field = new JTextField(10);
				JComboBox<String> comboBox = new JComboBox<>(new String[]{"Album", "Photos", "Videos", "Links", "Events", "All"});
				
				fields.add(field);
				fields.add(comboBox);

				int result = JOptionPane.showConfirmDialog(null, fields, "Give number of updates you want to see ", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				int k=Integer.parseInt(field.getText());
				int selection=comboBox.getSelectedIndex();
				switch (result) {
				    case JOptionPane.OK_OPTION:
				    	Updates update = new Updates(user,conn,k,selection);
				    	dispose();
				    	update.setVisible(true);
				        break;
				}
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(222, 215, 122, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Profile editor");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditAccount edit = new EditAccount(user,conn,1);
				dispose();
				edit.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(222, 181, 122, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Show profile");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowProfile prof = new ShowProfile(user,-1,conn,0);
				dispose();
				prof.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(222, 148, 122, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(233, 11, 104, 86);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Menu men = new Menu(user,conn);
				dispose();
				men.setVisible(true);
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(102, 102, 255));
		btnNewButton_4.setBounds(10, 11, 74, 23);
		contentPane.add(btnNewButton_4);
		
	}
}
