package test;

import java.sql.*;

public class JDBCQuery {
	private static final int DEFAULT_PORT = 1972;

	public static String towncode(String disname,String townname) {
		disname = disname.split("������")[0];
		townname = townname.split("����Ժ")[0];
		
		String code = "";
		try {
			int port = determinePort();
			String url = "jdbc:Cache://localhost:1972/DHC-APP";
			String user = "_SYSTEM";
			String password = "SYS";
			String stQuery = "select * from CHSS.DictHospital where CommunityType='��������Ժ' and communityname like '%" + disname +"%"  + townname + "%'";
			//select * from CHSS.DictHospital where CommunityType='��������Ժ'  and communityname like '%����%'
			System.out.println(stQuery);

			Class.forName("com.intersys.jdbc.CacheDriver");
			Connection dbconnection = DriverManager.getConnection(url, user, password);
			Statement stmt = dbconnection.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(stQuery);
			ResultSetMetaData rsmd = rs.getMetaData();

			int colnum = rsmd.getColumnCount();
			while (rs.next()) {
//				for (int i = 1; i <= colnum; i++) {
//					System.out.print(rs.getString(i) + "  ");
//				}
//				System.out.println();
				code = rs.getString("CommunityCode");
			}

			dbconnection.close();
		} catch (Exception ex) {
			System.out.println("Caught exception: " + ex.getClass().getName()
					+ ": " + ex.getMessage());
		}
		return code;
	}

	
	public static String vilcode(String disname,String townname,String vilname){
		disname = disname.split("������")[0];
		townname = townname.split("����Ժ")[0];
		if(vilname.contains("������"))
			vilname = vilname.split("������")[0];
		else if(vilname.contains("����Ժ"))
			return towncode(disname,townname);//vilname = vilname.split("����Ժ")[0];
		
		String code = "";
		try {
			int port = determinePort();
			String url = "jdbc:Cache://localhost:1972/DHC-APP";
			String user = "_SYSTEM";
			String password = "SYS";
			String stQuery = "select * from CHSS.DictHospital where  CommunityType='��������' and communityname like '%" + disname + "%"  + townname  + "%" + vilname + "%'";
			//select * from CHSS.DictHospital where CommunityType='��������Ժ'  and communityname like '%����%'
			System.out.println(stQuery);

			Class.forName("com.intersys.jdbc.CacheDriver");
			Connection dbconnection = DriverManager.getConnection(url, user, password);
			Statement stmt = dbconnection.createStatement();
			java.sql.ResultSet rs = stmt.executeQuery(stQuery);
			ResultSetMetaData rsmd = rs.getMetaData();

			int colnum = rsmd.getColumnCount();
			while (rs.next()) {
//				for (int i = 1; i <= colnum; i++) {
//					System.out.print(rs.getString(i) + "  ");
//				}
//				System.out.println();
				code = rs.getString("CommunityCode");
			}

			dbconnection.close();
		} catch (Exception ex) {
			System.out.println("Caught exception: " + ex.getClass().getName()
					+ ": " + ex.getMessage());
		}
		return code;		
	}
	
	private final static int determinePort() throws Exception {
		String pt = System.getProperty("com.intersys.port");
		if (pt == null) {
			return DEFAULT_PORT;
		}

		int port = 0;
		try {
			port = Integer.parseInt(pt);
		} catch (NumberFormatException x) {
			throw new Exception("Invalid default port specified in "
					+ "system properties: " + pt);
		}

		return port;
	}

}
