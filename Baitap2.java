package Baitap2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Baitap2 {
	private static Connection getConnect() throws SQLException
	{
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=JAVA_CSDL;user=sa;password=Dilysnguyen23;encrypt=false");
			Statement stmt = conn.createStatement();
			String sql = "select * from Table1";
			ResultSet result  = stmt.executeQuery(sql);
			ResultSetMetaData rs = result.getMetaData();
			int count = rs.getColumnCount();
			  for(int i = 1; i<=count; i++) {
			         System.out.print(rs.getColumnName(i) + " ");
			      }
			      System.out.println();
			while (result.next())
			{
				System.out.print(result.getString("Id") + " ");
				System.out.print(result.getString("Name") + " ");
				System.out.print(result.getString("Address") + " ");
				System.out.print(result.getString("Total") + "\n");
			}

		}catch (Exception e) 
		{
			
			System.out.println("Erro" + e);
		}
		return conn;
	}
	
	// kết nối với mysql
	private static Connection getConnectMySQL() throws SQLException
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/JAVA_CSDL","root", "");
			Statement stmt = conn.createStatement();
			String sql = "select * from Table1";
			ResultSet result  = stmt.executeQuery(sql);
			ResultSetMetaData rs = result.getMetaData();
			int count = rs.getColumnCount();
			  for(int i = 1; i<=count; i++) {
			         System.out.print(rs.getColumnName(i) + " ");
			      }
			      System.out.println();
			while (result.next())
			{
				System.out.print(result.getString("Id") + " ");
				System.out.print(result.getString("Name") + " ");
				System.out.print(result.getString("Address") + " ");
				System.out.print(result.getString("Total") + "\n");
			}

		}catch (Exception e) 
		{
			
			System.out.println("Erro" + e);
		}
		return conn;
	}
	public static void main(String[] args) throws SQLException {
		getConnect();
		//getConnectMySQL();
		// TODO Auto-generated method stub

	}

}
