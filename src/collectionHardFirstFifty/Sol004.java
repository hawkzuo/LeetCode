package collectionHardFirstFifty;

/**
 * Created by Amos on 2017/8/26.
 * Median of Two Sorted Arrays
 */
public class Sol004 {

    // Average O(lg(m+n)) solution
    // Idea is simple, each time compare middle element of two arrays and cut half for each array
    // But the implementation is very annoying
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        if( (lenA + lenB) % 2 == 0) {
            int leftMedian = getKthOfTwoArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, (lenA + lenB) / 2);
            int rightMedian = getKthOfTwoArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, (lenA + lenB) / 2 + 1);
            return ((double)leftMedian + (double)rightMedian ) / 2.0;
        } else {
            return getKthOfTwoArrays(nums1, 0, nums1.length, nums2, 0, nums2.length, (lenA + lenB) / 2 + 1);
        }
    }

    // [startA, endA)   [startB, endB)
    private int getKthOfTwoArrays(int[] A, int startA, int endA, int[] B, int startB, int endB, int k) {
        int lenA = endA - startA;
        int lenB = endB - startB;
        if(lenA <= 0) {
            return B[startB + k -1];
        }
        if(lenB <= 0) {
            return A[startA + k -1];
        }
        // Base case shortcut
        if(k == 1) {
            return A[startA] < B[startB] ? A[startA] : B[startB];
        }

        int midA = (startA + endA) / 2;
        int midB = (startB + endB) / 2;

        if(A[midA] <= B[midB]) {
            // Am <= Bm
            // [........*........]
            // [.....*.....]
            // Each step either get ride of A[1:midA] or B[midB:endB]
            if(lenA / 2 + lenB / 2 + 1 >= k) {
                // The possible interval is the entire A plus smaller half of B
                return getKthOfTwoArrays(A, startA, endA, B, startB, midB, k);
            } else {
                // The possible interval is the entire B plus bigger half of A
                return getKthOfTwoArrays(A, midA+1, endA, B, startB, endB, k - (lenA / 2 + 1));
            }
        } else {
            // Am > Bm
            // [........*........]
            // [.....*.....]
            // Each step either get ride of A[midA:endA] or B[1:midB]
            if(lenA / 2 + lenB / 2 + 1 >= k) {
                // The possible interval is the entire B plus smaller half of A
                return getKthOfTwoArrays(A, startA, midA, B, startB, endB, k);
            } else {
                // The possible interval is the entire A plus bigger half of B
                return getKthOfTwoArrays(A, startA, endA, B, midB+1, endB, k - (lenB / 2 + 1));
            }
        }
    }

    public static void main(String[] args) {
        Sol004 s = new Sol004();
        int[] A = {4, 5, 6};
        int[] B = {1, 2, 3};
        StringBuilder sb = new StringBuilder();
        System.out.println(s.findMedianSortedArrays(A, B));
    }
}
