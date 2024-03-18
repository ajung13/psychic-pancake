package acmicpc;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = new int[k];
		int[] multi = new int[n];
		for(int i=0; i<k; i++)
			arr[i] = scn.nextInt();
		scn.close();
		
		int unplug = 0;
		for(int i=0; i<n; i++)
			multi[i] = arr[i];
		for(int i=n; i<k; i++) {
			if(array_contains(multi, arr[i]) >= 0)
				continue;
			//뽑아야됨
			unplug++;
			// 1. 쓸때까지 오래걸리는 애
//			int[] next_use = new int[n];
//			Arrays.fill(next_use, -1);
			boolean[] next_use = new boolean[n];
			Arrays.fill(next_use, false);
			int idx = 0;
			for(int j=i+1; j<k; j++) {
				idx = array_contains(multi, arr[j]);
				if(idx < 0)		continue;
				if(next_use[idx])	continue;
				if(last(next_use))	break;
				next_use[idx] = true;
//				if(idx >= 0)	next_use[idx] = j;
//				if(next_use_filled(next_use))
//					break;
			}
			System.out.println(i + "th (" + arr[i] + ")");
			multi[idx] = arr[i];
			print(multi);
		}
		
		System.out.print(unplug);
	}
	private static void print(int[] arr) {
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	private static int array_contains(int[] arr, int key) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == key)	return i;
		}
		return -1;
	}
	private static boolean last(boolean[] next) {
		int cnt = next.length;
		for(int i=0; i<next.length; i++) {
			if(next[i])	cnt--;
		}
		if(cnt == 1)	return true;
		return false;
	}
//	private static boolean next_use_filled(int[] next) {
//		boolean flag = true;
//		for(int i=0; i<next.length; i++) {
//			if(next[i] == -1) {
//				flag = false;
//				break;
//			}
//		}
//		return flag;
//	}
}