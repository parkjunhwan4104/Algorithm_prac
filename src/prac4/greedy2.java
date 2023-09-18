package prac4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class greedy2 {
	
	static int[][] time;
	
	static int count=1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());
		
		time=new int[n][2];
		
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			
			st=new StringTokenizer(br.readLine()," ");
			
			time[i][0]=Integer.parseInt(st.nextToken());
			time[i][1]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1]==o2[1]) { //끝나는 시간이 같으면 시작시간이 빠른게 더 낮은 인덱스 값을 가짐
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
			
		});
		
		getCount(n);
		
		bw.write(""+count);
		bw.flush();
		bw.close();
	
	}
	
	public static void getCount(int n) {
		
		int temp=time[0][1];
		
		for(int i=1;i<n;i++) {
			if(time[i][0]>=temp) { //회의가 시작하자마자 끝날수 있으므로 크거나 같다임 ex) (4,8), (8,8)이면 2개가 되는 거임
				temp=time[i][1];
				count++;
			}
		}
		
		
	}
	

	
	

}
