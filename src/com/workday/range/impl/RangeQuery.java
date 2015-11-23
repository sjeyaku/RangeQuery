package com.workday.range.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.workday.range.Ids;
import com.workday.range.RangeContainer;
/**
 * Range query implementation class
 * @author sjeyaku
 *
 */
public class RangeQuery implements  RangeContainer{
    Node root;
	
	/**
	 * Recursive method to create binary search tree from a sorted array
	 * @param data - sorted array
	 * @param left - left most index of the array
	 * @param right - right most index of the array
	 * @return - root of the binary search tree
	 */
    public Node createBST(List<Node> data, int left, int right){
      if(left>right){
    	  return null;
      }
      
      if(data == null || data.size() == 0){
    	  return null;
      }
      // calculate the mid index from the left and right
      int mid = (left+right)/2;
      Node root = data.get(mid);
      // recursively call createBST method to build its left and right components      
      root.left(createBST(data, left, mid-1));
      root.right(createBST(data, mid+1, right));
      return root;
	}

	/**
	 * Method to perform binary search operation on given tree
	 * @param root - Root node of the given tree
	 * @param fromValue - starting value
	 * @param toValue - ending value
	 * @param fromInclusive - if true, include the starting value, exclude otherwise
	 * @param toInclusive - if true, include the ending value, exclude otherwise
	 * @param Ids - returns a List of Ids
	 */
    private static void rangeSearchTree(Node root, long fromValue, long toValue, boolean fromInclusive, boolean toInclusive, List<Node> Ids) {
       	// store the left and right child of the given root	
    	Node leftChild = root.left();
	    Node rightChild = root.right();
	    
        // if left is not null and the given root node is greater than the fromValue,
	    // recursively search the left side of the tree
	    if(leftChild != null && root.getValue() >= fromValue){
	    	rangeSearchTree(leftChild, fromValue, toValue,fromInclusive, toInclusive, Ids);
	    } 
	    // if right is not null and the given root node is less than the toValue,
	    // recursively search the right side of the tree
	    if(rightChild != null && root.getValue() <= toValue){
	    	rangeSearchTree(rightChild,fromValue,toValue,fromInclusive, toInclusive, Ids);
	    }
	    
	    if(fromInclusive && toInclusive){
	    	if(root.getValue() >= fromValue && root.getValue() <= toValue){
	    		Ids.add(root);
	    	}
	    }else if(!fromInclusive && toInclusive){
	    	if(root.getValue() > fromValue && root.getValue() <= toValue){
	    		Ids.add(root);
	    	}
	    	
	    }else if(!fromInclusive && !toInclusive){
	    	if(root.getValue() > fromValue && root.getValue() < toValue){
	    		Ids.add(root);
	    	}
	    	
	    }else if(fromInclusive && !toInclusive){
	    	if(root.getValue() >= fromValue && root.getValue() < toValue){
	    		Ids.add(root);
	    	}
	    	
	    }
    	    
	}
    /**
     * Method to return the range of sorted indexes for the given range in this container, return null otherwise
     */
	@Override
	public RangeLinkedList<Node> findIdsInRange(long fromValue, long toValue,
			boolean fromInclusive, boolean toInclusive) {		
		if(root != null){
			RangeLinkedList<Node> Ids = new RangeLinkedList<Node>();
			rangeSearchTree(root,fromValue, toValue, fromInclusive, toInclusive,Ids);
			Collections.sort(Ids, new IdsComparator());
			return Ids;
		}
		return null;
	}
   
	private class RangeLinkedList<E> extends LinkedList<E> implements Ids {
	   private int index = 0;
       
	   /**
	    * Method to return the next index of the given List collection object, if end of the list return END_OF_IDS
	    */
		@Override
		public int nextId() {
			
			if(index > this.size()-1) {
			  index = 0;
			  return END_OF_IDS;
			}
			else{
				Node n = (com.workday.range.impl.Node) this.get(index);
				if (n != null) {
					index++;
					return n.getIndex();
				} 
			}
			return -1;
			
		}
	}

}
