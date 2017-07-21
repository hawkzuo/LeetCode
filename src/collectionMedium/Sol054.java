package collectionMedium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/7/21.
 * Spiral Matrix
 */
public class Sol054 {
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0){return new ArrayList<Integer>();}
        List<Integer> l = new ArrayList<Integer>();

        int row=matrix.length;	int col=matrix[0].length;
        int rx=0;	int ry=0;

        int m=row;	int n=col;
        if(m==0 || n==0){return l;}

        while(m > 0 && n > 0){
            performSpiral(rx,ry,m,n,l,matrix);
            rx++; ry++;
            m=m-2;	n=n-2;
        }
        return l;
    }

    private void performSpiral(int x,int y,int m,int n, List<Integer> list, int[][] matrix){

        if(m==1 && n==1){
            list.add(matrix[x][y]);
        }else if(m==1 && n>1){
            for(int i=0;i<n;i++){
                //Perform n times
                list.add(matrix[x][y+i]);
            }
        }else if(m>1 && n==1){
            for(int j=0;j<m;j++){
                list.add(matrix[x+j][y]);
            }
        }else{
            for(int i=0;i<n-1;i++){
                //Perform n-1 times
                list.add(matrix[x][y+i]);
            }
            for(int j=0;j<m-1;j++){
                list.add(matrix[x+j][y+n-1]);
            }
            for(int i=0;i<n-1;i++){
                //Perform n-1 times
                list.add(matrix[x+m-1][y+n-1-i]);
            }
            for(int j=0;j<m-1;j++){
                list.add(matrix[x+m-1-j][y]);
            }
        }
    }
}
