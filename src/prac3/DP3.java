package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP3 {
	
	public static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());

		arr=new int[n+1];
				
		if(n<=2) {
			for(int i=0;i<=n;i++) {
				arr[i]=i;
			}
		}
		else {
			arr[0]=0;
			arr[1]=1;
			arr[2]=2;
				
		}
		
		int result=tile(n);
		
		bw.write(""+result);
		
		bw.flush();
		bw.close();
		
	}
	
	public static int tile(int n) {
		
		
		
		if(n==1||n==2) {
		
			return arr[n];
		}
		
		else{
			
			
			for(int i=3;i<=n;i++) {
				arr[i]=(arr[i-1]+arr[i-2])%15746;
				
			}
			
			return arr[n];
			
		}
				
	}

}
