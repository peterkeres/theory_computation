
/**
 * A 2-state automaton
 * Recognizes bitsrings that have an even number of 0's
 * 
 * @author Keres 
 * @version 1/31/2019
 */
public class L1
{
    private String state;
    private boolean accept;
    
    public L1(){
        state = "A";
        accept = true;
    }
    
    public boolean recognizeInput(String w){
        for(int i = 0; i < w.length(); i++){
            System.out.println("Consuming " + w.charAt(i));
            transition(w.charAt(i));
        }
        return accept;
    }
    public void transition(char c){
        if(state.equals("A") && c == '0'){
            System.out.println("State " + state + " Symbol " + c + " Go to B");
            state = "B"; accept = false;
        }
        else if(state.equals("A") && c == '1'){
            System.out.println("State " + state + " Symbol " + c + " Go to D");
            state = "B"; accept = false;
        }
        else if(state.equals("B") && c == '0'){
            System.out.println("State " + state + " Symbol " + c + " Go to D");
            state = "D"; accept = false;
        }
        else if (state.equals("B") && c == '1'){
            System.out.println("State " + state + " Symbol " + c + " Go to C");
            state = "C"; accept = true;
        }
        else if (state.equals("C") && (c == '1' || c == '0')){
            System.out.println("State " + state + " Symbol " + c + " Stay at C");
            state = "C"; accept = true;
        }
        else if (state.equals("D") && (c == '1' || c == '0')){
            System.out.println("State " + state + " Symbol " + c + " Stay at D");
            state = "D"; accept = false;
        }
        else{
            System.out.println("Bad 'State/Input' combination");
        }
    }
    
    
    public static void main(String...args){
        L1 machine = new L1();
        System.out.println(machine.recognizeInput("01"));
        System.out.println("");
        System.out.println(machine.recognizeInput("0101"));
        System.out.println("");
        System.out.println(machine.recognizeInput("010101"));
    }
}
