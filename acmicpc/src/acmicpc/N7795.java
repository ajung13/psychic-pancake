package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N7795 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int tc = scn.nextInt();
		for(int tcidx=0; tcidx<tc; tcidx++) {
			int a_num = scn.nextInt();
			int b_num = scn.nextInt();
			int[] a = new int[a_num];
			int[] b = new int[b_num];
			for(int i=0; i<a_num; i++)
				a[i] = scn.nextInt();
			for(int i=0; i<b_num; i++)
				b[i] = scn.nextInt();
			Arrays.sort(a);
			Arrays.sort(b);
			
			int a_ptr = 0;
			int b_ptr = 0;
			int cnt = 0;
			while(a_ptr < a_num) {
				if(b_ptr >= b_num) {
					cnt += b_num;
					a_ptr++;
					continue;
				}
				if(a[a_ptr] > b[b_ptr]) {
					while(b_ptr < b_num && a[a_ptr] > b[b_ptr])
						b_ptr++;
				}
				cnt += b_ptr;
				a_ptr++;
			}
			
			System.out.println(cnt);
		}
		scn.close();
	}

}
