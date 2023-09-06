package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP15 {
	
	static char[][] str=new char[2][];
	static int[][] dpArr;
	

 	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String s1=br.readLine();
		
		
		String s2=br.readLine();
		
		str[0]=s1.toCharArray();
		str[1]=s2.toCharArray();
		
		dpArr=new int[str[0].length+1][str[1].length+1];
		
		
		getLCS();
		
		bw.write(""+dpArr[str[0].length][str[1].length]);
		bw.flush();
		bw.close();
	}
	
	public static void getLCS() {
		for(int i=1;i<=str[0].length;i++) {
			for(int j=1;j<=str[1].length;j++) {
				
				if(str[0][i-1]==str[1][j-1]) {
					dpArr[i][j]=dpArr[i-1][j-1]+1;
				}
				else {
					dpArr[i][j]=Math.max(dpArr[i][j-1], dpArr[i-1][j]);
				}
			}
		}
		
	
	}

}
