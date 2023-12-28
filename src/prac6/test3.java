package prac6;


public class test3 {
	
	static int[] comparisonArr=new int[10001];
	
	public static void main(String[] args) {
		
		
		for(int i=1;i<=10000;i++) {
			
			if(i<10) {
				comparisonArr[i]=2*i;
			}
			else if(i<100&&i>=10) {
				comparisonArr[i]=i+(i/10)+(i%10);
			}
			else if(i>=100&&i<1000) {
				comparisonArr[i]=i+(i/100)+((i%100)/10)+((i%100)%10);
			}
			else if(i>=1000&&i<10000) {
				comparisonArr[i]=i+(i/1000)+((i%1000)/100)+(((i%1000)%100)/10)+(((i%1000)%100)%10);
				
			}
			else {
				comparisonArr[i]=10001;
			}
			
		}
		
		for(int i=1;i<=10000;i++) {
			for(int j=1;j<=10000;j++) {
				if(i==comparisonArr[j]) {
					break;
				}
				
				if(j==10000) {
					if(i==comparisonArr[j]) {
						break;
					}
					else {
						System.out.println(i);
					}
				}
			}
		}
		
		
	
	}
	

}
