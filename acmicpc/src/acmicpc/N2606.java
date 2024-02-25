package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class N2606 {
	static ArrayList<Integer>[] graph;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		graph = new ArrayList[N];
		visited = new boolean[N];
		Arrays.fill(visited, false);
		for(int i=0; i<N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		int lines = scn.nextInt();
		for(int i=0; i<lines; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			graph[a-1].add(b-1);
			graph[b-1].add(a-1);
		}
		scn.close();
		
		visited[0] = true;
		System.out.print(dfs(0, -1));
	}
	private static int dfs(int node, int cnt) {
		cnt++;
		visited[node] = true;
		for(int i=0; i<graph[node].size(); i++) {
			if(visited[graph[node].get(i)])	continue;
			cnt = dfs(graph[node].get(i), cnt);
		}
		return cnt;
	}
}
