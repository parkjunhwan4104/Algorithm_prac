package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP7 {
	
	static int[][] dpArr;
	
	static int[][] triangle;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());
		
		triangle=new int[n][n];
		
		dpArr=new int[n][n];
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<=i;j++) {
				
				triangle[i][j]=Integer.parseInt(st.nextToken());
				
			}
		}
		
		for(int i=0;i<n;i++) {
			dpArr[n-1][i]=triangle[n-1][i];
		}
		
		bw.write(""+getSum(n,0,0));
		
		bw.flush();
		bw.close();
		
	}
	
	public static int getSum(int n,int floor,int index){
		
		
		if(floor==n-1) {
			
			return dpArr[floor][index];
		}
		
		if(dpArr[floor][index]==0) {
			
			
			dpArr[floor][index]=Math.max(getSum(n,floor+1,index),getSum(n,floor+1,index+1))+triangle[floor][index];
		}
		
		return dpArr[floor][index];
	
	}

}
