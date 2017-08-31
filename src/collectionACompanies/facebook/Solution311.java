package collectionACompanies.facebook;

import java.util.HashMap;
import java.util.Map;

public class Solution311 {

	public Solution311() {
		// TODO Auto-generated constructor stub
	}
    public int[][] multiply(int[][] A, int[][] B) {
        
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        
        int[][] r = new int[m][p];
   
   
        for(int x=0;x<m;x++){
            for(int y=0;y<n;y++){
               if(A[x][y] != 0){
                   for(int z=0;z<p;z++){
                       if(B[y][z] != 0){
                          r[x][z] +=  A[x][y] * B[y][z];
                       }
                   }
               }
            }
        }

        return r;

        
    }	
    public int[][] multiplySlow(int[][] A, int[][] B) {
        
        int m = A.length;
        int n = A[0].length;
        int p = B[0].length;
        
        Map<Integer,Integer>[] m1 = new Map[m+1];
        // maintain by row
        for(int i=0;i<=m;i++){
            m1[i] = new HashMap<Integer,Integer>();
        }
        
        //maintain by col
        Map<Integer,Integer>[] m2 = new Map[n+1];
        for(int i=0;i<=n;i++){
            m2[i] = new HashMap<Integer,Integer>();
        }        
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(A[i][j] != 0){
                    m1[i].put(j,A[i][j]);
                }
            }
        }
        
        for(int j=0;j<p;j++){
            for(int i=0;i<n;i++){
                if(B[i][j] != 0){
                    m2[j].put(i,B[i][j]);
                }
            }
        }
        
        
        int[][] r = new int[m][p];
        
        
        for(int x=0;x<m;x++){
            for(int y=0;y<p;y++){
                int tsum = 0;
                for(Integer pos : m1[x].keySet()){
                    if(m2[y].containsKey(pos)){
                        tsum += m1[x].get(pos)*m2[y].get(pos);                        
                    }
                }
                r[x][y]=tsum;
            }
        }
        
        return r;

        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
