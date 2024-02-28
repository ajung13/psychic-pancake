package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N1759 {
	private static ArrayList<String> result;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int l = scn.nextInt();
		int c = scn.nextInt();
		String[] letter = new String[c];
		for(int i=0; i<c; i++)
			letter[i] = scn.next();
		scn.close();
		
		Arrays.sort(letter);
		boolean[] visited = new boolean[c];
		result = new ArrayList<String>();
		combination(letter, visited, 0, l);
		
		result.sort(Comparator.naturalOrder());
		for(int i=0; i<result.size(); i++)
			System.out.println(result.get(i));
	}
	private static void combination(String[] arr, boolean[] visited, 
			int depth, int r) {
		if(r == 0) {
			final String vowel = "aeiou";
			int con = 0;	int vow = 0;
			String mystr = "";
			for(int i=0; i<arr.length; i++) {
				if(visited[i]) {
					if(vowel.contains(arr[i]))
						vow++;
					else	con++;
					mystr += arr[i];
				}
			}
			if(vow > 0 && con > 1)
				result.add(mystr);
			return;
		}
		
		if(depth == arr.length)
			return;
		visited[depth] = true;
		combination(arr, visited, depth + 1, r - 1);
		visited[depth] = false;
		combination(arr, visited, depth + 1, r);
	}

}
