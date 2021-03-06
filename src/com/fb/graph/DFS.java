package com.fb.graph;

import java.util.ArrayList;

public class DFS<T> {

	/**
	 * DFS can be used:
	 * (a) To find Connected Components - Change color of a picture floodfill
	 * (b) Maze problems
	 * DFS can be pre/post/in order for a Binary Tree
	 * (c) DirectedGraph GC Mark and Sweep, Code Flow
	 * visit all 
	 */
	private final UnDirectedGraph<T> graph;
	private final ArrayList<T> visitedNodes = new ArrayList<T>();
	public DFS(UnDirectedGraph<T> graph){
		this.graph = graph;
	}
	
	public void dfs(T node){
		visitedNodes.add(node);
		for(T leafNode :graph.getAdjacentNodes(node)){
			if (!isVisited(leafNode)){
				dfs(leafNode);
			}
		}
	}
	
	public boolean isVisited(T node){
		return visitedNodes.contains(node);
	}
	
	public ArrayList<T> getVisitedNodes() {
		return visitedNodes;
	}
	
	public static void main(String[] args) {

		UnDirectedGraph<GraphNode> dg = new UnDirectedGraph<GraphNode>();
		GraphNode zero = new GraphNode("0");GraphNode one = new GraphNode("1");GraphNode two = new GraphNode("2");GraphNode three = new GraphNode("3");GraphNode four = new GraphNode("4");
		GraphNode five = new GraphNode("5");GraphNode six = new GraphNode("6");GraphNode seven = new GraphNode("7");GraphNode eight = new GraphNode("8");GraphNode nine = new GraphNode("9");
		dg.addNode(zero);dg.addNode(one);dg.addNode(two);dg.addNode(three);dg.addNode(four);dg.addNode(five);dg.addNode(six);dg.addNode(seven);
		dg.addEdge(zero, five);dg.addEdge(zero, one);dg.addEdge(zero, two);dg.addEdge(zero, six);
		dg.addEdge(six, seven);
		dg.addEdge(five,three);;dg.addEdge(four, five);
		/*
		 *             0
		 *          / / \ \
		 *        5  1  2  6
		 *      /  \      / 
		 *    3     4    7
		*/
		

		DFS<GraphNode> dfs = new DFS<GraphNode>(dg);
		dfs.dfs(zero);
		System.out.println(dfs.getVisitedNodes());
	}

}
