package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP12_2 {

	static int[] sequence;
	static int[] dpArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());

		sequence=new int[n+1];
		dpArr=new int[n+1];

		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		for(int i=1;i<=n;i++) {
			int k=Integer.parseInt(st.nextToken());
			sequence[i]=k;
		}

		for(int i=1;i<=n;i++) {
			getLIS(i);
		}
		
				
		bw.write(""+getMax(dpArr));
		
		bw.flush();
		bw.close();
	}

	public static int getLIS(int n) {

		if(dpArr[n]==0) {
			dpArr[n]=1;
		}
		
		for(int i=n-1;i>0;i--) {
			if(sequence[i]<sequence[n]) {
				dpArr[n]=Math.max(dpArr[n],getLIS(i)+1 );
			}
		}
	
		return dpArr[n];
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
