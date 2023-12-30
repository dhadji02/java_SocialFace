import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
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
import javax.swing.JScrollPane;

public class Videos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	int user;
	public Videos(int user, MainClass conn) {
		setTitle("Videos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 434);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Add video");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				VideoForm VidF = new VideoForm(user,conn,0,-1);
				VidF.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(53, 125, 105, 24);
		contentPane.add(btnNewButton_1);
		
		String col[] = {"Video ID","Message", "Description", "Length","Owner"};
		Show obj = new Show();
		String data[][]= obj.ShowVideo(user, conn);
		DefaultTableModel model = new DefaultTableModel(data,col);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 159, 480, 211);
		contentPane.add(scrollPane);
		table= new JTable();
		scrollPane.setViewportView(table);
		table= new JTable(model);
		scrollPane.setViewportView(table);
	    table.setDefaultEditor(Object.class, null);
	    ///////////////////////////////////////////////////
		 table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int p=table.getSelectedRow();
					dispose();
					VideoForm update=new VideoForm(user,conn,1,p);
					update.setVisible(true);
				}
			});
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(240, 11, 105, 83);
		contentPane.add(lblNewLabel);
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu men = new Menu(user,conn);
				men.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 83, 24);
		contentPane.add(btnNewButton);
	}

}
