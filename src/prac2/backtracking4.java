package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class backtracking4 {
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static boolean[] visited;
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		arr=new int[m];
		
		dfs(n,m,0,0);
		
		bw.flush();
		bw.close();
		
	}
	
	public static void dfs(int n,int m,int depth,int startIndex) throws IOException {
		if(depth==m) {
			for(int i=0;i<arr.length;i++) {
				bw.write(arr[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=startIndex;i<n;i++) {
			arr[depth]=i+1;
			
			dfs(n,m,depth+1,i);
		}
	}
}
