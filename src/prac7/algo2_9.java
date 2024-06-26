package prac7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Comparator;

public class algo2_9 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[n][2];
		
		for(int i=0;i<n;i++) {
			
			st=new StringTokenizer(br.readLine()," ");
			
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
			
		}
		
		Arrays.sort(arr, new Comparator<int[]>(){
			
			@Override
			public int compare(int[] o1,int[] o2) {
				
				
				if(o1[1]<o2[1]) {
					return -1;
				}
				else if(o1[1]==o2[1]) {
					
					return o1[0]-o2[0];
				}
				else {
					return 1;
				}
				
				
			}
			
		});
		
		for(int i=0;i<n;i++) {
			bw.write(arr[i][0]+" "+arr[i][1]+"\n");
		}
		
		bw.flush();
		bw.close();
	}

}
