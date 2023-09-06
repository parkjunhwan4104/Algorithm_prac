package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class DP14 {


	static int[] dpArr;
	static int[][] connected;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());

		dpArr=new int[n];
		connected=new int[n][2];


		StringTokenizer st;

		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine(), " ");
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());

			connected[i][0]=a;
			connected[i][1]=b;

			dpArr[i]=1;
		}

		Arrays.sort(connected,new Comparator<int[]>() {

			public int compare(int[] o1,int[] o2) {
				return o1[0]-o2[0];
			}
		});

		deleteLine(n);
		
		
		int max=getMax(dpArr);
		
		bw.write(""+(n-max));   //전선줄의 개수에서 연결 가능한 최대 전선을 뺴면 없애야할 최소 전선의 개수를 알 수 있음
		
		bw.flush();
		bw.close();
	}

	public static void deleteLine(int n) {

		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {

				if(connected[i][1]>connected[j][1]) {
					dpArr[i]=Math.max(dpArr[i], dpArr[j]+1);
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
