package Baitap4;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Bai4 extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtQuery;
	private JTable table;
	private DefaultTableModel dtm;
	private Connection getConnect(String input) throws SQLException
	{
		Connection conn = null;
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			//conn = DriverManager.getConnection(input,"root", "" );
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			
			conn = DriverManager.getConnection( input+ " ;user=sa;password=Dilysnguyen23;encrypt=false ");
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
	
	public Bai4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Input");
		lblNewLabel.setBounds(139, 43, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SQL query");
		lblNewLabel_1.setBounds(124, 66, 60, 17);
		contentPane.add(lblNewLabel_1);
		
		txtInput = new JTextField();
		txtInput.setBounds(235, 40, 137, 19);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		txtQuery = new JTextField();
		txtQuery.setBounds(235, 65, 137, 19);
		contentPane.add(txtQuery);
		txtQuery.setColumns(10);
		

		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
				txtInput.setText("");
				txtQuery.setText("");}
		});
		btnReset.setBounds(265, 274, 71, 21);
		contentPane.add(btnReset);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtInput.getText() == "")
				{
					JOptionPane.showMessageDialog(null,"Ô input còn trống","Thông báo",JOptionPane.INFORMATION_MESSAGE);
				}
				else if(txtQuery.getText()=="")
				{
					JOptionPane.showMessageDialog(null,"Câu lệnh sql còn trống","Thông báo",JOptionPane.INFORMATION_MESSAGE);

				}
				else {
					try {
						Connection con = getConnect(txtInput.getText());
						Statement statement = con.createStatement();
						ResultSet result = statement.executeQuery(txtQuery.getText());
						while(result.next())
						{
							Vector<Object>vec = new Vector<Object>();
							vec.add(result.getString("Id"));
							vec.add(result.getString("Name"));
							vec.add(result.getString("Address"));
							vec.add(result.getString("Total"));
							dtm.addRow(vec);
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"Input information hoặc query bị lỗi","Thông báo",JOptionPane.INFORMATION_MESSAGE);

					}
					
				}
			}
			
		});
		btnSubmit.setBounds(84, 274, 85, 21);
		contentPane.add(btnSubmit);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(408, 274, 85, 21);
		contentPane.add(btnExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 107, 575, 144);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		dtm = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Id", "Name", "Address", "Total"
				}
			);
		table.setModel(dtm);
		
		JLabel lblNewLabel_2 = new JLabel("KẾT NỐI CƠ SỞ DỮ LIỆU ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(221, 10, 236, 13);
		contentPane.add(lblNewLabel_2);

	}
	public void ShowWindow()
	{
		this.setVisible(true);
		this.setSize(660,600);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		Bai4 b4 = new Bai4();
		b4.ShowWindow();
	}


}
