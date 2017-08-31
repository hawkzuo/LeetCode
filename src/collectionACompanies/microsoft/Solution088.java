/**
 * 
 */
package collectionACompanies.microsoft;

/**
 * @author jiany
 *
 */
public class Solution088 {

	/**
	 * @param args
	 */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        while(p1>=0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p1+p2+1]=nums1[p1];
                p1--;
            }else{
                nums1[p1+p2+1]=nums2[p2];
                p2--;
            }
        }
        if(p1 >=0){
            ;
        }
        if(p2 >=0){
            while(p2 >=0){
                nums1[p2]=nums2[p2];
                p2--;
            }        	
        }

            
        }			
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
