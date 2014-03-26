package com.namoo.ns1.service.util;

import com.namoo.ns1.data.EntityManager;

import dom.entity.IdValue;

public class SequenceGenerator {
	
	public static <T> String getNextId(Class<T> clazz) {
		//
		EntityManager em = EntityManager.getInstance();
		
		String idKey = clazz.getName();
		IdValue idValue = em.find(IdValue.class, idKey);
		
		if(idValue == null) {
			idValue = new IdValue(idKey);
		}
		
		idValue.increase();
		em.store(idValue);
		
		return idValue.getValue() + "";
	}
}
