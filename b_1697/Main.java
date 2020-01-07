package b_1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static boolean visited[] = new boolean[100001];
	
	static int start, end, time = 0;
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);
		
		queue.add(start);
		visited[start] = true;
		
		find();
		
		System.out.println(time);
		
		br.close();
	}
	
	static int find() {
		int p, tp = 0;
		
		if(start == end) {
			return 0;
		}
		
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i=0; i<3; i++) {
				switch (i) {
				case 0:
					tp = p-1;
					break;
				case 1:
					tp = p+1;
					break;
				case 2:
					tp = p<<1;
				}
				
				if(checkRange(tp) && visited[tp] == false) {
					visited[tp] = true;
					tempQueue.add(tp);
				}
			}
			
			if(queue.isEmpty()) {
				time++;
				
				if(visited[end] == true) {
					return time;
				}
				
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
		
		return time;
	}
	
	static boolean checkRange (int point) {
		if(point >= 0 && point <= 100000) {
			return true;
		}
		return false;
	}
	
}
