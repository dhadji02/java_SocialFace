import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Events extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public Events(int user, MainClass conn) {
		setTitle("Events");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 469);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Add events");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventForm Eform = new EventForm(user,conn,0,-1);
				dispose();
				Eform.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(624, 96, 155, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search events");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel fields = new JPanel(new GridLayout(2, 2));
				JTextField field = new JTextField(10);
				fields.add(field);
				int result = JOptionPane.showConfirmDialog(null, fields, "Enter city of event", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				switch (result) {
				    case JOptionPane.OK_OPTION:
				    	SearchedEvents update = new SearchedEvents(user,conn,field.getText());
				    	dispose();
				    	update.setVisible(true);	  
				        break;
				}
			}
		});
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(343, 340, 156, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Unpopular events");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GiveNonFamousEventsClass famous = new GiveNonFamousEventsClass();
				String col[] = {"Event ID"};
				int mid[]= famous.action(conn);
				String data[][]=new String[mid.length][1];
				for (int y=0;y<data.length;y++)
					data[y][0]=String.valueOf(mid[y]);
				
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(41, 140, 738, 186);
				contentPane.add(scrollPane);
				
				table= new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
		});
		
		btnNewButton_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(343, 388, 155, 21);
		contentPane.add(btnNewButton_3);
		//SHOW
		String col[] = {"Event ID","Name", "Description", "Start Date","End Date","Privacy","Venue","Host","City"};
		Show obj = new Show();
		String data[][]= obj.ShowEvent(user, conn);
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
			int a=Integer.parseInt(data[i][8]);
			data[i][8] = city[a-1];	
			}
		DefaultTableModel model = new DefaultTableModel(data,col);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 140, 738, 186);
		contentPane.add(scrollPane);
		
		table= new JTable(model);
		scrollPane.setViewportView(table);
	    table.setDefaultEditor(Object.class, null);
	    /////////////////////////////////////////////////
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int p=table.getSelectedRow();
				dispose();
				EventForm update=new EventForm(user,conn,1,p);
				update.setVisible(true);
			}
		});
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(372, 25, 96, 94);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Menu men = new Menu(user,conn);
				dispose();
				men.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 78, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("Refresh");
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_4.setBounds(56, 96, 90, 23);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String col[] = {"Event ID","Name", "Description", "Start Date","End Date","Privacy","Venue","Host","City"};
				Show obj = new Show();
				String data[][]= obj.ShowEvent(user, conn);
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
					int a=Integer.parseInt(data[i][8]);
					data[i][8] = city[a-1];	
					}
				DefaultTableModel model = new DefaultTableModel(data,col);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(41, 140, 738, 186);
				contentPane.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				table= new JTable(model);
				scrollPane.setViewportView(table);
			    table.setDefaultEditor(Object.class, null);
			}
		});
		
		
	}

}
