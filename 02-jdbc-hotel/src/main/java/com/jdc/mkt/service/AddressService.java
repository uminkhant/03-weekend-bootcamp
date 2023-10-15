package com.jdc.mkt.service;

import com.jdc.mkt.entity.Address;
import static com.jdc.mkt.utils.MyConnection.getConnection;

public class AddressService implements CrudOperation<Address>{
	
	@Override
	public int insert(Address address) {
		String sql = "insert into address_tbl(street,township,city)values (?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, address.getStreet());
			stmt.setString(2, address.getTownship());
			stmt.setString(3, address.getCity());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Address address) {
		String sql = "update address_tbl set street=?,township =?,city = ? where id =? and active=1";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, address.getStreet());
			stmt.setString(2, address.getTownship());
			stmt.setString(3, address.getCity());
			stmt.setInt(4, address.getId());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Address address) {
		String sql = "update address_tbl set active=? where id =? and active=1";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setBoolean(1, address.isActive());
			stmt.setInt(2, address.getId());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Address select(Address t) {
		// TODO Auto-generated method stub
		return null;
	}

}
