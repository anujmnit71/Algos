package com.linkedin.algos;

import java.util.HashSet;

public class Node<T> {
        Node<T> next;
        T val;
        public Node(T val){
                this(val, null);

        }
        public Node(T val, Node<T> next){
                this.val = val;
                this.next = next;
        }

        public T getVal() {
                return val;
        }
        public void setNext(Node<T> next) {
                this.next = next;
        }
        public Node<T> next() {
                return next;
        }
        @Override
        public String toString() {
                return val.toString();
        }

        public static <T> void printLL(Node<T> node){                
	        HashSet<Node<T>> hashSet = new HashSet<Node<T>>();
	        while (node != null){
	            if (hashSet.contains(node)){
	                    System.out.println("Cycle to -> " + node );
	                    return;
	            }
	            hashSet.add(node);
	            System.out.print(node+" -> "); node = node.next;
	        }
	        System.out.print(" null \n");
        }
}