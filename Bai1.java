package Baitap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Bai1 {

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
			while (result.next())
			{
				System.out.println(rs.getColumnName(1) + "=" + result.getString("Id")+" " +rs.getColumnName(2) + "="+result.getString("Name")+" "+rs.getColumnName(3) +"="+result.getString("Address")+" "+rs.getColumnName(4)+"="+result.getString("Total"));
	
			}

		}catch (Exception e) 
		{
			
			System.out.println("Erro" + e);
		}
		return conn;
	}
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
			while (result.next())
			{
				System.out.println(rs.getColumnName(1) + "=" + result.getString("Id")+" " +rs.getColumnName(2) + "="+result.getString("Name")+" "+rs.getColumnName(3) +"="+result.getString("Address")+" "+rs.getColumnName(4)+"="+result.getString("Total"));
	
			}

		}catch (Exception e) 
		{
			
			System.out.println("Erro" + e);
		}
		return conn;
		
	}
	public static void main(String[] args) throws SQLException {
		//Bai1 b1 = new Bai1();
		getConnect();
		//getConnectMySQL();
		
	}

}
