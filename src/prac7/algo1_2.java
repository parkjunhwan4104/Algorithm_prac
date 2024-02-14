package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

public class algo1_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		String s=br.readLine();
		
		char[] arr=s.toCharArray();
		
		Integer[] numArr=new Integer[arr.length];
		
		for(int i=0;i<arr.length;i++) {
			numArr[i]=Character.getNumericValue(arr[i]);
		}
		
		Arrays.sort(numArr,Collections.reverseOrder());
	
		for(int i=0;i<numArr.length;i++) {
			bw.write(""+numArr[i]);
		}
		
		bw.flush();
		bw.close();
	}

}
