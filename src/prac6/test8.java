package prac6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class test8 {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		String s=br.readLine();

		char[] arr=s.toCharArray();

		int count=0;

		for(int i=0;i<arr.length;i++) {
			if(i!=arr.length-1) {
				if(arr[i]=='c') {
					if(arr[i+1]=='=') {
						count++;
						i++;

					}
					else if(arr[i+1]=='-') {
						count++;
						i++;

					}
					else {
						count++;
					}
				}
				
				else if(arr[i]=='l'){
					if(arr[i+1]=='j') {
						count++;
						i++;
					}
					else {
						count++;
					}
				}
				
				else if(arr[i]=='n'){
					if(arr[i+1]=='j') {
						count++;
						i++;
					}
					else {
						count++;
					}
				}
				
				else if(arr[i]=='s'){
					if(arr[i+1]=='=') {
						count++;
						i++;
					}
					else {
						count++;
					}
				}
				
				else if(arr[i]=='z') {
					if(i==0) {
						if(arr[i+1]=='=') {
							count++;
							i++;
						}
						else {
							count++;
						}
					}
					else {
						if((arr[i-1]=='d')&&(arr[i+1]=='=')) {
							i++;
						}
						else {
							if(arr[i+1]=='=') {
								count++;
								i++;
							}
							else {
								count++;
							}
						}
					}
					
				}
				
				else if(arr[i]=='d') {
					if(i!=arr.length-2) {
						if(arr[i+1]=='z'&&arr[i+2]=='=') {
							count++;
							i=i+2;
						}
						else {
							if(arr[i+1]=='-') {
								count++;
								i++;
							}
							else {
								count++;
							}
						}
					}
					else {
						if(arr[i+1]=='-') {
							count++;
							i++;
						}
						else {
							count++;
						}
					}
				}
				else {
					count++;
				}
				
			}
			else {
				count++;
			}
			
		}
		
		bw.write(""+count);
		bw.flush();
		bw.close();
	}

}
