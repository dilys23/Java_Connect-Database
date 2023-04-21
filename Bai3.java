package Baitap3;

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



import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class Bai3 extends JFrame {
	private DefaultTableModel dtm;
	private JPanel contentPane;
	private JButton btnSubmit;
	private JTable table;
	
	private Connection getConnect() throws SQLException
	{
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=JAVA_CSDL;user=sa;password=Dilysnguyen23;encrypt=false");
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

	private Connection getConnectmySQL() throws SQLException
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JAVA_CSDL","root", "");
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

	public Bai3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSubmit = new JButton("SUBMIT");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = getConnect();
					//Connection con = getConnectmySQL();
					Statement statement = con.createStatement();
					String query = "select * from Table1";
					ResultSet result = statement.executeQuery(query);
					while(result.next())
					{
						Vector<Object> vec = new Vector<Object>();
						vec.add(result.getString("Id"));
						vec.add(result.getString("Name"));
						vec.add(result.getString("Address"));
						vec.add(result.getString("Total"));
						dtm.addRow(vec);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setBounds(50, 67, 69, 21);
		contentPane.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("KẾT NỐI CƠ SỞ DỮ LIỆU");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setBounds(148, 26, 145, 13);
		contentPane.add(lblNewLabel);
		
		JButton btnReset = new JButton("RESET");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
			}
		});
		btnReset.setBounds(175, 67, 63, 21);
		contentPane.add(btnReset);
		
		JButton btnexit = new JButton("EXIT");
		btnexit.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnexit.setBounds(285, 67, 55, 21);
		contentPane.add(btnexit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(38, 109, 347, 132);
		contentPane.add(scrollPane);
		table = new JTable();
		 dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Address", "Total"
				}
			);
				
		table.setModel(dtm);
		scrollPane.setViewportView(table);
	}
	public void ShowWinDow()
	{
		this.setVisible(true);
		this.setSize(600,420);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		Bai3 bt3 = new Bai3();
		bt3.ShowWinDow();
	}

}
