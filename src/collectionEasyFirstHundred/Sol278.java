package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/7.
 * First Bad Version
 */
public class Sol278 {
    // Idea: Just Binary Search
    //  'Moban'
    public int firstBadVersion(int n) {

        int l=1; int r=n;
        // Control flow guarantees r & l are different values
        while(l+1<r){
            // This format will not lead to Integer overflow
            int mid = l+(r-l)/2;
            // Cut half of the size
            if(isBadVersion(mid)) r = mid;
            else l = mid;
        }
        // Will remain at most 2 values, the answer must be either l or r
        return isBadVersion(l) ? l : r;
    }

    private boolean isBadVersion(int version) {
        return true;
    }
}
