package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP13 {
	
	static int[] sequence;
	static int[] dpArr;
	static int[] dpArr2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		sequence=new int[n+1];
		dpArr=new int[n+1];
		dpArr2=new int[n+1];

		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		for(int i=1;i<=n;i++) {
			
			int k=Integer.parseInt(st.nextToken());
			sequence[i]=k;			
			dpArr2[i]=1;
			dpArr[i]=1;
		}
		
		
		
		
		
		getBitonic(n);
		
		
		bw.write(""+getMax(dpArr));
		bw.flush();
		bw.close();
		
		
	}
	
	public static void getBitonic(int n) {
		
				
		for(int i=n-1;i>0;i--) {			
			for(int j=n;j>i;j--) {
				if(sequence[i]>sequence[j]&&dpArr2[i]<=dpArr2[j]+1) {
					dpArr2[i]=dpArr2[j]+1;
				}
			}
		}
		
		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(sequence[i]>sequence[j]&&dpArr[i]<=dpArr[j]+1) {
					dpArr[i]=dpArr[j]+1;
				}
				
			
			}
						
		}
		
		
		for(int i=1;i<=n;i++) {
			dpArr[i]=dpArr[i]+dpArr2[i]-1;
		}
		
	
	}
	
	public static int getMax(int[] arr) {
		int max=arr[0];
		
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		
		return max;
	}

}
