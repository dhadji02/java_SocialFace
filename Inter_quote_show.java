import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Inter_quote_show extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtQuote;
	private JTextField txtInterest;
	private JTextField txtWorkplace;
	private JTextField txtEdu;

	public Inter_quote_show(int user, MainClass conn) {
		setTitle("Quotes/Interests/Workplace/Education");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 530);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(368, 11, 96, 94);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Insert insert2 = new Insert();
				int ids=insert2.giveID(conn);
				if (user==ids) {
				EditAccount men = new EditAccount(user,conn,0);
				dispose();
				men.setVisible(true);
				}
				else {
					EditAccount men = new EditAccount(user,conn,1);
					dispose();
					men.setVisible(true);
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 87, 21);
		contentPane.add(btnNewButton);
		
		JComboBox<String> cmbQuotes = new JComboBox<String>();
		cmbQuotes.setBounds(26, 144, 340, 22);
		contentPane.add(cmbQuotes);
		
		JLabel lblNewLabel_1 = new JLabel("Quotes to Add:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(26, 112, 87, 19);
		contentPane.add(lblNewLabel_1);
		
		JComboBox<String> cmbInterests = new JComboBox<String>();
		cmbInterests.setBounds(442, 144, 333, 22);
		contentPane.add(cmbInterests);
		
		JLabel lblNewLabel_1_1 = new JLabel("Interests to Add:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1.setBounds(442, 118, 333, 19);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox<String> cmbWork = new JComboBox<String>();
		cmbWork.setBounds(26, 323, 340, 22);
		contentPane.add(cmbWork);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Add a new Interest:");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_1.setBounds(442, 201, 208, 19);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Add a new Quote:");
		lblNewLabel_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_1_1.setBounds(26, 201, 226, 19);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JComboBox<String> cmbEdu = new JComboBox<String>();
		cmbEdu.setBounds(442, 323, 333, 22);
		contentPane.add(cmbEdu);
		
		Interests_Quotes_qry show=new Interests_Quotes_qry();
		InsertB insert=new InsertB();
		
		String quotes[][]=show.showQuotes(user, conn);
		String interests[][]=show.showInt(user, conn);
		String workplace[][]=show.showWork(user, conn);
		String education[][]=show.showEdu(user, conn);
		
		for(int s=0;s<quotes.length;s++)
			cmbQuotes.addItem(quotes[s][1]);
		for(int s=0;s<interests.length;s++)
			cmbInterests.addItem(interests[s][1]);
		for(int s=0;s<workplace.length;s++)
			cmbWork.addItem(workplace[s][1]);
		for(int s=0;s<education.length;s++)
			cmbEdu.addItem(education[s][1]);
		
		JButton addQc = new JButton("Add");
		addQc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				insert.insertSaidMethod(Integer.parseInt(quotes[cmbQuotes.getSelectedIndex()][0]), user, conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String quotes[][]=show.showQuotes(user, conn);
				for(int s=0;s<quotes.length;s++)
					cmbQuotes.addItem(quotes[s][1]);
			}
		});
		addQc.setForeground(Color.WHITE);
		addQc.setBackground(new Color(102, 102, 255));
		addQc.setBounds(26, 175, 63, 21);
		contentPane.add(addQc);
		
		JButton addIc = new JButton("Add");
		addIc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertInterestedInMethod(Integer.parseInt(interests[cmbInterests.getSelectedIndex()][0]), user, conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String interests[][]=show.showInt(user, conn);
				for(int s=0;s<interests.length;s++)
					cmbInterests.addItem(interests[s][1]);
			}
		});
		addIc.setForeground(Color.WHITE);
		addIc.setBackground(new Color(102, 102, 255));
		addIc.setBounds(442, 179, 63, 21);
		contentPane.add(addIc);
		
		JButton addWc = new JButton("Add");
		addWc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertWorksAtMethod(Integer.parseInt(workplace[cmbWork.getSelectedIndex()][0]), user, conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String workplace[][]=show.showWork(user, conn);
				for(int s=0;s<workplace.length;s++)
					cmbWork.addItem(workplace[s][1]);
			}
		});
		addWc.setForeground(Color.WHITE);
		addWc.setBackground(new Color(102, 102, 255));
		addWc.setBounds(26, 359, 63, 21);
		contentPane.add(addWc);
		
		JButton addEc = new JButton("Add");
		addEc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertStudyMethod(Integer.parseInt(education[cmbEdu.getSelectedIndex()][0]), user, conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String education[][]=show.showEdu(user, conn);
				for(int s=0;s<education.length;s++)
					cmbEdu.addItem(education[s][1]);
			}
		});
		addEc.setForeground(Color.WHITE);
		addEc.setBackground(new Color(102, 102, 255));
		addEc.setBounds(442, 359, 63, 21);
		contentPane.add(addEc);
		
		txtInterest = new JTextField();
		txtInterest.setColumns(10);
		txtInterest.setBounds(442, 222, 333, 22);
		contentPane.add(txtInterest);
		
		JButton addIn = new JButton("Add");
		addIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertInterestMethod(txtInterest.getText(), conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String interests[][]=show.showInt(user, conn);
				for(int s=0;s<interests.length;s++)
					cmbInterests.addItem(interests[s][1]);
			}
		});
		addIn.setForeground(Color.WHITE);
		addIn.setBackground(new Color(102, 102, 255));
		addIn.setBounds(442, 257, 63, 21);
		contentPane.add(addIn);
		
		txtQuote = new JTextField();
		txtQuote.setBounds(26, 222, 340, 22);
		contentPane.add(txtQuote);
		txtQuote.setColumns(10);
		JButton addQn = new JButton("Add");
		addQn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertQuoteMethod(txtQuote.getText(), conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String quotes[][]=show.showQuotes(user, conn);
				for(int s=0;s<quotes.length;s++)
					cmbQuotes.addItem(quotes[s][1]);
			}
		});
		addQn.setForeground(Color.WHITE);
		addQn.setBackground(new Color(102, 102, 255));
		addQn.setBounds(26, 257, 63, 21);
		contentPane.add(addQn);
		
	
		JLabel lblNewLabel_1_2 = new JLabel("Workplaces to Add:");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2.setBounds(26, 291, 142, 19);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Education to Add:");
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_2_1.setBounds(442, 291, 142, 19);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Add a new Workplace:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_1_1_1.setBounds(26, 393, 226, 19);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		txtWorkplace = new JTextField();
		txtWorkplace.setColumns(10);
		txtWorkplace.setBounds(26, 414, 340, 22);
		contentPane.add(txtWorkplace);
		
		JButton addWn = new JButton("Add");
		addWn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertWorkplaceMethod(txtWorkplace.getText(), conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String workplace[][]=show.showWork(user, conn);
				for(int s=0;s<workplace.length;s++)
					cmbWork.addItem(workplace[s][1]);
			}
		});
		addWn.setForeground(Color.WHITE);
		addWn.setBackground(new Color(102, 102, 255));
		addWn.setBounds(26, 449, 63, 21);
		contentPane.add(addWn);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Add a new Educational Establishment:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblNewLabel_1_1_1_1_2.setBounds(442, 393, 226, 19);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		txtEdu = new JTextField();
		txtEdu.setColumns(10);
		txtEdu.setBounds(442, 414, 333, 22);
		contentPane.add(txtEdu);
		
		JButton addEn = new JButton("Add");
		addEn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				insert.insertEducationMethod(txtEdu.getText(), conn);
				JOptionPane.showMessageDialog(contentPane, "Added Successfully");
				String education[][]=show.showEdu(user, conn);
				for(int s=0;s<education.length;s++)
					cmbEdu.addItem(education[s][1]);
				
			}
		});
		addEn.setForeground(Color.WHITE);
		addEn.setBackground(new Color(102, 102, 255));
		addEn.setBounds(442, 449, 63, 21);
		contentPane.add(addEn);
		
		
	}
}
