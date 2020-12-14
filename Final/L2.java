
/**
 * A 2-state automaton
 * Recognizes bitsrings that have an even number of 0's
 * 
 * @author Keres 
 * @version 1/31/2019
 */
public class L2
{
    private String state;
    private boolean accept;
    
    public L2(){
        state = "AQ";
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
        if(state.equals("AQ") && c == '0'){
            System.out.println("State " + state + " Symbol " + c + " Go to BR");
            state = "BR"; accept = false;
        }
        else if(state.equals("AQ") && c == '1'){
            System.out.println("State " + state + " Symbol " + c + " Go to DQ");
            state = "DQ"; accept = false;
        }
        else if(state.equals("DQ") && c == '0'){
            System.out.println("State " + state + " Symbol " + c + " Go to DR");
            state = "DR"; accept = false;
        }
        else if (state.equals("DQ") && c == '1'){
            System.out.println("State " + state + " Symbol " + c + " Go to DQ");
            state = "DQ"; accept = false;
        }
        else if (state.equals("BR") && (c == '0')){
            System.out.println("State " + state + " Symbol " + c + " GO TO DS");
            state = "DS"; accept = false;
        }
        else if (state.equals("BR") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CR");
            state = "CR"; accept = false;
        }
        else if (state.equals("DR") && (c == '0' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO DS");
            state = "DS"; accept = false;
        }
        else if (state.equals("DR") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO DR");
            state = "DR"; accept = false;
        }
        else if (state.equals("DS") && (c == '0' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO DT");
            state = "DT"; accept = false;
        }
        else if (state.equals("DS") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO DS");
            state = "DS"; accept = false;
        }
        else if (state.equals("CR") && (c == '0' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CS");
            state = "CS"; accept = false;
        }
        else if (state.equals("CR") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CR");
            state = "CR"; accept = false;
        }
        else if (state.equals("DT") && (c == '0' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO DT");
            state = "DT"; accept = false;
        }
        else if (state.equals("DT") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO DT");
            state = "DT"; accept = false;
        }
        else if (state.equals("CS") && (c == '0' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CT");
            state = "CT"; accept = true;
        }
        else if (state.equals("CS") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CS");
            state = "CS"; accept = false;
        }
        else if (state.equals("CT") && (c == '0' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CT");
            state = "CT"; accept = true;
        }
        else if (state.equals("CT") && (c == '1' )){
            System.out.println("State " + state + " Symbol " + c + " GO TO CT");
            state = "CT"; accept = true;
        }
        else{
            System.out.println("Bad 'State/Input' combination");
        }
    }
    
    
    public static void main(String...args){
        L2 machine = new L2();
        System.out.println(machine.recognizeInput("010101"));
        System.out.println("");
        System.out.println(machine.recognizeInput("01010101"));
        System.out.println("");
        System.out.println(machine.recognizeInput("0101010101"));
    }
}
