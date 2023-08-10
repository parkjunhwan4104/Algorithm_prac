package prac2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class backTracking7 {

	static int[] numArr;

	static int[] operatorArr=new int[4];

	static ArrayList<Integer> resultArr=new ArrayList<Integer>();

	



	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n=Integer.parseInt(br.readLine());

		numArr=new int[n];

		StringTokenizer st=new StringTokenizer(br.readLine()," ");

		for(int i=0;i<n;i++) {

			numArr[i]=Integer.parseInt(st.nextToken());
		}

		st=new StringTokenizer(br.readLine()," ");

		for(int i=0;i<4;i++) {
			operatorArr[i]=Integer.parseInt(st.nextToken());
		}

		putOperator(n,numArr[0],1);

		int max=getMax(resultArr);
		int min=getMin(resultArr);
		
		
		bw.write(""+max);
		bw.write("\n");
		bw.write(""+min);
		
		bw.flush();
		bw.close();

	}

	public static void putOperator(int n,int num,int depth) {


		if(depth==n) {
			resultArr.add(num);
			return;
		}


		for(int i=0;i<operatorArr.length;i++) {
			if(operatorArr[i]>0) {
				operatorArr[i]--;

				switch(i) {

				case 0: 
					putOperator(n,num+numArr[depth],depth+1);
					break;

				case 1:
					putOperator(n,num-numArr[depth],depth+1);
					break;

				case 2: 
					putOperator(n,num*numArr[depth],depth+1);
					break;

				case 3: 
					putOperator(n,num/numArr[depth],depth+1);
					break;
				}
				operatorArr[i]++;
			}

		}




	}

	public static int getMax(ArrayList<Integer> arr) {

		int max=arr.get(0);

		for(int i=1;i<arr.size();i++) {
			if(arr.get(i)>max) {
				max=arr.get(i);
			}
		}

		return max;
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
