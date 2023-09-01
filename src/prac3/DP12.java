package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class DP12 {

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
			
			dpArr[i]=1;
		}

	
		getLIS(n);
				
		bw.write(""+getMax(dpArr));
		
		bw.flush();
		bw.close();
	}

	public static void getLIS(int n) {

		
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(sequence[i]>sequence[j]&&dpArr[i]<=dpArr[j]+1) {
					dpArr[i]=dpArr[j]+1;					
				}
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
