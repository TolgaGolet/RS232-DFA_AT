package javaapplication44;

import java.util.ArrayList;

/**
 *
 * @author MTG
 */
public class RS232 {
    ArrayList<Integer> data=new ArrayList();
    int currentState=0;  //Default is initial state.
    int[][] table={
        {1, 0},
        {2, 2},
        {3, 3},
        {4, 4},
        {5, 5},
        {6, 6},
        {7, 7},
        {8, 8},
        {9, 9},
        {1, 10},
        {1, 10}
    };
    
    public void input(int x) {
        if(currentState!=0&&currentState!=10) {
            if(currentState!=9) data.add(x-48);
        }
        currentState=table[currentState][x-48];
    }
    
    public int getCurrentState() {
        return currentState;
    }
    
    public ArrayList<Integer> getData() {
        return data;
    }
    
}
