package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N2309 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int[] talls = new int[9];
		int sum = 0;
		for(int i=0; i<9; i++) {
			talls[i] = scn.nextInt();
			sum += talls[i];
		}
		scn.close();
		
		Arrays.sort(talls);
		int x=-1, y=-1;
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum - talls[i] - talls[j] == 100) {
					x = i;	y = j;
					break;
				}
			}
			if(x > 0)	break;
		}
		
		for(int k=0; k<9; k++){
			if(k == x || k == y)	continue;
			System.out.println(talls[k]);
		}
	}
}
