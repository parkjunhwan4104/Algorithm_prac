package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class backTracking1 {
	
	public static boolean[] visited;
	public static int[] arr;
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(bf.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		visited=new boolean[n];
		arr=new int[m];
		
		dfs(n,m,0);
		
		bw.flush();
		bw.close();
	
	}
	
	public static void dfs(int n,int m,int depth) throws IOException {
		
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				
				arr[depth]=i+1;
				
				dfs(n,m,depth+1);
				
				visited[i]=false;
			}
		}
	}
	

}
