/**
* @author Juano
*/
package sudoku;
public class Board
{
    private Cell[][] cells = new Cell[9][9];
    private int dimension = 0;
    
    public Board()
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }
    
    public void setup(int[][] puzzle)
    {
        int N = puzzle.length;
        //System.out.println(String.format("%d ",N));
        dimension = N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (puzzle[i][j] != 0) {
                    cells[i][j].setValue(puzzle[i][j]);
                }
                //cells[i][j].getAllValues();
            }
        }
    }
    
    public void resetBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!cells[i][j].getSolved()){
                    cells[i][j].resetCell();
                }
            }
        }
    }
    
    @Override
    public String toString()
    {
        String str = "+---------+---------+---------+ \n";
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if ((j == 0) || (j == 3) || (j == 6))
                {
                    str += "|";
                }
                if (cells[i][j].getValue() == 0)
                {
                    str += "   ";
                }else{
                    str += String.format(" %d ", cells[i][j].getValue());
                }
            }
            if ((i == 2) || (i == 5) || (i == 8))
            {
                str += "| \n+---------+---------+---------+\n";
            }else
            {
                str += "| \n";
            }
        }
        return str;
    }
    
    public void candidate(){
        //System.out.println(String.format("%d \n",dimension));
        for(int i=0; i < dimension; i++){
            for(int j=0; j < dimension; j++){
                //System.out.println(String.format("%b \n",cells[i][j].getSolved()));
                if(!cells[i][j].getSolved()){
                    if(i<3){
                        if(j<3){
                            for(int x=0;x<3;x++){
                                for(int y=0;y<3;y++){
                                    if(cells[x][y].getSolved()){
                                        cells[i][j].deleteValue(cells[x][y].getValue());
                                    }
                                }
                            }
                        }else{
                            if(j<6){
                                for(int x=0;x<3;x++){
                                    for(int y=3;y<6;y++){
                                        if(cells[x][y].getSolved()){
                                            cells[i][j].deleteValue(cells[x][y].getValue());
                                        }
                                    }
                                }
                            }else{
                                if(j<9){
                                    for(int x=0;x<3;x++){
                                        for(int y=6;y<9;y++){
                                            if(cells[x][y].getSolved()){
                                                cells[i][j].deleteValue(cells[x][y].getValue());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(i<6){
                            if(j<3){
                                for(int x=3;x<6;x++){
                                    for(int y=0;y<3;y++){
                                        if(cells[x][y].getSolved()){
                                            cells[i][j].deleteValue(cells[x][y].getValue());
                                        }
                                    }
                                }
                            }else{
                                if(j<6){
                                    for(int x=3;x<6;x++){
                                        for(int y=3;y<6;y++){
                                            if(cells[x][y].getSolved()){
                                                cells[i][j].deleteValue(cells[x][y].getValue());
                                            }
                                        }
                                    }
                                }else{
                                    if(j<9){
                                        for(int x=3;x<6;x++){
                                            for(int y=6;y<9;y++){
                                                if(cells[x][y].getSolved()){
                                                    cells[i][j].deleteValue(cells[x][y].getValue());
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else{
                            if(i<9){
                                if(j<3){
                                    for(int x=6;x<9;x++){
                                        for(int y=0;y<3;y++){
                                            if(cells[x][y].getSolved()){
                                                cells[i][j].deleteValue(cells[x][y].getValue());
                                            }
                                        }
                                    }
                                }else{
                                    if(j<6){
                                        for(int x=6;x<9;x++){
                                            for(int y=3;y<6;y++){
                                                if(cells[x][y].getSolved()){
                                                    cells[i][j].deleteValue(cells[x][y].getValue());
                                                }
                                            }
                                        }
                                    }else{
                                        if(j<9){
                                            for(int x=6;x<9;x++){
                                                for(int y=6;y<9;y++){
                                                    if(cells[x][y].getSolved()){
                                                        cells[i][j].deleteValue(cells[x][y].getValue());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }                                
                            }
                        }
                    }
                    for(int l=0; l<dimension; l++){
                        if(cells[l][j].getSolved()){
                            cells[i][j].deleteValue(cells[l][j].getValue());
                        }
                        if(cells[i][l].getSolved()){
                            cells[i][j].deleteValue(cells[i][l].getValue());      
                        }
                    }
                }
            }
        }
    }
    
    public String toCandidate()
    {
        String str = "++------------------+------------------+------------------++------------------+------------------+------------------++------------------+------------------+------------------++ \n";
        for (int i=0; i<9; i++){
            //System.out.println("Entre");
            for (int j=0; j<9; j++){
                if ((j==0) || (j==3) || (j==6)){
                    str += "||";
                }
                if(cells[i][j].getSolved()){
                    str += String.format("        %d         ", cells[i][j].getValue());
                }else{
                    for(int k=0; k < 9; k++){
                        if(k<cells[i][j].sizeCell()){
                            str += String.format("%d,", cells[i][j].getValues(k));
                            //System.out.println(String.format("%d ",cells[i][j].getValues(k)));
                        }else{
                            str += "  ";
                        }
                    }
                }
                if ((j!=2)&&(j!=5)&&(j!=8)){
                    str += "|";
                }
                if (j==8){
                    str += "||\n";
                }
            }
            if ((i==2) || (i==5) || (i==8)){
                    str += "++------------------+------------------+------------------++------------------+------------------+------------------++------------------+------------------+------------------++ \n";
            }
        }
        return str;
    }
    
        public boolean checkBoardCom(){
        boolean good = true;
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                if(cells[i][j].getSolved()){
                    if(i<3){
                        if(j<3){
                            for(int x=0;x<3;x++){
                                for(int y=0;y<3;y++){
                                    if(cells[x][y].getSolved()){
                                        if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                            System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                            good = false;
                                        }
                                    }
                                }
                            }
                        }else{
                            if(j<6){
                                for(int x=0;x<3;x++){
                                    for(int y=3;y<6;y++){
                                        if(cells[x][y].getSolved()){
                                            if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                good = false;
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(j<9){
                                    for(int x=0;x<3;x++){
                                        for(int y=6;y<9;y++){
                                            if(cells[x][y].getSolved()){
                                                if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                    System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                    good = false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(i<6){
                            if(j<3){
                                for(int x=3;x<6;x++){
                                    for(int y=0;y<3;y++){
                                        if(cells[x][y].getSolved()){
                                            if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                good = false;
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(j<6){
                                    for(int x=3;x<6;x++){
                                        for(int y=3;y<6;y++){
                                            if(cells[x][y].getSolved()){
                                                if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                    System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                    good = false;
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    if(j<9){
                                        for(int x=3;x<6;x++){
                                            for(int y=6;y<9;y++){
                                                if(cells[x][y].getSolved()){
                                                    if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                        System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                        good = false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else{
                            if(i<9){
                                if(j<3){
                                    for(int x=6;x<9;x++){
                                        for(int y=0;y<3;y++){
                                            if(cells[x][y].getSolved()){
                                                if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                    System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                    good = false;
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    if(j<6){
                                        for(int x=6;x<9;x++){
                                            for(int y=3;y<6;y++){
                                                if(cells[x][y].getSolved()){
                                                    if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                        System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                        good = false;
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        if(j<9){
                                            for(int x=6;x<9;x++){
                                                for(int y=6;y<9;y++){
                                                    if(cells[x][y].getSolved()){
                                                        if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                            System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                            good = false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }                                
                            }
                        }
                    }
                    for(int l=0; l<dimension; l++){
                        if(cells[l][j].getSolved()){
                            if((cells[i][j].getValue()==cells[l][j].getValue())&&(!(i==l))){
                                System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),l,j,cells[l][j].getValue()));
                                good = false;
                            }
                        }
                        if(cells[i][l].getSolved()){
                            if((cells[i][j].getValue()==cells[i][l].getValue())&&(!(j==l))){
                                System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),i,l,cells[i][l].getValue()));
                                good = false;
                            }
                        }
                    }
                }else{
                    if(cells[i][j].sizeCell()==0){
                        System.out.println(String.format("Cell[%d][%d] No Candidates = %d",i,j,cells[i][j].sizeCell()));
                        good = false;
                    }
                }
            }
        }
        return good;
    }
    
    public boolean checkBoard(){
        boolean good = true;
        for(int i=0; i<dimension; i++){
            for(int j=0; j<dimension; j++){
                if(cells[i][j].getSolved()){
                    if(i<3){
                        if(j<3){
                            for(int x=0;x<3;x++){
                                for(int y=0;y<3;y++){
                                    if(cells[x][y].getSolved()){
                                        if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                            //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                            good = false;
                                        }
                                    }
                                }
                            }
                        }else{
                            if(j<6){
                                for(int x=0;x<3;x++){
                                    for(int y=3;y<6;y++){
                                        if(cells[x][y].getSolved()){
                                            if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                good = false;
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(j<9){
                                    for(int x=0;x<3;x++){
                                        for(int y=6;y<9;y++){
                                            if(cells[x][y].getSolved()){
                                                if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                    //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                    good = false;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else{
                        if(i<6){
                            if(j<3){
                                for(int x=3;x<6;x++){
                                    for(int y=0;y<3;y++){
                                        if(cells[x][y].getSolved()){
                                            if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                good = false;
                                            }
                                        }
                                    }
                                }
                            }else{
                                if(j<6){
                                    for(int x=3;x<6;x++){
                                        for(int y=3;y<6;y++){
                                            if(cells[x][y].getSolved()){
                                                if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                    //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                    good = false;
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    if(j<9){
                                        for(int x=3;x<6;x++){
                                            for(int y=6;y<9;y++){
                                                if(cells[x][y].getSolved()){
                                                    if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                        //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                        good = false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else{
                            if(i<9){
                                if(j<3){
                                    for(int x=6;x<9;x++){
                                        for(int y=0;y<3;y++){
                                            if(cells[x][y].getSolved()){
                                                if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                    //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                    good = false;
                                                }
                                            }
                                        }
                                    }
                                }else{
                                    if(j<6){
                                        for(int x=6;x<9;x++){
                                            for(int y=3;y<6;y++){
                                                if(cells[x][y].getSolved()){
                                                    if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                        //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                        good = false;
                                                    }
                                                }
                                            }
                                        }
                                    }else{
                                        if(j<9){
                                            for(int x=6;x<9;x++){
                                                for(int y=6;y<9;y++){
                                                    if(cells[x][y].getSolved()){
                                                        if((cells[i][j].getValue()==cells[x][y].getValue())&&(!((i==x)&&(j==y)))){
                                                            //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),x,y,cells[x][y].getValue()));
                                                            good = false;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }                                
                            }
                        }
                    }
                    for(int l=0; l<dimension; l++){
                        if(cells[l][j].getSolved()){
                            if((cells[i][j].getValue()==cells[l][j].getValue())&&(!(i==l))){
                                //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),l,j,cells[l][j].getValue()));
                                good = false;
                            }
                        }
                        if(cells[i][l].getSolved()){
                            if((cells[i][j].getValue()==cells[i][l].getValue())&&(!(j==l))){
                                //System.out.println(String.format("[%d][%d] = %d and [%d][%d] = %d",i,j,cells[i][j].getValue(),i,l,cells[i][l].getValue()));
                                good = false;
                            }
                        }
                    }
                }else{
                    if(cells[i][j].sizeCell()==0){
                        //System.out.println(String.format("Cell[%d][%d] No Candidates = %d",i,j,cells[i][j].sizeCell()));
                        good = false;
                    }
                }
            }
        }
        return good;
    }
    
    public void resolverSudoku(){
        //System.out.println(toString());
        candidate();
        if(checkBoard()){
            for(int i=0; i < dimension; i++){
                for(int j=0; j < dimension; j++){
                    if(!cells[i][j].getSolved()){
                        for(int k = 0; k < cells[i][j].sizeCell(); k++){
                            int TempValue = cells[i][j].getValues(k);
                            cells[i][j].setValue(TempValue);
                            resolverSudoku();
                            cells[i][j].resetCell();
                            resetBoard();
                            //System.out.println(toString());
                            candidate();
                            //checkBoardCom();
                        }
                        i=dimension;
                        j=dimension;
                    }
                }
            }
        }else{
            //System.out.println(toCandidate());
            //System.out.println("Creo que hay errores");
        }
        boolean full=true;
        for(int x=0; (x<dimension) && (full) ; x++){
            for(int y=0; y<dimension && (full) ;y++){
                if(!cells[x][y].getSolved()){
                    full = false;
                }
            }
        }
        if(full){
            System.out.println("Una posible solucion para el sodoku es :");
            System.out.println(toString());
        }
    }
}
