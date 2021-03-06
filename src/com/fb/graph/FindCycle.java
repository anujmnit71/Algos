package com.fb.graph;

import java.util.HashSet;

public class FindCycle<T> {

	/**
	 * Finding cycle in an Directed Graph. Like a topologocal sort
	 * Run on all nodes and do dfs
	 */
	private DirectedGraph<T> graph;
	private HashSet<T> visited = new HashSet<T>();
	private HashSet<T> completed = new HashSet<T>();
	
	public FindCycle(DirectedGraph<T> graph){
		this.graph = graph;
	}
	
	public void findCycle(){
		for(T node: graph){
			if(!visited.contains(node)){
				dfs(node, new HashSet<T>());
			}
		}
	}
	public void dfs(T node,HashSet<T> parentNodes){
		visited.add(node);
		for(T leaf : graph.getAdjacentNodes(node)){
			parentNodes.add(node);
			if(parentNodes.contains(leaf)){
				throw new IllegalStateException("Cycle Detected");
			}
			if(!visited.contains(leaf)){
				dfs(leaf, parentNodes);
			}
		}
	}
	
	public static void main(String[] args) {
		DirectedGraph<GraphNode> dg = new DirectedGraph<GraphNode>();
		GraphNode zero = new GraphNode("0");GraphNode one = new GraphNode("1");GraphNode two = new GraphNode("2");GraphNode three = new GraphNode("3");GraphNode four = new GraphNode("4");
		GraphNode five = new GraphNode("5");GraphNode six = new GraphNode("6");GraphNode seven = new GraphNode("7");GraphNode eight = new GraphNode("8");GraphNode nine = new GraphNode("9");
		dg.addNode(zero);dg.addNode(one);dg.addNode(two);dg.addNode(three);dg.addNode(four);
		dg.addEdge(zero, one);dg.addEdge(one, two);dg.addEdge( zero, two); dg.addEdge(four,one); 
		//dg.addEdge( two, zero);  UNCOMMENT TO SEE CYCLE DETECTED
		/*    4   0
		 *     \ / \
		 *      1-->2  
		 */
		FindCycle<GraphNode> fc = new FindCycle<GraphNode>(dg);
		try {
			fc.findCycle();
			System.out.println("No Cycle Detected");
		} catch (IllegalStateException ex) {
			System.out.println("Cycle Detected");
		}
		int x = 8;
		System.out.println((x & (x-1))==0);//if x is power of 2
		System.out.println("unhappy".substring(2,7).equals("unhappy".substring(2))); //same
		String check = "ilikesamsung";
		int i =3;
		System.out.println(check.substring(0,i)+" "+ check.substring(i, check.length()-i)+" "+check.substring(i));
		
		
		
	}
}