package prac4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class greedy1 {
	
	private static int[] value;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		value=new int[n];
		
		for(int i=0;i<n;i++) {
			value[i]=Integer.parseInt(br.readLine());
		}
		
		
		
		bw.write(""+coinCount(n,k,0));
		bw.flush();
		
		bw.close();
	}
	
	public static int coinCount(int n,int k,int total) {
		 
		int max=0;
		int count=total;
		int save=0;  //나머지
		
		for(int i=0;i<n;i++) {
			if(value[i]<=k) {
				max=value[i];
			}
		}
		
		count+=(k/max);
		save=(k%max);
		
		if(save==0) {
			return count;
		}
		
		return coinCount(n,save,count);
		
		
	}
}
