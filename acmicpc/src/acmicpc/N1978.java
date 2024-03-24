package acmicpc;

import java.util.Scanner;

public class N1978 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int cnt = 0;
		for(int i=0; i<n; i++) {
			int num = scn.nextInt();
			if(isPrime(num))
				cnt++;
		}
		scn.close();
		System.out.print(cnt);
	}
	private static boolean isPrime(int num) {
		if(num < 2)		return false;
		if(num == 2)	return true;
		for(int i=2; i<=Math.sqrt(num); i++) {
			if(num % i == 0)
				return false;
		}
		return true;
	}

}
