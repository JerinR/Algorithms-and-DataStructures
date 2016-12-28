//https://www.hackerearth.com/international-women-hackathon-2016/algorithm/mark-the-answer-1/

import java.util.Scanner;

public class MarkTheAns {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int count = 0,skip=0;
		for(int i=0;i<n;i++){
			//int[] a = new int[n];
			int a = s.nextInt();
			if(a<=x && skip<=1){
				count++;				
			}
			else skip++;
			if(skip >2)
				break;
			
		}
		System.out.println(count);
	}

}
