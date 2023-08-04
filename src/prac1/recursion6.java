package prac1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class recursion6 {
	
	public static char arr[][];
	 

	public static void main(String[] args) throws NumberFormatException, IOException {
		

		
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(bf.readLine());
		
		arr=new char[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=' ';
			}
		}
		
		makeStar(0,0,n);
		
		
		
		
		
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
			
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	
	public static void makeStar(int x, int y,int k) {
		
		if(k==1) {
			arr[x][y]='*';
			return;
		}
		

		else {
					
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					if(!(i==1&&j==1)) {
						makeStar(x+i*(k/3),y+j*(k/3),k/3);
					}
				}
			}
		}
		

	}
	

}
