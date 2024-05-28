package prac7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo2_8 {
	
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException  { //특별
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		isVisited=new boolean[n+1];
		
		combination(n,m,1);
		
	}
	
	public static void combination(int n,int m,int start) {
		
		if(m==0) {
			for(int i=1;i<=n;i++) {
				if(isVisited[i]==true) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
			return;
		}
		
		for(int i=start;i<=n;i++) {
			
			isVisited[i]=true;
			
			combination(n,m-1,i+1);
		
			isVisited[i]=false;
			
							
		}
		
	}

}
