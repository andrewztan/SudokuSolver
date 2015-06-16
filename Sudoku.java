/*
HW
predator prey
chess
Sudoku
matrix inversion
*/
import java.util.*;

public class Sudoku {

	public static boolean isSafe(int[][] q, int r, int c, int n) {
		//check vertical
		for (int i=0; i<9; i++) {
			if (i==r)
				continue;

			if (q[i][c]==n) 
				return false;
		}

		//check horizontal
		for (int j=0; j<9; j++) {
			if (j==c)
				continue;

			if (q[r][j]==n)
				return false;
		}
		
		//check 3x3 square
		int a = (r/3) * 3;
		int b = (c/3) * 3;
		
		for (int i=a; i<a+3; i++) {
			for (int j=b; j<b+3; j++) {
				if (i==r && j==c)
					continue;

				if (q[i][j]==n)
					return false;
			}
		}

		return true;
	}

	public static void runSudoku (int[][] q, int r, int c) {
		if (r==9)
			printSudoku(q);
		else {

			//for (int i=0; i<9; i++) {
			//	for (int j=0; j<9; j++) {
			
			while (q[r][c]!=0) {
				if (c==8) {
					r++;
					c=0;
				}
				else {
					c++;
				}
			}
			
			

			for (int n=1; n<=9; n++) {

				if (isSafe(q, r, c, n)) {
					q[r][c] = n;

					if (c==8)
						runSudoku(q, r+1, 0);
					else
						runSudoku(q, r, c+1);
					
				}
			}

			q[r][c] = 0;
				
		}

			/*
			for (int i=0; i<q.length; i++) {
				q[r] = i;
				if (isSafe(q, r, i))
					NQueens(q, r+1);
			}
			*/

	}

	public static void printSudoku(int[][] q) {
		System.out.println();
		System.out.println("Solution: ");
		for (int i=0; i<q.length; i++) {
			for (int j=0; j<q[i].length; j++) {
				System.out.printf("%s ", q[i][j]);
			}
			
			System.out.println();
		}
	}


	public static void main(String[] args) {

		/* user input Sudoku puzzle
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter dimensions of Sudoku puzzle: ");
		int s = inp.nextInt();
		int[][] A = new int[s][s];

		System.out.print("Enter an integer 1-9 or 0 for blank.");
		for (int i=0; i<s; i++) {
			for (int j=0; j<s; j++)
			{
				System.out.print("Enter A["+i+"]["+j+"]: ");
				A[i][j] = inp.nextInt();
				while (!(A[i][j]>=0 && A[i][j]<10)) {
					System.out.println("Must enter an integer 1-9 or 0 for blank.");
					System.out.print("Enter A["+i+"]["+j+"]: ");
					A[i][j] = inp.nextInt();
				}
			}
		}
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<A[i].length; j++) {
				System.out.printf("%s ", A[i][j]);
			}
			System.out.println();
		}
		*/

		//e.g. puzzle[0] is an array that represents the top/first row of numbers in the puzzle
		int[][] puzzle = {{0,0,7,0,3,0,0,5,6}, {0,0,9,1,0,0,0,0,0}, {0,0,0,0,0,6,1,4,0}, {0,0,0,0,0,4,0,3,0}, {0,0,0,0,0,3,0,0,5}, {0,7,5,0,0,0,0,8,2}, {4,0,0,0,0,0,0,0,0}, {0,6,0,3,0,1,9,0,0}, {0,0,0,0,0,8,2,0,0}};
		int[][] puzzle2 = {{0,0,0,7,2,0,9,3,6}, {2,6,9,5,0,3,4,0,0}, {7,0,4,0,6,0,2,5,0}, {1,7,0,0,9,2,0,0,3}, {0,2,8,3,0,0,1,0,5}, {0,4,0,8,0,5,0,2,7}, {0,0,6,0,7,0,5,8,2}, {8,5,2,9,0,6,0,0,0}, {4,0,0,0,0,8,3,6,0}};

		System.out.println("Puzzle:");
		for (int i=0; i<puzzle2.length; i++) {
			for (int j=0; j<puzzle2[i].length; j++) {
				System.out.printf("%s ", puzzle2[i][j]);
			}
			System.out.println();
		}

		Sudoku.runSudoku(puzzle2, 0, 0);

	}
}
