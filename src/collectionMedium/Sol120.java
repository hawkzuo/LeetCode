package collectionMedium;

import java.util.List;

/**
 * Created by Amos on 2017/7/31.
 * Triangle
 */
public class Sol120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // stores min sum ends with
        if(triangle == null || triangle.size() == 0) {  return 0; }
        else if(triangle.size() == 1){  return triangle.get(0).get(0); }

        int n = triangle.size();
        int[] table = new int[n];
        table[0] = triangle.get(0).get(0);

        for(int i=1;i<n;i++){
            int[] newTable = new int[i+1];
            List<Integer> curLevel = triangle.get(i);
            for(int cursor = 0; cursor <= i; cursor++) {
                if(cursor == 0){
                    newTable[cursor] = table[0]+curLevel.get(cursor);
                }else if(cursor == i){
                    newTable[cursor] = table[i-1]+curLevel.get(cursor);
                }else{
                    newTable[cursor] = Math.min(table[cursor-1], table[cursor]) + curLevel.get(cursor);
                }
            }
            // Copy to table
            System.arraycopy(newTable, 0, table, 0, i + 1);
        }

        int res = table[0];
        for(int i=0;i<n;i++){
            res = Math.min(res, table[i]);
        }
        return res;
    }
}
