package prac1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class recursion4 {
	
	public static int[] forSort;
	
	public static int k;
	
	public static int count=0;
	
	public static int result=-1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader read=new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st=new StringTokenizer(read.readLine()," ");
		
		int n=Integer.parseInt(st.nextToken());
		
		k=Integer.parseInt(st.nextToken());
		
		int[] a=new int[n];
		
		st=new StringTokenizer(read.readLine()," ");
		
		for(int i=0;i<n;i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		
		merge_sort(a);
		
		System.out.println(result);
	}
	
	public static void merge_sort(int[] arr) {
		forSort=new int[arr.length];
		merge_sort(arr,0,arr.length-1);
		forSort=null;
	}
	
	public static void merge_sort(int[] arr,int left,int right) {
		if(left==right) {
			return;
		}
		
		int mid=(left+right)/2;
		
		merge_sort(arr,left,mid);
		merge_sort(arr,mid+1,right);
		
		merge(arr,left,mid,right);
		
	}
	
	public static void merge(int[] arr,int left,int mid,int right) {
		int l=left;
		int r=mid+1;
		int idx=left;
		
		while(l<=mid && r<=right) {
			if(arr[l]<=arr[r]) {
				forSort[idx]=arr[l];
				idx++;
				l++;
			}
			else {
				forSort[idx]=arr[r];
				idx++;
				r++;
			}
			
			
		}
		
		if(l>mid) {
			while(r<=right) {
				forSort[idx]=arr[r];
				idx++;
				r++;
			}
		}
		else {
			while(l<=mid) {
				forSort[idx]=arr[l];
				idx++;
				l++;
			}
		}
		
		for(int i=left;i<=right;i++) {
			arr[i]=forSort[i];
			
			count++;
			
			if(count==k) {
				result=arr[i];
			}
			
		}
	}

}
