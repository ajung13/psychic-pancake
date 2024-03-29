package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N5214_failed {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int m = scn.nextInt();
		ArrayList<Integer>[] tube = new ArrayList[m];
		for(int i=0; i<m; i++) {
			tube[i] = new ArrayList<>();
			for(int j=0; j<k; j++)
				tube[i].add(scn.nextInt()-1);
			Collections.sort(tube[i]);
		}
		scn.close();
		
		System.out.print(bfs(tube, n));
	}
	private static int bfs(ArrayList<Integer>[] tube, int n) {
		if(n == 1)	return 1;
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> depth = new LinkedList<>();
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		q.offer(0);
		depth.offer(1);
		visited[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			int dep = depth.poll();
			for(int i=0; i<tube.length; i++) {
				if(!tube[i].contains(node))
					continue;
				for(int j=tube[i].indexOf(node)+1; j<tube[i].size(); j++) {
					int tmp = tube[i].get(j); 
					if(tmp == n-1)
						return dep+1;
					if(visited[tmp])	continue;
					visited[tmp] = true;
					q.offer(tmp);
					depth.offer(dep+1);
				}
			}
		}
		return -1;
	}
}
