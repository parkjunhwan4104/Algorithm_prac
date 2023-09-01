package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class DP11 {

	static int[] grapeArr;
	static int[] dpArr;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n= Integer.parseInt(br.readLine());

		dpArr=new int[n+1];
		grapeArr=new int[n+1];

		for(int i=1;i<=n;i++) {
			int k=Integer.parseInt(br.readLine());
			grapeArr[i]=k;
		}

		if(n==1) {
			dpArr[1]=grapeArr[1];
		}

		if(n>1) {
			dpArr[1]=grapeArr[1];
			dpArr[2]=dpArr[1]+grapeArr[2];
		}

		
		getGrape(n);	

		bw.write(""+dpArr[n]);
		bw.flush();
		bw.close();

		
	}

	public static void getGrape(int n) {

		for(int i=3;i<=n;i++) {


			dpArr[i]=Math.max(Math.max(dpArr[i-3]+grapeArr[i-1], dpArr[i-2])+grapeArr[i], dpArr[i-1])    ;

		}

	}





}
