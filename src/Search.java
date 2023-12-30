import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class Search extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDOB;
	private JTextField txtCity;
	private JTextField txtinprofile;
	private JTextField txtotherobj;
	public Search(int user, MainClass conn) {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 572);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		txtName = new JTextField();
		txtName.setBounds(39, 329, 145, 22);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDOB = new JTextField();
		txtDOB.setColumns(10);
		txtDOB.setBounds(206, 328, 145, 22);
		contentPane.add(txtDOB);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(366, 328, 145, 22);
		contentPane.add(txtCity);
		
		JComboBox<String> cmbAdvanced = new JComboBox<String>();
		cmbAdvanced.setModel(new DefaultComboBoxModel<String>(new String[] {"Work", "Education"}));
		cmbAdvanced.setBounds(172, 443, 203, 22);
		contentPane.add(cmbAdvanced);
		
		JComboBox<String> cmbcritprofile = new JComboBox<String>();
		cmbcritprofile.setModel(new DefaultComboBoxModel<String>(new String[] {"Album Name", "Album Description", "Event Name", "Event Description", "Link Name", "Link Caption", "Link URL", "Photo Source", "Photo Height", "Photo Width", "Video Description", "Video Message", "Video Length"}));
		cmbcritprofile.setBounds(39, 98, 203, 22);
		contentPane.add(cmbcritprofile);
		
		txtinprofile = new JTextField();
		txtinprofile.setColumns(10);
		txtinprofile.setBounds(299, 98, 188, 22);
		contentPane.add(txtinprofile);
		
		JComboBox<String> cmbotherobj = new JComboBox<String>();
		cmbotherobj.setModel(new DefaultComboBoxModel<String>(new String[] {"Search Photos by height", "Search Videos by length", "Search Links by url", "Search Albums by url"}));
		cmbotherobj.setBounds(39, 208, 203, 22);
		contentPane.add(cmbotherobj);
		
		JLabel lblEnterSerachItem = new JLabel("Enter search item:");
		lblEnterSerachItem.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblEnterSerachItem.setBounds(299, 176, 117, 19);
		contentPane.add(lblEnterSerachItem);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblName.setBounds(73, 306, 81, 19);
		contentPane.add(lblName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth:");
		lblDateOfBirth.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblDateOfBirth.setBounds(242, 306, 81, 19);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblCity.setBounds(409, 306, 81, 19);
		contentPane.add(lblCity);
		
		txtotherobj = new JTextField();
		txtotherobj.setColumns(10);
		txtotherobj.setBounds(299, 208, 203, 22);
		contentPane.add(txtotherobj);
		
		JLabel lblSelectCriteria = new JLabel("Search by:");
		lblSelectCriteria.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSelectCriteria.setBounds(39, 72, 81, 19);
		contentPane.add(lblSelectCriteria);
		
		JLabel lblSelectCriteriaTo = new JLabel("Select Criteria to search for other users:");
		lblSelectCriteriaTo.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSelectCriteriaTo.setBounds(172, 421, 203, 19);
		contentPane.add(lblSelectCriteriaTo);
		
		JLabel lblSelectObject = new JLabel("Search by:");
		lblSelectObject.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSelectObject.setBounds(39, 177, 81, 19);
		contentPane.add(lblSelectObject);
		
		JLabel lblSelectObject_1_1 = new JLabel("Enter search item:");
		lblSelectObject_1_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		lblSelectObject_1_1.setBounds(299, 72, 105, 19);
		contentPane.add(lblSelectObject_1_1);
////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton btninprofile = new JButton("Find in your profile");
		btninprofile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input=txtinprofile.getText();
				int sel=cmbcritprofile.getSelectedIndex();
				dispose();
				SearchObj search=new SearchObj(user,conn,input,sel,0);
				search.setVisible(true);
			}
		});
		btninprofile.setFont(new Font("Segoe UI", Font.BOLD, 11));

		btninprofile.setBackground(Color.WHITE);
		btninprofile.setBounds(172, 133, 203, 21);
		contentPane.add(btninprofile);
///////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton btnobjother = new JButton("Find in other profiles");
		btnobjother.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input=txtotherobj.getText();
				int sel=cmbotherobj.getSelectedIndex();
				dispose();
				SearchObj search=new SearchObj(user,conn,input,sel,1);
				search.setVisible(true);
			}
		});

		btnobjother.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnobjother.setBackground(Color.WHITE);
		btnobjother.setBounds(172, 257, 203, 20);
		contentPane.add(btnobjother);
///////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton btnOtherUsers = new JButton("Search other users");
		btnOtherUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SearchUsers search=new SearchUsers(user,conn,-1,txtName.getText(),txtDOB.getText(),txtCity.getText());
				dispose();
				search.setVisible(true);
			}
		});
		btnOtherUsers.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnOtherUsers.setBackground(Color.WHITE);
		btnOtherUsers.setBounds(172, 364, 203, 20);
		contentPane.add(btnOtherUsers);
///////////////////////////////////////////////////////////////////////////////////////////////////////
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(219, -1, 117, 89);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_4 = new JButton("BACK");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Menu men = new Menu(user, conn);
				men.setVisible(true);
			}
		});
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(new Color(102, 102, 255));
		btnNewButton_4.setBounds(10, 11, 93, 21);
		contentPane.add(btnNewButton_4);
		/////////////////////////////////////////////////////////////////////////////////////
		JButton btnAdvanced = new JButton("Advanced User search");
		btnAdvanced.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int sel=cmbAdvanced.getSelectedIndex();
				SearchUsers search=new SearchUsers(user,conn,sel, "","","");
				dispose();
				search.setVisible(true);
			}
		});
		btnAdvanced.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnAdvanced.setBackground(Color.WHITE);
		btnAdvanced.setBounds(172, 478, 203, 21);
		contentPane.add(btnAdvanced);
		
		
	}
}
