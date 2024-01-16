package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test12 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int m=Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		int[] isPrimeArr=new int[n+1];
		
		for(int i=2;i<=n;i++) {
			isPrimeArr[i]=1;
			
		}
		
		
		for(int i=2;i<=n;i++) {
			if(isPrimeArr[i]==0) {
				continue;
			}
			else {
				for(int j=i+i;j<=n;j+=i) {
					isPrimeArr[j]=0;
				}
			}
			
		}

		for(int i=m;i<=n;i++) {
			if(isPrimeArr[i]==1) {
				bw.write(i+"\n");
			}
			
		}
		
		bw.flush();
		bw.close();
	}
}
