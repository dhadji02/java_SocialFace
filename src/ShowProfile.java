import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JButton btnNewButton;
	private JButton btnFR;
	private JTextField lblID;
	private JTextField lblusr;
	private JTextField lblfn;
	private JTextField lblln;
	private JTextField lblbday;
	private JTextField lblwebsite;
	private JTextField lblhome;
	private JTextField lblloc;
	private JTextField lblmail;
	private JTextField lblgender;
	private JTextField lblfull;
	private JTextField lblveri;
	private JTextField txturl;
	private JComboBox<String> cmbInterests;
	private JLabel lblNewLabel_4;
	private JComboBox<String> cmbQuotes;
	private JLabel lblNewLabel_16;

	public ShowProfile(int user, int sel,MainClass conn, int p) {
		setTitle("Show profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 685);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setForeground(Color.BLUE);
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("Profile.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(66, 46, 133, 129);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image image2 = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(image2));
		lblNewLabel_1.setBounds(240, 11, 100, 85);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("User ID:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_2.setBounds(22, 185, 69, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Username:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_3.setBounds(22, 241, 69, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_5 = new JLabel("First name:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_5.setBounds(22, 357, 69, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Last name:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_6.setBounds(22, 399, 69, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Birthday:");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_7.setBounds(22, 456, 69, 14);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel(" Website:");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_8.setBounds(22, 513, 69, 14);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Hometown:");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_9.setBounds(326, 185, 69, 14);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Location:");
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_10.setBounds(326, 241, 69, 14);
		contentPane.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Email:");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_11.setBounds(326, 297, 69, 14);
		contentPane.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Gender:");
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_12.setBounds(326, 357, 69, 14);
		contentPane.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Full name:");
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_13.setBounds(326, 415, 69, 14);
		contentPane.add(lblNewLabel_13);
		
		lblNewLabel_14 = new JLabel("Verified:");
		lblNewLabel_14.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_14.setBounds(326, 472, 69, 14);
		contentPane.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("URL:");
		lblNewLabel_15.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_15.setBounds(326, 131, 69, 14);
		contentPane.add(lblNewLabel_15);
		
		btnNewButton = new JButton("BACK");
	
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 92, 20);
		contentPane.add(btnNewButton);
		
		btnFR = new JButton("Send friend request");
		
		btnFR.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnFR.setForeground(Color.WHITE);
		btnFR.setBackground(new Color(102, 255, 51));
		btnFR.setBounds(381, 76, 150, 20);
		contentPane.add(btnFR);
		
		lblID = new JTextField("");
		lblID.setEditable(false);
		lblID.setForeground(Color.BLUE);
		lblID.setBackground(Color.WHITE);
		lblID.setBounds(22, 212, 50, 16);
		contentPane.add(lblID);
		
		lblusr = new JTextField("");
		lblusr.setEditable(false);
		lblusr.setForeground(Color.BLACK);
		lblusr.setBackground(Color.WHITE);
		lblusr.setBounds(22, 268, 144, 16);
		contentPane.add(lblusr);
		
		lblfn = new JTextField("");
		lblfn.setBackground(Color.WHITE);
		lblfn.setEditable(false);
		lblfn.setForeground(Color.BLACK);
		lblfn.setBounds(22, 384, 197, 16);
		contentPane.add(lblfn);
		
		lblln = new JTextField("");
		lblln.setBackground(Color.WHITE);
		lblln.setEditable(false);
		lblln.setForeground(Color.BLACK);
		lblln.setBounds(22, 427, 197, 16);
		contentPane.add(lblln);
		
		lblbday = new JTextField("");
		lblbday.setBackground(Color.WHITE);
		lblbday.setEditable(false);
		lblbday.setForeground(Color.BLACK);
		lblbday.setBounds(22, 483, 117, 16);
		contentPane.add(lblbday);
		
		lblwebsite = new JTextField("");
		lblwebsite.setBackground(Color.WHITE);
		lblwebsite.setEditable(false);
		lblwebsite.setForeground(Color.BLACK);
		lblwebsite.setBounds(22, 538, 260, 16);
		contentPane.add(lblwebsite);
		
		lblhome = new JTextField("");
		lblhome.setBackground(Color.WHITE);
		lblhome.setEditable(false);
		lblhome.setForeground(Color.BLACK);
		lblhome.setBounds(326, 212, 224, 16);
		contentPane.add(lblhome);
		
		lblloc = new JTextField("");
		lblloc.setBackground(Color.WHITE);
		lblloc.setEditable(false);
		lblloc.setForeground(Color.BLACK);
		lblloc.setBounds(326, 268, 224, 16);
		contentPane.add(lblloc);
		
		lblmail = new JTextField("");
		lblmail.setBackground(Color.WHITE);
		lblmail.setEditable(false);
		lblmail.setForeground(Color.BLACK);
		lblmail.setBounds(326, 328, 224, 16);
		contentPane.add(lblmail);
		
		lblgender = new JTextField("");
		lblgender.setBackground(Color.WHITE);
		lblgender.setEditable(false);
		lblgender.setForeground(Color.BLACK);
		lblgender.setBounds(326, 384, 100, 16);
		contentPane.add(lblgender);
		
		lblfull = new JTextField("");
		lblfull.setBackground(Color.WHITE);
		lblfull.setEditable(false);
		lblfull.setForeground(Color.BLACK);
		lblfull.setBounds(326, 442, 224, 16);
		contentPane.add(lblfull);
		
		lblveri = new JTextField("");
		lblveri.setBackground(Color.WHITE);
		lblveri.setEditable(false);
		lblveri.setForeground(Color.BLACK);
		lblveri.setBounds(326, 499, 55, 16);
		contentPane.add(lblveri);
		
		txturl = new JTextField("");
		txturl.setBackground(Color.WHITE);
		txturl.setEditable(false);
		txturl.setForeground(Color.BLACK);
		txturl.setBounds(326, 158, 224, 16);
		contentPane.add(txturl);
		
		cmbInterests = new JComboBox<String>();
		cmbInterests.setBounds(22, 322, 260, 22);
		contentPane.add(cmbInterests);
		
		lblNewLabel_4 = new JLabel("Interests:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_4.setBounds(22, 297, 69, 14);
		contentPane.add(lblNewLabel_4);
		
		cmbQuotes = new JComboBox<String>();
		cmbQuotes.setBounds(22, 605, 260, 22);
		contentPane.add(cmbQuotes);
		
		lblNewLabel_16 = new JLabel("Quotes:");
		lblNewLabel_16.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_16.setBounds(22, 578, 69, 14);
		contentPane.add(lblNewLabel_16);
		
		JComboBox<String> cmbEducation = new JComboBox<String>();
		cmbEducation.setBounds(326, 605, 224, 22);
		contentPane.add(cmbEducation);
		
		JLabel lblNewLabel_4_1 = new JLabel("Education:");
		lblNewLabel_4_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_4_1.setBounds(326, 578, 69, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Work:");
		lblNewLabel_4_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_4_1_1.setBounds(326, 525, 69, 14);
		contentPane.add(lblNewLabel_4_1_1);
		
		JComboBox<String> cmbWork = new JComboBox<String>();
		cmbWork.setBounds(326, 550, 224, 22);
		contentPane.add(cmbWork);
		
		
		if (p==0) {
			btnFR.setVisible(false);
			Show show=new Show();
			String data[][];
			data=show.ShowUser(user, conn);
			lblID.setText(data[0][0]);
			lblusr.setText(data[0][12]);
			lblfn.setText(data[0][2]);
			lblln.setText(data[0][3]);
			lblbday.setText(data[0][4]);
			lblmail.setText(data[0][5]);
			lblgender.setText(data[0][6]);
			lblfull.setText(data[0][1]);
			if (data[0][9].equals("1"))
				lblveri.setText("Yes");
			else
				lblveri.setText("No");
			lblwebsite.setText(data[0][7]);
			txturl.setText(data[0][8]);
			if (data[0][6].equals("1"))
				lblgender.setText("Female");
			else
				lblgender.setText("Male");
			
			Interests_Quotes_qry inter= new Interests_Quotes_qry();
			String cities[]=inter.showCity(conn);
			lblhome.setText(cities[Integer.parseInt(data[0][10])-1]);
			lblloc.setText(cities[Integer.parseInt(data[0][11])-1]);
			String interests[]=inter.showIntusr(user, conn);
			String quotes[]=inter.showQuotesUsr(user, conn);
			for (int s=0;s<interests.length;s++)
			cmbInterests.addItem(interests[s]);
			for (int s=0;s<quotes.length;s++)
				cmbQuotes.addItem(quotes[s]);
			String education[] =inter.showEduusr(user, conn);
			String works[]=inter.showWorkusr(user, conn);
			for (int s=0;s<education.length;s++)
			cmbEducation.addItem(education[s]);
			for (int s=0;s<works.length;s++)
				cmbWork.addItem(works[s]);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					User user1 = new User(user,conn);
					dispose();
					user1.setVisible(true);
				}
			});
		}
		else if (p==1) {
			Show show=new Show();
			String data[][];
			data=show.ShowUser(sel, conn);
			lblID.setText(data[0][0]);
			lblusr.setText(data[0][12]);
			lblfn.setText(data[0][2]);
			lblln.setText(data[0][3]);
			lblbday.setText(data[0][4]);
			lblmail.setText(data[0][5]);
			lblgender.setText(data[0][6]);
			lblfull.setText(data[0][1]);
			if (data[0][9].equals("1"))
				lblveri.setText("Yes");
			else
				lblveri.setText("No");
			lblwebsite.setText(data[0][7]);
			txturl.setText(data[0][8]);
			if (data[0][6].equals("1"))
				lblgender.setText("Female");
			else
				lblgender.setText("Male");
			
			Interests_Quotes_qry inter= new Interests_Quotes_qry();
			String cities[]=inter.showCity(conn);
			lblhome.setText(cities[Integer.parseInt(data[0][10])-1]);
			lblloc.setText(cities[Integer.parseInt(data[0][11])-1]);
			
			String interests[]=inter.showIntusr(sel, conn);
			String quotes[]=inter.showQuotesUsr(sel, conn);
			for (int s=0;s<interests.length;s++)
			cmbInterests.addItem(interests[s]);
			for (int s=0;s<quotes.length;s++)
				cmbQuotes.addItem(quotes[s]);
			String education[] =inter.showEduusr(sel, conn);
			String works[]=inter.showWorkusr(sel, conn);
			for (int s=0;s<education.length;s++)
				cmbEducation.addItem(education[s]);
			for (int s=0;s<works.length;s++)
				cmbWork.addItem(works[s]);
			
			friendQrys friends=new friendQrys();
			String data2[][]=friends.takeFriends(user, conn);
			boolean q=false,b=false;
			String data3[][]=friends.takeFriendReq(sel, conn);
			
				for (int s=0;s<data2.length;s++)
					if ((Integer.parseInt(data2[s][0])==user))
						q=true;
				
				for (int s=0;s<data3.length;s++)
					if ((Integer.parseInt(data3[s][0])==user))
						b=true;
				
			if (q||b)
				btnFR.setVisible(false);
			
			btnFR.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					UpdatesQry update1=new UpdatesQry();
					update1.updateFriend(sel, 1, 0,user , conn);
					JOptionPane.showMessageDialog(contentPane, "Friend Request Sent!");
				}
			});
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Search user1 = new Search(user,conn);
					dispose();
					user1.setVisible(true);
				}
			});
		}
	}
}
