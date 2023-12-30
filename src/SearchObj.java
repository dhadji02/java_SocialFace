import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class SearchObj extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public SearchObj(int user, MainClass conn, String input, int selection,int p) {
		setTitle("Searched Objects");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 425);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Search fr = new Search(user, conn);
				fr.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 72, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(393, 13, 127, 106);
		contentPane.add(lblNewLabel);
		if (p==0) {
			switch (selection) {
			case 0:{
				String col[] = {"Album ID","Album Name", "Description", "URL", "Photo Count"};
				SearchName obj = new SearchName();
				String data[][]= obj.SearchAlbum(user, input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 125, 757, 243);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 1:{
				String col[] = {"Album ID","Album Name", "Description", "URL", "Photo Count"};
				SearchName obj = new SearchName();
				String data[][]= obj.AlbumDescription(user, input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(33, 125, 757, 243);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 2:{
				String col[] = {"Event ID","Name", "Description", "Start Date","End Date","Privacy","Venue","Host","City"};
				SearchName obj = new SearchName();
				String data[][]= obj.SearchEvent(user, input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(41, 140, 738, 186);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 3:{
				String col[] = {"Event ID","Name", "Description", "Start Date","End Date","Privacy","Venue","Host","City"};
				SearchName obj = new SearchName();
				String data[][]= obj.EventDescription(user, input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(41, 140, 738, 186);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 4:{
				String col[] = {"Link ID","Name", "Caption", "Description","Link","Message","Owner"};
				SearchName obj = new SearchName();
				String data[][]= obj.SearchLink(user, input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(52, 183, 710, 187);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 5:{
				String col[] = {"Link ID","Name", "Caption", "Description","Link","Message","Owner"};
				SearchName obj = new SearchName();
				String data[][]= obj.LinkCaption(user, input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(52, 183, 710, 187);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 6:{
				String col[] = {"Link ID","Name", "Caption", "Description","Link","Message","Owner"};
				SearchName obj = new SearchName();
				String data[][]= obj.LinkUrl(user,input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(52, 183, 710, 187);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 7:{
				String col[] = { "Photo ID", "Source", "URL" };
				SearchName obj = new SearchName();
				String data[][]= obj.SearchPhoto(user,input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(49, 146, 708, 183);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 8:{
				String col[] = { "Photo ID", "Source", "URL"};
				SearchName obj = new SearchName();
				String data[][]= obj.PhotoHeight(user,Float.parseFloat(input), conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(49, 146, 708, 183);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 9:{
				String col[] = { "Photo ID", "Source", "URL"};
				SearchName obj = new SearchName();
				String data[][]= obj.PhotoWidth(user,Float.parseFloat(input), conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(49, 146, 708, 183);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 10:{
				String col[] = {"Video ID","Message", "Description", "Length","Owner"};
				SearchName obj = new SearchName();
				String data[][]= obj.VideoDes(user, input, conn);
				
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(54, 159, 480, 211);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 11:{
				String col[] = {"Video ID","Message", "Description", "Length","Owner"};
				SearchName obj = new SearchName();
				String data[][]= obj.SearchVideo(user,input, conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(54, 159, 480, 211);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			case 12:{
				String col[] = {"Video ID","Message", "Description", "Length","Owner"};
				SearchName obj = new SearchName();
				String data[][]= obj.VideoLength(user,Long.parseLong(input), conn);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(54, 159, 480, 211);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
				break;
			}
			}
			
		}
		else {
			if (selection==0) {
				String col[] = {"Photo ID","Source"};
				TakePhotosFromUsersClass obj = new TakePhotosFromUsersClass();
				
				String data[][]= obj.action(user, Float.parseFloat(input), conn);
			
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(47, 151, 472, 219);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
			else if (selection==1) {
				String col[] = {"Video ID","Video Title"};
				TakeVideosFromUsersClass obj = new TakeVideosFromUsersClass();
				String data[][]= obj.action(user,Long.parseLong(input), conn);
			
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(47, 151, 472, 219);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
			else if (selection==2) {
				String col[] = {"Link ID","Link Name"};
				TakeLinksFromUsersClass obj = new TakeLinksFromUsersClass();
				String data[][]= obj.action(user, input, conn);
			
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(47, 151, 472, 219);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
			else {
				String col[] = {"Album ID","Album Name"};
				TakeAlbumFromUsersClass obj = new TakeAlbumFromUsersClass();
				String data[][]= obj.action(user, input, conn);
			
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(47, 151, 472, 219);
				contentPane.add(scrollPane);
				
				table = new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
		}
		
	}

}
