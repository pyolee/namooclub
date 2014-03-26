package com.namoo.ns1.service.util;

import static org.junit.Assert.*;

import org.junit.Test;

import dom.entity.Community;

public class SequenceGeneratorTest {

	@Test
	public void testGetNextId() {
		//
		String seq = SequenceGenerator.getNextId(Community.class);
		String seq2 = SequenceGenerator.getNextId(Community.class);
		
		assertEquals(seq2, seq+1);
	}
}
