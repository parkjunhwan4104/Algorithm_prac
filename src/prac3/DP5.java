package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP5 {
	
	private static int[] sequence;
	
	private static int[] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		sequence=new int[n];
		dpArr=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			sequence[i]=Integer.parseInt(st.nextToken());
		}
		
		sum(n);
		
		bw.write(""+getMax(dpArr));
		
		bw.flush();
		bw.close();
	}
	
	public static void sum(int n) {
		
			
		for(int i=0;i<n;i++) {
			if(i==0) {
				dpArr[i]=sequence[i];
			}
			
			else {
				dpArr[i]=Math.max(dpArr[i-1]+sequence[i], sequence[i]);
			}
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
