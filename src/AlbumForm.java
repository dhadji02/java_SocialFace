import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AlbumForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDesc;
	private JTextField txtLink;
	private JTextField photocount;
	private JLabel lblid2;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_6_2;
	

	public AlbumForm(int user, MainClass conn, int up, int p) {

		setTitle("Album form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 723);
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
				Albums al = new Albums(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 72, 23);
		contentPane.add(btnNewButton);

		txtName = new JTextField();
		txtName.setBounds(168, 151, 159, 23);
		contentPane.add(txtName);
		txtName.setColumns(10);

		txtDesc = new JTextField();
		txtDesc.setBounds(168, 203, 159, 23);
		contentPane.add(txtDesc);
		txtDesc.setColumns(10);

		txtLink = new JTextField();
		txtLink.setBounds(168, 313, 159, 23);
		contentPane.add(txtLink);
		txtLink.setColumns(10);

		photocount = new JTextField();
		photocount.setEditable(false);
		photocount.setBounds(168, 422, 44, 23);
		contentPane.add(photocount);
		photocount.setColumns(10);

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(187, 11, 109, 69);
		contentPane.add(lblNewLabel);

		lblid2 = new JLabel("Album ID:");
		lblid2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblid2.setBounds(28, 99, 81, 19);
		contentPane.add(lblid2);

		lblNewLabel_2 = new JLabel("Name:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_2.setBounds(28, 151, 81, 19);
		contentPane.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("Description:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_3.setBounds(28, 203, 81, 19);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("Location:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_4.setBounds(28, 257, 81, 19);
		contentPane.add(lblNewLabel_4);
		JComboBox<String> cmbComments = new JComboBox<String>();
		cmbComments.setBackground(Color.WHITE);
		cmbComments.setBounds(168, 565, 159, 23);
		contentPane.add(cmbComments);

		JLabel lblNewLabel_6_1 = new JLabel("Photos:");
		lblNewLabel_6_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_6_1.setBounds(28, 516, 81, 19);
		contentPane.add(lblNewLabel_6_1);

		JComboBox<String> cmbPhotos = new JComboBox<String>();
		cmbPhotos.setBackground(Color.WHITE);
		cmbPhotos.setBounds(168, 514, 159, 23);
		contentPane.add(cmbPhotos);

		lblNewLabel_5 = new JLabel("Link:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5.setBounds(28, 313, 81, 19);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("Privacy:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_6.setBounds(28, 367, 81, 19);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("Photo Count:");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_7.setBounds(28, 422, 81, 19);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("Owner:");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_8.setBounds(28, 474, 81, 19);
		contentPane.add(lblNewLabel_8);

		JButton btnUp = new JButton("Update");

		JLabel lblid = new JLabel("");
		lblid.setBounds(168, 99, 159, 23);
		contentPane.add(lblid);

		JLabel lblOwner = new JLabel("");
		lblOwner.setBounds(168, 474, 159, 23);
		contentPane.add(lblOwner);

		JComboBox<String> cmbPrivacy = new JComboBox<String>();
		cmbPrivacy.setModel(new DefaultComboBoxModel<String>(new String[] { "OPEN", "CLOSED", "FRIEND", "NETWORK" }));

		cmbPrivacy.setBackground(Color.WHITE);
		cmbPrivacy.setBounds(168, 370, 159, 23);
		contentPane.add(cmbPrivacy);

		JComboBox<String> cmbLoc = new JComboBox<String>();
		cmbLoc.setBackground(Color.WHITE);
		cmbLoc.setBounds(168, 256, 159, 23);
		contentPane.add(cmbLoc);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert addAlbum = new Insert();
				Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
				String data1[] = obj1.showCity(conn);
				for (int i = 0; i < data1.length; i++)
					cmbLoc.addItem(data1[i]);
				addAlbum.insertAlbumMethod(txtName.getText(), txtDesc.getText(), txtLink.getText(),
						0, ((cmbPrivacy.getSelectedIndex())),
						Integer.parseInt(lblOwner.getText()), cmbLoc.getSelectedIndex() +1 , conn);
				JOptionPane.showMessageDialog(contentPane, "Added successfully");
				Albums al = new Albums(user, conn);
				dispose();
				al.setVisible(true);
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdd.setBackground(new Color(51, 255, 51));
		btnAdd.setBounds(187, 606, 109, 22);
		contentPane.add(btnAdd);

		if (up == 1) {
			// Update Album
			btnAdd.setEnabled(false);
			btnAdd.setVisible(false);
			
			// "Album ID","Album Name", "Description", "URL", "Photo
			// Count","Privacy","Owner","Location"
			Show obj = new Show();
			String data[][] = obj.ShowAlbum(user, conn);
			lblid.setText(data[p][0]);
			txtName.setText(data[p][1]);
			txtDesc.setText(data[p][2]);

			Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
			String data1[] = obj1.showCity(conn);
			for (int i = 0; i < data1.length; i++)
				cmbLoc.addItem(data1[i]);
			int c = Integer.parseInt(data[p][7]) - 1;
			cmbLoc.setSelectedIndex(c);

			txtLink.setText(data[p][3]);
			cmbPrivacy.setSelectedIndex(Integer.parseInt(data[p][5]));
			photocount.setText(data[p][4]);
			lblOwner.setText(data[p][6]);
			Like_Comment show1 =new Like_Comment ();
			int b=Integer.parseInt(data[p][0]);
			int photos[]=show1.showPhotos(user,b, conn);
			String comments[]=show1.showCommentsA(b, conn);
			for(int w=0;w<photos.length;w++)
				cmbPhotos.addItem(String.valueOf(photos[w]));
			for (int w=0;w<comments.length;w++)
				cmbComments.addItem(comments[w]);
			if(photos.length==0)
				cmbPhotos.addItem("-");
			else if (comments.length==0)
				cmbComments.addItem("-");
			btnUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UpdatesQry updateAl = new UpdatesQry();
					updateAl.updateAlbumMethod(Integer.parseInt(data[p][0]), txtName.getText(), txtDesc.getText(),
							txtLink.getText(), Integer.parseInt(photocount.getText()),
							((cmbPrivacy.getSelectedIndex())), Integer.parseInt(lblOwner.getText()),
							cmbLoc.getSelectedIndex() + 1, conn);
					JOptionPane.showMessageDialog(contentPane, "Updated successfully");
					Albums al = new Albums(user, conn);
					dispose();
					al.setVisible(true);
				}
			});

		} else {
			lblid.setText("AUTO");
			cmbPhotos.setEnabled(false);
			cmbComments.setEnabled(false);
			photocount.setText("0");
			photocount.setEnabled(false);
			btnUp.setEnabled(false);
				cmbPhotos.addItem("-");
			cmbPhotos.setEnabled(false);
			btnUp.setVisible(false);
			Interests_Quotes_qry obj1 = new Interests_Quotes_qry();
			String data1[] = obj1.showCity(conn);
			for (int i = 0; i < data1.length; i++)
				cmbLoc.addItem(data1[i]);
			lblOwner.setText(String.valueOf(user));
		}
		btnUp.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUp.setBackground(new Color(102, 153, 255));
		btnUp.setBounds(183, 628, 103, 23);
		contentPane.add(btnUp);
		
		lblNewLabel_6_2 = new JLabel("Comments:");
		lblNewLabel_6_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_6_2.setBounds(28, 567, 81, 19);
		contentPane.add(lblNewLabel_6_2);
		
		
	}
}
