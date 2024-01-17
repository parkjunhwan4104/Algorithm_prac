package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test13 {
	
	static int[][] maze;
	
	static boolean[][] isVisited;
	
	static Queue<int[]> q=new LinkedList<>();
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		maze=new int[n+1][m+1];
		
		isVisited=new boolean[n+1][m+1];
		
		
		
		for(int i=1;i<=n;i++) {
			String line=br.readLine();
			
			for(int j=1;j<=m;j++) {
				
				char[] c=line.toCharArray();
				
				maze[i][j]=Character.getNumericValue(c[j-1]);
			}
			
		}
		
		getMin(n,m,1,1);
		
		
		bw.write(""+maze[n][m]);
		bw.flush();
		bw.close();
		
	}	
	
	public static void getMin(int n,int m,int x,int y) {
		q.add(new int[] {x,y});
		isVisited[x][y]=true;
		
		while(!q.isEmpty()) {
			int node[]=q.poll();
			int nowX=node[0];
			int nowY=node[1];
			
			for(int i=0;i<4;i++) {
				int newX=nowX+dx[i];
				int newY=nowY+dy[i];
				
				if(newX<1||newY<1||newX>n||newY>m) {
					continue;
				}
				
				if(isVisited[newX][newY]==true||maze[newX][newY]==0) {
					continue;
				}
				
				
				maze[newX][newY]=maze[nowX][nowY]+1;
				q.add(new int[] {newX,newY});
				isVisited[newX][newY]=true;
				
			}
		}
		
	}
	
	
	
}
