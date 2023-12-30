import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class CommonInterests extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;

	public CommonInterests(int user, MainClass conn) {
		setTitle("Common interests");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 477);
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

				dispose();
				Friends fr = new Friends(user, conn);
				fr.setVisible(true);
			}
		});
		btnNewButton.setBackground(new Color(102, 102, 255));
		btnNewButton.setBounds(10, 11, 89, 23);
		contentPane.add(btnNewButton);

		String col[] = { "User ID" };
		SameInterestsClass obj = new SameInterestsClass();
		int data1[] = obj.action(user, conn);
		String data2[][] = new String[data1.length][1];
		for (int l = 0; l < data1.length; l++)
			data2[l][0] = String.valueOf(data1[l]);
		DefaultTableModel model = new DefaultTableModel(data2, col);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 177, 513, 231);
		contentPane.add(scrollPane);

		table = new JTable(model);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);

		JLabel lblNewLabel = new JLabel("");
		Image image = new ImageIcon(this.getClass().getResource("login.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		lblNewLabel.setBounds(244, 11, 120, 112);
		contentPane.add(lblNewLabel);

		btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 11));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(48, 145, 89, 23);
		contentPane.add(btnNewButton_1);

	}

}
