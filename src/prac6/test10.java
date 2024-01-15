package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class test10 {

	static int[][] arr;

	static ArrayList<Integer> visitedNumArr=new ArrayList<>();
	static ArrayList<Integer> visitedNumArr2=new ArrayList<>();
	static Queue<Integer> q=new LinkedList<>();
	
	static boolean[] isVisited1;
	static boolean[] isVisited2;
	
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int v=Integer.parseInt(st.nextToken());

		arr=new int[n+1][n+1];
		
		isVisited1=new boolean[n+1];
		isVisited2=new boolean[n+1];
		
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");

			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			arr[a][b]=1;
			arr[b][a]=1;
		}
		
		
		dfs(n,v);
		
		for(int i=0;i<visitedNumArr.size();i++) {
			bw.write(visitedNumArr.get(i)+" ");
			
		}
		bw.write("\n");
		
		bfs(n,v);
		
		for(int i=0;i<visitedNumArr2.size();i++) {
			bw.write(visitedNumArr2.get(i)+" ");
			
		}
		
		bw.flush();
		bw.close();
		
	}


	public static void dfs(int n,int v) {
		
		visitedNumArr.add(v);
		isVisited1[v]=true;
		
		for(int i=1;i<=n;i++) {
			
			if(arr[v][i]==1&&isVisited1[i]==false) {
				dfs(n,i);
			}
		}
	}

	public static void bfs(int n,int v) {
		q.add(v);
		isVisited2[v]=true;
		visitedNumArr2.add(v);
		
		while(!q.isEmpty()) {
			int vertex=q.poll();
			
			for(int i=1;i<=n;i++) {
				if(arr[vertex][i]==1&&isVisited2[i]==false) {
					q.add(i);
					visitedNumArr2.add(i);
					isVisited2[i]=true;
				}
			}
		}
	}

}
