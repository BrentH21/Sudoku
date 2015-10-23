
import java.util.Scanner;


public class Driver{

   public static void main(String[] args){

	Scanner scan = new Scanner(System.in);
	System.out.println("Enter in each row of soduko puzzle on a line with 0s as unknown spots");
	int[][] grid = new int[9][9];
	int line = 0;
	while (line <9){

		if (scan.hasNextLine()){
			for (int i=0; i<9; i++){
				if (scan.hasNextInt()){
					int temp = scan.nextInt();
					if (temp<0 || temp >9){
					  System.out.println("Non valid number entered please re enter row");
					  line--;
					  break;
					}
					else{ grid[line][i] = temp;}

				}
				else if (scan.hasNext()){
					System.out.println("Non integer entered please reenter the row");
					line--;
					break;
				}
				
			}
			line++;
			scan.nextLine();
		}	
	}

	Solver puzzle = new Solver(grid);
	if (puzzle.solve()){
		System.out.println();
		System.out.println("The solved puzzle is: ");
		puzzle.print();
	}
	else{
		System.out.println("The puzzle could not be solved please verify input");
	}	
	



   }


}
