package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backTracking8 {

	public static int[][] statArr;

	public static ArrayList<Integer> resultArr=new ArrayList<Integer>();
	
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int n=Integer.parseInt(br.readLine());
		
		statArr=new int[n][n];

		visited=new boolean[n];

		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");

			for(int j=0;j<n;j++) {
				int s=Integer.parseInt(st.nextToken());

				statArr[i][j]=s;
			}
		}
		 
		
		getGap(n,0,0);
		
		
		
		
		bw.write(""+getMin(resultArr));
		
		bw.flush();
		bw.close();
		
	}

	public static void getGap(int n,int index,int depth) {

		if(depth==(n/2)) {
			
			getDifference();
			return;
		}
		
		for(int i=index;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				getGap(n,i+1,depth+1);
				
				visited[i]=false;
			}
			
		}

		
	}
	
	public static void getDifference() {
		int teamStart=0;
		int teamLink=0;
		
		for(int i=0;i<statArr.length-1;i++) {
			for(int j=i+1;j<statArr.length;j++) {
				
				if(visited[i]==true&&visited[j]==true) {
					teamStart+=(statArr[i][j]+statArr[j][i]);
				}
				
				if(visited[i]==false&&visited[j]==false) {
					teamLink+=(statArr[i][j]+statArr[j][i]);
				}
			}
		}
		
		
		int difference=Math.abs(teamStart-teamLink);
		
		resultArr.add(difference);
		
		if(difference==0) {
			System.out.println(difference);
			System.exit(0);
		}
		
	}

	public static int getMin(ArrayList<Integer> arr) {

		int min=arr.get(0);

		for(int i=1;i<arr.size();i++) {
			if(arr.get(i)<min) {
				min=arr.get(i);
			}
		}

		return min;
	}

}
