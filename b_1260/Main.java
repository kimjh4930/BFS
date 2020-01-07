package b_1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	
	static boolean visited[];
	static int[][] map;
	
	static Queue<Integer> queue = new LinkedList<>();
	static Queue<Integer> tempQueue = new LinkedList<>();
	
	static List<Integer> resultList = new ArrayList<>(10000);
	
	static int N, M, start;
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		start = Integer.parseInt(input[2]);
		
		visited = new boolean[N+1];
		map = new int[N+1][N+1];
		
		int p1, p2;
		
		for(int i=0; i<M; i++) {
			input = br.readLine().split(" ");
			p1 = Integer.parseInt(input[0]);
			p2 = Integer.parseInt(input[1]);
			
			map[p1][p2] = map[p2][p1] = 1;
		}
		StringBuffer str = new StringBuffer();
		
		//dfs
		visited[start] = true;
		resultList.add(start);
		dfs(start);
		
		for(Integer result : resultList) {
			str.append(result + " ");
		}
		str.append("\n");
		
		clear();
		
		//bfs
		queue.add(start);
		visited[start] = true;
		resultList.add(start);
		bfs();
		
		
		for(Integer result : resultList) {
			str.append(result + " ");
		}
		str.append("\n");
		
		System.out.println(str.toString());
		
		br.close();
	}
	
	static void bfs () {
		
		int p;
		
		while(!queue.isEmpty()) {
			
			p = queue.poll();
			
			for(int i=1; i<=N; i++) {
				if(map[p][i] == 1 && visited[i] == false) {
					visited[i] = true;
					tempQueue.add(i);
					resultList.add(i);
				}
			}
			
			if(queue.isEmpty()) {
				queue.addAll(tempQueue);
				tempQueue.clear();
			}
		}
	}
	
	static void dfs (int start) {
		
		for(int i=1; i<=N; i++) {
			if(map[start][i] == 1 && visited[i] == false) {
				visited[i] = true;
				resultList.add(i);
				dfs(i);
			}
		}
	}
	
	static void clear () {
		for(int i=1; i<=N; i++) {
			visited[i] = false;
		}
		resultList.clear();
	}
	
	static void printMap (int N) {
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
