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
import java.awt.Image;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class Links extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	public Links(int user,MainClass conn) {
		setTitle("Links");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 427);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add link");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LinkForm Lform = new LinkForm(user,conn,0,-1);
				dispose();
				Lform.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(648, 149, 114, 23);
		contentPane.add(btnNewButton);
		
		String col[] = {"Link ID","Name", "Caption", "Description","Link","Message","Owner"};
		Show obj = new Show();
		String data[][]= obj.ShowLink(user, conn);
		DefaultTableModel model = new DefaultTableModel(data,col);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 183, 710, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table = new JTable();
		scrollPane.setViewportView(table);
		table= new JTable(model);
		scrollPane.setViewportView(table);
	    table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int p=table.getSelectedRow();
				dispose();
				LinkForm update=new LinkForm(user,conn,1,p);
				update.setVisible(true);
			}
		});
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(340, 41, 114, 76);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Menu men = new Menu(user,conn);
				dispose();
				men.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(102, 102, 255));
		btnNewButton_1.setBounds(10, 11, 76, 23);
		contentPane.add(btnNewButton_1);
	}

}
