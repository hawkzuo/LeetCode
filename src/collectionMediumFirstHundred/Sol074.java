package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/23.
 * Search a 2D Matrix
 */
public class Sol074 {
    // A binarySearch example
    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;
        if(row == 0){   return false;}
        int col = matrix[0].length;
        if(col == 0){   return false;}

        int column = findColumn(0,row-1,matrix,target);
        if(column == -1){   return false;}
        else if(column == -2){  return true;}

        int l=0; int r=col-1; int mid=(r+l)/2;
        if(matrix[column][l] == target || matrix[column][r] == target){ return true;}

        while(r-l>1){
            mid=(r+l)/2;
            if(matrix[column][mid] == target){
                return true;
            }else if(matrix[column][mid] < target){
                l=mid;
            }else{
                r=mid;
            }
        }
        return false;
    }

    private int findColumn(int start, int end, int[][] d, int tar){
        if(start > end){    return -1;}
        if((start-end+1) % 2 == 0){
            int mid = (start + end )/2;

            int l=d[start][0];
            int r1=d[mid][d[0].length-1];
            int r = d[end][d[0].length-1];
            if(tar == l || tar == r1 || tar == r){
                return -2;
            }else if(tar < l || tar > r){
                return -1;
            }else{
                if(tar < r1){
                    //Upper Half
                    return findColumn(start,mid,d,tar);
                }else{
                    //Down half
                    return findColumn(mid+1,end,d,tar);
                }
            }
        }else{
            if(start - end == 0){   return start;}
            int mid = (start + end )/2;
            int l=d[start][0];
            int l1=d[mid][0];
            int r1=d[mid][d[0].length-1];
            int r = d[end][d[0].length-1];
            if(tar == l || tar == l1 || tar == r1 || tar == r){
                return -2;
            }else if(tar < l || tar > r){
                return -1;
            }else{
                if(tar < l1){
                    return findColumn(start,mid-1,d,tar);
                }else if(tar < r1){
                    return mid;
                }else{
                    return findColumn(mid+1,end,d,tar);
                }
            }
        }
    }
}
