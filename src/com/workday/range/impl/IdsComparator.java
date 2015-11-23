package com.workday.range.impl;

import java.util.Comparator;
/**
 * Comparator class to compare nodes using the index of the node
 * @author sjeyaku
 *
 */
public class IdsComparator implements Comparator<Node> {
	@Override
    public int compare(Node e1, Node e2) {
		if(e1.getIndex() > e2.getIndex()){
            return 1;
        } else {
            return -1;
        }
    }
}
