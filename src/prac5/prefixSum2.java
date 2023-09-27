package prac5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prefixSum2 {
	
	static int[] numArr;
	//static int[] tempArr;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		
		int k=Integer.parseInt(st.nextToken());
		//tempArr=new int[n+k];
	
		numArr=new int[n+1];
		
		numArr[0]=0;
		st=new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			numArr[i]=numArr[i-1]+Integer.parseInt(st.nextToken());
		}
		
		int max=Integer.MIN_VALUE;
		
		for(int i=k;i<=n;i++) {
		
			int sum=numArr[i]-numArr[i-k];
			
			if(max<sum) {
				max=sum;
			}
			
		
		}
		
		
		bw.write(""+max);
		bw.flush();
		bw.close();
	 
		
	}
	
	
	

}
