package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo1_4 {
	
	static int[][] vegetArr;
	static boolean[][] isVisited;
	static Queue<int[]> q=new LinkedList<>();
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	static int count;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t=Integer.parseInt(br.readLine());
		int[] resultArr=new int[t];
		
		
		
		StringTokenizer st;
		for(int i=0;i<t;i++) {
			count=0;
			st=new StringTokenizer(br.readLine()," ");
			int m=Integer.parseInt(st.nextToken());
			int n=Integer.parseInt(st.nextToken());
	
			vegetArr=new int[m][n];
			isVisited=new boolean[m][n];
			
			int k=Integer.parseInt(st.nextToken());
			int[][] spotArr=new int[k][2];
			for(int j=0;j<k;j++) {
				
				
				st=new StringTokenizer(br.readLine()," ");
				
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				
				vegetArr[x][y]=1;
				
				spotArr[j][0]=x;
				spotArr[j][1]=y;
							
			}
			
			for(int j=0;j<k;j++) {
				getMinimum(spotArr[j][0],spotArr[j][1],m,n);
			}
			
			resultArr[i]=count;
			
		}
		
		for(int i=0;i<resultArr.length;i++) {
			bw.write(resultArr[i]+"\n");
		}
		bw.flush();
		bw.close();
	
	}
	
	public static void getMinimum(int x,int y,int m,int n) {
		
		if(isVisited[x][y]==false&&vegetArr[x][y]==1) {
			q.add(new int[]{x,y});
			isVisited[x][y]=true;
			
			count++;
			
			while(!q.isEmpty()) {
				int[] target=q.poll();
				
				for(int i=0;i<4;i++) {
					int newX=target[0]+dx[i];
					int newY=target[1]+dy[i];
							
					if(newX>=0&&newY>=0&&newX<=m-1&&newY<=n-1) {		
						if(vegetArr[newX][newY]==1&&isVisited[newX][newY]==false) {
						
							isVisited[newX][newY]=true;
							q.add(new int[] {newX,newY});
						}
					}
				}
			}
		}
		else {
			return;
		}
		
		
	}

}
