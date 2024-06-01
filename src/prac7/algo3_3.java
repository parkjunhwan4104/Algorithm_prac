package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.LinkedList;

public class algo3_3 {
	
	static boolean[] isVisited;

	static LinkedList<Integer> arr=new LinkedList<>();
	public static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		isVisited=new boolean[n+1];
				
		perputation(n,m);
		
		bw.flush();
		bw.close();
	}
	
	public static void perputation(int n,int left) throws IOException{
		
		
		
		if(left==0) {
			for(int i=0;i<arr.size();i++) {
			//	System.out.print(arr.get(i)+" ");
				bw.write(arr.get(i)+" ");
			}
		//	System.out.println();
			bw.write("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			
			if(isVisited[i]==true) {
				continue;
			}
				
			isVisited[i]=true;
			arr.addLast(i);
			
			perputation(n,left-1);
			
			isVisited[i]=false;
			arr.removeLast();
			
		}
		
		
	}

}
