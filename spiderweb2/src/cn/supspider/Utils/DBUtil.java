package cn.supspider.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private String driver;
	private String url;
	private String username;
	private String password;
	private Connection conn;
	private Statement statement;
	private ResultSet rs;
	
	public DBUtil(){
		driver="com.mysql.jdbc.Driver";	
		url="jdbc:mysql:///netspider";
		username="root";
		password="1069";
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加入驱动异常");
			e.printStackTrace();
		}	
	}
	public int DBupdata(String sql){
		int result=0;
			try {
				if(conn == null){
				conn=DriverManager.getConnection(url, username, password);
				}
				if(statement == null){
				statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);	
				}
				result=statement.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("更新数据库异常");
				System.out.println(sql);
				e.printStackTrace();
			}
				
		return result;
	}
	public ResultSet DBQuery(String sql){
			try {
				if(conn == null){
					conn=DriverManager.getConnection(url, username, password);
				}
				if(statement == null){
					statement=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);		
				}
				rs=statement.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("查询数据库异常");
				System.out.println(sql);
				e.printStackTrace();
			}
		return rs;
	}
	public void CloseAll(){
		try {
			if(rs != null){
			rs.close();
			}
			if(statement != null){
			statement.close();
			}
			if(conn != null){
			conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
