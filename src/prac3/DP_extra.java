package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP_extra {

	static int[] arr;
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int t=Integer.parseInt(br.readLine());

		

		while(t>0) {
			int n=Integer.parseInt(br.readLine());

			arr=new int[n];

			StringTokenizer st=new StringTokenizer(br.readLine()," ");

			for(int i=0;i<n;i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			t--;

			bw.write(""+distribute(n)+"\n");
			
		}
		bw.flush();
		bw.close();

	}

	public static int distribute(int n) {

		ArrayList<Integer> minList=getMin(arr);
		
		int[] posibilites=new int[5]; // 최소값~ 최소값-4까지
		
		int min=minList.get(1);
		for(int i=0;i<posibilites.length;i++) {
			
			for(int j=0;j<n;j++) {
				int differ=arr[j]-min;
				int count=differ/5+ (differ%5)/2+ ((differ%5)%2)/1;
				posibilites[i]+=count;
			}
			min--;  //최소값~ 최소값-4 까지 커버하기 위해 1씩 감소 최대 4까지 감소
		}
		
		ArrayList<Integer> posibleList=getMin(posibilites);
		
		
		return posibleList.get(1); 
		
	}


	public static ArrayList<Integer> getMin(int[] arr) {

		int min=arr[0];
		int index=0;

		ArrayList<Integer> list=new ArrayList<>();

		for(int i=1;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
				index=i;
			}
		}
		list.add(index);
		list.add(min);


		return list;
	}

}






