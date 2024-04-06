package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10815_binary {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken())+10000000;
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] find = new int[m];
		for(int i=0; i<m; i++)
			find[i] = Integer.parseInt(st.nextToken())+10000000;
		Arrays.sort(find);
		
		int low = 0;
		for(int i=0; i<m; i++) {
			int key = binary(arr, find[i], low, n-1);
			bw.write(((key>=0)?1:0) + " ");
			low = key;
		}
		
		
		bw.flush();
		bw.close();
	}
	private static int binary(int[] arr, int key, int low, int high) {
		if(low > high)	return -1;
		int mid = (low + high)/2;
		if(key == arr[mid])	return mid;
		else if(key < arr[mid])	return binary(arr, key, low, mid-1);
		else			return binary(arr, key, mid+1, high);
	}

}
