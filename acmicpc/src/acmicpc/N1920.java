package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N1920 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = scn.nextInt();
		Arrays.sort(arr);
		
		int m = scn.nextInt();
		for(int i=0; i<m; i++) {
			int key = scn.nextInt();
			System.out.println(find(arr, key, 0, n-1)?1:0);
		}
		scn.close();
	}
	private static boolean find(int[] arr, int key, int start, int end) {
		if(start > end)		return false;
		int mid = (end + start)/2;
		if(arr[mid] == key)	return true;
		if(arr[mid] > key)	return find(arr, key, start, mid-1);
		else				return find(arr, key, mid+1, end);
	}

}
