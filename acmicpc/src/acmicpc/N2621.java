package acmicpc;

import java.util.Arrays;
import java.util.Scanner;

public class N2621 {

	public static void main(String[] args) {
		char[] cardC = new char[5];
		int[] cardN = new int[5];
		
		Scanner scn = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			cardC[i] = scn.next().charAt(0);
			cardN[i] = scn.nextInt();
		}
		scn.close();
		
		int score = 0;
		Arrays.sort(cardN);
		int consecutive_max = consecutive(cardN);
		if(sameColor(cardC)) {
			score += Arrays.stream(cardN).max().getAsInt() + 600;
			if(consecutive_max > 0)
				score += 300; 
		}
		else if(consecutive_max > 0)
			score += consecutive_max + 500;
		else {
			int tmp = _4cards(cardN);
			if(tmp > 0)
				score += tmp + 800;
			else {
				tmp = _3cards(cardN);
				if(tmp > 0) {	// 3 numbers are same
					int tmp2 = _2cards(cardN, tmp)[0];
					if(tmp2 > 0)	score = tmp * 10 + tmp2 +700;
					else			score = tmp + 400;
				}
				else {
					int[] tmp2 = _2cards(cardN, -1);
					if(tmp2[1] > 0)
						score = tmp2[0] + 300 + tmp2[1] * 10;
					else if(tmp2[0] > 0)
						score = tmp2[0] + 200;
					else
						score = cardN[4] + 100;
				}
			}
		}
		
		System.out.println(score);
	}
	
	private static boolean sameColor(char[] a) {
		boolean flag = true;
		for(int i=1; i<a.length; i++) {
			if(a[i-1] != a[i]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	private static int consecutive(int[] a) {
		int max = -1;
		for(int i=1; i<a.length; i++) {
			if(a[i] != a[0] + i) break;
			if(i == a.length - 1)
				max = a[i];
		}
		return max;
	}
	private static int _4cards(int[] a) {
		for(int i=1; i<3; i++) {
			if(a[i] != a[i+1])
				return -1;
		}
		if(a[0] == a[1] || a[3] == a[4])
			return a[1];
		return -1;
	}
	private static int _3cards(int[] a) {
		if(a[0] == a[2] || a[2] == a[4])
			return a[2];
		if(a[1] == a[2] && a[2] == a[3])
			return a[2];
		return -1;
	}
	private static int[] _2cards(int[] a, int except){
		int[] result = new int[] {-1, -1};
		for(int i=1; i<a.length; i++) {
			if(a[i] == except)	continue;
			if(a[i-1] == a[i]) {
				if(result[0] > 0)	result[1] = a[i];
				else				result[0] = a[i];
			}
		}
		return result;
	}
}