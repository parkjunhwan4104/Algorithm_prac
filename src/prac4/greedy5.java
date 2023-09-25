package prac4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class greedy5 {

	static long[] kilo;
	static long[] gasCost;
	static long total=0;
	static long minCost;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());

		kilo=new long[n-1];
		gasCost=new long[n];

		StringTokenizer st=new StringTokenizer(br.readLine()," ");;

		for(int i=0;i<kilo.length;i++) {
			kilo[i]=Long.parseLong(st.nextToken());
		}

		st=new StringTokenizer(br.readLine()," ");

		for(int i=0;i<n;i++) {
			gasCost[i]=Long.parseLong(st.nextToken());
		}

		total+=gasCost[0]*kilo[0];
		minCost=gasCost[0];

		if(n==2) {
			bw.write(""+total);
		}
		else {
			getMiniMum(n);
			bw.write(""+total);
		}
		bw.flush();
		bw.close();
	}

	public static void getMiniMum(int n) {


		for(int i=1;i<n-1;i++) {



			if(gasCost[i]>minCost) {
				total+=minCost*kilo[i];
			}
			else {
				total+=gasCost[i]*kilo[i];
				minCost=gasCost[i];
			}


		}
	}







}	
