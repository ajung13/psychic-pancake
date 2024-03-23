package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N5648 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		long[] arr = new long[n];
		for(int i=0; i<n; i++) {
			String num = scn.next();
			arr[i] = 0;
			for(int j=num.length()-1; j>=0; j--) {
				arr[i] *= 10;
				arr[i] += Character.getNumericValue(num.charAt(j));
			}
		}
		scn.close();
		
		Arrays.sort(arr);
		for(int i=0; i<n; i++)
			System.out.println(arr[i]);
	}

}
