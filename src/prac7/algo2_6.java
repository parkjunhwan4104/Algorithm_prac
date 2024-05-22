package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class algo2_6 {  //특별
	
	public static void main(String[] args) throws NumberFormatException, IOException  {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		int num=666;
		
		int count=0;
		
		while(true) {
			
			String snum=Integer.toString(num);
			
			if(snum.contains("666")) {
				count++;
			}
			
			if(count==n) {
				break;
			}
			else {
				num++;
			}
			
		}
		
		
		bw.write(num+"");
		bw.flush();
		bw.close();
	}

}
