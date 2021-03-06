
/**
 * Skeleton of a tm L1.
 * Add the states and the transition function to implement TM behavior
 * 
 * @author Radhouane 
 * @version 4/10/2020
 */
public class TM
{
    String state;
    char[] tape;
    char[] input;
    int head;//current position of the tape head
    
    //Initialize the Machine
    //Place the input on the tape. No more than 255 symbols
    public TM(char[] input){
        state = "Q1";
        
        //the tape is initially all blank symbols
        tape = new char[256];//Assume up to 255 char. Normally infinite
        for(int i = 0; i < tape.length; i++) tape[i] = '%';
        
        this.input = input;
        for(int i = 0; i < input.length; i++) tape[i+1] = input[i];
        
        head = 1;//The Read/Write head is at index 0
    }
    
    public void move_left(){
        head--;
        if(head < 0) assert false: "Cant move left";
    }
    
    public void move_right(){
        head++;
        if(head >= tape.length) assert false: "Cant move right";
    }
    
    public void write_symbol(char symbol){
        tape[head] = symbol;
    }
    
    public String toString(){
        String s = "State = " + state + " Current Symbol = " + tape[head] + "\n Tape = "; //"State = " + state + " Current Symbol = " + tape[head] + "\n Tape = ";
        for(int i = 0; i < tape.length; i++){ 
           s += tape[i] + " ";
           if(tape[i] == '%' && i != 0) break;
        }
        return s + "\n";
    }
    
    public boolean transition(char symbol){

        
        if (state.equals("Q1") && (symbol == '0') ){ // copy input section
            state = "Q2"; write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q2") && (symbol == '0')){
            state = "Q2"; move_right(); return true;
        }
        else if (state.equals("Q2") && (symbol == '1') ){
            state = "Q3"; write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q3") && (symbol == '1')){
            state = "Q3"; move_right(); return true;
        }
        else if (state.equals("Q3") && (symbol == '2')){
            state = "Q4"; write_symbol('*'); move_left(); return true;
        }
        else if (state.equals("Q4") && (symbol == '1' || symbol == '2' | symbol == '*')){
            state = "Q4"; move_left(); return true;
        }
        else if (state.equals("Q4") && (symbol == '0')){
            state = "Q5"; move_left(); return true;
        }
        else if (state.equals("Q5") && (symbol == '0')){
            state = "Q5"; move_left(); return true;
        }
        else if (state.equals("Q5") && (symbol == '*')){
            state = "Q6"; move_right(); return true;
        }
        else if (state.equals("Q6") && (symbol == '0')){
            state = "Q7"; write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q7") && (symbol == '0' || symbol =='*')){
            state = "Q7"; move_right(); return true;
        }
        else if (state.equals("Q7") && (symbol == '1')){
            state = "Q8"; write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q8") && (symbol == '1' || symbol =='*')){
            state = "Q8"; move_right(); return true;
        }
        else if (state.equals("Q8") && (symbol == '2')){
            state = "Q9"; write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q9") && (symbol == '%')){
            state = "Q10"; write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q9") && (symbol == '0' || symbol == '1' || symbol =='2' || symbol=='*')){
            state = "Q11"; move_left(); return true;
        }
        else if (state.equals("Q10")){
            state = "Q10"; return true;
        }
        else if (state.equals("Q11") && (symbol == '0' || symbol == '1' || symbol =='2' || symbol=='*')){
            state = "Q11"; move_left(); return true;
        }
        else if (state.equals("Q11") && (symbol=='%')){
            state = "Q12"; move_right(); return true;
        }
        else if (state.equals("Q12") && (symbol=='*')){
            state = "Q12"; move_right(); return true;
        }
        else if (state.equals("Q12") && (symbol=='0')){
            state = "Q7"; write_symbol('*'); move_right(); return true;
        }
        
        return false;

    }
    public void run(){
        while(!state.equals("Q10")){
          System.out.println(toString());//Print the current configuration
          if(false == transition(tape[head])){
              System.out.println("Input rejected:\n" + toString()); System.exit(0);
            }
        }
        System.out.println("TM accepts:\n " + toString()); System.exit(0);

    }
}
