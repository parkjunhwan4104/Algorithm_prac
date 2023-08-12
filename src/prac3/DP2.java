package prac3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DP2 {

	public static ArrayList<int[]> arr=new ArrayList<int[]>();

	public static int[][][] dpArr=new int[21][21][21];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

				
		while(true) {
			int[] tempArr=new int[3];

			StringTokenizer st=new StringTokenizer(br.readLine()," ");

			for(int i=0;i<3;i++) {
				int n=Integer.parseInt(st.nextToken());
				tempArr[i]=n;
			}

			if(tempArr[0]==-1&&tempArr[1]==-1&&tempArr[2]==-1) {

				break;
			}


			arr.add(tempArr);

		}
		
		

		for(int i=0;i<arr.size();i++) {
			int a=arr.get(i)[0];
			int b=arr.get(i)[1];
			int c=arr.get(i)[2];

			bw.write("w("+a+", "+b+", "+c+") = "+w(a,b,c));
	
			bw.write("\n");
		}

		bw.flush();
		bw.close();

	}

	public static int w(int a,int b,int c) {

		
		
		if(a<=0||b<=0||c<=0) {
			return 1;
		}
		
		else if(a>20||b>20||c>20) {
			return dpArr[20][20][20]=w(20,20,20);
		}

		else if(dpArr[a][b][c]!=0) {
			return dpArr[a][b][c];
		}
		
		else if(a<b&&b<c) {
			return dpArr[a][b][c]=w(a,b,c-1)+w(a,b-1,c-1)-w(a,b-1,c);
		}
		else {
			return dpArr[a][b][c]=w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		}
		
		
	}



}

