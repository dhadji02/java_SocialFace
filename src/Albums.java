
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class Albums extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public Albums(int user,MainClass conn) {
		setTitle("Albums");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 534);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Add album");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AlbumForm Aform = new AlbumForm(user,conn,0,-1);
				dispose();
				Aform.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(33, 97, 187, 22);
		contentPane.add(btnNewButton_1);
		
		String col[] = {"Album ID","Album Name", "Description", "URL", "Photo Count","Privacy","Owner","Location"};
		Show obj = new Show();
		String data[][]= obj.ShowAlbum(user, conn);
		for (int i=0;i<data.length;i++) {
		switch (data[i][5]) {
		case "0": {
			data[i][5]="OPEN";
			break;
		}
		case "1":{
			data[i][5]="CLOSED";
			break;
		}
		case "2":{
			data[i][5]="FRIEND";
			break;
		}
		case "3": {
			data[i][5]="NETWORK";
			break;
		}
		}
		Interests_Quotes_qry cities = new Interests_Quotes_qry();
		String city[]=cities.showCity(conn);
		int a=Integer.parseInt(data[i][7]);
		data[i][7] = city[a-1];	
		}
		DefaultTableModel model = new DefaultTableModel(data,col);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 125, 757, 243);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
	    table.setDefaultEditor(Object.class, null);
	    
	    table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int p=table.getSelectedRow();
				dispose();
				AlbumForm update=new AlbumForm(user,conn,1,p);
				update.setVisible(true);
			}
		});
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Menu men = new Menu(user,conn);
				dispose();
				men.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(102, 102, 255));
		btnNewButton_2.setBounds(10, 11, 70, 22);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(361, 13, 103, 82);
		contentPane.add(lblNewLabel);
		
		JButton btnFriends = new JButton("Friends with biggest albums");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel fields = new JPanel(new GridLayout(2, 2));
				JTextField field = new JTextField(10);
				
				fields.add(field);
				int result = JOptionPane.showConfirmDialog(null, fields, "Enter Number of photos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				int a=Integer.parseInt(field.getText());
				switch (result) {
				    case JOptionPane.OK_OPTION:
				        break;
				}

				BigAlbumsFriends al=new BigAlbumsFriends();
				String data[][]=al.FriendsAlbum(user, a, conn);
				String col[] = {"Friend ID", "Number of photos","Album Name"};
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 125, 757, 243);
				contentPane.add(scrollPane);
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
		});
		btnFriends.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnFriends.setBackground(Color.WHITE);
		btnFriends.setBounds(310, 417, 187, 22);
		contentPane.add(btnFriends);
		
		JButton btnUsers = new JButton("Users with biggest albums");
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JPanel fields = new JPanel(new GridLayout(2, 2));
				JTextField field = new JTextField(10);
				fields.add(field);
				int result = JOptionPane.showConfirmDialog(null, fields, "Enter Number of photos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				int a=Integer.parseInt(field.getText());
				switch (result) {
				    case JOptionPane.OK_OPTION:
				        break;
				}
				
				NetworkBigAlbum al=new NetworkBigAlbum();
				String data[][]=al.NetworkAlbums(user, a, conn);
				String col[] = {"Friend ID", "Number of photos","Album Name"};
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 125, 757, 243);
				contentPane.add(scrollPane);
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
		});
		btnUsers.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUsers.setBackground(Color.WHITE);
		btnUsers.setBounds(310, 452, 187, 22);
		contentPane.add(btnUsers);
		
		JLabel lblShow = new JLabel("Show:");
		lblShow.setBounds(378, 388, 56, 16);
		contentPane.add(lblShow);
		
		JButton btnNewButton_1_1 = new JButton("Refresh");
		btnNewButton_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(645, 97, 145, 22);
		contentPane.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String col[] = {"Album ID","Album Name", "Description", "URL", "Photo Count","Privacy","Owner","Location"};
				Show obj = new Show();
				String data[][]= obj.ShowAlbum(user, conn);
				for (int i=0;i<data.length;i++) {
				switch (data[i][5]) {
				case "0": {
					data[i][5]="OPEN";
					break;
				}
				case "1":{
					data[i][5]="CLOSED";
					break;
				}
				case "2":{
					data[i][5]="FRIEND";
					break;
				}
				case "3": {
					data[i][5]="NETWORK";
					break;
				}
				}
				Interests_Quotes_qry cities = new Interests_Quotes_qry();
				String city[]=cities.showCity(conn);
				int a=Integer.parseInt(data[i][7]);
				data[i][7] = city[a-1];	
				}
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 125, 757, 243);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
		});
		
	}
}
