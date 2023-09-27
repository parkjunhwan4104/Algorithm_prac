package prac5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prefixSum3 {
	
	static int[][] range;
	static String[] alpha;
	static char[] sentence;
	static int[] result;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		
		sentence=s.toCharArray();
		
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		
		range=new int[n][2];
		alpha=new String[n];
		result=new int[sentence.length];
				
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			alpha[i]=st.nextToken();
			
			range[i][0]=Integer.parseInt(st.nextToken());
			range[i][1]=Integer.parseInt(st.nextToken());
							
		}
	
	}
	
	
	
		
	

}
