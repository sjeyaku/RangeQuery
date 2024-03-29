package com.workday.range.test;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.workday.range.Ids;
import com.workday.range.RangeContainerFactory;
import com.workday.range.impl.PayRangeContainerFactory;
import com.workday.range.impl.RangeQuery;


public class RangeQueryTest {

	private RangeQuery rc;

	@Before
	public void setUp(){
	  RangeContainerFactory rf = new PayRangeContainerFactory();
	  rc = rf.createContainer(new long[]{10,12,17,21,2,15,16});
	}

	@Test
	public void runARangeQuery(){
	  
	  Ids ids = rc.findIdsInRange(14, 17, true, true);
	  
	  assertEquals(2, ids.nextId());
	  assertEquals(5, ids.nextId());
	  assertEquals(6, ids.nextId());
	  assertEquals(Ids.END_OF_IDS, ids.nextId());
	
	  ids = rc.findIdsInRange(14, 17, true, false);
	  assertEquals(5, ids.nextId());
	  assertEquals(6, ids.nextId());
	  assertEquals(Ids.END_OF_IDS, ids.nextId());
	
	  ids = rc.findIdsInRange(20, Long.MAX_VALUE, false, true);
	  assertEquals(3, ids.nextId());
	  assertEquals(Ids.END_OF_IDS, ids.nextId());
	 
	}

}
