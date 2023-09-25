package prac5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prefixSum1{

	static int[] numArr;
	static int[][] scope;




	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());

		st=new StringTokenizer(br.readLine()," ");

		numArr=new int[n+1];
		scope=new int[m][2];

		numArr[0]=0;
		for(int i=1;i<=n;i++) {

			numArr[i]=numArr[i-1]+Integer.parseInt(st.nextToken());

		}

		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine()," ");
			scope[i][0]=Integer.parseInt(st.nextToken());
			scope[i][1]=Integer.parseInt(st.nextToken());
		}



		for(int i=0;i<m;i++) {
			bw.write(getPrefixSum(scope[i][0],scope[i][1])+"\n");

		}
		bw.flush();
		bw.close();

	}

	public static int getPrefixSum(int i,int j) {
		
		
		return numArr[j]-numArr[i-1];

	}
}





