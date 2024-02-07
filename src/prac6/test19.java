package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test19 {

	static int[] standardArr;
	static int[] numArr;

	static int[] resultArr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());

		standardArr=new int[n];

		StringTokenizer st=new StringTokenizer(br.readLine()," ");;

		for(int i=0;i<n;i++) {


			standardArr[i]=Integer.parseInt(st.nextToken());
		}

		Arrays.sort(standardArr);

		int m=Integer.parseInt(br.readLine());

		numArr=new int[m];
		resultArr=new int[m];

		st=new StringTokenizer(br.readLine()," ");

		for(int i=0;i<m;i++) {

			numArr[i]=Integer.parseInt(st.nextToken());

			findNum(n,numArr[i],0,n-1,i);
		}

		for(int i=0;i<m;i++) {
			bw.write(resultArr[i]+"\n");
		}

		bw.flush();
		bw.close();
	}

	public static void findNum(int n,int target,int start,int end,int index) {

		int mid=(start+end)/2;

		if(mid<start) {
		
			return;
			
		}
		if(mid>end) {
		
			return;
		}



		if(target>standardArr[end]) {

			return;
		}
		if(target<standardArr[start]) {
		
			return;
		}



		if(target>standardArr[mid]) {
			findNum(n,target,mid+1,end,index);
		}
		else if(target<standardArr[mid]) {
			findNum(n,target,start,mid-1,index);
		}
		else {
			resultArr[index]=1;
		}



	}

}
