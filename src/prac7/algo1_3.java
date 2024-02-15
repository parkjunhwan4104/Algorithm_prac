package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class algo1_3 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		int zeroCount=0;
		
		Stack<Integer> st=new Stack<>();
		
		int sum=0;
		
		for(int i=0;i<n;i++) {
			st.add(Integer.parseInt(br.readLine()));
		}
		
		
		while(!st.isEmpty()) {
			
			
			if(st.peek()==0) {
				
				st.pop();
				zeroCount++;
			}
			else {
				if(zeroCount==0) {
					sum+=st.pop();
				}
				else {
					st.pop();
					zeroCount--;
				}
							
			}
		}
		
		bw.write(""+sum);
		bw.flush();
		bw.close();
		
		
	}

}
