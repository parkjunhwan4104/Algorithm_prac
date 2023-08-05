package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class backTracking5 {
	
	public static int[] arr;
	public static int count=0;

	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		arr=new int[n];
		
		nQueen(n,0);
		
		
		bw.write(count+"");
		
		bw.flush();
		bw.close();
	}
	
	public static void nQueen(int n,int col){
		
		if(col==n) {
			count++;
			return;
		}
		
		for(int i=0;i<n;i++) {
			
			
			arr[col]=i;
			
			if(isPromising(col)) {
				
				
				nQueen(n,col+1);
			}
		}
		
	}
	
	public static boolean isPromising(int col) {
		for(int i=0;i<col;i++) {
			if((arr[i]==arr[col])||(Math.abs(col-i)==Math.abs(arr[col]-arr[i]))) {
				return false;
			}
		}
		return true;
	}

}
