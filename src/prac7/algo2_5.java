package prac7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class algo2_5 {
	public static void main(String args[]) throws Exception
	{
	
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
       
        /*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		int T=Integer.parseInt(br.readLine());
        int[] resultArr=new int[T+1];
		for(int i = 1; i <= T; i++)    
		{
            st=new StringTokenizer(br.readLine()," ");
            
			int n=Integer.parseInt(st.nextToken());            
			int k=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine()," ");
            
            int[] arr=new int[n];
            for(int j=0;j<n;j++) {
            	arr[j]=Integer.parseInt(st.nextToken());
            }
           
            Arrays.sort(arr);
            
            
            
                    
            resultArr[i]=getMin(n,k,arr);
            
		
		}
                    
        for(int i=1;i<resultArr.length;i++){
         	bw.write(i+"# "+resultArr[i]+"\n");   
        }    
        bw.flush();
        bw.close();
    }
    public static int getMin(int n,int k,int[] arr){
		    
       int  min=arr[k-1]-arr[0];
       
       
       if((n-k)!=0) {
    	   for(int i=1;i<=n-k;i++){
          		
               
               int temp=arr[k-1+i]-arr[i];
               if(temp<min){
  				min=temp;
               }    
             
         }   
       }
       
       
        return min;
    }   
}
