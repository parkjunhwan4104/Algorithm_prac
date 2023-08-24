package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP10 {
	

	static long[][] dpArr;
	
	static long mod=1000000000;
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		dpArr=new long[n+1][10]; // [자릿 수][끝자리의 수]

		stepCount(n);
		
		long count=0;
		
		for(int i=0;i<10;i++) {
			count+=dpArr[n][i];
		}
		
		count=count%mod;
		
		bw.write(""+count);
		
		bw.flush();
		bw.close();
	}
	
	
	public static void stepCount(int n) {
		
		for(int i=1;i<10;i++) {
			dpArr[1][i]=1;
		}
		
		if(n==1) {
			return;
		}
		
		
		for(int i=2;i<=n;i++) {
			for(int j=0;j<10;j++) {
				if(j==0) {
					dpArr[i][0]=dpArr[i-1][1]%mod;
				}
				else if(j==9) {
					dpArr[i][9]=dpArr[i-1][8]%mod;
				}
				
				else {
					dpArr[i][j]=(dpArr[i-1][j+1]+dpArr[i-1][j-1])%mod;
				}
			}
		}		
		
	}

}
