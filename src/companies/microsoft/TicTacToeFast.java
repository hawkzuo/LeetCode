package companies.microsoft;
//O(1) time performing move
//This one is faster, but this one stores less information about the board.
//Actually that less is none.


public class TicTacToeFast {
	private int[] rows;
	private int[] cols;
	private int diagonal;
	private int antiDiagonal;
	int size;
	public TicTacToeFast(int n) {
		// TODO Auto-generated constructor stub
		rows=new int[n];
		cols=new int[n];
		diagonal=0;
		antiDiagonal=0;
		size=n;
	}
	public int move(int row, int col, int player) {
		
				
		if(player == 1){
			rows[row]++;
			cols[col]++;
			if(col == row){
				diagonal++;
			}
			if(col + row == size-1){
				antiDiagonal++;
			}
			
			
		}else if(player == 2){
			rows[row]--;
			cols[col]--;
			if(col == row){
				diagonal--;
			}
			if(col + row == size-1){
				antiDiagonal--;
			}
			
		}
		
		if(rows[row] == size || cols[col] == size || diagonal == size || antiDiagonal == size){
			return 1;
		}
		if(rows[row] == -size || cols[col] == -size || diagonal == -size || antiDiagonal == -size){
			return 2;
		}		
		return 0;
	
	}
	
	
	
	
	
	
	//Once a row/col has a piece, then it will never be ready for winning.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		TicTacToeFast t=new TicTacToeFast(3);
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
