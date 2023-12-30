import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class DB_Manager extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public DB_Manager(int user,MainClass conn) {
		setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 261);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton Friends_Button = new JButton("Import Database");
		Friends_Button.setForeground(new Color(0, 0, 0));
		Friends_Button.setFont(new Font("Segoe UI", Font.BOLD, 11));
		Friends_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPanel fields = new JPanel(new GridLayout(2, 1));
				JTextField field = new JTextField(15);

				fields.add(field);
				int result = JOptionPane.showConfirmDialog(null, fields, "Enter File Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
				switch (result) {
				    case JOptionPane.OK_OPTION:{
				        ImportDatabase import1=new ImportDatabase();
				    	try {
							import1.read(field.getText(), conn);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				        break;
				    }
				}
				JOptionPane.showMessageDialog(contentPane, "Import Successful");
			}
		});
		Friends_Button.setBackground(Color.WHITE);
		Friends_Button.setBounds(12, 158, 141, 23);
		contentPane.add(Friends_Button);
		
		JButton Videos_Button = new JButton("Export Database\r\n");
		Videos_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Videos_Button.setBackground(Color.WHITE);
		Videos_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ExportData obj = new ExportData();
				String name[]=obj.name(conn);
				for (int i = 0; i < name.length; i++) {
					try {
						obj.Export(name[i], new FileWriter(name[i]+".txt"), conn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				JOptionPane.showMessageDialog(contentPane, "Export Successful");
			}
		});
		Videos_Button.setBounds(184, 159, 160, 23);
		contentPane.add(Videos_Button);
		
		JButton Events_Button = new JButton("Delete Database");
		Events_Button.setFont(new Font("Tahoma", Font.BOLD, 11));
		Events_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeleteDBClass new1=new DeleteDBClass();
				new1.DeleteDBMethod(conn);
				resetIdentityClass reset=new resetIdentityClass();
				reset.DeleteDBMethod(conn);
				JOptionPane.showMessageDialog(contentPane, "Delete Successful");
			}
		});
		Events_Button.setBackground(Color.WHITE);
		Events_Button.setBounds(371, 159, 147, 23);
		contentPane.add(Events_Button);
		
		JLabel lblNewLabel = new JLabel("Database Management\r\n");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(152, 102, 248, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(image));
		lblNewLabel_1.setBounds(214, 13, 89, 76);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu men=new Menu(user,conn);
				men.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 13, 77, 23);
		contentPane.add(btnNewButton);
	
	}
}
