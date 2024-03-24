package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N11656 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String input = scn.next();
		scn.close();
		
		String[] suffix = new String[input.length()];
		for(int i=0; i<input.length(); i++)
			suffix[i] = input.substring(i);
		Arrays.sort(suffix);
		
		for(int i=0; i<suffix.length; i++)
			System.out.println(suffix[i]);
	}
}
