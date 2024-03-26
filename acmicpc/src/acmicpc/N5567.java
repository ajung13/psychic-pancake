package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N5567 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		boolean[][] friend = new boolean[n][n];
		for(int i=0; i<n; i++)
			Arrays.fill(friend[i], false);
		for(int i=0; i<m; i++) {
			int a = scn.nextInt();
			int b = scn.nextInt();
			friend[a-1][b-1] = true;
			friend[b-1][a-1] = true;
		}
		scn.close();
		
		boolean[] invited = new boolean[n];
		Arrays.fill(invited, false);
		int cnt = 0;
		for(int i=1; i<n; i++) {
			if(friend[0][i]) {
				if(!invited[i]) {
					cnt++;
					invited[i] = true;
				}
				for(int j=1; j<n; j++) {
					if(friend[i][j] && !invited[j]) {
						cnt++;
						invited[j] = true;
					}
				}
			}
		}
		System.out.print(cnt);
	}
}
