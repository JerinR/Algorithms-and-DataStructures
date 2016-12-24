//HACKERRANK

/*
https://www.hackerrank.com/challenges/array-splitting
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NikitaAndGame {

    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for(int i=0;i<t;i++){
			int n = s.nextInt();
			long sum = 0;
			long[] arr = new long[n];
			for(int j=0;j<n;j++){
				arr[j] = s.nextLong();
				sum += arr[j];
			}
			System.out.println(count(arr));
		}
	}
	
	private static long count(long[] arr){
		
		long leftsum = 0;
        long rightsum = 0;
		int partition = 0, j = 0;
        boolean isEqual = false;
        for(int i=0;i<arr.length;i++){
            rightsum += arr[i];
        }
		while(j<arr.length){
			if(leftsum == rightsum){
			     isEqual = true;
                 partition = j;
                break;
			}
            else{
                leftsum += arr[j];
                rightsum -= arr[j];
                j++;
            }
		}
        if(!isEqual){
             return 0;
        }
        
       
		return 1 + Math.max(count(Arrays.copyOfRange(arr,0,partition)), count(Arrays.copyOfRange(arr,partition+1,arr.length)));
	
	}
}
