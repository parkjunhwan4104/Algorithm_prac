package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP16 {
	
	static int[] weight;
	static int[] value;
	static int[][] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		weight=new int[n+1];
		value=new int[n+1];		
		dpArr=new int[n+1][k+1];
		
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			int w=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			
			weight[i]=w;
			value[i]=v;
		}
		
		maxValue(n,k);
		
		
		
		bw.write(""+dpArr[n][k]);
		bw.flush();
		bw.close();
	
	}
	
	public static void maxValue(int n,int k) {
		
	
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				
				if(weight[i]>j) {
					dpArr[i][j]=dpArr[i-1][j];
				}
				
				else {
					dpArr[i][j]=Math.max(dpArr[i-1][j],value[i]+dpArr[i-1][j-weight[i]]);
				}
				
				
			}		
		}
		
	}
	
	
	
}
