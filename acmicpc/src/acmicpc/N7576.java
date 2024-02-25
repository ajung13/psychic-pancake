package acmicpc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N7576 {
	static int[][] box;
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		box = new int[n][m];
		boolean impossible = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				box[i][j] = scn.nextInt(); 
				if(!impossible && box[i][j] > 0)
					impossible = true;
			}
		}
		scn.close();
		
		if(not_ripe() == 0)	System.out.print("0");
		else {
			int timer = time_goes(n, m);
			if(not_ripe() != 0)
				System.out.print("-1");
			else
				System.out.print(timer);
		}
		
	}
	private static int time_goes(int n, int m) {
		Queue<String> queue = new LinkedList<String>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(box[i][j] == 1)	queue.offer(i + " " + j);
			}
		}
		int timer = 0;
		queue.offer("time goes");
		
		while(!queue.isEmpty()) {
			String[] node = queue.poll().split(" ");
			if(node[0].equals("time")) {
				if(queue.isEmpty())
					break;
				timer++;
				queue.offer("time goes");
				continue;
			}
			int a = Integer.valueOf(node[0]);
			int b = Integer.valueOf(node[1]);
//			System.out.println(a + " " + b);
			if(a > 0 && box[a-1][b] == 0) {
				box[a-1][b] = 1; 
				queue.offer((a-1) + " " + b);
			}
			if(a < n-1 && box[a+1][b] == 0) {
				box[a+1][b] = 1; 
				queue.offer((a+1) + " " + b);
			}
			if(b > 0 && box[a][b-1] == 0) {
				box[a][b-1] = 1; 
				queue.offer(a + " " + (b-1));
			}
			if(b < m-1 && box[a][b+1] == 0) {
				box[a][b+1] = 1; 
				queue.offer(a + " " + (b+1));
			}
		}
		return timer;
	}
	private static int not_ripe() {
		int cnt = 0;
		for(int i=0; i<box.length; i++) {
			for(int j=0; j<box[i].length; j++) {
				if(box[i][j] == 0)	cnt++;
			}
		}
		return cnt;
	}

}
