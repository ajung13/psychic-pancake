package acmicpc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class N2910 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = scn.nextInt();
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashMap<Integer, Integer> order = new HashMap<>();
		for(int i=0; i<n; i++) {
			int num = scn.nextInt();
			if(hm.containsKey(num))
				hm.replace(num, hm.get(num)+1);
			else
				hm.put(num, 1);
			if(!order.containsKey(num))
				order.put(num, i);
		}
		scn.close();
		
		List<Integer> keys = new ArrayList<>(hm.keySet());
		keys.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int result = hm.get(o2).compareTo(hm.get(o1));
				if(result == 0)
					return order.get(o1).compareTo(order.get(o2));
				return result;
			}
		});
		
		for(int i=0; i<keys.size(); i++) {
			int num = keys.get(i);
			System.out.print((num + " ").repeat(hm.get(num)));
		}
	}
}
