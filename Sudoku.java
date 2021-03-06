/*
* @author Juan Camilo Castaño 
* @version 23-Feb-2016
*/

package sudoku;

public class Sudoku
{
    public static void Sudoku(int[][] puzzle){
        Board sudoku = new Board();
        sudoku.setup(puzzle);
        sudoku.candidate();
        System.out.println("La matriz a resolver es:");
        System.out.println(sudoku.toString());
        if(sudoku.checkBoardCom()){
            sudoku.resolverSudoku();
        }
    }
    
    public static void main(String[] args)
    {
        int[][] puzzle ={
            {0,2,0, 0,3,0, 0,4,0},
            {6,0,0, 0,0,0, 0,0,3},
            {0,0,4, 0,0,0, 5,0,0},
            
            {0,0,0, 8,0,6, 0,0,0},
            {8,0,0, 0,1,0, 0,0,6},
            {0,0,0, 7,0,5, 0,0,0},
            
            {0,0,7, 0,0,0, 6,0,0},
            {4,0,0, 0,0,0, 0,0,8},
            {0,3,0, 0,4,0, 0,2,0},
        };
        int[][] puzzleERRORES ={
            {0,2,0, 0,3,0, 0,4,0},
            {6,0,2, 0,0,0, 0,0,3},
            {0,0,4, 0,0,0, 5,0,0},
            
            {0,0,0, 8,0,6, 0,0,0},
            {8,0,0, 0,1,0, 0,4,6},
            {0,0,0, 7,0,5, 0,0,0},
            
            {0,4,7, 0,0,0, 6,0,9},
            {4,0,0, 0,0,8, 7,5,8},
            {0,3,0, 0,4,0, 1,2,0},
        };
        int[][] puzzle2 = {
            {8,0,0, 4,0,6, 0,0,7},
            {0,0,0, 0,0,0, 4,0,0},
            {0,1,0, 0,0,0, 6,5,0},
            {5,0,9, 0,3,0, 7,8,0},
            {0,0,0, 0,7,0, 0,0,0},
            {0,4,8, 0,2,0, 1,0,3},
            {0,5,2, 0,0,0, 0,9,0},
            {0,0,1, 0,0,0, 0,0,0},
            {3,0,0, 9,0,2, 0,0,5},
        };
        int[][] puzzle3 = {
        	{3,0,0,2,0,7,1,0,0},
        	{0,6,2,0,0,0,3,0,0},
        	{8,0,0,0,0,0,0,0,4},
        	{5,3,4,8,0,1,0,7,6},
        	{7,0,1,6,0,5,4,0,8},
        	{2,8,0,7,0,3,5,1,9},
        	{9,0,0,0,0,0,0,0,2},
        	{0,0,8,0,0,0,7,9,0},
        	{0,0,7,4,0,9,0,0,3},
        };
	
        int[][] puzzle4 = {
        	{6,0,4,3,5,2,9,7,0},
        	{0,0,2,4,7,0,0,3,6},
        	{3,7,0,6,9,0,4,0,2},
        	{4,2,9,5,3,6,1,8,7},
        	{7,5,1,2,8,4,3,6,9},
        	{8,6,3,7,1,9,2,0,0},
        	{2,4,0,1,6,0,0,9,3},
        	{1,0,0,0,4,0,6,2,0},
        	{0,0,6,0,2,0,7,0,0},
        };

        
        Sudoku(puzzle);
        
    }
}
