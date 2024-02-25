package acmicpc;

import java.util.Scanner;

public class N8979 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int K = scn.nextInt();
		int k_idx = -1;
		int[][] array = new int[N][5];
		for(int i=0; i<N; i++) {
			for(int j=0; j<4; j++) {
				array[i][j] = scn.nextInt(); 
			}
			array[i][4] = 1;
			if(array[i][0] == K)
				k_idx = i;
		}
		scn.close();
		
		int rank = 0;
		for(int j=1; j<4; j++) {
			for(int i=0; i<N; i++) {
				if(array[i][4] > 0 && array[i][j] > array[k_idx][j])
					rank++;
				if(array[i][j] != array[k_idx][j])
					array[i][4] = 0;
			}
		}
		
		System.out.print(rank+1);
	}
}
