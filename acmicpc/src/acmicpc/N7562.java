package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7562 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcase = scn.nextInt();
		for(int tc=0; tc<testcase; tc++) {
			int l = scn.nextInt();
			int[] start = new int[2];
			int[] end = new int[2];
			start[0] = scn.nextInt();
			start[1] = scn.nextInt();
			end[0] = scn.nextInt();
			end[1] = scn.nextInt();
			
			System.out.println(bfs(start, end, l));
		}
		scn.close();
	}
	
	private static int bfs(int[] start, int[] end, int l) {
		Queue<Integer> a = new LinkedList<Integer>();
		Queue<Integer> b = new LinkedList<Integer>();
		boolean[][] visited = new boolean[l][l];
		int cnt = 0;
				
		a.offer(start[0]);	b.offer(start[1]);
		a.offer(-1);		b.offer(-1);
		visited[start[0]][start[1]] = true;
		
		while(!a.isEmpty()) {
			int a_idx = a.poll();
			int b_idx = b.poll();
			//System.out.println(a_idx + " " + b_idx);
			if(a_idx < 0) {
				cnt++;
				a.offer(-1);		b.offer(-1);
				continue;
			}
			if(a_idx == end[0] && b_idx == end[1])
				break;
			
			if(a_idx > 1 && b_idx > 0 && !visited[a_idx-2][b_idx-1]) {
				visited[a_idx-2][b_idx-1] = true;
				a.offer(a_idx-2);	b.offer(b_idx-1);
			}
			if(a_idx > 1 && b_idx < l-1 && !visited[a_idx-2][b_idx+1]) {
				visited[a_idx-2][b_idx+1] = true;
				a.offer(a_idx-2); 	b.offer(b_idx+1);
			}
			if(a_idx > 0 && b_idx > 1 && !visited[a_idx-1][b_idx-2]) {
				visited[a_idx-1][b_idx-2] = true;
				a.offer(a_idx-1);	b.offer(b_idx-2);
			}
			if(a_idx > 0 && b_idx < l-2 && !visited[a_idx-1][b_idx+2]) {
				visited[a_idx-1][b_idx+2] = true;
				a.offer(a_idx-1);	b.offer(b_idx+2);
			}
			if(a_idx < l-1 && b_idx > 1 && !visited[a_idx+1][b_idx-2]) {
				visited[a_idx+1][b_idx-2] = true;
				a.offer(a_idx+1);	b.offer(b_idx-2);
			}
			if(a_idx < l-1 && b_idx < l-2 && !visited[a_idx+1][b_idx+2]) {
				visited[a_idx+1][b_idx+2] = true;
				a.offer(a_idx+1);	b.offer(b_idx+2);
			}
			if(a_idx < l-2 && b_idx > 0 && !visited[a_idx+2][b_idx-1]) {
				visited[a_idx+2][b_idx-1] = true;
				a.offer(a_idx+2);	b.offer(b_idx-1);
			}
			if(a_idx < l-2 && b_idx < l-1 && !visited[a_idx+2][b_idx+1]) {
				visited[a_idx+2][b_idx+1] = true;
				a.offer(a_idx+2);	b.offer(b_idx+1);
			}
		}
		
		return cnt;
	}
}
