package Baitap6;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Bai6 extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTable table;
	private DefaultTableModel dtm;
	private Connection getConnect() throws SQLException
	{
		Connection conn = null;
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JAVA_CSDL","root", "" );
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
			conn = DriverManager.getConnection(  "jdbc:sqlserver://localhost:1433;databasename=JAVA_CSDL ;user=sa;password=Dilysnguyen23;encrypt=false ");
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception: " + e.toString());
		}
		catch(ClassNotFoundException cE)
		{
			System.out.println("Class Not Found Exception: "+cE.toString());
		}
		return conn;
	}

	public Bai6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 770, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtSearch = new JTextField();
		txtSearch.setBounds(131, 86, 122, 19);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				txtSearch.setText("");
			}
		});
		btnReset.setBounds(469, 85, 80, 21);
		contentPane.add(btnReset);
		

		JRadioButton rdbtnID = new JRadioButton("Id ");
		rdbtnID.setBounds(157, 142, 47, 21);
		contentPane.add(rdbtnID);
		
		JRadioButton rdbtnGender = new JRadioButton("Gender");
		rdbtnGender.setBounds(586, 142, 113, 21);
		contentPane.add(rdbtnGender);
		
		JRadioButton rdbtnName = new JRadioButton("Name");
		rdbtnName.setBounds(236, 142, 64, 21);
		contentPane.add(rdbtnName);
		
		JRadioButton rdbtnDate = new JRadioButton("Birthday");
		rdbtnDate.setBounds(334, 142, 80, 21);
		contentPane.add(rdbtnDate);
		
		JRadioButton rdbtnAdress = new JRadioButton("Adress");
		rdbtnAdress.setBounds(469, 142, 88, 21);
		contentPane.add(rdbtnAdress);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = getConnect();
					Statement statement = con.createStatement();
					String search = null;
					if(rdbtnName.isSelected())search = "Name";
					if(rdbtnAdress.isSelected())search = "Address";
					if(rdbtnDate.isSelected())search = "Birthday";
					if(rdbtnGender.isSelected())search = "Gender";
					if(rdbtnID.isSelected())search = "Id";
					String key = txtSearch.getText();
					String query = "select * from student where "+search +" like N'%"+key+"%'";
					ResultSet result = statement.executeQuery(query);
					while(result.next())
					{
						Vector<Object>vec= new Vector<Object>();
						vec.add(result.getString("Id"));
						vec.add(result.getString("Name"));
						vec.add(result.getString("Birthday"));
						vec.add(result.getString("Address"));
						vec.add(result.getString("Gender"));
						dtm.addRow(vec);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		btnSearch.setBounds(317, 85, 97, 21);
		contentPane.add(btnSearch);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(611, 85, 88, 21);
		contentPane.add(btnExit);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 192, 665, 195);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "NAME", "BIRTHDAY", "ADDRESS", "GENDER"
				}
			);
		table.setModel(dtm);
		
		
		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(65, 88, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSearch.setBounds(63, 143, 64, 17);
		contentPane.add(lblSearch);
		
		JLabel lblNewLabel_2 = new JLabel("KẾT NỐI CƠ SỞ DỮ LIỆU ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(298, 30, 236, 13);
		contentPane.add(lblNewLabel_2);
	}

	public void ShowWindow()
	{
		this.setVisible(true);
		this.setSize(800,700);
		this.setLocationRelativeTo(null);
	
}
	public static void main(String[] args) {
		Bai6 bt6 = new Bai6();
		bt6.ShowWindow();
	}
	}
