package acmicpc;

import java.text.DecimalFormat;
import java.util.Scanner;

public class N2529 {
	private static long min = 9999999999L;
	private static long max = 0;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int k = scn.nextInt();
		boolean[] sign = new boolean[k];
		for(int i=0; i<k; i++) {
			if(scn.next().equals("<"))
				sign[i] = true;
			else
				sign[i] = false;
		}
		scn.close();
		
		boolean[] visited = new boolean[10];
		int[] arr = new int[k+1];
		perm(arr, sign, visited, 0, k+1);
		
		String zero_format = "0".repeat(k+1);
		DecimalFormat df = new DecimalFormat(zero_format);
		
		System.out.println(df.format(max));
		System.out.println(df.format(min));
	}
	
	private static void perm(int[] arr, boolean[] sign, boolean[] visited, int depth, int r) {
		if(depth == r) {
			long n = arrtoint(arr);
//			System.out.println("- " + n);
			if(n > max)	max = n;
			if(n < min)	min = n;
			return;
		}
		for(int i=0; i<10; i++) {
			if(visited[i])	continue;
			if(depth == 0) {
				visited[i] = true;
				arr[depth] = i;
				perm(arr, sign, visited, depth+1, r);
				visited[i] = false;				
			}else if((sign[depth-1])?arr[depth-1]<i:arr[depth-1]>i) {
				visited[i] = true;
				arr[depth] = i;
				perm(arr, sign, visited, depth+1, r);
				visited[i] = false;
			}			
		}
	}
	
	private static long arrtoint(int[] arr) {
		long result = 0;
		for(int i=0; i<arr.length; i++) {
			result += arr[i];
			result *= 10;
		}
		return result/10;
	}

}
