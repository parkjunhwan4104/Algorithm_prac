package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP6 {

	static int[][] costArr;

	static int[][] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());

		costArr=new int[n][3];
		dpArr=new int[n][3];

		StringTokenizer st;

		for(int i=0;i<n;i++) {

			st=new StringTokenizer(br.readLine()," ");

			for(int j=0;j<3;j++) {
				costArr[i][j]=Integer.parseInt(st.nextToken());
				
			}

		}
		
		for(int i=0;i<3;i++) {
			dpArr[0][i]=costArr[0][i];
		}
		
		
		
		
		bw.write(""+Math.min(getMinCost(n-1,0) ,Math.min(getMinCost(n-1,1),getMinCost(n-1,2))));
		
		bw.flush();
		bw.close();
		
				
		

	}

	public static int getMinCost(int n,int index) {
		
		if(dpArr[n][index]==0) {
			if(index==0) {
				dpArr[n][index]+=Math.min(getMinCost(n-1,1), getMinCost(n-1,2))+costArr[n][index];
			}
			if(index==1) {
				dpArr[n][index]+=Math.min(getMinCost(n-1,0), getMinCost(n-1,2))+costArr[n][index];
			}
			if(index==2) {
				dpArr[n][index]+=Math.min(getMinCost(n-1,0), getMinCost(n-1,1))+costArr[n][index];
			}
			
		}
		
		return dpArr[n][index];
	}

	

}
