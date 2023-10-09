package prac5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prefixSum5 {
	
	static int[][] numArr;
	
	static int[][] dpArr;
	
	
	static int[] result;
		
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		numArr=new int[n+1][n+1];
		dpArr=new int[n+1][n+1];
		result=new int[m];
		
		for(int i=1;i<=n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
							
					numArr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
			
		for(int i=0;i<m;i++) {
			int startx;
			int starty;
			int endx;
			int endy;
			int resultNum=0;
			
			st=new StringTokenizer(br.readLine()," ");
			
			startx=Integer.parseInt(st.nextToken());
			starty=Integer.parseInt(st.nextToken());
			endx=Integer.parseInt(st.nextToken());
			endy=Integer.parseInt(st.nextToken());
					
			
			for(int j=startx;j<=endx;j++) {
				resultNum+=dpArr[j][endy]-dpArr[j][starty-1];
			}
			
			result[i]=resultNum;
		}
		
		for(int i=0;i<m;i++) {
			bw.write(result[i]+"\n");
		}
		bw.flush();
		bw.close();
		
	}

}
