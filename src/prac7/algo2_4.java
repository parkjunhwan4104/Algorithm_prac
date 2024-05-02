package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo2_4 {
	
	static int tomato[][];
	static int dayNum[][];
	
	static int[] dx= {1,-1,0,0};
	static int[] dy= {0,0,1,-1};
	
	static Queue<int[]> q=new LinkedList<>();
	static boolean isVisited[][];
	static ArrayList<int[]> list=new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		tomato=new int[n+1][m+1];
		dayNum=new int[n+1][m+1];
		isVisited=new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			
			st=new StringTokenizer(br.readLine()," ");
			
			for(int j=1;j<=m;j++) {
				int k=Integer.parseInt(st.nextToken());
				tomato[i][j]=k;
				
			}
		}
		
		for(int i=1;i<=n;i++) {
			
			for(int j=1;j<=m;j++) {
				if(tomato[i][j]==1) {
					list.add(new int[] {i,j});
				}
			}
		}
		
		findMin(list,n,m);
		
		boolean isNot=false; //다 익지 못할 상황인 경우
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(tomato[i][j]==0) {
					
					isNot=true;
					break;
				}						
			}			
		}
		
		if(isNot==false) {
			bw.write(getMax(dayNum)+"");
		}
		
		else {
			bw.write(-1+"");
		}
		
		bw.flush();
		bw.close();
			
	}
	
	public static void findMin(ArrayList<int[]> list,int n, int m){
		
		for(int i=0;i<list.size();i++) {
			int x=list.get(i)[0];
			int y=list.get(i)[1];
			
			if(isVisited[x][y]==false) {
					
				q.add(new int[] {x,y});
				isVisited[x][y]=true;
					
			}
		}
		
		
		while(!q.isEmpty()) {
			
			
			int[] target=q.poll();
			int targetX=target[0];
			int targetY=target[1];
			
		
			
			for(int i=0;i<4;i++) {
				int newX=targetX+dx[i];
				int newY=targetY+dy[i];
				
				if(newX>=1&&newY>=1&&newX<=n&&newY<=m) {
					if(isVisited[newX][newY]==false&&tomato[newX][newY]==0) {
						
						isVisited[newX][newY]=true;
						tomato[newX][newY]=1;
						dayNum[newX][newY]=dayNum[targetX][targetY]+1;
						q.add(new int[] {newX,newY});
						
					}
				}
			}
				
		}
		
		
				
	}
	
	public static int getMax(int[][] arr) {
		int max=arr[1][1];
		
		for(int i=1;i<arr.length;i++) {
			
			for(int j=1;j<arr[0].length;j++) {
				if(arr[i][j]>max) {
					max=arr[i][j];
				}
			}
			
		}
		
		return max;
	}

}
