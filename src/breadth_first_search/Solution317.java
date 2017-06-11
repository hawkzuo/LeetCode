//317. Shortest Distance from All Buildings
//Hash Table won't work.
package breadth_first_search;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution317 {

    private boolean noSol = false;

    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        if(row == 0){   return -1; }
        int col = grid[0].length;
        
        Map<Cor,Integer> m = new HashMap<Cor,Integer>();
        
        boolean begin = true;
        for(int i=0;i<col;i++){
            for(int j=0;j<row;j++){          
                if(grid[j][i] == 1){
                    if(begin){
                        firstaddDist(grid,j,i,m);
                    }
                    boolean res = updateDist(grid,j,i,m);
                    if(!res){	return -1;}                    
                }else{
                			;
                }
            }
        }
        
        int shortest=-1;
        for(Cor key: m.keySet()){
            if(shortest == -1){
                shortest = m.get(key);
            }else{
                shortest = Math.min(shortest,m.get(key));
            }
            
        }
        if(!noSol){
            return shortest;
        }else{
            return -1;
        }
        
        
    }
    private void firstaddDist(int[][] rooms,int x, int y, Map<Cor,Integer> m){
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
    private boolean updateDist(int[][] rooms,int x, int y, Map<Cor,Integer> m){
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

                if(perform2(nb1,rooms,cur,m)){
                	stack.add(nb1);
                }
                if(perform2(nb2,rooms,cur,m)){
                    stack.add(nb2);
                }                
                if(perform2(nb3,rooms,cur,m)){
                    stack.add(nb3);
                }                
                if(perform2(nb4,rooms,cur,m)){
                    stack.add(nb4);
                } 
                
                //Prevent No solution situation
                if(i==0 && stack.size() == 0){
                    noSol = true;
                    return false;
                }
                
            }
        }  
        return true;
    }  
    private boolean perform2(Cor cur,int[][] rooms,int steps, Map<Cor,Integer> m){    
        int r=rooms.length;
        int c1=rooms[0].length;   
        int x = cur.x;
        int y = cur.y;    
        if(x>=0 && x<r && y>=0 && y<c1){        
            if(rooms[x][y] != 0){   return false;}
            
            if(!m.containsKey(cur)){
                return false;
            }else{
                m.put(cur,m.get(cur)+steps);
                return true;
            }
            
        }
        return false;
    }
    
    
    private boolean perform(Cor cur,int[][] rooms,int steps, Map<Cor,Integer> m){
        
        int r=rooms.length;
        int c1=rooms[0].length;   
        int x = cur.x;
        int y = cur.y;
        if(x>=0 && x<r && y>=0 && y<c1){
            if(rooms[x][y] != 0){   return false;}
            
            if(m.containsKey(cur)){
                return false;
            }else{
                m.put(cur,steps);
                return true;
            }

        }
        return false;
        
    }    

    
    
    public static void main(String[] args) {
    	
    	Solution317 s = new Solution317();
    	int[][] test = {{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}};
    	int res = s.shortestDistance(test);
    	System.out.print(res);
    }
}
