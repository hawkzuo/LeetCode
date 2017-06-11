//286. Walls and Gates

package breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution286 {
	public class Cor {

	    public int x;
	    public int y;
	    
	    public Cor(int i, int j){
	        x=i;
	        y=j;
	    }
	    public String toString(){
	    	return '('+Integer.toString(x)+','+Integer.toString(y)+')';
	    }
	}
    public void wallsAndGates(int[][] rooms) {
        int row = rooms.length;
        if(row == 0){   return; }
        int col = rooms[0].length;        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rooms[i][j] == 0){
                    markDist(rooms,i,j);
                }
            }
        }
        
    }
    private void markDist(int[][] rooms, int x, int y){
        
        int cur = 0;
        Deque<Cor> stack = new ArrayDeque<Cor>();
        stack.add(new Cor(x,y));
        
        while(!stack.isEmpty()){
            int times = stack.size();
            cur++;
            for(int i=0;i<times;i++){
                Cor current = stack.remove();
                 
                Cor nb1 = new Cor(current.x-1,current.y);
                Cor nb2 = new Cor(current.x+1,current.y);
                Cor nb3 = new Cor(current.x,current.y-1);
                Cor nb4 = new Cor(current.x,current.y+1);

                if(perform(nb1,rooms,cur)){
                	stack.add(nb1);
                }
                if(perform(nb2,rooms,cur)){
                    stack.add(nb2);
                }                
                if(perform(nb3,rooms,cur)){
                    stack.add(nb3);
                }                
                if(perform(nb4,rooms,cur)){
                    stack.add(nb4);
                }                
            }
        }
        
    }
    private boolean perform(Cor cur,int[][] rooms,int steps){
        
        int r=rooms.length;
        int c1=rooms[0].length;   
        int x = cur.x;
        int y = cur.y;
        if(x>=0 && x<r && y>=0 && y<c1){
            if(rooms[x][y] == Integer.MAX_VALUE){
	        	rooms[x][y] = steps;
	            return true;
            }else if(rooms[x][y] >steps){
            	rooms[x][y] = steps;
            	return true;
            }
        }
        return false;
        
    }
    public static void main(String[] args) {
    	
    	Solution286 s = new Solution286();
    	int[][] rms= {{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
    	s.wallsAndGates(rms);
    	System.out.print(rms);
    	
    }
}
