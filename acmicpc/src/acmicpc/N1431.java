package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N1431 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] input = new String[n];
		for(int i=0; i<n; i++)
			input[i] = scn.next();
		scn.close();
		
		Arrays.sort(input, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() != o2.length())
					return o1.length()-o2.length();
				int num1=0, num2=0;
				for(int i=0; i<o1.length(); i++) {
					if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9')
						num1 += (o1.charAt(i) - '0');
					if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9')
						num2 += (o2.charAt(i) - '0');
				}
				if(num1 != num2)
					return num1-num2;
				return o1.compareTo(o2);
			}
		});
		
		for(int i=0; i<n; i++)
			System.out.println(input[i]);
	}

}
