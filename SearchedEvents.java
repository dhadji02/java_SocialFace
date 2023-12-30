import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JScrollPane;

public class SearchedEvents extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	public SearchedEvents(int user,MainClass conn, String city) {
		setTitle("Searched Events");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 578, 370);
		setIconImage(new ImageIcon(getClass().getResource("Icon.png")).getImage());

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Events fr = new Events(user,conn);
				fr.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(102, 102, 255));
		btnNewButton_1.setBounds(10, 11, 74, 23);
		contentPane.add(btnNewButton_1);
		
		String col[] = { "Happening ID" ,"Happening Name" };
		TakeHappeningFromUsersClass obj = new TakeHappeningFromUsersClass();
		String data[][] = obj.action(user, city, conn);
		
		DefaultTableModel model = new DefaultTableModel(data, col);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(178, 118, 205, 174);
		contentPane.add(scrollPane);
		
		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

        		int index = table.getSelectedRow();
        		
        		String[] options = {"Attend Event", "Cancel"}; 
                int result = JOptionPane.showOptionDialog(
                   table,
                   "Choose your option", 
                   "Want to attend this event?",            
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,     //no custom icon
                   options,  //button titles
                   options[0] //default button
                );
                if (result==0){
                	Insert new1= new Insert();
                	new1.insertParticipateMethod(Integer.parseInt(data[index][0]), user, conn);
                }
			}
		});
		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(228, 11, 116, 109);
		contentPane.add(lblNewLabel);
		
	}
}
