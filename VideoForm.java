import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class VideoForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txttitle;
	private JTextField txtdesc;
	private JTextField txtlength;

	public VideoForm(int user, MainClass conn, int up, int p) {
		setTitle("Video Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 606);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(189, 11, 117, 111);
		contentPane.add(lblNewLabel);

		txttitle = new JTextField();
		txttitle.setBounds(169, 211, 142, 20);
		contentPane.add(txttitle);
		txttitle.setColumns(10);

		txtdesc = new JTextField();
		txtdesc.setBounds(169, 272, 142, 20);
		contentPane.add(txtdesc);
		txtdesc.setColumns(10);

		txtlength = new JTextField();
		txtlength.setBounds(169, 335, 142, 20);
		contentPane.add(txtlength);
		txtlength.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Video ID:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(48, 149, 83, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Title:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(48, 211, 83, 20);
		contentPane.add(lblNewLabel_1_1);
		JComboBox<String> cmbComments = new JComboBox<String>();

		JButton btnUpdated = new JButton("Update");
		JLabel lblNewLabel_1_2 = new JLabel("Description:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(48, 272, 83, 20);
		contentPane.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Length:");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_3.setBounds(48, 335, 83, 20);
		contentPane.add(lblNewLabel_1_3);

		JLabel lblNewLabel_1_4 = new JLabel("Owner:");
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4.setBounds(48, 397, 83, 20);
		contentPane.add(lblNewLabel_1_4);

		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Videos vid = new Videos(user, conn);
				vid.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(102, 102, 255));
		btnNewButton_1.setBounds(10, 11, 74, 20);
		contentPane.add(btnNewButton_1);

		JLabel lblid = new JLabel("");
		lblid.setBounds(169, 149, 142, 20);
		contentPane.add(lblid);

		JLabel lblowner = new JLabel("");
		lblowner.setBounds(169, 401, 142, 20);
		contentPane.add(lblowner);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert addVideo = new Insert();
				addVideo.insertVideoMethod(txttitle.getText(), txtdesc.getText(), Integer.parseInt(txtlength.getText()),
						Integer.parseInt(lblowner.getText()), conn);
				JOptionPane.showMessageDialog(contentPane, "Added successfully");
				Videos al = new Videos(user, conn);
				dispose();
				al.setVisible(true);

			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdd.setBackground(new Color(102, 255, 51));
		btnAdd.setBounds(196, 526, 100, 20);
		contentPane.add(btnAdd);
		if (up == 1) {
			// Update Album
			btnAdd.setEnabled(false);
			btnAdd.setVisible(false);

			// "Album ID","Album Name", "Description", "URL", "Photo
			// Count","Privacy","Owner","Location"
			Show obj = new Show();
			String data[][] = obj.ShowVideo(user, conn);
			/****
			 * ? video[i][0] = (String.valueOf((rs.getInt("id") ))); 
			 * video[i][1] =
			 * ((rs.getString("vid_message") )); 
			 * video[i][2] =
			 * ((rs.getString("vid_description") )); 
			 * video[i][3] =
			 * (String.valueOf((rs.getInt("vid_length")))); 
			 * video[i][4] =
			 * (String.valueOf((rs.getInt("vid_owner")
			 */
			lblid.setText(data[p][0]);
			txttitle.setText(data[p][1]);
			txtdesc.setText(data[p][2]);
			txtlength.setText(data[p][3]);
			lblowner.setText(data[p][4]);
			Like_Comment show1 = new Like_Comment();
			int b = Integer.parseInt(data[p][0]);
			String comments[] = show1.showCommentsA(b, conn);
			;
			for (int w = 0; w < comments.length; w++)
				cmbComments.addItem(comments[w]);
			if (comments.length == 0)
				cmbComments.addItem("-");
			btnUpdated.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UpdatesQry updateV = new UpdatesQry();
					updateV.updateVideoMethod(txttitle.getText(), txtdesc.getText(),
							Integer.parseInt(txtlength.getText()), Integer.parseInt(lblowner.getText()),
							Integer.parseInt(lblid.getText()), conn);
					JOptionPane.showMessageDialog(contentPane, "Updated successfully");
					Videos al = new Videos(user, conn);
					dispose();
					al.setVisible(true);
				}
			});

		} else {
			cmbComments.setEnabled(false);
			btnUpdated.setVisible(false);
			lblowner.setText(String.valueOf(user));
			lblid.setText("AUTO");
		}

		btnUpdated.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnUpdated.setBackground(new Color(102, 153, 255));
		btnUpdated.setBounds(189, 501, 100, 20);
		contentPane.add(btnUpdated);

		JLabel lblNewLabel_1_4_1 = new JLabel("Comments:");
		lblNewLabel_1_4_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_4_1.setBounds(48, 442, 83, 20);
		contentPane.add(lblNewLabel_1_4_1);

		cmbComments.setBounds(169, 441, 142, 22);
		contentPane.add(cmbComments);
	}
}
