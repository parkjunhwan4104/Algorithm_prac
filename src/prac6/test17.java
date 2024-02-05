package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test17 {

	static int[][] connArr;

	static boolean[] isVisited;
	
	static int count=0;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());
		int m=Integer.parseInt(br.readLine());

		connArr=new int[n+1][n+1];
		isVisited=new boolean[n+1];

		isVisited[1]=true;

		StringTokenizer st;

		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");

			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());

			connArr[a][b]=1;
			connArr[b][a]=1;
		}
		
		dfs(n,1);
		
		bw.write(""+count);
		bw.flush();
		bw.close();

	}

	public static void dfs(int n,int start) {

		
		for(int i=1;i<=n;i++) {
			if(connArr[start][i]==1) {
				if(isVisited[i]==false) {
					count++;
					isVisited[i]=true;
					
					dfs(n,i);
				}
				else {
					continue;
				}
			}
		}

		
	}


}
