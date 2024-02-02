package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test15 {
	
	static int[] arr;
	
	static int[] countArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t=Integer.parseInt(br.readLine());
		
		
		arr=new int[t];
		countArr=new int[t];
		
		for(int i=0;i<t;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<t;i++) {
			countArr[i]=getCount(arr[i],0);
		}
		
		for(int i=0;i<t;i++) {
			bw.write(countArr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int getCount(int n,int count) {
		
		if(n==0) {
			
			count++;
			return count;
		}
		else {
			
			if(n>=3) {
				
				return getCount(n-3,count)+getCount(n-2,count)+getCount(n-1,count);
			}
			
			else if(n==2) {
				return getCount(n-2,count)+getCount(n-1,count);
			}
			else {
				return getCount(n-1,count);
			}
			
			
		}
		
	}

}
