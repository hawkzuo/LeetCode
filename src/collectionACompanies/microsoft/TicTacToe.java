package collectionACompanies.microsoft;


//Though this might be slow, but this matrix board[][] should exist.
//O(n^2) solution
public class TicTacToe {
	
	
	int [][] board;
	//int steps;
	int size;
	
	public TicTacToe(int n) {
		// TODO Auto-generated constructor stub
		// mark 1 for Player1; mark 2 for Player2;
		board= new int[n+1][n+1];
		//steps=0;
		size=n;
	}
    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
            0: No one wins.
            1: Player 1 wins.
            2: Player 2 wins. */
	public int move(int row, int col, int player) {
		row=row+1;
		col=col+1;
		
		
		board[row][col]=player;		//steps++;
		//if(steps<2*size-1)	{return 0;}
		
		int check=board[1][1];	
		//Check diagagonal
		for(int i=2;i<=size;i++){
			if(board[i][i] == check){
				;
			}else{
				check=0;
				break;
			}									
		}
		if(check!= 0){	return check;}
				
		check=board[1][size];
		for(int i=2;i<=size;i++){
			if(board[i][size+1-i] == check){
				;
			}else{
				check=0;
				break;
			}									
		}		
		if(check!= 0){	return check;}	
		
		//Check horizontal
		for(int j=1;j<=size;j++){
			check=board[j][1];
			for(int i=2;i<=size;i++){
				if(board[j][i] == check){
					;
				}else{
					check=0;
					break;
				}									
			}		
			if(check!= 0){	return check;}									
		}			
				
		
		//Check Vertical
		for(int k=1;k<=size;k++){
			check=board[1][k];
			for(int i=2;i<=size;i++){
				if(board[i][k] == check){
					;
				}else{
					check=0;
					break;
				}
				
			}
			if(check!= 0){	return check;}							
		}
		
		//Finally
		return check;
		
	}	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicTacToe t=new TicTacToe(3);
		int p1=t.move(0, 0, 1);
		int p2=t.move(0, 2, 2);
		int p3=t.move(2, 2, 1);
		int p4=t.move(1, 1, 2);
		int p5=t.move(2, 0, 1);
		int p6=t.move(1, 0, 2);
		int p7=t.move(2, 1, 1);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		System.out.println(p5);
		System.out.println(p6);
		System.out.println(p7);
		
	}

}
