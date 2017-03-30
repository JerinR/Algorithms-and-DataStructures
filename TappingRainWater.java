/*
Leetcode problem - https://leetcode.com/problems/trapping-rain-water/#/description
*/

public class TappingRainWater {
    public int trap(int[] height) {
       Stack<Integer> st = new Stack();
        int start=0, end=0,endEle,secondEle, area = 0;
        while(start<height.length-1){
        	if(height[start]<=height[start+1])
        		start++;
        	else
        		break;
        }
        for(int i=start+1;i<height.length;i++){
        	while(i<height.length && height[start]>=height[i]){
        		st.add(height[i]);
        		i++;
        	}
        	end = i;
        	if(i==height.length && !st.isEmpty()){
        		endEle = st.pop();
        		if(st.isEmpty())
        			secondEle = height[start];
        		else secondEle = st.pop();
        		while(!st.isEmpty()){        			
        			if(secondEle>=endEle){
        				endEle = secondEle;
        				secondEle = st.pop();
        			}        			        			
    				while(!st.isEmpty() && secondEle<endEle){
    					area += endEle - secondEle;
    					secondEle = st.pop();
    				}
    				       				
        		}
        		if(secondEle<endEle)
					area += endEle - secondEle; 
        	}
        	while(!st.isEmpty()){
        		area += (height[start] - st.pop());        		
        	}
        	start = end;
        }
        return area;
    }
}
