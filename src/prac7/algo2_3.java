package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo2_3 {
	
	static int maze[][];
	static boolean isVisited[][];
	
	static Queue<int[]> q=new LinkedList<>();
	
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		maze=new int[n+1][m+1];
		isVisited=new boolean[n+1][m+1];
		
		
		
		for(int i=1;i<=n;i++) {
			String temp=br.readLine();
			char[] c=temp.toCharArray();
			for(int j=1;j<=m;j++) {
				maze[i][j]=Character.getNumericValue(c[j-1]);
			}
		}
		
		bfs(n,m,1,1);
		
		bw.write(maze[n][m]+"");
		bw.flush();
		bw.close();
		
		
	}
	
	public static void bfs(int n,int m,int x, int y) {
		 
		q.add(new int[]{x,y});
		isVisited[x][y]=true;
		
		while(!q.isEmpty()) {
			int k[]=q.poll();
			
			int oldX=k[0];
			int oldY=k[1];
			
			for(int i=0;i<4;i++) {
				int newX=oldX+dx[i];
				int newY=oldY+dy[i];
				
				if((newX>0&&newY>0)&&(newX<=n&&newY<=m)) {
					if((maze[newX][newY]!=0)&&isVisited[newX][newY]==false) {
						maze[newX][newY]=maze[oldX][oldY]+1;
						q.add(new int[]{newX,newY});
						isVisited[newX][newY]=true;
					}
				}
			}
		}
		
		
		
	}

}
