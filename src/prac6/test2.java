package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test2 {

	static int dpArr[];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());
		
		/* 수학적 풀이
		int count=0;
		
		while(n>0) {
			if(n%5==0) {
				count++;
				n=n-5;
			}
			else {
				count++;
				n=n-3;
			}
		}
		
		if(n==0) {
			bw.write(""+count);
		}
		else {
			bw.write(""+(-1));
		}
		*/
		
		
		
		//DP
		dpArr=new int[n+1];
		
		if(n==3) {
			dpArr[n]=1;
		}
		if(n==4) {
			dpArr[n-1]=1;
			dpArr[n]=-1;
		
		}
		if(n==5) {
			dpArr[n-2]=1;
			dpArr[n-1]=-1;
			dpArr[n]=1;
		}
		
		if(n>5) {
			dpArr[3]=1;
			dpArr[4]=-1;
			dpArr[5]=1;
			
			
			for(int i=6;i<=n;i++) {
				if(i==6) {
					dpArr[i]=2;
				}
				else if(i==7) {
					dpArr[i]=-1;
				}
				
				else {
					if(dpArr[i-3]==-1&&dpArr[i-5]!=-1) {
						dpArr[i]=dpArr[i-5]+1;
					}
					if(dpArr[i-3]!=-1&&dpArr[i-5]==-1) {
						dpArr[i]=dpArr[i-3]+1;
					}
					if(dpArr[i-3]!=-1&&dpArr[i-5]!=-1) {
						dpArr[i]=Math.min(dpArr[i-3]+1, dpArr[i-5]+1);
					}
					if(dpArr[i-3]==-1&&dpArr[i-5]==-1) {
						dpArr[i]=-1;
					}
					
				}
				
			}
			
		}
		
			
		
		
		bw.write(""+dpArr[n]);
		
		bw.flush();
		bw.close();
	}

	
}
