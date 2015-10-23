import java.util.*;
import java.util.Scanner;


public class Solver{

    int[][] grid;
    public  Solver(int[][] grid){

	this.grid = grid;
	}
	
	//checks if all columns are valid
	private boolean col(){ 
	   for (int m=0; m<9; m++){	
		for (int i=0; i<9; i++){  //traversing through the column
			for (int j = i+1; j<9; j++){
				if (grid[i][m] != 0 && grid[i][m] == grid[j][m]){ return false;} //another number in the column is the same
			}
		}
	}	
      	return true;
	}
	//given row # says whether it has any duplicates or #s other than 1-9
	private boolean row(){ 
	   for (int m=0; m<9; m++){	 
		for (int i = 0; i<9; i++){
			for (int j=i+1; j<9;j++){
				if (grid[m][i] != 0 && grid[m][i] == grid[m][j]){ return false;}
			}
		}
	}
		return true;
	}
	//checks whether the subsquare of 9 numbers is valid
	private boolean sectValid(int row, int col){
		row=(row/3)*3;
		col=(col/3)*3;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i=row;i<row+3;i++){
			for (int j=col; j<col+3; j++){
			   if (grid[i][j] != 0){ arr.add(grid[i][j]);}
			}
		}
		for (int i=0; i<arr.size(); i++){
		   for (int j = i+1;j<arr.size(); j++){
			if (arr.get(i) == arr.get(j)){
				return false;
			}
		   }
		}
			return true;
	}
	//attempts to solve puzzle returns true if success, false otherwise
	public  boolean solve(){
		
	   int[] rowcol = findempty();
  	   int row = rowcol[0];
	   int col = rowcol[1];
	
       	   if (rowcol[0] == 10){
		 return true;}

	   for (int i=1; i<10; i++){
		grid[row][col] = i;
		if (row() && col() && sectValid(row,col)){
			if (solve()){ return true;}		   
		}		
	   }
	   grid[row][col] = 0;
	    return false;
	}
	//returns an array with the indexes of the empty spots in puzzle
	private int[] findempty(){
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				if (grid[i][j] == 0){
					return new int[] {i,j};
			}
		}
		}
		return new int[] {10,10};

	}
	
	public void print(){
		System.out.println();
		for (int i=0; i<9; i++){
			for (int j=0; j<9; j++){
				System.out.print(" "+grid[i][j]);
			}
			System.out.println();
		}

	}
}
