package prac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class recursion3 {
	
	static int count=0;
	
	public static int recursion(String s, int l, int r){
		count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	
		int n=Integer.parseInt(reader.readLine());
		
		String[] arr=new String[n];
		
		int[] callRecursionNum=new int[n];
		
		for(int i=0; i<n;i++) {
						
			String s=reader.readLine();
			
			arr[i]=s;	
			
			isPalindrome(arr[i]);
			
			callRecursionNum[i]=count;
			
			count=0;
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(isPalindrome(arr[i])+" "+callRecursionNum[i]);
		}
	
	}
}
