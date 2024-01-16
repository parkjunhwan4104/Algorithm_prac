package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test11 {
	
	static int[] withDrawTime;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		withDrawTime=new int[n];
		
		int min=0;
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			
			withDrawTime[i]= Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(withDrawTime);
	
		for(int i=0;i<withDrawTime.length;i++) {
			
			
			for(int j=0;j<=i;j++) {
				min+=withDrawTime[j];
			}
		}
		
		bw.write(""+min);
		bw.flush();
		bw.close();
	
	}
	
}
