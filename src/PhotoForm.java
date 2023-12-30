import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PhotoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSource;
	private JTextField txtURL;
	private JTextField txtheight;
	private JTextField textWidth;


	public PhotoForm(int user,MainClass conn,int up,int p) {
		setTitle("Photo Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 644);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(193, 30, 113, 90);
		contentPane.add(lblNewLabel);
		
		txtSource = new JTextField();
		txtSource.setBounds(164, 184, 296, 20);
		contentPane.add(txtSource);
		txtSource.setColumns(10);
		
		txtURL = new JTextField();
		txtURL.setBounds(164, 242, 296, 20);
		contentPane.add(txtURL);
		txtURL.setColumns(10);
		
		txtheight = new JTextField();
		txtheight.setBounds(164, 297, 151, 20);
		contentPane.add(txtheight);
		txtheight.setColumns(10);
		
		textWidth = new JTextField();
		textWidth.setBounds(164, 354, 151, 20);
		contentPane.add(textWidth);
		textWidth.setColumns(10);
		
		JTextField txtOwner = new JTextField();
		txtOwner.setEditable(false);
		txtOwner.setBounds(164, 410, 151, 20);
		contentPane.add(txtOwner);
		txtOwner.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Photo ID:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(44, 131, 81, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Source:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(44, 187, 81, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("URL:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(44, 245, 81, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Height:");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(44, 300, 81, 17);
		contentPane.add(lblNewLabel_1_3);
		
		JComboBox<Integer> cmbLikes = new JComboBox<Integer>();
		cmbLikes.setBackground(Color.WHITE);
		cmbLikes.setBounds(164, 510, 151, 19);
		contentPane.add(cmbLikes);
		
		JLabel lblNewLabel_1_4 = new JLabel("Width:");
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(44, 357, 81, 17);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Owner:");
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_5.setBounds(44, 413, 81, 17);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Album ID:");
		lblNewLabel_1_6.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_6.setBounds(44, 468, 81, 17);
		contentPane.add(lblNewLabel_1_6);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Photos ph = new Photos(user,conn);
				ph.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 81, 20);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("See Likes:");
		lblNewLabel_1_4_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4_1.setBounds(44, 511, 83, 20);
		contentPane.add(lblNewLabel_1_4_1);
		
		JComboBox<Integer> cmbAlbumID = new JComboBox<Integer>();
		cmbAlbumID.setBackground(Color.WHITE);
		cmbAlbumID.setBounds(164, 466, 151, 19);
		contentPane.add(cmbAlbumID);
		
		JLabel lblid = new JLabel("");
		lblid.setBounds(164, 133, 151, 20);
		contentPane.add(lblid);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert addPhoto = new Insert();
				addPhoto.insertPhotoMethod(txtSource.getText(), txtURL.getText(), Float.parseFloat(textWidth.getText()),Float.parseFloat(txtheight.getText()), Integer.parseInt(txtOwner.getText()), (int) cmbAlbumID.getSelectedItem(), conn);
				UpdatesQry new1= new UpdatesQry();
				new1.updateCount(user, (int) cmbAlbumID.getSelectedItem(), conn);
				JOptionPane.showMessageDialog(contentPane, "Added successfully");
				Photos al = new Photos(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdd.setBackground(new Color(102, 255, 51));
		btnAdd.setBounds(193, 564, 92, 20);
		contentPane.add(btnAdd);
		
		JButton btnUp = new JButton("Update");
		if (up==1) {
			btnAdd.setVisible(false);
			Show obj = new Show();
			String data[][] = obj.ShowPhoto(user, conn);
			/**
			 * 			photo[i][0] = (String.valueOf((rs.getInt("id") + "\n")));
				photo[i][1] = ((rs.getString("ph_source") + "\n"));
				photo[i][2] = ((rs.getString("ph_url") + "\n"));
				photo[i][3] = (String.valueOf((rs.getDouble("width") + "\n")));
				photo[i][4] = (String.valueOf((rs.getDouble("height") + "\n")));
				photo[i][5] = (String.valueOf((rs.getInt("ph_owner") + "\n")));
				photo[i][6] = (String.valueOf((rs.getInt("album_id") + "\n")));**/
			lblid.setText(data[p][0]);
			txtSource.setText(data[p][1]);
			txtURL.setText(data[p][2]);
			textWidth.setText(data[p][3]);
			txtheight.setText(data[p][4]);
			txtOwner.setText(data[p][5]);

			Like_Comment photo=new Like_Comment();
			int ids[]=photo.takeAlbumId(user, conn);
			for (int i=0;i<ids.length;i++)
				cmbAlbumID.addItem(ids[i]);
			cmbAlbumID.setSelectedItem(data[p][6]);
			int likes[]=photo.showLikes(user, conn);
			for (int w=0;w<likes.length;w++)
				cmbLikes.addItem(likes[w]);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdatesQry updatePh = new UpdatesQry();
				updatePh.updatePhotoMethod(txtSource.getText(), txtURL.getText(), Float.parseFloat(textWidth.getText()),Float.parseFloat(txtheight.getText()), Integer.parseInt(txtOwner.getText().trim()), (int) cmbAlbumID.getSelectedItem(), Integer.parseInt(lblid.getText().trim()),  conn);
				JOptionPane.showMessageDialog(contentPane, "Updated successfully");
				Photos al = new Photos(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		} 
		else {
			lblid.setText("AUTO");
			Like_Comment photo=new Like_Comment();
			txtOwner.setText(String.valueOf(user));
			int ids[]=photo.takeAlbumId(user, conn);
			for (int i=0;i<ids.length;i++)
				cmbAlbumID.addItem(ids[i]);
			btnUp.setVisible(false);
			cmbLikes.setEnabled(false);
			btnUp.setVisible(false);
		}
		btnUp.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUp.setBackground(new Color(102, 153, 255));
		btnUp.setBounds(193, 552, 92, 20);
		contentPane.add(btnUp);
	
		
		
	}
}
