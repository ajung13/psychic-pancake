package acmicpc;
// No.1652

import java.util.Scanner;

public class N1652 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		boolean[][] space = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String line = scn.next();
			for(int j=0; j<N; j++)
				space[i][j] = (line.charAt(j) == '.')? true:false;
		}
		scn.close();
		
		int cnt = 0;
		boolean flag = false;
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(!space[i][j-1])	continue;
				if(space[i][j])	flag = true;
				else if(flag) {
					flag = false;
					cnt++;
				}
			}
			if(flag) {
				flag = false;
				cnt++;
			}
		}
		System.out.print(cnt + " ");

		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				if(!space[j-1][i])	continue;
				if(space[j][i])	flag = true;
				else if(flag) {
					flag = false;
					cnt++;
				}
			}
			if(flag) {
				flag = false;
				cnt++;
			}
		}
		System.out.print(cnt);
	}
}
