package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class algo2_7 { //특별

	static boolean[] isVisited=new boolean[100001];
	static int[] timeArr=new int[100001];
	static Queue<Integer> q=new LinkedList<>();

	static int[] dx= {-1, 1,2};

	public static void main(String[] args) throws Exception {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());

		q.add(n);
		isVisited[n]=true;

		bfs(n,k);
		
		bw.write(timeArr[k]+"");
		bw.flush();
		bw.close();
		
	}	

	public static void bfs(int n, int k) {

		while(!q.isEmpty()) {
			int num=q.poll();

			for(int i=0;i<dx.length;i++) {
				int newNum;
				if(i==dx.length-1) {
					newNum=num*dx[i];
					
					if(newNum>2*k) {
						continue;
					}
				}
				else {
					
					newNum=num+dx[i];
					
				}
				
				if(newNum<0||newNum>100000) {
					continue;
				}
				else {
					if(isVisited[newNum]==false) {
						q.add(newNum);
						isVisited[newNum]=true;
						timeArr[newNum]=timeArr[num]+1;
					}

				}			

			}

		}



	}

}
