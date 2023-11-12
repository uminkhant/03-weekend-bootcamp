package com.jdc.mkt.test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.jdc.mkt.entity.Address;
import com.jdc.mkt.entity.Contact;
import com.jdc.mkt.entity.Parent;

public class AccountTest extends JpaFactory{

	@ParameterizedTest
	@CsvSource({
		"AungAung,aung12,123,java,1,1",
		"SuSu,sussusu,222,Spring,2,2"})
	void test(String name,String loginId,String password,String course,int contactId,int addressId) {
		
		var parent = new Parent();
		parent.setName(name);
		parent.setLoginId(loginId);
		parent.setPassword(password);
		
		var address = new Address();
		address.setId(addressId);
		parent.setAddress(address);
		
		var contact1 = new Contact("aungaung@gmail.com","0942342323");
		var contact2 = new Contact("aungaung11@gmail.com","092342322");
		parent.setPrimaryContact(contact1);
		parent.setSecondaryontact(contact2);
		
//		var teacher = new Teacher();
//		teacher.setLoginId(loginId);
//		teacher.setName(name);
//		teacher.setPassword(password);
//		teacher.setCourse(course);
		
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		//em.persist(teacher);
		em.persist(parent);
		em.getTransaction().commit();
	}
}
