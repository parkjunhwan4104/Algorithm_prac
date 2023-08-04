package prac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recursion1 {
	
	public static long factorial(int n) {
		
		if(n<=1) {
			return 1;
		}
		
		return factorial(n-1)*n;
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		 int n=Integer.parseInt(reader.readLine());
		 
		 System.out.println(factorial(n));
	}

}
