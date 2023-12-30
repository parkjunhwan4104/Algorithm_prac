package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;


public class test5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));


		int n=Integer.parseInt(br.readLine());

		String[] result=new String[n];

		Stack<Character> stack;
		for(int i=0;i<n;i++) {
			stack=new Stack<>();

			String s=br.readLine();
			char[] c=s.toCharArray();

			for(int j=0;j<c.length;j++) {
				if(c[j]=='(') {
					stack.push(c[j]);
				}
				else {
					if(stack.isEmpty()) {

						stack.push(c[j]);
					}
					else {
						if(stack.peek()==')') {
							stack.push(c[j]);
						}
						else {
							stack.pop();
						}
						
					}
				}
			}
			if(stack.isEmpty()) {
				result[i]="YES";
			}
			else {
				result[i]="NO";
			}
		
		}
		
		for(int i=0;i<result.length;i++) {
			bw.write(""+result[i]+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
