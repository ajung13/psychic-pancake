package acmicpc;

import java.util.Scanner;

public class N2816 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		int[] channel = new int[N];
		int kbs1 = 0, kbs2 = 0;
		for(int i=0; i<N; i++) {
			String input = scn.next();
			if(input.equals("KBS1")) {
				channel[i] = 1;
				kbs1 = i;
			}
			else if(input.equals("KBS2")) {
				channel[i] = 2;
				kbs2 = i;
			}
			else
				channel[i] = 0;
		}
		scn.close();
		
		System.out.print("1".repeat(kbs1));
		System.out.print("4".repeat(kbs1));
		if(kbs2 == 0)	return;
		System.out.print("1".repeat(kbs2));
		if(kbs2 < kbs1)	System.out.print("1");
		System.out.print("4".repeat(kbs2-1));
		if(kbs2 < kbs1)	System.out.print("4");
	}
}
