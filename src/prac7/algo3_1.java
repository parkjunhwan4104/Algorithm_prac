package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer; 

public class algo3_1 {
	
	static int[] arr;
	static int[] dpArr;
	
	public static void main(String[] args) throws IOException { //특수
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		arr=new int[n];
		dpArr=new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			dpArr[i]=1;
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]&&dpArr[i]<=dpArr[j]) {
					dpArr[i]=dpArr[j]+1;
				}
			}
		}
		
	
		
		
		bw.write(getMax(dpArr)+"");
		bw.flush();
		bw.close();
		
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
