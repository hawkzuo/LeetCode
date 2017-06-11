package scatter;
//This one isn't trie type
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
public class Solution149 {
    public int maxPoints(Point[] points) {
        if(points.length <= 0) return 0;
        if(points.length <= 2) return points.length;
        int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<BigDecimal, Integer> hm = new HashMap<BigDecimal, Integer>();
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i){
                    if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                        samep++;
                    }
                    if(points[j].x == points[i].x){
                        samex++;
                        continue;
                    }
                    
                    BigDecimal r1 = new BigDecimal(points[j].y - points[i].y);
                    BigDecimal r2 = new BigDecimal(points[j].x - points[i].x);
                    BigDecimal k = r1.divide(r2,20,RoundingMode.CEILING);
                    
                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
    
    public static void main(String[] args) {
    	Point[] points = new Point[10];
    	points[0] = new Point(1,1);	points[1] = new Point(1,1);	points[2] = new Point(1,2);
    	points[3] = new Point(1,2);	points[4] = new Point(1,4);	points[5] = new Point(1,4);
    	points[6] = new Point(1,4);	points[7] = new Point(2,2);	points[8] = new Point(2,2);
    	points[9] = new Point(3,3);	
    	Point[] pts2 = new Point[4];
    	pts2[0]=new Point(0,0);	pts2[1]=new Point(1,1);	pts2[2]=new Point(0,0); pts2[3]=new Point(1,1);
    	Solution149 s = new Solution149();
    	System.out.println(s.maxPoints(pts2));
    }
    
    
}
