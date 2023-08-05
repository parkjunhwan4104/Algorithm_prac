package prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class recursion7 {
	
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		
		int n=Integer.parseInt(bf.readLine());
		
		bw.write((int)(Math.pow(2, n)-1)+"\n");
		
		hanoi(1,2,3,n);
		
		bw.flush();
		bw.close();
	}
	
	public static void hanoi(int start,int mid,int end,int n) throws IOException {
		if(n==1) {
			bw.write(start+" "+end+"\n");
			return;
		}
		
		hanoi(start,end,mid,n-1);
		
		bw.write(start+" "+end+"\n");
		
		hanoi(mid,start,end,n-1);
	}

}
