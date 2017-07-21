package collectionMedium;

/**
 * Created by Amos on 2017/7/21.
 * Spiral Matrix II
 */
public class Sol059 {
    public int[][] generateMatrix(int n) {

        if(n<=0){return new int[0][0];}
        int[][] m=new int[n][n];
        int rxy=0;
        int value=1;
        while(n>0){
            value=performAdd(rxy,n,m,value);
            rxy++;
            n -= 2;
        }
        return m;
    }
    private int performAdd(int x,int n, int[][] matrix,int val){
        if(n==1){
            matrix[x][x]=val;
            val++;
        }else if(n>1){
            for(int i=0;i<n-1;i++){
                //Perform n-1 times
                matrix[x][x+i]=val;
                val++;
            }
            for(int j=0;j<n-1;j++){

                matrix[x+j][x+n-1]=val;
                val++;

            }
            for(int i=0;i<n-1;i++){
                //Perform n-1 times
                matrix[x+n-1][x+n-1-i]=val;
                val++;
            }
            for(int j=0;j<n-1;j++){
                matrix[x+n-1-j][x]=val;
                val++;
            }
        }
        return val;
    }
}
