package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class algo1_8 {
	
	static int costArr[][];
	static int dpArr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		costArr=new int[n][3];
		dpArr=new int[n][3];
		
		
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			costArr[i][0]=Integer.parseInt(st.nextToken());
			costArr[i][1]=Integer.parseInt(st.nextToken());
			costArr[i][2]=Integer.parseInt(st.nextToken());
		}
		
		dpArr[0][0]=costArr[0][0];
		dpArr[0][1]=costArr[0][1];
		dpArr[0][2]=costArr[0][2];
		
		for(int i=1;i<n;i++) {
			dpArr[i][0]=costArr[i][0]+Math.min(dpArr[i-1][1],dpArr[i-1][2]);
			dpArr[i][1]=costArr[i][1]+Math.min(dpArr[i-1][0],dpArr[i-1][2]);
			dpArr[i][2]=costArr[i][2]+Math.min(dpArr[i-1][1],dpArr[i-1][0]);
		}
		
		int result=getMin(dpArr[n-1]);
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		
	}
	
	
	public static int getMin(int[] arr) {
		int min=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		return min;
	}
	

}
