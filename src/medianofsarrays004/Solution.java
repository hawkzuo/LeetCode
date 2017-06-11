package medianofsarrays004;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {   	
   	    if(nums1 == null || nums1.length == 0){
   	        if(nums2 == null || nums2.length == 0){
   	            return 0;
   	        }
   	        
   	        if(nums2.length % 2 != 0){
   	            return nums2[(nums2.length-1)/2];
   	        }else{
   	            return (double)(nums2[(nums2.length-1)/2]+nums2[(nums2.length+1)/2])/2;
   	        }
   	        
   	    }else if(nums2 == null || nums2.length == 0){
   	        if(nums1 == null || nums1.length == 0){
   	            return 0;
   	        }
   	        
   	        if(nums1.length % 2 != 0){
   	            return nums1[(nums1.length-1)/2];
   	        }else{
   	            return (double)(nums1[(nums1.length-1)/2]+nums1[(nums1.length+1)/2])/2;
   	        }   	        
   	        
   	    }
   	    
   	    
   	    int m=nums1.length;   int n=nums2.length;
        int target=(m+n+1)/2-2;
        boolean odd=true;
        if((m+n) % 2 == 0){ odd=false;}
        
        int i=0;  int j=0;
        
        while(i+j<target){
            while(i+j<target && nums1[i] < nums2[j]){
            	i++;        	        	        	
            }
            while(i+j<target && nums1[i] > nums2[j]){
            	j++;
            }
            while(i+j<target && nums1[i] == nums2[j]){
            	i++;	j++;
            }        	
        }

        return 0;
        
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Solution s=new Solution();
		int a1[]	= {1,3,5,6,7,8};
		int a2[]   = {0,2,3,4,5,6};
		
		System.out.println(s.findMedianSortedArrays(a1,a2));
	}
	
	
	

}
