import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Font;

public class FriendRequests extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	int user;
	DefaultTableModel model;
	String data[][] = null;
	JScrollPane scrollPane;

	private JTable table_1;
	DefaultTableModel model_1;
	String data1[][] = null;
	JScrollPane scrollPane_1;
	public FriendRequests(int user, MainClass conn) {

		setTitle("Friend Requests");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 447);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton_3 = new JButton("BACK");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Friends fr = new Friends(user, conn);
				fr.setVisible(true);
			}
		});
		btnNewButton_3.setBackground(new Color(102, 102, 255));
		btnNewButton_3.setBounds(10, 11, 82, 23);
		contentPane.add(btnNewButton_3);

		// FRIEND REQUESTS
		String col[] = { "User_ID", "Username", "Full Name" };

		friendQrys obj = new friendQrys();
			data = obj.takeFriendReq(user, conn);
			model = new DefaultTableModel(data, col);
			scrollPane = new JScrollPane();
			scrollPane.setBounds(38, 109, 510, 103);
			contentPane.add(scrollPane);
			table = new JTable(model);
			scrollPane.setViewportView(table);
			table.setDefaultEditor(Object.class, null);
			table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				String[] options = { "Accept", "Decline", "Ignore" };
				int result = JOptionPane.showOptionDialog(table, "Choose your option", "Friend requests",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // no custom icon
						options, // button titles
						options[0] // default button
				);
				switch (result) {
				case 0: {
					UpdatesQry update=new UpdatesQry ();
					update.updateFriend(user, 0, 0, Integer.parseInt(data[index][0]),conn);
					break;
				}
				case 1: {
					Delete del = new Delete();
					int idf = Integer.parseInt(data[index][0]);
					del.DeleteFriendReq(user, idf, conn);
					break;
				}
				case 2: {
					UpdatesQry update=new UpdatesQry ();
					update.updateFriend(user, 0, 1, Integer.parseInt(data[index][0]),conn);
					break;
				}
				}
			}
		});

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(243, 0, 109, 103);
		contentPane.add(lblNewLabel);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				data = obj.takeFriendReq(user, conn);
				model = new DefaultTableModel(data, col);
				scrollPane = new JScrollPane();
				scrollPane.setBounds(38, 109, 510, 103);
				contentPane.add(scrollPane);
				table = new JTable(model);
				scrollPane.setViewportView(table);
				table.setDefaultEditor(Object.class, null);
				
				String col1[] = { "User_ID", "Username", "Full Name" };
				friendQrys obj1 = new friendQrys();
					data1 = obj1.takeIgnored(user, conn);
					model_1 = new DefaultTableModel(data1, col1);
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(40, 284, 508, 103);
					contentPane.add(scrollPane_1);
					table_1 = new JTable(model_1);
					scrollPane_1.setViewportView(table_1);
			}
		});
		btnRefresh.setForeground(Color.BLACK);
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setBounds(38, 73, 130, 23);
		contentPane.add(btnRefresh);
		
				String col1[] = { "User_ID", "Username", "Full Name" };
				friendQrys obj1 = new friendQrys();
					data1 = obj1.takeIgnored(user, conn);
					model_1 = new DefaultTableModel(data1, col1);
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(40, 284, 508, 103);
					contentPane.add(scrollPane_1);
					table_1 = new JTable(model_1);
					scrollPane_1.setViewportView(table_1);
					
					JLabel lblIgnored = new JLabel("Ignored:");
					lblIgnored.setFont(new Font("Segoe UI", Font.BOLD, 11));
					lblIgnored.setBounds(38, 252, 81, 19);
					contentPane.add(lblIgnored);
					table.setDefaultEditor(Object.class, null);
			
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();
				String[] options = { "Accept", "Decline", "Ignore" };
				int result = JOptionPane.showOptionDialog(table, "Choose your option", "Friend requests",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, // no custom icon
						options, // button titles
						options[0] // default button
				);
				switch (result) {
				case 0: {
					UpdatesQry update=new UpdatesQry ();
					update.updateFriend(user, 0, 0, Integer.parseInt(data1[index][0]),conn);
					break;
				}
				case 1: {
					Delete del = new Delete();
					int idf = Integer.parseInt(data1[index][0]);
					del.DeleteFriendReq(user, idf, conn);
					break;
				}
				case 2: {
					break;
				}
				}
			}
		});

	}
}
