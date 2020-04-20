
/**
 * Skeleton of a TM.
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
        for(int i = 0; i < input.length; i++) tape[i] = input[i];
        
        head = 0;//The Read/Write head is at index 0
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
        String s = ""; //"State = " + state + " Current Symbol = " + tape[head] + "\n Tape = ";
        for(int i = 0; i < tape.length; i++){ 
           s += tape[i] + " ";
           if(tape[i] == '%') break;
        }
        return s + "\n";
    }
    
    public boolean transition(char symbol){
        if (state.equals("Q1") && symbol == '1'){
            state = "Q3"; write_symbol('x'); move_right(); return true;
        }else if (state.equals("Q3") && (symbol == '0' || symbol == '1')){
            state = "Q3"; move_right(); return true;
        }else if (state.equals("Q3") && (symbol == '#')){
            state = "Q5"; move_right(); return true;
        }else if (state.equals("Q5") && (symbol == 'x')){
            state = "Q5"; move_right(); return true;
        }else if (state.equals("Q5") && (symbol == '1')){
            state = "Q6"; write_symbol('x'); move_left(); return true;
        }else if (state.equals("Q6") && (symbol == '0' || symbol == '1' || symbol == 'x')){
            state = "Q6"; write_symbol('x'); move_left(); return true;
        }else if (state.equals("Q6") && (symbol == '#')){
            state = "Q7"; move_left(); return true;
        }else if (state.equals("Q7") && (symbol == '0' || symbol == '1')){
            state = "Q7"; move_left(); return true;
        }else if (state.equals("Q7") && (symbol == 'x')){
            state = "Q1"; move_right(); return true;
        }else if (state.equals("Q1") && (symbol == '0')){
            state = "Q2"; write_symbol('x'); move_right(); return true;
        }else if (state.equals("Q2") && (symbol == '0' || symbol == '1')){
            state = "Q2"; move_right(); return true;
        }else if (state.equals("Q2") && (symbol == '#')){
            state = "Q4"; move_right(); return true;
        }else if (state.equals("Q4") && (symbol == 'x')){
            state = "Q4"; move_right(); return true;
        }else if (state.equals("Q4") && (symbol == '0')){
            state = "Q6"; write_symbol('x'); move_left(); return true;
        }else if (state.equals("Q1") && (symbol == '#')){
            state = "Q8"; move_right(); return true;
        }else if (state.equals("Q8") && (symbol == 'x')){
            state = "Q8"; move_right(); return true;
        }else if (state.equals("Q8") && (symbol == '%')){
            state = "Q9"; return true;
        }
        else{
            return false;
        }
        
    }
    public void run(){
        while(!state.equals("Q9")){
          System.out.println(toString());//Print the current configuration
          if(false == transition(tape[head])){
              System.out.println("Input rejected:\n" + toString()); System.exit(0);
            }
        }
        System.out.println("TM accepts:\n " + toString()); System.exit(0);

    }
}
