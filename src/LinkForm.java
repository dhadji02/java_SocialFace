import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class LinkForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCaption;
	private JTextField txtDesc;
	private JTextField txtLink;
	private JTextField txtMsg;

	public LinkForm(int user,MainClass conn,int up,int p) {
		setTitle("Link form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 575);
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
				Links link = new Links(user,conn);
				dispose();
				link.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 69, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(189, 11, 106, 85);
		contentPane.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(168, 175, 155, 23);
		contentPane.add(txtName);
		
		txtCaption = new JTextField();
		txtCaption.setColumns(10);
		txtCaption.setBounds(168, 227, 155, 23);
		contentPane.add(txtCaption);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(168, 283, 155, 23);
		contentPane.add(txtDesc);
		
		txtLink = new JTextField();
		txtLink.setColumns(10);
		txtLink.setBounds(168, 337, 155, 23);
		contentPane.add(txtLink);
		
		txtMsg = new JTextField();
		txtMsg.setColumns(10);
		txtMsg.setBounds(168, 394, 155, 23);
		contentPane.add(txtMsg);
		
		JLabel lblNewLabel_1 = new JLabel("Link ID:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(40, 126, 79, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(40, 179, 79, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Caption:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(40, 231, 79, 19);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Description:");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(40, 287, 79, 19);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Link:");
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(40, 341, 79, 19);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Message:");
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(40, 398, 79, 19);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblID = new JLabel("");
		lblID.setBounds(168, 129, 155, 23);
		contentPane.add(lblID);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert addLink=new Insert();
				addLink.insertLinkMethod(txtName.getText(),txtCaption.getText(), txtDesc.getText(), txtLink.getText(), txtMsg.getText(), user, conn);
				JOptionPane.showMessageDialog(contentPane, "Added successfully");
				Links al = new Links(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdd.setBackground(new Color(51, 255, 51));
		btnAdd.setBounds(189, 490, 106, 23);
		contentPane.add(btnAdd);
		JButton btnUpdate = new JButton("Update");
		if (up==1) {
			btnAdd.setEnabled(false);
			btnAdd.setVisible(false);
			Show obj = new Show();
			String data[][] = obj.ShowLink(user, conn);
			//"Link ID","Name", "Caption", "Description","Link","Message","Owner"
			lblID.setText(data[p][0].trim());
			txtName.setText(data[p][1]);
			txtCaption.setText(data[p][2]);
			txtDesc.setText(data[p][3]);
			txtLink.setText(data[p][4]);
			txtMsg.setText(data[p][5]);
			
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdatesQry updateLink=new UpdatesQry();
				updateLink.updateLinkMethod(txtName.getText(), txtCaption.getText(),txtDesc.getText(), txtLink.getText(), txtMsg.getText(), user, Integer.parseInt(lblID.getText()), conn);
				JOptionPane.showMessageDialog(contentPane, "Updated successfully");
				Links al = new Links(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		}
		else {
			btnUpdate.setEnabled(false);
			btnUpdate.setVisible(false);
			lblID.setText("AUTO");
		}
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(102, 153, 255));
		btnUpdate.setBounds(189, 464, 106, 23);
		contentPane.add(btnUpdate);
	}
	
}
