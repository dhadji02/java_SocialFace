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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class AllFriends extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnRefresh;

	public AllFriends(int user,MainClass conn) {
		setTitle("All friends");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 439);
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
				Friends fr = new Friends(user,conn);
				fr.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 77, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(234, 11, 115, 95);
		contentPane.add(lblNewLabel);
		
		String col[] = { "User_ID", "Username", "Full Name" };
		friendQrys obj = new friendQrys();
		String data[][] = obj.takeFriends(user, conn);
		DefaultTableModel model = new DefaultTableModel(data, col);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 164, 516, 208);
		contentPane.add(scrollPane);
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);

	        table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent e) {
	        		int index = table.getSelectedRow();
	        		int result=JOptionPane.showConfirmDialog(table,"Delete friend ?");	
	        		if (result==0) {
	        			int idf=Integer.parseInt(data[index][0]);
	        			Delete del=new Delete();
	        			del.DeleteFriend(user, idf, conn);
	        		}
	        	}
	        });
		
		btnRefresh = new JButton("Refresh");
		btnRefresh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String col[] = { "User_ID", "Username", "Full Name" }; //COLUMN NAMES
				friendQrys obj = new friendQrys(); //CLASS CONTAINING QUERY
				String data[][] = obj.takeFriends(user, conn); //FILLING ARRAY WITH DATA (ROWS)
				DefaultTableModel model = new DefaultTableModel(data, col); //ADDING TO TABLE COLUMNS AND ROWS
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(36, 164, 516, 208);
				contentPane.add(scrollPane);
				table = new JTable(model);
				scrollPane.setViewportView(table);
				table.setDefaultEditor(Object.class, null);
			}
		});
		btnRefresh.setBounds(36, 130, 89, 23);
		contentPane.add(btnRefresh);
	}
}
