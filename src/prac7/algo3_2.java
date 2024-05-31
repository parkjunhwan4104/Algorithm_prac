package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class algo3_2 {

	static int[] sequence;
	static Stack<Integer> st=new Stack<>();
	
	public static void main(String[] args) throws IOException { //특수

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());

		sequence=new int[n];
		ArrayList<Character> arList=new ArrayList<>();
		
		int temp=1;
		boolean isPossi=true; // 스택 수열의 과정을 거칠수 있는 지
		
		for(int i=0;i<n;i++) {
			sequence[i]=Integer.parseInt(br.readLine());
			
			
			for(;temp<=sequence[i];temp++) {
				
				st.push(temp);
				arList.add('+');
			}
			
			if(st.peek()==sequence[i]) {
				st.pop();
				arList.add('-');
			}
			else {
				isPossi=false;
			}
	

		}

		

		if(!isPossi) {
			bw.write("NO");
			
		}
		else {

			for(int i=0;i<arList.size();i++) {
				
				
				bw.write(arList.get(i)+"\n");
				
						
			}

		}

		bw.flush();
		bw.close();

	}


	
}
