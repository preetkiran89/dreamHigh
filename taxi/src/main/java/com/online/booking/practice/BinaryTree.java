package com.online.booking.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Node
{
	Node left;
	Node right;
	int value;
	
	public Node(int value){
		this.left = null;
		this.right = null;
		this.value = value;
	}
}

public class BinaryTree 
{
    Node root;
    
    private Node addRecursive(Node current, int value){
       if(current == null)
    	   return new Node(value);
       
       if(value > current.value)
    	   current.right = addRecursive(current.right, value);
       else if (value < current.value) 
    	   current.left = addRecursive(current.left, value);
       else 
    	   return current;
    	
       return current;	
    }
    
    public void addNode(int value){
    	root = addRecursive(root, value);
    }
    
    private boolean findNodeInBinaryTree(Node current, int value){
    	if(current == null)
    		return false;
    	
    	if(value == current.value)
    		return true;
    	
    	return value < current.value
    		      ? findNodeInBinaryTree(current.left, value)
    		      : findNodeInBinaryTree(current.right, value);
    }
    
    public boolean containsNode(int value){
    	return findNodeInBinaryTree(root,value); 			
    }
    
    private Node deleteRecursive(Node current, int value){
    	if(current == null)
    		return null;
    	if(current.value == value){
    		if(current.left == null & current.right == null){
    			return current;
    		}
    		else if(current.left == null){
    			return current.right;
    		}
    		else if(current.right == null){
    			return current.left;
    		}
    		else if(current.left != null && current.right != null){
    			Node temp = current.right;
    			//run loop until right child is null
    		}
    	}
    		
    	return current;    	
    }
    
    public void deleteNode(int value){
         deleteRecursive(root, value);	
    }
    
    public static int[] a() {
    	Map<Integer,Integer> l = new TreeMap<>(new Comparator<Integer>() {
    		
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});
    	return new int[] {1};
    }
    
    public static void main(String args[]){
	    List<Integer> wd = new ArrayList<>();
	    Object[] d = wd.toArray();
    	BinaryTree binaryTree = new BinaryTree();
		binaryTree.addNode(3);
		binaryTree.addNode(4);
		binaryTree.addNode(7);
		binaryTree.addNode(2);
		System.out.println(binaryTree.containsNode(2));
    }
}
