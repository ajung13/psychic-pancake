package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class N10825 {
	static class Stu{
		String name;
		int kor, eng, math;
		public Stu(String name, int kor, int eng, int math) {
			this.name = name;
			this.kor = kor; this.eng = eng; this.math = math;
		}
		public int getKor() {
			return this.kor;
		}
		public int getEng() {
			return this.eng;
		}
		public int getMath() {
			return this.math;
		}
		public String getName() {
			return this.name;
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Stu[] student = new Stu[n];
		for(int i=0; i<n; i++) {
			student[i] = new Stu(scn.next(), scn.nextInt(), scn.nextInt(), scn.nextInt());
		}
		scn.close();
		
		Arrays.sort(student, new Comparator<>() {
			@Override
			public int compare(Stu o1, Stu o2) {
				int a = o1.getKor();
				int b = o2.getKor();
				if(a != b)	return b-a;
				a = o1.getEng();
				b = o2.getEng();
				if(a != b)	return a-b;
				a = o1.getMath();
				b = o2.getMath();
				if(a != b)	return b-a;
				return o1.getName().compareTo(o2.getName());
			}
		});
		
		for(int i=0; i<n; i++)
			System.out.println(student[i].getName());
	}
}
