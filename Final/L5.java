
/**
 * Skeleton of a tm L2.
 * Add the states and the transition function to implement TM behavior
 * 
 * @author Keres
 * @version 4/10/2020
 */
public class L5
{
    String state;
    char[] tape;
    char[] input;
    int head;//current position of the tape head
    
    //Initialize the Machine
    //Place the input on the tape. No more than 255 symbols
    public L5(char[] input){
        state = "A";
        
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

        
        if (state.equals("A") && (symbol == '0'||symbol=='1') ){ // copy input section
            state = "A"; move_right(); return true;
        }
        else if (state.equals("A") && (symbol == '#')){
            state = "B"; move_left(); return true;
        }
        else if (state.equals("B") && (symbol == '%')){
            state = "H"; move_right(); return true;
        }
        else if (state.equals("B") && (symbol == '0' )){
            state = "C";write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("B") && (symbol == '1')){
            state = "D";write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("C") && (symbol == '*' )){
            state = "C"; move_right(); return true;
        }
        else if (state.equals("C") && (symbol == '#')){
            state = "E"; move_right(); return true;
        }
        else if (state.equals("D") && (symbol == '*' )){
            state = "D"; move_right(); return true;
        }
        else if (state.equals("D") && (symbol == '#' )){
            state = "F"; move_right(); return true;
        }
        else if (state.equals("E") && (symbol == '$')){
            state = "E";move_right(); return true;
        }
        else if (state.equals("E") && (symbol == '0')){
            state = "G";write_symbol('$'); move_left(); return true;
        }
        else if (state.equals("F") && (symbol == '$')){
            state = "F"; move_right(); return true;
        }
        else if (state.equals("F") && (symbol == '1')){
            state = "G";write_symbol('$'); move_left(); return true;
        }
        else if (state.equals("G") && (symbol == '#'||symbol=='$'||symbol=='*')){
            state = "G"; move_left(); return true;
        }
        else if (state.equals("G") && (symbol == '1'||symbol=='0')){
            state = "B"; return true;
        }
        else if (state.equals("G") && (symbol == '%')){
            state = "H"; move_right(); return true;
        }
        
        return false;

    }
    public void run(){
        while(!state.equals("H")){
          System.out.println(toString());//Print the current configuration
          if(false == transition(tape[head])){
              System.out.println("Input rejected:\n" + toString()); 
            }
        }
        System.out.println("TM accepts:\n " + toString()); 

    }
}
