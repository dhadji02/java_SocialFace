import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class SearchUsers extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	int go[];
	public SearchUsers(int user, MainClass conn,int sel, String name, String dob, String city) {
		setTitle("Searched Users");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 425);
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
		lblNewLabel.setBounds(226, 32, 127, 106);
		contentPane.add(lblNewLabel);
/////////////////////////////////////////////
		if (sel==0) {
			HaveInCommonBClass obj=new HaveInCommonBClass();
			String col[] = { "User ID", "Number of common Workplaces" };
			String data[][] = obj.action(user, conn);
			go=new int[data.length];
			DefaultTableModel model = new DefaultTableModel(data, col);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(47, 151, 472, 219);
			contentPane.add(scrollPane);
			for (int j=0;j<data.length;j++)
				go[j]=Integer.parseInt(data[j][0]);
			table = new JTable(model);
			scrollPane.setViewportView(table);
			table.setDefaultEditor(Object.class, null);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int p=table.getSelectedRow();
					dispose();
					ShowProfile update=new ShowProfile(user,go[p],conn,1);
					update.setVisible(true);
				}
			});
		}
		else if (sel==1) {
			HaveInCommonClass obj=new HaveInCommonClass();
			String data1[][] = obj.action(user, conn);
			String col1[] = { "User ID", "Number of common Educational Establishments" };
			
			DefaultTableModel model = new DefaultTableModel(data1, col1);
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(47, 151, 472, 219);
			contentPane.add(scrollPane1);
			
			table = new JTable(model);
			scrollPane1.setViewportView(table);
			table.setDefaultEditor(Object.class, null);
			go=new int[data1.length];
			for (int j=0;j<data1.length;j++)
				go[j]=Integer.parseInt(data1[j][0]);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int p=table.getSelectedRow();
					ShowProfile update=new ShowProfile(user,go[p],conn,1);
					update.setVisible(true);
					dispose();		
				}
			});
		}
		else {
			int parameter=0;
			if (name.isEmpty()&&dob.isEmpty()&&!city.isEmpty())
				parameter=7;
			else if (name.isEmpty()&&city.isEmpty()&&!dob.isEmpty())
				parameter=6;
			else if (dob.isEmpty()&&city.isEmpty()&&!name.isEmpty())
				parameter=5;
			else if (name.isEmpty()&&!dob.isEmpty()&&!city.isEmpty())
				parameter=4;
			else if (dob.isEmpty()&&!name.isEmpty()&&!city.isEmpty())
				parameter=3;
			else if (city.isEmpty()&&!name.isEmpty()&&!dob.isEmpty())
				parameter=2;
			else if (!city.isEmpty()&&!name.isEmpty()&&!dob.isEmpty())
				parameter=1;
			SearchForOtherUsersClass searchthem= new SearchForOtherUsersClass();
			String data1[][] = searchthem.action(user, parameter, name, city,dob, conn);
			String col1[] = { "User ID", "Full Name" };
			DefaultTableModel model = new DefaultTableModel(data1, col1);
			JScrollPane scrollPane1 = new JScrollPane();
			scrollPane1.setBounds(47, 151, 472, 219);
			contentPane.add(scrollPane1);
			
			table = new JTable(model);
			scrollPane1.setViewportView(table);
			table.setDefaultEditor(Object.class, null);
			go=new int[data1.length];
			for (int j=0;j<data1.length;j++)
				go[j]=Integer.parseInt(data1[j][0]);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int p=table.getSelectedRow();
					ShowProfile update=new ShowProfile(user,go[p],conn,1);
					update.setVisible(true);
					dispose();		
				}
			});
		}
		

	}

}
