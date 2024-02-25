package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N1012 {
	static boolean[][] jeon;
	static int M, N;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int testcase = scn.nextInt();
		for(int i=0; i<testcase; i++) {
			M = scn.nextInt();
			N = scn.nextInt();
			jeon = new boolean[N][M];
			for(int j=0; j<N; j++)
				Arrays.fill(jeon[j], false);
			int lines = scn.nextInt();
			for(int j=0; j<lines; j++) {
				int x = scn.nextInt();
				int y = scn.nextInt();
				jeon[y][x] = true; 
			}
			
			int bug_count = 0;
			for(int j=0; j<N; j++) {
				for(int k=0; k<M; k++) {
					if(jeon[j][k]) {
						bug_count++;
						dfs(j, k);
					}
				}
			}
			
			System.out.println(bug_count);
		}
		scn.close();
	}
	
	private static void dfs(int x, int y) {
		jeon[x][y] = false;
		if(x>0 && jeon[x-1][y])
			dfs(x-1, y);
		if(x<N-1 && jeon[x+1][y])
			dfs(x+1, y);
		if(y>0 && jeon[x][y-1])
			dfs(x, y-1);
		if(y<M-1 && jeon[x][y+1])
			dfs(x, y+1);
	}

}
