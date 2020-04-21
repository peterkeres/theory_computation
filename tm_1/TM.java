
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
        state = "Q0";
        
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
        /*
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
        */

        
        if (state.equals("Q0") && (symbol == '1' || symbol == '0') ){ // copy input section
            state = "Q0"; move_right(); return true;
        }
        else if (state.equals("Q0") && (symbol == '%')){
            state = "Q1"; write_symbol('@'); move_left(); return true;
        }
        else if (state.equals("Q1") && (symbol == '1' || symbol == '0') ){
            state = "Q1"; move_left(); return true;
        }
        else if (state.equals("Q1") && (symbol == '%')){
            state = "Q2"; move_right(); return true;
        }
        else if (state.equals("Q2") && (symbol == '0')){
            state = "Q3"; write_symbol('#'); move_right(); return true;
        }
        else if (state.equals("Q2") && (symbol == '1')){
            state = "Q4";write_symbol('*'); move_right(); return true;
        }
        else if (state.equals("Q2") && (symbol == '@')){
            state = "Q6"; move_left(); return true;
        }
        else if (state.equals("Q3") && (symbol == '1' || symbol == '0' || symbol == '@') ){
            state = "Q3"; move_right(); return true;
        }
        else if (state.equals("Q3") && (symbol == '%')){
            state = "Q5"; write_symbol('0'); move_left(); return true;
        }
        else if (state.equals("Q4") && (symbol == '1' || symbol == '0' || symbol == '@')){
            state = "Q4"; move_right(); return true;
        }
        else if (state.equals("Q4") && (symbol == '%')){
            state = "Q5"; write_symbol('1'); move_left(); return true;
        }
        else if (state.equals("Q5") && (symbol == '1' || symbol == '0' || symbol == '@') ){
            state = "Q5"; move_left(); return true;
        }
        else if (state.equals("Q5") && (symbol == '#')){
            state = "Q2";write_symbol('0'); move_right(); return true;
        }
        else if (state.equals("Q5") && (symbol == '*')){
            state = "Q2";write_symbol('1'); move_right(); return true;
        }
        else if (state.equals("Q6") && (symbol == '1' || symbol == '0')){
            state = "Q6"; move_left(); return true;
        }
        else if (state.equals("Q6") && (symbol == '%')){
            state = "Q7"; move_right(); return true;
        }
        else if (state.equals("Q7") && (symbol == '1' ) ){              // same 0 and 1 section
            state = "Q8";write_symbol('$'); move_right(); return true;
        }
        else if (state.equals("Q7") && (symbol == '0' ) ){
            state = "Q9";write_symbol('$'); move_right(); return true;
        }
        else if (state.equals("Q7") && (symbol == '@') ){
            state = "Q12"; move_left(); return true;
        }
        else if (state.equals("Q8") && (symbol == '1' || symbol == '$') ){
            state = "Q8"; move_right(); return true;
        }
        else if (state.equals("Q8") && (symbol == '0') ){
            state = "Q10";write_symbol('$'); move_left(); return true;
        }
        else if (state.equals("Q9") && (symbol == '0' || symbol == '$') ){
            state = "Q9"; move_right(); return true;
        }
        else if (state.equals("Q9") && (symbol == '1' ) ){
            state = "Q10";write_symbol('$'); move_left(); return true;
        }
        else if (state.equals("Q10") && (symbol == '1' || symbol == '0' || symbol == '$') ){
            state = "Q10"; move_left(); return true;
        }
        else if (state.equals("Q10") && (symbol == '%') ){
            state = "Q11"; move_right(); return true;
        }
        else if (state.equals("Q11") && (symbol == '$') ){
            state = "Q11"; move_right(); return true;
        }
        else if (state.equals("Q11") && (symbol == '1' || symbol == '0' || symbol == '@') ){
            state = "Q7"; return true;
        }
        else if (state.equals("Q12") && (symbol == '$') ){
            state = "Q12"; move_left(); return true;
        }
        else if (state.equals("Q12") && (symbol == '%') ){
            state = "Q13"; move_right(); return true;
        }
        else if (state.equals("Q13") && (symbol == '1' || symbol == '0' || symbol == '@' || symbol == '$') ){ // start of cleaing input
            state = "Q13"; move_left(); return true;
        }
        else if (state.equals("Q13") && (symbol == '%') ){
            state = "Q14"; move_right(); return true;
        }
        else if (state.equals("Q14") && (symbol == '1' || symbol == '0' || symbol == '$') ){
            state = "Q14"; move_right(); return true;
        }
        else if (state.equals("Q14") && (symbol == '@') ){
            state = "Q15"; move_right(); return true;
        }
        else if (state.equals("Q15") && (symbol == '1') ){
            state = "Q16"; write_symbol('*'); move_left(); return true;
        }
        else if (state.equals("Q15") && (symbol == '0') ){
            state = "Q17";write_symbol('#'); move_left(); return true;
        }
        else if (state.equals("Q15") && (symbol == '%') ){
            state = "Q23"; move_left(); return true;
        }
        else if (state.equals("Q16") && (symbol == '1' || symbol == '0' ) ){
            state = "Q16"; move_left(); return true;
        }
        else if (state.equals("Q16") && (symbol == '@') ){
            state = "Q18"; move_left(); return true;
        }
        else if (state.equals("Q17") && (symbol == '1' || symbol == '0') ){
            state = "Q17"; move_left(); return true;
        }
        else if (state.equals("Q17") && (symbol == '@') ){
            state = "Q19"; move_left(); return true;
        }
        else if (state.equals("Q18") && (symbol == '$') ){
            state = "Q18"; move_left(); return true;
        }
        else if (state.equals("Q18") && (symbol == '1' || symbol == '0' || symbol == '%') ){
            state = "Q20"; move_right(); return true;
        }
        else if (state.equals("Q19") && (symbol == '$') ){
            state = "Q19"; move_left(); return true;
        }
        else if (state.equals("Q19") && (symbol == '1' || symbol == '0' || symbol == '%') ){
            state = "Q21"; move_right(); return true;
        }
        else if (state.equals("Q20") && (symbol == '$') ){
            state = "Q22";write_symbol('1'); move_right(); return true;
        }
        else if (state.equals("Q21") && (symbol == '$') ){
            state = "Q22";write_symbol('0'); move_right(); return true;
        }
        else if (state.equals("Q22") && (symbol == '1' || symbol == '0' || symbol == '$' || symbol == '@') ){
            state = "Q22"; move_right(); return true;
        }
        else if (state.equals("Q22") && (symbol == '*') ){
            state = "Q15"; write_symbol('1'); move_right(); return true;
        }
        else if (state.equals("Q22") && (symbol == '#') ){
            state = "Q15"; write_symbol('0'); move_right(); return true;
        }
        else if (state.equals("Q23") && (symbol == '1' || symbol == '0' || symbol == '@' ) ){
            state = "Q23"; move_left(); return true;
        }
        else if (state.equals("Q23") && (symbol == '%') ){
            state = "Q24"; move_right(); return true;
        }
        /*
        else if (state.equals("Q24") && (symbol == '1' ) ){
            state = "Q25"; write_symbol('$'); move_right(); return true;
        }
        else if (state.equals("Q24") && (symbol == '0') ){
            state = "Q27";write_symbol('$'); move_right(); return true;
        }
        else if (state.equals("Q24") && (symbol == '$' ) ){
            state = "Q33"; move_left(); return true;
        }
        else if (state.equals("Q25") && (symbol == '$' ) ){
            state = "Q26"; move_right(); return true;
        }
        else if (state.equals("Q25") && (symbol == '1' || symbol == '0' ) ){
            state = "Q28"; move_right(); return true;
        }
        */
        return false;

    }
    public void run(){
        while(!state.equals("Q24")){
          System.out.println(toString());//Print the current configuration
          if(false == transition(tape[head])){
              System.out.println("Input rejected:\n" + toString()); System.exit(0);
            }
        }
        System.out.println("TM accepts:\n " + toString()); System.exit(0);

    }
}
