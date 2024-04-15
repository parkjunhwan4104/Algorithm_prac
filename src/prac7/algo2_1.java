package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo2_1 {
	
	static int body[][];
	static int rank[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		body=new int[n][2];
		rank=new int[n];
		
		for(int i=0;i<n;i++) {
			rank[i]=1;
		}
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			body[i][0]=Integer.parseInt(st.nextToken());
			body[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(i==j) {
					continue;
				}
				else {
					if(body[i][0]<body[j][0]&&body[i][1]<body[j][1]) {
						rank[i]++;
					}
					
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			bw.write(rank[i]+" ");
		}
		
		bw.flush();
		bw.close();
	}

}
