package com.workday.range.impl;

import java.util.Comparator;
/**
 * Comparator class used to compare node based on the value of the node
 * @author sjeyaku
 *
 */
public class ValueComparator implements Comparator<Node> {
	@Override
    public int compare(Node e1, Node e2) {
		if(e1.getValue() > e2.getValue()){
            return 1;
        } else {
            return -1;
        }
    }
}
