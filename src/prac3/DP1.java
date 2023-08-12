package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP1 {
	
	public static int countRecur=0;
	public static int countDp=0;
	
	public static int[] dpArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		dpArr=new int[n];
		dpArr[0]=1;
		dpArr[1]=1;
		
		recursive(n);
		dynamicProgramming(n);
		
		bw.write(countRecur+" "+countDp);
		
		bw.flush();
		bw.close();
	}
	
	public static int recursive(int n) {
		
		
		
		if(n==1||n==2){
			countRecur++;
			return 1;
		}
		
		else {
			
			return recursive(n-2)+recursive(n-1);
		}
				
	}
	
	public static int dynamicProgramming(int n) {
		
		
		for(int i=2;i<n;i++) {
			countDp++;
			dpArr[i]=dpArr[i-1]+dpArr[i-2];
		}
		
		return dpArr[n-1];
		
	}

}
