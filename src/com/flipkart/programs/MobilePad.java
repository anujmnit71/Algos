package com.flipkart.programs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MobilePad {

	/**
	 * Given the mobile numeric keypad. You can only press buttons that are up, left, right or down to the current button. 
	 * You are not allowed to press bottom row corner buttons (i.e. * and # ).
	 * 
	 * Given a number N, find out the number of possible numbers of given length.
	 * @param graph 
	 * @param visited 
	 */
	private static final int N = 3;
	private static int count = 0;
	
	public static void findPath(UnDirectedGraph<Node> graph){
		//Do Dfs from all nodes.
		for (Node node : graph){
			List<Node> visited = new ArrayList<Node>();
			node.hd = 1;
			dfs(node, graph, visited);
		}
	}
	
	public static void dfs(Node node, UnDirectedGraph<Node> graph, List<Node> visited){
		visited.add(node);
		if(node.hd==N) {
			System.out.print(visited	); count++;
			visited.remove(node);
			return;
		}
		for(Node leaf : graph.getAdjecent(node)){
			if(!visited.contains(leaf)){
				leaf.hd = node.hd+1;
				dfs(leaf, graph, visited);
			}
		}
		visited.remove(node);
		//dfs(node, graph, visited);
	}
	
	
	public static void main(String[] args) {
		MobilePad pad = new MobilePad();
		UnDirectedGraph<Node> graph = pad.new UnDirectedGraph<Node>();

		Node zero = pad.new Node(0);Node one = pad.new Node(1);Node two = pad.new Node(2);Node three = pad.new Node(3);
		Node four = pad.new Node(4);Node five = pad.new Node(5);Node six = pad.new Node(6);Node seven = pad.new Node(7);
		Node eight = pad.new Node(8);Node nine = pad.new Node(9);
		
		graph.addNode(zero);graph.addNode(one);graph.addNode(two);graph.addNode(three);
		graph.addNode(four);graph.addNode(five);graph.addNode(six);graph.addNode(seven);
		graph.addNode(eight);graph.addNode(nine);
		
		graph.addEdge(zero, eight);
		graph.addEdge(one, two);graph.addEdge(one, four);
		graph.addEdge(two, one);graph.addEdge(two, five);graph.addEdge(two, three);
		graph.addEdge(three, two);graph.addEdge(three, six);
		graph.addEdge(four, one);graph.addEdge(four, five);graph.addEdge(four, seven);
		graph.addEdge(five, two);graph.addEdge(five, six);graph.addEdge(five, four);graph.addEdge(five, eight);
		graph.addEdge(six, three);graph.addEdge(six, five);graph.addEdge(six, nine);
		graph.addEdge(seven, four);graph.addEdge(seven, eight);
		graph.addEdge(eight, five);graph.addEdge(eight, seven);graph.addEdge(eight, nine);graph.addEdge(eight, zero);
		graph.addEdge(nine,six);graph.addEdge(nine, eight);
		
		findPath(graph);
		System.out.println("\n "+count);
	}

	private class UnDirectedGraph<T> implements Iterable<T>{
		private final HashMap<T, HashSet<T>> graph =  new HashMap<T, HashSet<T>>();
		public void addNode(T node){
			graph.put(node,new HashSet<T>());
			addEdge(node, node);
		}
		public void addEdge(T src, T dest){
			if(!graph.containsKey(src) || !graph.containsKey(dest)){
				throw new IllegalArgumentException();
			}
			graph.get(src).add(dest);
			graph.get(dest).add(src);
		}
		public HashSet<T> getAdjecent(T node){
			return graph.get(node);
		}
		
		public Iterator<T> iterator(){
			return graph.keySet().iterator();
		}
		
	}
	
	private final class Node{
		int val;
		int hd;
		public Node(int val, int hd){
			this.val = val;
			this.hd = hd;
		}
		public Node(int val){
			this.val = val;
		}
		@Override
		public int hashCode(){
			return ((Integer)val).hashCode();
		}
		@Override
		public boolean equals(Object obj){
			if(obj==this) return true;
			if ( !(obj instanceof Node)){
				return false;
			}
			
			return ((Node)obj).val == this.val;
		}
		@Override
		public String toString(){
			return Integer.toString(val);
		}
	}
}
