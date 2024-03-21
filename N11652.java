package acmicpc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class N11652 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Map<Long, Integer> cards = new HashMap<>();
		for(int i=0; i<n; i++) {
			long input = scn.nextLong();
			if(cards.containsKey(input)) {
				int cnt = cards.get(input);
				cards.replace(input, cnt+1);
			}
			else
				cards.put(input, 1);
		}
		scn.close();

		List<Long> keySet = new ArrayList<>(cards.keySet());
		keySet.sort(new Comparator<Long>() {
			@Override
			public int compare(Long o1, Long o2) {
				int cnt1 = cards.get(o1);
				int cnt2 = cards.get(o2);
				int result = cnt2 - cnt1;
				if(result == 0)
					return Long.compare(o1, o2);
				return result;
			}
		});
		System.out.print(keySet.get(0));
	}

}
