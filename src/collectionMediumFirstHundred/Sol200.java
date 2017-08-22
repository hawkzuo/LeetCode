package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/21.
 * Number of Islands
 */
public class Sol200 {
    public int numIslands(char[][] grid) {
        // Idea: Mimic the "encroaching" process of the island and record the count
        int sum = 0;
        int row = grid.length;
        if(row == 0){   return sum;}
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    markZeros(grid,i,j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void markZeros(char[][] grid, int x,int y){

        int r=grid.length;
        int c=grid[0].length;

        if(x>=0 && x<r && y>=0 && y<c && grid[x][y] == '1'){
            grid[x][y] = '0';
            markZeros(grid,x-1,y);
            markZeros(grid,x+1,y);
            markZeros(grid,x,y+1);
            markZeros(grid,x,y-1);
        }
    }
}
