package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class test6 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());
		
		int count=n;
		
		String s;
		
		ArrayList<Character> arr;
		
		for(int i=0;i<n;i++) {
			s=br.readLine();
			
			char[] c=s.toCharArray();
			
			arr=new ArrayList<>();
			
			boolean isValidatedLoop=true;
			
			for(int j=0;j<c.length;j++) {
				
				if(arr.size()==0) {
					arr.add(c[j]);
					
				}
				else {
					if(arr.get(arr.size()-1)==c[j]) {
						continue;
					}
					else {
						arr.add(c[j]);
					}
				}
						
			}
			
			for(int j=0;j<arr.size();j++) {
				
				if(isValidatedLoop==false) {
					isValidatedLoop=true;
					break;
				}
				for(int k=j+1;k<arr.size();k++) {
					
					
					if(arr.get(j)==arr.get(k)) {
						count--;
						isValidatedLoop=false;
						break;
					}
					
				}
			}
			
		}
		
		bw.write(""+count);
		bw.flush();
		bw.flush();
	}

}
