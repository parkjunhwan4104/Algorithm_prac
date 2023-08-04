package prac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class recursion5 {
	
	public static ArrayList<String> resultArr=new ArrayList<>();
	
	public static int arrIndex=0;
	
	public static char[] result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
		String input="";
		
				
		while(true) {
			input=read.readLine();
			
			if(input!=null&&!input.isEmpty()) {
				int n=Integer.parseInt(input);
				
				int len=(int)Math.pow(3, n);
				
				char[] str=new char[len];
			
				
				for(int i=0;i<len;i++) {
					str[i]='-';
				}
				
				result=str;
				
				cantorianSet(0,len-1,len);
				
				String s=new String(result);
				
				resultArr.add(s);
				
				
			}
			
			
			else {
				break;
			}
			arrIndex++;
			
		}
		
		
		for(int i=0;i<resultArr.size();i++) {
			
			System.out.print(resultArr.get(i));
			
			System.out.println();
			
		}
				
		
		
		
		
	}
	
	//처음에는 문자열 배열을 만들어 쪼갠 후 다시 병합하려했지만 그럴 필요가 전혀없었고 3등분중 2번째에 해당하는 부분만 ' '로 바꿔 그대로 리턴을 했으면 됐었다.
	
	public static void cantorianSet(int start,int end,int size) {
		
		if(size==1) {
			return;
		}
		
		int newSize=size/3;
		
		for(int i=start+newSize;i<end-newSize+1;i++) {
			result[i]=' ';
		}
		
			
		cantorianSet(start,start+newSize-1,newSize);
		cantorianSet(end-newSize+1,end,newSize);
		

	}
	
	
}
