package prac5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prefixSum3 {
	
	static int[][] alphabetSum;
	static char[] sentence;
	static int[] result;
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s=br.readLine();
		
		sentence=s.toCharArray();
		
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		int l=sentence.length;
		
		alphabetSum=new int[l+1][26];
		result=new int[n];
	
		
		for(int i=1;i<=l;i++) {
			
			int index=sentence[i-1]-'a';   //어떤 알파벳인지에 대한 인덱스번호
			
			for(int j=0;j<26;j++) {
				
				alphabetSum[i][j]=alphabetSum[i-1][j];
				
				if(index==j) {
					alphabetSum[i][j]=alphabetSum[i-1][j]+1;
				}
			}
			
		}
	
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int index=st.nextToken().charAt(0)-'a';
			
			int start=Integer.parseInt(st.nextToken())+1;
			int end=Integer.parseInt(st.nextToken())+1;
					
			result[i]=alphabetSum[end][index]-alphabetSum[start-1][index];
			
			
		}
		
		for(int i=0;i<n;i++) {
			bw.write(result[i]+"\n");
		}
	
		bw.flush();
		bw.close();
	}
	
	
	
		
	

}
