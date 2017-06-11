//84. Largest Rectangle in Histogram
//85 221
package maxsquares;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution084 {

	public Solution084() {
		// TODO Auto-generated constructor stub
	}
	
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        Deque<Integer> s = new ArrayDeque<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }	
	
	
    public int largestRectangleArea1(int[] heights) {
        
    	Map<Integer,Integer> res = new HashMap<Integer,Integer>();
    	Map<Integer,Integer> temp = new HashMap<Integer,Integer>();
    	Deque<Integer> stack = new LinkedList<Integer>();
    	int result = 0;
    	if(heights.length == 0){	return result;}
    	if(heights.length == 1){	return heights[0]; }
    	
    	for(int i=0;i<heights.length;i++){    		
    		if(heights[i] == 0){
    			//Pour it out
    			while(!stack.isEmpty()){
    				int key = stack.pop();
    				int count = temp.get(key);
					if(!res.containsKey(key)){
						res.put(key, count);
					}else{
						if(count > res.get(key)){
							res.put(key, count);
						}    						
					}    				    				
    				temp.remove(key);    				
    			}
    			
    			
    			
    			
    			
    		}else{
    			
    			if(stack.isEmpty()){
    				
    				stack.push(heights[i]);
    				temp.put(heights[i],1);
    				
    			}else{
    				Deque<Integer> rep = new LinkedList<Integer>();
    				
    				int biggestsofar = stack.pop();
    				
    				if(heights[i] >= biggestsofar){
    					
    					if(heights[i] > biggestsofar){
    						rep.push(heights[i]);
    						temp.put(heights[i],1);
    					}
    					
    					rep.push(biggestsofar);
    					temp.put(biggestsofar, temp.get(biggestsofar)+1);
    					
    					while(!stack.isEmpty()){
    						int num = stack.pop();
    						rep.push(num);
    						temp.put(num, temp.get(num)+1);    						    						
    					}
    					
    					while(!rep.isEmpty()){
    						stack.push(rep.pop());
    					}
    					
    					
    				}else{
    					int pourtimes = 1;
    					
    					int count = temp.get(biggestsofar);
    					//Update permanent
    					if(!res.containsKey(biggestsofar)){
    						res.put(biggestsofar, count);
    					}else{
    						if(count > res.get(biggestsofar)){
    							res.put(biggestsofar, count);
    						}    						
    					}
    					temp.remove(biggestsofar);
    					
    					//Do looping pouring out
    					if(stack.isEmpty()){
    						//2 1
    						//Adding up
    	    				stack.push(heights[i]);
    	    				temp.put(heights[i],1+pourtimes);    						
    					}else{
    						
    						biggestsofar = stack.pop();
    						pourtimes ++;
    						//Delete those first
        					while(!stack.isEmpty() && heights[i] < biggestsofar){
            					count = temp.get(biggestsofar);
            					//Update permanent
            					if(!res.containsKey(biggestsofar)){
            						res.put(biggestsofar, count);
            					}else{
            						if(count > res.get(biggestsofar)){
            							res.put(biggestsofar, count);
            						}    						
            					}    						
            					temp.remove(biggestsofar);    
            					biggestsofar = stack.pop();
            					pourtimes ++;
        					}    						
    						
        					
        					
        					
        					//651 2
        					if(stack.isEmpty()){
        						if(heights[i] < biggestsofar){
        							//234 1
        							//Remove the '2'
                					count = temp.get(biggestsofar);
                					//Update permanent
                					if(!res.containsKey(biggestsofar)){
                						res.put(biggestsofar, count);
                					}else{
                						if(count > res.get(biggestsofar)){
                							res.put(biggestsofar, count);
                						}    						
                					}    						
                					temp.remove(biggestsofar);
        							//add up '1'
            	    				stack.push(heights[i]);
            	    				temp.put(heights[i],1+pourtimes);                  					
        							
        						}else if(heights[i] == biggestsofar){
        							//134 1
        							//Don't remove just add up
        							stack.push(biggestsofar);
        							temp.put(biggestsofar, temp.get(biggestsofar)+1);
        							
        						}else{
        							//134 2
        							//Add up both
        							stack.push(biggestsofar);
        							temp.put(biggestsofar, temp.get(biggestsofar)+1);        							
            	    				stack.push(heights[i]);
            	    				temp.put(heights[i],1+pourtimes-1);         							
        						}
        						
        					}else{
        						//stack is not empty AND
        						// heights[i] >= biggestsofar        	    					
        	    					if(heights[i] > biggestsofar){
        	    						//xxx134 2
        	    						rep.push(heights[i]);
        	    						temp.put(heights[i],1+pourtimes-1);
        	    					}
        	    					//xxx134 1
        	    					rep.push(biggestsofar);
        	    					temp.put(biggestsofar, temp.get(biggestsofar)+1);
        	    					
        	    					while(!stack.isEmpty()){
        	    						int num = stack.pop();
        	    						rep.push(num);
        	    						temp.put(num, temp.get(num)+1);    						    						
        	    					}
        	    					
        	    					while(!rep.isEmpty()){
        	    						stack.push(rep.pop());
        	    					}
        						
        					}
      					
    					}   					
    					
    				}    				
    			}
    			
    		}
    		
    		
    	}
    	//36574810 Lack one situation
    	//Finally pour out the keys
		while(!stack.isEmpty()){
			int key = stack.pop();
			int count = temp.get(key);
			if(!res.containsKey(key)){
				res.put(key, count);
			}else{
				if(count > res.get(key)){
					res.put(key, count);
				}    						
			}    				    				
			temp.remove(key);    				
		}     
		//Check the return value
    	for(Integer key : res.keySet()){
    		result = Math.max(result, key*res.get(key));    		
    	}
    	
    	return result;
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution084 s = new Solution084();
		int[] t = {3,6,5,7,4,8,1,0};
		int res = s.largestRectangleArea1(t);
		System.out.print(res);
	}

}
