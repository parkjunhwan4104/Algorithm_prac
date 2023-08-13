package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP4 {
	
	private static long[] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t=Integer.parseInt(br.readLine());
		
		int[] NArr=new int[t];
		
		for(int i=0;i<t;i++) {
			int n=Integer.parseInt(br.readLine());
			
			NArr[i]=n;
		}
		
		for(int i=0;i<NArr.length;i++) {
			dpArr=new long[NArr[i]+1];
			
			if(NArr[i]<=3) {
				dpArr[0]=0;
				for(int j=1;j<=NArr[i];j++) {
					dpArr[j]=1;
				}
			}
			else {
				dpArr[0]=0;
				dpArr[1]=1;
				dpArr[2]=1;
				dpArr[3]=1;
			}
			
			bw.write(""+padovan(NArr[i]));
			bw.write("\n");
		}
		
		
		
		
		bw.flush();
		bw.close();
				
	}
	
	public static long padovan(int n) {
		
		
		if(n<=3) {
			return dpArr[n];
		}
				
		else{
			if(dpArr[n]==0) {
				
				for(int i=4;i<=n;i++) {
					dpArr[i]=dpArr[i-3]+dpArr[i-2];
				}
				
			}
			return dpArr[n];
			
		}
	}

}
