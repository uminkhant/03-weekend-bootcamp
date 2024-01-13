package com.jdc.mkt.repo;

import java.util.HashMap;
import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import com.jdc.mkt.entity.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class ProductSearchRepoDefault implements ProductSearchRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Product> search( String cName, String pName, Integer sPrice, Integer ePrice) {
		
		var sb = new StringBuilder("select p from Product p where 1 = 1");
		var map = new HashMap<String, Object>();
		
		if(StringUtils.hasLength(cName)) {
			sb.append(" and p.category.name = :cName");
			map.put("cName", cName);
		}
		if(StringUtils.hasLength(pName)) {
			sb.append(" and p.name = :pName");
			map.put("pName", pName);
		}
		
		if(null != sPrice && sPrice > 0) {
			sb.append(" and p.dtPrice >= :sPrice");
			map.put("sPrice", sPrice);
		}
		
		if(null !=ePrice && ePrice > 0) {
			sb.append(" and p.dtPrice <= :ePrice");
			map.put("ePrice", ePrice);
		}
		var query = em.createQuery(sb.toString(),Product.class);
		
		for(var entry : map.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		return query.getResultList();
	}

}
