package com.jdc.mkt;

import static com.jdc.mkt.utils.MysqlConnection.getConnection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCStatementDemo {	
	public List<String> selectData() throws SQLException {
		var list = new ArrayList<String>();
		String query = "select * from data_tbl";
		
		try(var con = getConnection();
			Statement stmt = con.createStatement()){		
			var rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String s = rs.getString("name");
				list.add(s);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertData(String data) {
		String query = "insert into data_tbl(name) values('%s') "
						.formatted(data);
		
		try(var con = getConnection();
			Statement stmt = con.createStatement()){		
			var count = stmt.executeUpdate(query);
			return count;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void truncatTest() {
		String query1 = "truncate table data_tbl";
		String query2 = "insert into data_tbl(name) values('aung aung'),('soe san')";
		try(var con = getConnection();
				Statement stmt = con.createStatement()){		
				stmt.addBatch(query1);
				stmt.addBatch(query2);
				stmt.executeBatch();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
