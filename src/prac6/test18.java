package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test18 {
	
	static int[] caseArr;
	
	static int[] dpOneArr;
	static int[] dpZeroArr;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t=Integer.parseInt(br.readLine());
		
		caseArr=new int[t];
		
		for(int i=0;i<t;i++) {
				
		
			
			caseArr[i]=Integer.parseInt(br.readLine());
			
			dpOneArr=new int[caseArr[i]+1];
			dpZeroArr=new int[caseArr[i]+1];
			
			dpOneArr[0]=0;
			dpZeroArr[0]=1;
			
			if(caseArr[i]>=1) {
				dpOneArr[1]=1;
				dpZeroArr[1]=0;
			}
			
			if(caseArr[i]>1) {
				dp(caseArr[i]);
			}
			
			bw.write(dpZeroArr[caseArr[i]]+" "+dpOneArr[caseArr[i]]+"\n");
			
		}
	
		bw.flush();
		bw.close();
	}
	
	public static void dp(int n) {
		
		for(int i=2;i<=n;i++) {
			
			dpZeroArr[i]=dpZeroArr[i-1]+dpZeroArr[i-2];
			dpOneArr[i]=dpOneArr[i-1]+dpOneArr[i-2];
		}
		
			
		
		
	}

}
