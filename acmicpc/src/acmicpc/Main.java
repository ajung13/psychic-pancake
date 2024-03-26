package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static ArrayList<Integer>[] path;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int m = scn.nextInt();
		path = new ArrayList[n];
		for(int i=0; i<n; i++)	path[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			int a = scn.nextInt();
			int b;
			for(int j=0; j<k-1; j++) {
				b = scn.nextInt();
				path[a-1].add(b-1);
				path[b-1].add(a-1);
				a = b;
			}
		}
		scn.close();
		
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		System.out.print(bfs(visited, n-1));
	}
	private static int bfs(boolean[] visited, int goal) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> depth = new LinkedList<>();
		q.offer(0);
		depth.offer(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			int dept = depth.poll();
			if(node == goal)
				return dept;
			for(int i=0; i<path[node].size(); i++) {
				int next = path[node].get(i); 
				if(!visited[next]) {
					q.offer(next);
					depth.offer(dept+1);
					visited[next] = true;
				}
			}
		}
		return -1;
	}
}