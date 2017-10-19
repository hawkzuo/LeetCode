package collectionMediumSecondHundred;

/**
 * Created by Amos on 2017/10/18.
 * Rectangle Area
 */
public class Sol223 {
    // Idea: Brute-force checking all possible situations for 2 rectangles
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = 0;
        if(A <= E) {
            // ABCD lefter than EFGH
            if(E >= C) {
                // No overlapping
                result += getArea(A,B,C,D) + getArea(E,F,G,H);
            } else {
                if(F >= D) {
                    // No overlapping
                    result += getArea(A,B,C,D) + getArea(E,F,G,H);
                } else {
                    // Now A<E<C F<D
                    if(H <= B) {
                        // No overlapping
                        result += getArea(A,B,C,D) + getArea(E,F,G,H);
                    } else {
                        // Now A<E<C F<D H>B Must Overlap
                        int leftY = Math.max(B,F);
                        int rightX = Math.min(G, C);
                        int rightY = Math.min(D,H);
                        result += getArea(A,B,C,D) + getArea(E,F,G,H) - getArea(E, leftY, rightX, rightY);
                    }
                }
            }
            return result;
        } else {
            return computeArea(E,F,G,H,A,B,C,D);
        }
    }

    private int getArea(int ldX, int ldY, int ruX, int ruY) {
        return (ruX-ldX) * (ruY - ldY);
    }
}
