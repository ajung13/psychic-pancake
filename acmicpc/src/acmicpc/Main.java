package acmicpc;
// No.1747

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		scn.close();
		
		System.out.println(brute(N));
	}
	private static int brute(int N) {
		int i = N;
		if(i == 1)	i++;
		for(; i<1100000; i++) {
			if(isPrime(i) && palin(i))
				break;
		}
		return i;
	}
	private static boolean palin(int a) {
		String str = String.valueOf(a); 
		int digit = str.length();
		boolean flag = true;
		for(int i=0; i<digit/2; i++) {
			if(str.charAt(i) != str.charAt(digit-i-1)) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	private static boolean isPrime(int a) {
		for(int i = 2; i<=(int)Math.sqrt(a); i++) {
			if(a % i == 0)
				return false;
		}
		return true;
	}
}
