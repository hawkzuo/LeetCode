package microsoft;

public class Solution035 {

	public Solution035() {
		// TODO Auto-generated constructor stub
	}
    public int searchInsert(int[] nums, int target) {
        
    	if(nums == null){return -1;}
    	if(nums.length == 0){return 0;}
    	
    	//Invariant: t is not equal to boundary points
    	if(target <= nums[0]){	return 0;}
    	if(target > nums[nums.length-1]){	return nums.length;}
    	if(target == nums[nums.length-1]){	return nums.length-1;}
    	
    	int len=nums.length;
    	
    	int left=0;	int right=len-1;
    	
    	int result=performSearch(left,right,target,nums);
    	
    	return result;
    	
    }
    
    private int performSearch(int l,int r,int t,int[] a){
    	//Boundary case: t will be between(l,r), thus return index r
    	if(r-l == 1){	return r;}
    	
    	//Binary divide
    	int m=(r-l)/2;
    	
    	
    	if(t == a[l+m]){
    		//Equal return
    		return (l+m);
    	}else if(t > a[l+m]){
    		//t is greater, left pointer increases
    		l=l+m;
    		return performSearch(l,r,t,a);
    		
    		
    	}else{
    		//t is smaller, right pointer reduces
    		r=l+m;
    		return performSearch(l,r,t,a);   		
    	}
    	
    	
    	
    }
    
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution035 s=new Solution035();
		
		int[] arr1={};
		int[] arr2={1};
		
		int[] arr3={1,5,11,14};
		
		System.out.println(s.searchInsert(arr1, 1));
		
		
		
		System.out.println(s.searchInsert(arr2, 0));
		System.out.println(s.searchInsert(arr2, 1));
		System.out.println(s.searchInsert(arr2, 2));
		//System.out.println(s.searchInsert(arr2, 1));
		
		System.out.println(s.searchInsert(arr3, 0));
		System.out.println(s.searchInsert(arr3, 1));
		System.out.println(s.searchInsert(arr3, 3));
		System.out.println(s.searchInsert(arr3, 5));
		System.out.println(s.searchInsert(arr3, 7));
		System.out.println(s.searchInsert(arr3, 11));
		System.out.println(s.searchInsert(arr3, 12));
		System.out.println(s.searchInsert(arr3, 14));
		System.out.println(s.searchInsert(arr3, 15));
	}

}
