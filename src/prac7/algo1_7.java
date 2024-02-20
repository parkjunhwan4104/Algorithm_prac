package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class algo1_7 {
	
	static int[][] timeArr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
			
		int n=Integer.parseInt(br.readLine());
	
		timeArr=new int[n][2];
		
		int count=0;
		
		int lastEndTime=0;
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			timeArr[i][0]=Integer.parseInt(st.nextToken());
			timeArr[i][1]=Integer.parseInt(st.nextToken());		
		}
		
		
		Arrays.sort(timeArr,new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1,int[] o2) {
				if(o1[0]==o2[0]) {
					return o1[1]-o2[1];
				}
				else {
					return o1[0]-o2[0];
				}
			}
		});
		
		for(int i=0;i<timeArr.length;i++) {
			if(i!=0) {
				if(timeArr[i][1]<lastEndTime) {
					lastEndTime=timeArr[i][1];
					continue;
				}
				
				if(lastEndTime<=timeArr[i][0]) {		
					lastEndTime=timeArr[i][1];
					count++;
				}
				
			}
			else {
				lastEndTime=timeArr[i][1];
				count++;
			}
		}
		
		bw.write(count+"");
		bw.flush();
		bw.close();
	}

}
