package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class DP9 {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		bw.write(""+operation(n,0));
		bw.flush();
		bw.close();
		
	}
	
	public static int operation(int n,int count) {
		
		if(n<2) {  //n==1이 아닌 이유는 예를 들어 n이 2일 때 아래 else문에서 3으로 나누면 몫이 0이고 나머지가 2가 되는데 이 때 매개변수 n값에 0이 들어가게 되므로 오류가 생김
			
			return count;
			
		}
		
		
		else {
		
			return Math.min(operation(n/2,count+1+(n%2)), operation(n/3,count+1+(n%3)));
			

		}
		
		
		
	
	}
	
	

}
