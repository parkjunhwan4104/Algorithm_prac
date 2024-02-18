package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo1_5 {
	
	static int[] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		dpArr=new int[n+1];
		
		if(n==1) {
			dpArr[1]=1;
		}
		
		if(n==2) {
			dpArr[1]=1;
			dpArr[2]=2;
		}
		
		if(n>=3) {
			dpArr[1]=1;
			dpArr[2]=2;
			
			for(int i=3;i<=n;i++) {
				dpArr[i]=(dpArr[i-1]+dpArr[i-2])%10007;
			}
			
		}
		
		
		bw.write(""+dpArr[n]);
		bw.flush();
		bw.close();
	}

}
