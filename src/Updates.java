import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Updates extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;

	public Updates(int user,MainClass conn, int k, int selection) {
		setTitle("Updates");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 386);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//"Album", "Photos", "Videos", "Links", "Events", "All"
		Triggers obj = new Triggers();
		String col[]={ "id", "updated_at", "operation"};
		String data[][]=null;
		DefaultTableModel model = new DefaultTableModel(data, col);
		switch (selection) {
		case 0:
		{
			col[0]="album_id";
			data= obj.upAlbum(user, k, conn);
			model = new DefaultTableModel(data, col);
			break;
		}
		case 1:
		{
			col[0]="photo_id";
			data= obj.upPhoto(user, k, conn);
			model = new DefaultTableModel(data, col);
			break;
		}
		case 2:
		{
			col[0]="video_id";
			data= obj.upVideo(user, k, conn);
			model = new DefaultTableModel(data, col);
			break;
		}
		case 3:
		{
			col[0]="link_id";
			data= obj.upLink(user, k, conn);
			model = new DefaultTableModel(data, col);
			break;
		}
		case 4:
		{
			col[0]="event_id";
			data= obj.upHap(user, k, conn);
			model = new DefaultTableModel(data, col);
			break;
		}
		case 5:
		{
				String col1[]={"updated_at", "operation"};
				data=obj.upAll(user, k, conn);
				model = new DefaultTableModel(data, col1);
				break;
		}
		}
	
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 123, 481, 190);
		contentPane.add(scrollPane);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);
		
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(242, 11, 121, 101);
		contentPane.add(lblNewLabel);
		
		btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(102, 102, 255));
		btnNewButton_2.setBounds(12, 11, 77, 21);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu men = new Menu(user,conn);
				men.setVisible(true);
			}
	});
	}
}
