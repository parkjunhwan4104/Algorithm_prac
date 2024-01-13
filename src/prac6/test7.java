package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test7 {

	static int dpArr[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		dpArr=new int[n+1];
		
		
		
		bw.write(""+getMinimum(n));
		bw.flush();
		bw.close();
	}
	
	
	
	public static int getMinimum(int n) {
	
		if(n==1) {
			dpArr[n]=0;
		}
		else if(n==2||n==3) {
			dpArr[n]=1;
		}
		else {
			if(dpArr[n]==0) {
				if(n%6==0) {
					dpArr[n]=Math.min(getMinimum(n/3)+1,Math.min(getMinimum(n/2)+1, getMinimum(n-1)+1));
					
				}
				else if(n%3==0) {
					dpArr[n]=Math.min(getMinimum(n/3)+1, getMinimum(n-1)+1);
				}
				else if(n%2==0) {
					dpArr[n]=Math.min(getMinimum(n/2)+1, getMinimum(n-1)+1);
				}
				else {
					dpArr[n]=getMinimum(n-1)+1;
				}
			}
		}
		
		return dpArr[n];
	}
	
	

}
