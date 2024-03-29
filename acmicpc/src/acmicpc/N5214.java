package acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N5214 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int m = scn.nextInt();
		ArrayList<Integer>[] tube = new ArrayList[n+m];
		for(int i=0; i<n+m; i++)
			tube[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<k; j++) {
				int tmp = scn.nextInt()-1;
				tube[tmp].add(n+i);
				tube[n+i].add(tmp);
			}
		}
		scn.close();
		
		System.out.print(bfs(tube, n, m));
	}
	private static int bfs(ArrayList<Integer>[] tube, int n, int m) {
		int[] distance = new int[n+m];
		boolean[] visited = new boolean[n+m];
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);	distance[0] = 1; visited[0] = true;
		while(!q.isEmpty()) {
			int from = q.poll();
			for(int i=0; i<tube[from].size(); i++) {
				int to = tube[from].get(i);
				if(visited[to])	continue;
				visited[to] = true;
				distance[to] = distance[from]+1;
				q.offer(to);
			}
		}
		return visited[n-1]? (distance[n-1]/2 + 1):-1;
	}

}
