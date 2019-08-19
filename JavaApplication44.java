package javaapplication44;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author MTG
 */
public class JavaApplication44 {

    public static void main(String[] args) {
        RS232 dfa=new RS232();
        String input;
        ArrayList<Character> array=new ArrayList();
        ArrayList<Integer> data=new ArrayList();
        boolean isValid=true;
        Scanner scan=new Scanner(System.in);
        
        System.out.println("Start Bit: 0, Data Bits: 8 bits, Parity Bit: None, Stop Bit: 1(1 bit)");
        System.out.print("Input: ");
        input=scan.nextLine();
        if(!input.isEmpty()) {
            for(int i=0;i<input.length();i++) {
                if(input.charAt(i)!='0'&&input.charAt(i)!='1') {
                    System.out.println("Invalid input");
                    isValid=false;
                    break;
                }
                else array.add(input.charAt(i));
            }
            if(isValid==true) {
                for(int i=0;i<array.size();i++) {
                    dfa.input(array.get(i));
                }
            }
            if(isValid==true) {
                if(dfa.getCurrentState()==0) System.out.println("No start bit detected.");
                else if(dfa.getCurrentState()==10) {
                        System.out.println("Eligible input.");
                        data=dfa.getData();
                        System.out.print("Transmitted data: ");
                        for(int i=0;i<data.size();i++) {
                            System.out.print(data.get(i));
                        }
                        System.out.println("");               
                }
                else System.out.println("Error detected. Incomplete input.");
                System.out.println("q"+dfa.getCurrentState());
            }
        }
        else {
            if(isValid==true) {
                System.out.println("No input detected.");
                System.out.println("q"+dfa.getCurrentState());
            }
        }
        
    }
    
}
