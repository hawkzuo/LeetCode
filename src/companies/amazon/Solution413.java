package companies.amazon;

public class Solution413 {

	public Solution413() {
		// TODO Auto-generated constructor stub
	}
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 2) return 0;
        int diff = 0;
        int result = 0;
        for (int i = 0; i < A.length - 2; i++){
            int count = 0;
            diff = A[i+1] - A[i];
            int current = i+1;
            while(current < A.length-1){
                if (A[current+1]-A[current] == diff){
                    count ++;
                    current ++;
                }
                else{
                    break;
                }
            }
            result += count;
        }
        return result > 1000000000 ? -1: result;        
    }
}
