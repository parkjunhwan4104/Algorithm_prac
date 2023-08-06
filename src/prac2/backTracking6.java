package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backTracking6 {

	
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static int[][] arr=new int[9][9];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0;i<9;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				
			}		
		}
		
		sudoku(0,0);
			
		
	
	}
	
	public static void sudoku(int row,int col) throws IOException {
		if(col==9) {
			
			sudoku(row+1,0);
			return;
			
		}
		
		if(row==9) {
			
			
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
				bw.write(arr[i][j]+" ");
					
				}
				bw.write("\n");
				
			
			}
			
			bw.flush();
			bw.close();
			
			System.exit(0);
		}
		
		
		
		if(arr[row][col]==0) {
			for(int i=1;i<=9;i++) {
				
				
				if(isPromising(row,col,i)) {
					arr[row][col]=i;
					sudoku(row,col+1);
					
				}
			
			}
			arr[row][col]=0;  //무언가 잘 못 되었을 때 다시 0으로 초기화하여 되돌리기
			return;
			
		}
		else {  // arr[row][col]값이 0이 아닌경우 다음 컬럼으로 넘어가도록
			sudoku(row,col+1);
		}
		
		
		
		
	}
	
	public static boolean isPromising(int row,int col,int target) {
		
		for(int i=0;i<9;i++) {
			if(arr[row][i]==target) {
				return false;
			}
		}
		
		for(int i=0;i<9;i++) {
			if(arr[i][col]==target) {
				return false;
			}
		}
		
		int range_row=(row/3)*3;
		int range_col=(col/3)*3;	
		
		for(int i=range_row;i<range_row+3;i++) {
			for(int j=range_col;j<range_col+3;j++) {
				if(arr[i][j]==target) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	
	
}
