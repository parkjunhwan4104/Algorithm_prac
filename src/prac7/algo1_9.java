package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class algo1_9 {  //처음에 못 풀었음
	
	static char[][] board;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		board=new char[n][m];
		
		for(int i=0;i<n;i++) {
			
			String s=br.readLine();
			
			char[] temp=s.toCharArray();
			for(int j=0;j<m;j++) {
				board[i][j]=temp[j];
			}
		}
		
		
		int row=m-7;
		int col=n-7;
		
		ArrayList<Integer> countArr=new ArrayList<>();
		
		for(int i=0;i<col;i++) {
			for(int j=0;j<row;j++) {
				countArr.add(checkAround(i,j));
			}
		}
		
		int min=countArr.get(0);
		
		for(int i=1;i<countArr.size();i++) {
			if(countArr.get(i)<min) {
				min=countArr.get(i);
			}
		}
		
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	
	
	public static int checkAround(int x,int  y) {
		
		int tempCount=0;;
		
		char first=board[x][y];
		
		char tempFirst=first;
		
		for(int i=x;i<x+8;i++) {
			
			for(int j=y;j<y+8;j++) {
				if(i==x&&j==y) {
					if(first=='B') {
						first='W';
					}
					else {
						first='B';
					}
					continue;
				}
				else {
					if(j==y) {
						if(board[i][j]==tempFirst) {
							tempCount++;
											
						}
						
						if(tempFirst=='B') {
							tempFirst='W';
						}
						else {
							tempFirst='B';
						}
						
						continue;
					}
				
					if(board[i][j]!=first) {
							tempCount++;
			
						
					}
					
				}
				
				if(first=='B') {
					first='W';
				}
				else {
					first='B';
				}
				
			}
		}
		tempCount=Math.min(tempCount, 64-tempCount);
		
		return tempCount;
	}

}
