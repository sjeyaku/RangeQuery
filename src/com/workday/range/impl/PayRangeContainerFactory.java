package com.workday.range.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.workday.range.RangeContainerFactory;

public class PayRangeContainerFactory implements RangeContainerFactory{

	@Override
	public RangeQuery createContainer(long[] data) {
		RangeQuery rm = new RangeQuery();
		List<Node> inputObjList = new LinkedList<Node>();
		// Builds a node list where each node contains value and an index
		for(int i=0;i<data.length; i++){
			inputObjList.add(new Node(data[i],i));
		}
		// sort the list using ValueComparator
		Collections.sort(inputObjList, new ValueComparator());
		// create bst from the given input array
		rm.root = rm.createBST(inputObjList, 0,inputObjList.size()-1);
		return rm;
	}	
	
}
