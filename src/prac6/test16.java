package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test16 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
			
		
		int crossLineNum=1;
		
		while(n-crossLineNum>0) {
			n=n-crossLineNum;
			crossLineNum++;
		}
		
		int targetNumInCrossLine=n;
		
		if(crossLineNum%2==1) {
			bw.write((crossLineNum+1-targetNumInCrossLine)+"/"+targetNumInCrossLine);
		}
		else {
			bw.write(targetNumInCrossLine+"/"+(crossLineNum+1-targetNumInCrossLine));
		}
		
		
		bw.flush();
		bw.close();
		
		
	}

}
