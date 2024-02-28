package acmicpc;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Scanner;

import javax.management.loading.PrivateClassLoader;

public class Main {
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
		
		for(int i=0; i<10; i++) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			arrayList.add(i);
			dfs(sign, arrayList);
		}
		
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(boolean[] sign, ArrayList<Integer> arr) {
		if(arr.size() == sign.length) {
			long number = 0;
			for(int i=0; i<arr.size(); i++) {
				number += arr.get(i);
				number *= 10;
			}
			number /= 10;
			if(number > max)	max = number;
			if(number < min)	min = number;
			return;
		}
		for(int i=0; i<10; i++) {
			if(arr.contains(i))
				continue;
			int idx = arr.size() - 1;
			if((sign[idx])?arr.get(idx)<i:arr.get(idx)>i) {
				print(sign, arr);
				arr.add(i);
				dfs(sign, arr);
			}
		}
	}
	
	private static void print(boolean[] sign, ArrayList<Integer> arr) {
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i));
			if(i == arr.size() - 1)	break;
			if(sign[i])	System.out.print("<");
			else		System.out.print(">");
		}
		System.out.println();
	}
}