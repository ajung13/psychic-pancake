package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N1043 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int people_num = scn.nextInt();
		int party_num = scn.nextInt();
		boolean[] know_truth = new boolean[people_num];
		Arrays.fill(know_truth, false);
		ArrayList<Integer>[] party = new ArrayList[party_num];
		
		int n = scn.nextInt();
		for(int i=0; i<n; i++) {
			int tmp = scn.nextInt();
			know_truth[tmp-1] = true;
		}
		for(int i=0; i<party_num; i++) {
			n = scn.nextInt();
			party[i] = new ArrayList<>();
			for(int j=0; j<n; j++) {
				int tmp = scn.nextInt();
				party[i].add(tmp-1);
			}
		}
		scn.close();
		
		checkTruth(know_truth, party);
		
		n = 0;
		for(int i=0; i<party_num; i++) {
			if(!know_truth[party[i].get(0)])
				n++;
		}
		System.out.print(n);
	}
	
	private static void checkTruth(boolean[] know, ArrayList<Integer>[] party) {
		Queue<Integer> q = new LinkedList<>();
		for(int i=0; i<know.length; i++) {
			if(know[i])	q.offer(i);
		}
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i=0; i<party.length; i++) {
				if(!party[i].contains(node))
					continue;
				for(int j=0; j<party[i].size(); j++) {
					int tmp = party[i].get(j);
					if(know[tmp])	continue;
					know[tmp] = true;
					q.offer(tmp);
				}
			}
		}
		return;
	}
}
