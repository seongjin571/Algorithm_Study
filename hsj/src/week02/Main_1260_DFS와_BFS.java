package week02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main_1260_DFS와_BFS {
	static Scanner scan = new Scanner(System.in);
	static final int NODE_NUM = scan.nextInt();;
	static final int ROW_NUM = scan.nextInt();;
	static final int START_NODE = scan.nextInt();
	static int[][] array = new int[NODE_NUM + 1][NODE_NUM + 1];
	static boolean[] dfsVisit = new boolean[NODE_NUM + 1];
	static boolean[] bfsVisit = new boolean[NODE_NUM + 1];

	static void dfs(int node) {
		Stack<Integer> stack = new Stack<>();
		stack.push(node);
		dfsVisit[node] = true;
		System.out.printf("%d ", node);
		int standardNode;
		while (!stack.isEmpty()) {
			boolean flag = false;
			standardNode = stack.peek();
			for (int i = 1; i <= NODE_NUM; i++) {
				if (array[standardNode][i] == 1 && !dfsVisit[i]) {
					dfsVisit[i] = true;
					stack.push(i);
					System.out.printf("%d ", i);
					flag = true;
					break;
				}
			}
			if(!flag)
				stack.pop();
		}
		System.out.println("");
	}
	
	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		bfsVisit[node] = true;
		int standardNode;
		while(!queue.isEmpty()) {
			standardNode = queue.poll();
			System.out.printf("%d ", standardNode);
			for(int i = 1; i <= NODE_NUM; i++) {
				if(array[standardNode][i] == 1 && !bfsVisit[i]) {
					queue.add(i);
					bfsVisit[i] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		for (int i = 1; i <= ROW_NUM; i++) {
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			array[node1][node2] = 1;
			array[node2][node1] = 1;
		}
		dfs(START_NODE);
		bfs(START_NODE);
	}


}
