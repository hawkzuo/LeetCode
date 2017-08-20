package tags.divideandconquer;

import java.util.*;

class Edge{
    int key;
    int rank;
    public Edge(int k, int r){
        key = k;
        rank = r;
    }
    public Edge(int k){
        key = k;
        rank = 0;
    }
    public String toString(){
    	String res ="";
    	res += "["+key+","+rank+"]";
    	return res;
    }
}

class EComp implements Comparator<Edge>{
	@Override
	public int compare(Edge arg0, Edge arg1) {
		// TODO Auto-generated method stub
		return Integer.valueOf(arg0.key).compareTo(arg1.key);
	}	
}





public class Solution315 {
    public List<Integer> countSmaller(int[] nums) {
        if(nums == null || nums.length <= 0){
            return new ArrayList<Integer>();
        }else if(nums.length == 1){
        	List<Integer> res = new ArrayList<Integer>();
        	res.add(0);
        	return res;
        }
    	
    	Edge[] eds = new Edge[nums.length];
        Map<Integer,Edge> refers = new HashMap<Integer,Edge>();
        for(int i=0;i<nums.length;i++){
            
            eds[i] = new Edge(nums[i]);
            //Maintain original structure
            refers.put(i,eds[i]);
        }
        
        EComp ecmp = new EComp();
        
        dcCount(eds,0,nums.length,ecmp);
        
        // reconstruct
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
        	res.add(refers.get(i).rank);
        }
        return res;     
    }
    
    private void dcCount(Edge[] eds, int l, int r, Comparator<Edge> cp){
        
        //Base case
        if(r-l == 2 ){
            if(eds[l].key > eds[l+1].key){
                eds[l].rank ++;
            }
            
            Arrays.sort(eds,l,r,cp);

        }else if ( r-l == 3){
            if(eds[l].key > eds[l+1].key){
                eds[l].rank ++;
            }
            if(eds[l].key > eds[l+2].key){
            	eds[l].rank ++;
            }
            if(eds[l+1].key > eds[l+2].key){
            	eds[l+1].rank ++;
            } 
            Arrays.sort(eds,l,r,cp);

        }else{
            // Divide & Conquer
            int mid = l+(r-l)/2;
             dcCount(eds,l,mid,cp);
             dcCount(eds,mid,r,cp);            
            //Try New Version:
            // Observation: when doing the combine step, the order within the self group is 
            // not a big concern. Meaning we can change whatever we want, since we only combine left half and 
            // right half, with assurance the i is anyway smaller than j    
            // Utilize two-pointers' idea
            // T(n) = 2T(n/2)+O(nlgn)   => T(n) = O(nlgn)
            int count = 0;
            for (int lef = l, ri = mid; lef < mid;) {
                if (ri > (r-1) || eds[lef].key <= eds[ri].key ) {
                	//These two lines, order does matter.
                	eds[lef].rank += count;
                    lef++;
                } else {
                    ri++;
                    count++;
                }
            }
            Arrays.sort(eds,l,r,cp);
        }                        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution315 s = new Solution315();
		int [] num = {5,2,6,1,5,2,6,1};
		System.out.println(s.countSmaller(num));
		int r=1+3+4+6+9+20+24+48;
		System.out.println(r);
	}
    
}