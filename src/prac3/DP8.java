package prac3;

import java.io.BufferedReader; 
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DP8 {
	
	static int[] stepArr;
	
	static int[] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		stepArr=new int[n];
		dpArr=new int[n];

		for(int i=0;i<n;i++) {
			
			int k=Integer.parseInt(br.readLine());
			
			stepArr[i]=k;
			
		}
		
		if(n==1) {
			dpArr[0]=stepArr[0];
		}
		
		if(n==2) {
			dpArr[0]=stepArr[0];
			dpArr[1]=dpArr[0]+stepArr[1];
		}
		
		if(n>=3) {
			dpArr[0]=stepArr[0];
			dpArr[1]=dpArr[0]+stepArr[1];
			dpArr[2]=Math.max(stepArr[0], stepArr[1])+stepArr[2];
			
			upStep(n);
		}
				
		
		
		bw.write(""+dpArr[n-1]);
		
		bw.flush();
		bw.close();
	}
	
	public static void upStep(int n) {
		
		for(int i=3;i<n;i++) {
			dpArr[i]=Math.max(dpArr[i-3]+stepArr[i-1], dpArr[i-2])+stepArr[i];
		}		
	}

}
