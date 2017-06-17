package google;

/**
 * Created by Amos on 2017/6/18.
 * Island Perimeter
 */
public class ESolution463 {
    public int islandPerimeter(int[][] grid) {
        // Only go down and right
        if(grid == null || grid.length ==0){    return 0;}

        int res = 0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c] == 0){    continue;}
                res += 4;
                if(r+1 < grid.length && grid[r+1][c] == 1){ res-=2;}
                if(c+1 < grid[0].length && grid[r][c+1] == 1){  res-=2;}
            }
        }
        return res;
    }
}
