package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class test9 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		ArrayList<Integer> arr=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		//Arrays.sort()는 평균 시간 복잡도가 O(nlogn)이지만 최악의 경우 O(n^2)이다
		//Collections.sort()는 시간복잡도 O(n)~O(nlogn)을 보장한다.
		
		for(int i=0;i<arr.size();i++) {
			bw.write(arr.get(i)+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
