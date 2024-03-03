package acmicpc;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	// TODO : 알파벳 숫자로 바꾸기, hashmap 쓰기
	private static int depth = 1;
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
		char[][] board = new char[r][c];
		for(int i=0; i<r; i++) {
			String line = scn.next();
			for(int j=0; j<c; j++)
				board[i][j] = line.charAt(j);
		}
		scn.close();
		
		Stack<Character> way = new Stack<>();
		way.add(board[0][0]);
		dfs(board, way, 0, 0);
		System.out.print(depth);
	}
	
	private static void dfs(char[][] board, Stack<Character> way, int i, int j) {
		char tmp;
		boolean canvisit = false;
//		for(int idx=0; idx<way.size(); idx++) {
//			System.out.print(way.get(idx) + " ");
//		}
//		System.out.println();
		
		if(i > 0) {					// above
			tmp = board[i-1][j];
			if(!way.contains(tmp)) {
				way.push(tmp);
				dfs(board, way, i-1, j);
				canvisit = true;
			}
		}
		if(i < board.length - 1) {	// below
			tmp = board[i+1][j];
			if(!way.contains(tmp)) {
				way.push(tmp);
				dfs(board, way, i+1, j);
				canvisit = true;
			}
		}
		if(j > 0) {					// left
			tmp = board[i][j-1];
			if(!way.contains(tmp)) {
				way.push(tmp);
				dfs(board, way, i, j-1);
				canvisit = true;
			}
		}
		if(j < board[0].length - 1) {//right
			tmp = board[i][j+1];
			if(!way.contains(tmp)) {
				way.push(tmp);
				dfs(board, way, i, j+1);
				canvisit = true;
			}
		}
		
		if(!canvisit) {
//			System.out.println("CANT VISIT " + way.size());
			if(depth < way.size())
				depth = way.size();
		}
		way.pop();
	}
}