package com.jdc.mkt;

import static com.jdc.mkt.utils.MysqlConnection.getConnection;
public class JDBCPreparedStatementDemo {

	public int insertData(String name) {
		String query = "insert into data_tbl values (?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(query)){
			
			stmt.setString(1, name);
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
