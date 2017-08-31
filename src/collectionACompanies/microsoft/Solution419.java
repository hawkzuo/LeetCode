package collectionACompanies.microsoft;

public class Solution419 {

	public Solution419() {
		// TODO Auto-generated constructor stub
	}
    public int countBattleships(char[][] board) {
        
        if(board == null || board.length == 0 || board[0].length == 0){return 0;}
        
        int row=board.length;
        int col=board[0].length;
        int count=0;
        int [][] stat=new int[row][col];
               
        int i=0; 
        
        while(i<row){
            int j=0;
            while(j<col){
                if(board[i][j] == 'X'){
                    if(stat[i][j] == 1){
                        j++;
                    }else{
                        count++;
                        if(i+1<row && board[i+1][j] == 'X'){
                            stat[i+1][j] = 1;
                            for(int k=i+2;k<row;k++){
                                if(board[k][j] == 'X'){
                                    stat[k][j] = 1;
                                }else{
                                    break;
                                }
                            }
                            j++;
                            
                        }else{
                            j++;
                            //j<col is necessary
                            while(j<col && board[i][j] == 'X'){
                                j++;
                            }
                        }                        
                    }
                
                }else{
                    j++;
                }                
            }
            i++;
        }
        
        return count;
        
        
        
        
    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution419 s=new Solution419();
		
		char[][] ch={{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		
		System.out.print(s.countBattleships(ch));
		
	}
}
