//

package tags.breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution296 {

    public int minTotalDistance(int[][] grid) {
        int row = grid.length;
        if(row == 0){   return -1; }
        int col = grid[0].length;

        int[][] marks = new int[row][col];
        int[][] finals = new int[row][col];
        
        

        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){          
                if(grid[j][i] == 1){
                    marks[j][i] = -1;
                    firstaddDist(grid,j,i,marks);
                    marks[j][i] = 0;
                    update(finals,marks);
                    clear(marks);
                }
            }
        }
        
        int shortest=-1;
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){  
            	if(finals[j][i] > 0){
            		if(shortest == -1){	shortest = finals[j][i];}
            		else{
            			shortest = Math.min(shortest, finals[j][i]);
            		}
            	}
            }
            
        }

        return shortest;        
    }
    
    

    private void clear(int[][] m){
        int r = m.length;
        int c = m[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){   
            	m[i][j] = 0;
            }
            
        }    	
    	
    }
    private void update(int[][] f, int[][] m){
        int r = m.length;
        int c = m[0].length;
        
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){ 
                    f[i][j] = f[i][j]+m[i][j];                        
                }
            }
        

    }
    private void firstaddDist(int[][] rooms,int x, int y,int[][] m){
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

                if(perform(nb1,rooms,cur,m)){
                	stack.add(nb1);
                }
                if(perform(nb2,rooms,cur,m)){
                    stack.add(nb2);
                }                
                if(perform(nb3,rooms,cur,m)){
                    stack.add(nb3);
                }                
                if(perform(nb4,rooms,cur,m)){
                    stack.add(nb4);
                }                
            }
        }        
    }
    private boolean perform(Cor cur,int[][] rooms,int steps, int[][] m){
        
        int r=rooms.length;
        int c1=rooms[0].length;   
        int x = cur.x;
        int y = cur.y;
        if(x>=0 && x<r && y>=0 && y<c1){
                if(m[x][y] == 0){
                    m[x][y] = steps;
                    return true;
                    
                }else{
                    return false;
                }
                
            
        }
        return false;
        
    }    
    public static void main(String[] args) {
    	
    	Solution296 s = new Solution296();
    	int[][] test = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    	int[][] t2 = {{0,0,1},{1,0,0},{0,1,0}};
    	int[][] t3 = {{1,1}};
    	int res = s.minTotalDistance(test);
    	System.out.print(res);
    }
}
