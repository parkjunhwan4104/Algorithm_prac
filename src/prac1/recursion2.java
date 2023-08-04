package prac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recursion2 {
	
	public static int fibonacci(int n) {
		
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		
		return fibonacci(n-1)+fibonacci(n-2);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(read.readLine());
		
		System.out.println(fibonacci(n));
	}
	
	

}
