package prac4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class greedy3 {
	
	static int[][] people;
	static int[] countArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		people=new int[n][2];
		countArr=new int[n];
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			people[i][0]=i;
			people[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(people, new Comparator<int[]>(){
			
			public int compare(int[] o1,int[] o2) {
				return o1[1]-o2[1];
			}
			
			
		});
		
		int count=0;
		
		int temp=0;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				countArr[i]+=people[j][1];
			}
			
			
			count=temp+countArr[i];
			temp=count;
		}
		
		bw.write(""+count);
		bw.flush();
		bw.close();
	
	}
	

}
