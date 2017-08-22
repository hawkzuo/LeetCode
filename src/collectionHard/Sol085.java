//package collectionHard;
//
///**
// * Created by Amos on 2017/8/22.
// * Maximal Rectangle
// */
//final class Pair{
//    int x;
//    int y;
//    public Pair(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//public class Sol085 {
//    public int maximalRectangle(char[][] matrix) {
//        if(matrix == null || matrix.length ==0 || matrix[0].length == 0) {  return 0;}
//        int globalMax = 0;
//
//        // Initialize
//        int row = matrix.length;    int col = matrix[0].length;
//        // right/down prior
//        Pair[][] dpRight = new Pair[row][col];
//        Pair[][] dpDown  = new Pair[row][col];
//
//        if(matrix[row-1][col-1] == '0') {
//            dpRight[row-1][col-1] = null;
//            dpDown[row-1][col-1] = null;
//        } else {
//            dpRight[row-1][col-1] = new Pair(1, 1);
//            dpDown[row-1][col-1] = new Pair(1, 1);
//        }
//
//        for(int i=row-2;i>=0;i--) {
//            if(matrix[i][col-1] == '0') {
//                dpRight[i][col-1] = null;
//                dpDown[i][col-1] = null;
//            }else if (matrix[i][col-1] == '1') {
//                dpRight[i][col-1] = new Pair(1, 1);
//                if(dpDown[i+1][col-1] != null){
//                    dpDown[i][col-1] = new Pair(dpDown[i+1][col-1].x+1, 1);
//                } else {
//                    dpDown[i][col-1] = new Pair(1, 1);
//                }
//                globalMax = Math.max(globalMax, dpDown[i+1][col-1].x+1);
//            }
//        }
//        for(int j=col-2;j>=0;j--) {
//            if(matrix[row-1][j] == '0') {
//                dpRight[row-1][j] = null;
//                dpDown[row-1][j] = null;
//            }else if (matrix[row-1][j] == '1') {
//                dpDown[row-1][j] = new Pair(1, 1);
//                if(dpRight[row-1][j+1] != null){
//                    dpRight[row-1][j] = new Pair(1, dpRight[row-1][j+1].y + 1);
//                } else {
//                    dpRight[row-1][j] = new Pair(1, 1);
//                }
//                globalMax = Math.max(globalMax, dpRight[row-1][j+1].y + 1);
//            }
//        }
//
//        // Sub-problem:  For each element, either 'jiangjiu' right neighbor or 'jiangjiu' down neighbor
//        for(int j=col-2;j>=0;j--) {
//            for(int i=row-2;i>=0;i--) {
//                if(matrix[i][j] == '1') {
//                    Pair rightNb_R = dpRight[i][j+1];
//                    Pair downNb_R = dpRight[i+1][j];
//                    Pair rightNb_D = dpDown[i][j+1];
//                    Pair downNb_D = dpDown[i+1][j];
//
//                    if(rightNb_R == null && downNb_R == null) {
//                        dpRight[i][j] = new Pair(1, 1);
//                        dpDown[i][j] = new Pair(1, 1);
//                        globalMax = Math.max(globalMax, 1);
//                    } else if( rightNb_R == null) {
//                        // Only downward is allowed to move
//                        dpRight[i][j] = new Pair(1, 1);
//                        dpDown[i][j] = new Pair(downNb_D.x + 1, 1);
//                        globalMax = Math.max(globalMax, downNb_D.x + 1);
//                    } else if( downNb_R == null) {
//                        // Only rightward is allowed to move
//                        dpDown[i][j] = new Pair(1, 1);
//                        dpRight[i][j] = new Pair(1, rightNb_R.y + 1);
//                        globalMax = Math.max(globalMax, rightNb_R.y + 1);
//                    } else {
//                        // Compensate two sides to make the rectangle maximum
//
//                    }
//
//                } else {
//                    dpRight[i][j] = null;
//                    dpDown[i][j] = null;
//                }
//            }
//        }
//
//
//
//
//
//
//    }
//}
