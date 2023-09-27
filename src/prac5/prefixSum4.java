package prac5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class prefixSum4 {
	
	static long[] numArr;
	static long[] modArr;
	static long[] cntArr;
	static long count=0;
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
	
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		numArr=new long[n+1];
		modArr=new long[n+1];
		cntArr=new long[m];
		
		st=new StringTokenizer(br.readLine()," ");
		
		for(int i=1;i<=n;i++) {
			numArr[i]=(numArr[i-1]+Integer.parseInt(st.nextToken()));	
			modArr[i]=numArr[i]%m;
			
			if(modArr[i]==0) {
				count++;
			}			
			cntArr[(int)modArr[i]]++;
		
		}
		
		for(int i=0;i<m;i++) {
			if(cntArr[i]>1) {
				count+=(cntArr[i]*(cntArr[i]-1))/2;
			}
		}
		
		bw.write(""+count);
		bw.flush();
		bw.close();
				
	}
	

	
	
}
