package com.jdc.mkt.service;

import static com.jdc.mkt.utils.MyConnection.getConnection;

import java.util.List;

import com.jdc.mkt.entity.Contact;

public class ContactService implements CrudOperation<Contact>{

	@Override
	public int insert(Contact contact) {
		String sql = "insert into contact_tbl(primary_contact,secondary_contact,email)values (?,?,?)";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, contact.getPrimaryContact());
			stmt.setString(2, contact.getPrimaryContact());
			stmt.setString(3, contact.getEmail());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Contact contact) {
		String sql = "update contact_tbl set primary_contact =?,secondary_contact =? ,email = ? where id =? and active =1";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setString(1, contact.getPrimaryContact());
			stmt.setString(2, contact.getPrimaryContact());
			stmt.setString(3, contact.getEmail());
			stmt.setInt(4, contact.getId());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Contact contact) {
		String sql = "update contact_tbl set active = ? where id =? and active =1";
		try(var con = getConnection();
				var stmt = con.prepareStatement(sql)){
			
			stmt.setBoolean(1, contact.isActive());
			stmt.setInt(2, contact.getId());
			
			return stmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Contact> select(Contact t) {
		return null;
	}

}
