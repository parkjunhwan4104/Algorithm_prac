package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Arrays;
import java.util.Comparator;

public class test14 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	
		int n=Integer.parseInt(br.readLine());
		
		String[] arr=new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i]=br.readLine();
		}
		
		Arrays.sort(arr, new Comparator<String>() {
			
			// compare 함수의 리턴값이 양수면 둘의 자리를 바꾸고 음수라면 그대로 둠
			@Override
			public int compare(String a1,String a2) {
				
				if(a1.length()==a2.length()) {
					return a1.compareTo(a2);
				}
				else {
					return a1.length()-a2.length();
				}
			}
		});
		
		
		for(int i=0;i<arr.length;i++) {
			if(i!=arr.length-1) {
				if(arr[i].equals(arr[i+1])) {
					continue;
				}
				else {
					bw.write(arr[i]+"\n");
				}
			}
			else {
				bw.write(arr[i]);
			}
			
			
			
		}
		bw.flush();
		bw.close();
		
		
	}

}
