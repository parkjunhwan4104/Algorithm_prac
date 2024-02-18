package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class algo1_6 {
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		String[][] memberArr=new String[n][2];
		
		StringTokenizer st;
			
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			
			memberArr[i][0]=st.nextToken();
			memberArr[i][1]=st.nextToken();
		}
		
		Arrays.sort(memberArr,new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				
				int age1=Integer.parseInt(o1[0]);
				int age2=Integer.parseInt(o2[0]);
				
				if(age1==age2) {
					return 0;
				}
				else {
					return age1-age2;
			}
				
				
			}
			
		});
		
		for(int i=0;i<n;i++) {
			bw.write(memberArr[i][0]+" "+memberArr[i][1]+"\n");
		}
		bw.flush();
		bw.close();
	}
}
