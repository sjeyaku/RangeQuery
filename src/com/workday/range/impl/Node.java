package com.workday.range.impl;
/**
 * Node class to store value and index of the given input array
 * Along with this , it also store the left and right nodes
 * @author sjeyaku
 *
 */
public class Node{
	private long value;
	private int index;
	private Node left;
	private Node right;
	
	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public Node(long value, int index){
		this.value = value;
		this.index = index;
	}
	
	public void left(Node left){
		this.left = left;
	}
	
	public void right(Node right){
		this.right = right;
	}
	
	public Node right(){
		return right;
	}
	
	public Node left(){
		return left;
	}
}

