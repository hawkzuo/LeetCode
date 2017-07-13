package collectionMedium;

/**
 * Created by Amos on 2017/7/20.
 * Rotate Image
 */
public class Sol048 {
    public void rotate(int[][] matrix) {

        if(matrix.length == 1){
            return;
        }else if(matrix.length != matrix[0].length){
            return;
        }

        int n = matrix.length;
        for(int i=0;i<n/2;i++){
            RotateCircle(matrix,i,n-2*i);
        }
    }
    private void RotateCircle(int[][] a, int o, int size){
        for(int i=0;i<size-1;i++){

            int next = a[o+i][o+size-1];
            a[o+i][o+size-1] = a[o][o+i];
            int temp = next;
            next = a[o+size-1][o+size-1-i];
            a[o+size-1][o+size-1-i] = temp;

            a[o][o+i] = a[o+size-1-i][o];
            a[o+size-1-i][o] = next;
        }
    }
}
