package com.jdc.mkt.service;

import java.util.ArrayList;
import java.util.List;

import com.jdc.mkt.entity.dto.CustomerCountByHotel;
import static com.jdc.mkt.utils.MyConnection.getConnection;

public class CustomerService {

	public List<CustomerCountByHotel> getCustomers(String name){
		List<CustomerCountByHotel> list = new ArrayList<CustomerCountByHotel>();
		
		String sql = """
				select c.name name,count(tr.customer_id) qty from transaction_tbl tr 
				join customer_tbl c on tr.customer_id = c.id
				join room_tbl r on tr.room_id = r.id
				join hotel_tbl h on r.hotel_id = h.id
				where h.name = ? group by c.name;
				""";
		
		try(var con = getConnection();
			var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, name);
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var c = new CustomerCountByHotel(
						rs.getString("name"),
						rs.getLong("qty"));
				list.add(c);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public List<CustomerCountByHotel> getCustomersWithProcedure(String name){
		List<CustomerCountByHotel> list = new ArrayList<CustomerCountByHotel>();
		String sql = "{call customerCountByHotelName(?)}";
		try(var con = getConnection();
			var stmt = con.prepareCall(sql)){
			
			stmt.setString(1, name);
			var rs = stmt.executeQuery();
			
			while(rs.next()) {
				var c = new CustomerCountByHotel(
						rs.getString("name"),
						rs.getLong("count(tr.customer_id)"));
				list.add(c);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
