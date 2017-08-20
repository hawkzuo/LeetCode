package tags.divideandconquer;

public class Bsearch {

	public Bsearch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ref = {-1,-2,-3,-1,2,0};
		System.out.println(FGL(ref,4));
		System.out.println(FGL(ref,0));
		System.out.println(maxLess(ref,0));
		System.out.println(maxLess(ref,4));

	}

	public static int FGL(int[] rhalf, int maxtarget){
		
		int big=-1;
        int low=0;int high = rhalf.length;
      //Find smallest index that is greater or equal to given number  inclusive
        while(low!=high){
        	int middle = (low+high)/2;
        	if(rhalf[middle] < maxtarget){
        		low = middle+1;
        	}else{
        		high = middle;
        	}
        }
        if(low < rhalf.length && rhalf[low] == maxtarget){
        	big = low-1;
        	while(low <rhalf.length){
        		if(rhalf[low] == maxtarget){
        			big++;
        			low++;
        		}else{
        			break;
        		}
        	}
        }else{
        	big = low-1;
        }		
		return big;
		
	}
	
	public static int maxLess(int[] a, int target){
        if(a[0] > target){
            return -1;
        }		
		int start = 0;
		int end = a.length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(a[mid] <= target){
				start = mid;
			}else{
				end = mid;
			}
		}
		if(a[end] <= target){
			return end;
		}else{
			return start;
		}
	}
	
	
	
	
}
