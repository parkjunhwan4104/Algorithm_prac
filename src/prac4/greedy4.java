package prac4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class greedy4 {
	
	static char[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine(),"-");
		
		int sum=0;
		
		int i=0;
				
		while(st.hasMoreTokens()) {
		
			
			
			StringTokenizer st1=new StringTokenizer(st.nextToken(),"+");
			
			int plusTemp=0;
			
			while(st1.hasMoreTokens()) {
				plusTemp+=Integer.parseInt(st1.nextToken());
			}
			
			if(i==0) {
				sum+=plusTemp;
			}
			else {
				sum-=plusTemp;
			}
			i++;
			
			
		}
		
		bw.write(""+sum);
		
		bw.flush();
		bw.close();
		
	}	
	
	
	
}
