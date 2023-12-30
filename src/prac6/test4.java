package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test4 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n=Integer.parseInt(br.readLine());
		
		int count=0;
		
		for(int i=1;i<=n;i++) {
			if(i<10) {
				count++;
			}
			else if(i>=10&&i<100) {
				count++;
			}
			else if(i>=100&&i<1000) {
				int hundred=i/100;
				int ten=(i%100)/10;
				int one=(i%100)%10;
				
				if(hundred==ten&&ten==one) {
					count++;
					continue;
				}
				
				for(int j=1;j<5;j++) {
					if(hundred>ten&&ten>one) {
						if(hundred-ten==j&&ten-one==j) {
							count++;
							break;
						}
					}
					if(hundred<ten&&ten<one) {
						if(ten-hundred==j&&one-ten==j) {
							count++;
							break;
						}
					}
				}
			}
			else {
				break;
			}
			
		}
		
		bw.write(""+count);
		bw.flush();
		bw.close();
	}
}
