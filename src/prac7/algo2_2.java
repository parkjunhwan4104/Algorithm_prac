package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class algo2_2 {
	
	static int stepScore[];
	static int dpArr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		stepScore=new int[n+1];
		dpArr=new int[n+1];	
		
		for(int i=1;i<n+1;i++) {
			stepScore[i]=Integer.parseInt(br.readLine());
		}
		
		dpArr[1]=stepScore[1];
		
		if(n>=2) {
			dpArr[2]=stepScore[2]+stepScore[1];
			
		}
		if(n>=3) {
			getMaxScore(n);	
		}
			
		
		bw.write(dpArr[n]+"");
		bw.flush();
		bw.close();
		
	}
	
	public static void getMaxScore(int n) {
		
		for(int i=3;i<=n;i++) {
			
			dpArr[i]=Math.max(dpArr[i-2]+stepScore[i], stepScore[i]+stepScore[i-1]+dpArr[i-3]);
		}
	}

}
