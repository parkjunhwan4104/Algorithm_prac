package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class algo1_1 {
	
	static int apart[][];
	
	static boolean isVisited[][];
	
	static int count=0;
	
	static ArrayList<Integer> countArr=new ArrayList<>();
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		apart=new int[n+1][n+1];
		isVisited=new boolean[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String strArr=br.readLine();
			char[] arr=strArr.toCharArray();
			
			for(int j=1;j<=n;j++) {
				apart[i][j]=Character.getNumericValue(arr[j-1]);
			}
		}
		
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(apart[i][j]==1) {
					
					if(isVisited[i][j]==true) {
						continue;
					}
					else {
					//	System.out.println("i: "+i+", j: "+j);
					//	System.out.println("--------------");
						findComplex(i,j,n);
						if(count!=0) {
							countArr.add(count);
						}
						
						count=0;
					}
				}
				else {
					isVisited[i][j]=true;
				}
			}
		}
		
		Collections.sort(countArr);
		
		bw.write(countArr.size()+"\n");
		for(int i=0;i<countArr.size();i++) {
			bw.write(countArr.get(i)+"\n");
		
		}
		
		bw.flush();
		bw.close();
		
	}
	
	public static void findComplex(int i,int j,int n) {
		
		isVisited[i][j]=true;
		
		count=count+1;
	
		if(i==n&&j==n) {
			if(apart[i-1][j]==0&&apart[i][j-1]==0) {
				return;
			}
		}
		
		else if(i==n) {
			if(apart[i-1][j]==0&&apart[i][j-1]==0&&apart[i][j+1]==0) {
				return;
			}
		}
		
		else if(j==n) {
			if(apart[i-1][j]==0&&apart[i+1][j]==0&&apart[i][j-1]==0) {
				return;
			}
		}
		
		
		else {
			if(apart[i-1][j]==0&&apart[i+1][j]==0&&apart[i][j-1]==0&&apart[i][j+1]==0) {
				return;
			}
		}
		
		
		
		apart[i][j]=0;
		
				
		if(isVisited[i-1][j]==false&&apart[i-1][j]==1) {
			
			
			findComplex(i-1,j,n);
		}
		
		if(i!=n) {
			if(isVisited[i+1][j]==false&&apart[i+1][j]==1) {
				findComplex(i+1,j,n);
			}
			
		}
		
		
		if(isVisited[i][j-1]==false&&apart[i][j-1]==1) {
			findComplex(i,j-1,n);
		}
		
		if(j!=n) {
			if(isVisited[i][j+1]==false&&apart[i][j+1]==1) {
				findComplex(i,j+1,n);
			}
		}
	
		
		
		
	}

}
