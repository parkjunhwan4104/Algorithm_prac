package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test20 {
	
	
	static int locationArr[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		locationArr=new int[n][2];
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			
			locationArr[i][0]=x;
			locationArr[i][1]=y;
			
			
		}
		Arrays.sort(locationArr,new Comparator<int[]>(){

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
				
			}
			
		});
		
		
		for(int i=0;i<n;i++) {
			bw.write(locationArr[i][0]+" "+locationArr[i][1]+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
