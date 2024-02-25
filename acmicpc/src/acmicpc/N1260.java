package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1260 {

	static ArrayList<Integer>[] graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int M = scn.nextInt();
		int start = scn.nextInt();
		graph = new ArrayList[N+1];
		for(int i=1; i<N+1; i++)
			graph[i] = new ArrayList<Integer>();
		visited = new boolean[N+1];
		Arrays.fill(visited, false);
				
		for(int i=0; i<M; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			if(graph[a].contains(b))
				continue;
			graph[a].add(b);
			graph[b].add(a);
		}
		for(int i=1; i<N+1; i++)
			Collections.sort(graph[i]);
		scn.close();
		
		dfs(start);
		System.out.println();
		
		Arrays.fill(visited, false);
		bfs(start);
	}
	
	private static void dfs(int node) {
		visited[node] = true;
		System.out.print(node + " ");
		for(int i=0; i<graph[node].size(); i++){
			if(visited[graph[node].get(i)])
				continue;
			dfs(graph[node].get(i));
		}
	}
	private static void bfs(int node) {
		visited[node] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int next = queue.poll();
			System.out.print(next + " ");
			for(int i=0; i<graph[next].size(); i++) {
				int tmp = graph[next].get(i);
				if(!visited[tmp]) {
					visited[tmp] = true;
					queue.offer(tmp);
				}
			}
		}
	}
	
}
