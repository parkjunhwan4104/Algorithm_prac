package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class test1 {

	static int[][] inputArr;
	static int[] resultArr;
	static int count=0;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st;

		int t=Integer.parseInt(br.readLine());

		inputArr=new int[t][6];
		resultArr=new int[t];

		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine()," ");

			inputArr[i][0]=Integer.parseInt(st.nextToken());
			inputArr[i][1]=Integer.parseInt(st.nextToken());
			inputArr[i][2]=Integer.parseInt(st.nextToken());
			inputArr[i][3]=Integer.parseInt(st.nextToken());
			inputArr[i][4]=Integer.parseInt(st.nextToken());
			inputArr[i][5]=Integer.parseInt(st.nextToken());
		}

		polynom(t);

		for(int i=0;i<t;i++) {
			bw.write(resultArr[i]+"\n");
		}

		bw.flush();
		bw.close();
	}

	public static void polynom(int t) {

		int xDistance;
		int yDistance;
		int radiusSum;

		for(int i=0;i<t;i++) {

			xDistance=(int)Math.pow((inputArr[i][0]-inputArr[i][3]),2);
			yDistance=(int)Math.pow((inputArr[i][1]-inputArr[i][4]),2);
			radiusSum=(int)Math.pow(inputArr[i][2]+inputArr[i][5], 2);


			if(inputArr[i][0]==inputArr[i][3]&&inputArr[i][1]==inputArr[i][4]&&inputArr[i][2]==inputArr[i][5]) {
				resultArr[i]= -1;

			}
			else {
				if(radiusSum<xDistance+yDistance) {
					resultArr[i]=0;
				}

				else if(xDistance+yDistance<(int)Math.pow(inputArr[i][2]-inputArr[i][5], 2)) {
					resultArr[i]=0;
				}

				else if(xDistance+yDistance==radiusSum) {
					resultArr[i]=1;
				}

				else if(xDistance+yDistance==(int)Math.pow(inputArr[i][2]-inputArr[i][5], 2)) {
					resultArr[i]=1;

				}
				else {
					resultArr[i]=2;
				}




			}
		}
	}
}




