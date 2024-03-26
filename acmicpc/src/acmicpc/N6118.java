package acmicpc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N6118 {
	private static ArrayList<Integer>[] path;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		path = new ArrayList[n];
		for(int i=0; i<n; i++)
			path[i] = new ArrayList<>();
		for(int i=0; i<m; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			path[a-1].add(b-1);
			path[b-1].add(a-1);
		}
		scn.close();
		
		int[] distance = new int[n];
		boolean[] visited = new boolean[n];
		bfs(visited, distance);
		
		int max = -1, idx = -1;
		for(int i=0; i<n; i++) {
			if(distance[i] > max) {
				max = distance[i];
				idx = i;
			}
		}
		System.out.print((idx+1) + " " + max + " ");
		idx = 0;
		for(int i=0; i<n; i++) {
			if(distance[i] == max)
				idx++;
		}
		System.out.print(idx);
	}
	private static void bfs(boolean[] visited, int[] distance) {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> q_depth = new LinkedList<>();
		q.offer(0);
		q_depth.offer(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			distance[node] = q_depth.poll();
			for(int i=0; i<path[node].size(); i++) {
				int num = path[node].get(i);
				if(!visited[num]) {
					visited[num] = true;
					q.offer(num);
					q_depth.offer(distance[node]+1);
				}
			}
		}
		return;
	}
}
