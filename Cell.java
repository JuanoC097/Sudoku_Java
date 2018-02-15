package sudoku;

import java.util.ArrayList;
import java.util.List;

/**
* @author Juano
*/

public class Cell
{
    private List<Integer> values = new ArrayList<Integer>();
    private boolean isSolved;
    private int row;
    private int col;
    
    public Cell(int row, int col){
        this.row = row;
        this.col = col;
        
        for (int n = 1; n <= 9; n++) {
            values.add(n);
        }
    }
    
    public void resetCell(){
        values.clear();
        isSolved = false;
        for (int n = 1; n <= 9; n++) {
            values.add(n);
        }
    }
    
    public int sizeCell(){
        return values.size();
    }
    
    public void setValue(int value) {
        values.clear();
        values.add(value);
        isSolved = true;
    }
    
    public int getValue() {
        return isSolved? values.get(0) : 0;
    }
    
    public void setValues(int value){
        values.add(value);
        isSolved = false;
    }
    
    public int getValues(int k){
        return values.get(k);
    }
    
    public void getAllValues(){
        String str1 = String.format("Cell[%d][%d]",row,col);
        System.out.println(str1);
        System.out.println(String.format("%b ",isSolved));
        String str = "";
        for(int k=0; k < values.size(); k++){
            str += String.format("%d, ",values.get(k));
        }
        System.out.println(str);
    }
    
    public boolean getSolved() {
        return isSolved;
    }
    
    public void deleteValue(int x){
        for(int k=0; k < values.size(); k++){
            if(values.get(k) == x){
                values.remove(k);
            }
        }
    }
}
