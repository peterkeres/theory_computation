/**
 * A 2-state automaton
 * Recognizes bitsrings that have an even number of 0's and an odd number of 1's
 *
 * the language is {0,1}
 *
 * @author Peter Keres
 * @version 2/9/2019
 */


public class DFA
{
    private String state;
    private boolean accept;

    // sets default states and prints the value of the accept state after processing is done
    public DFA(String test){
        state = "AC";
        accept = false;
        System.out.println("actual results: " + recognizeInput(test));
}


    // takes each character in the input string and passes it to the transition function
    public boolean recognizeInput(String w){
        for(int i = 0; i < w.length(); i++){
            System.out.println("Consuming " + w.charAt(i));
            transition(w.charAt(i));
        }
        return accept;
    }


    // figures out what current state the DFA is in and passes it to the correct method to handle where to go next
    public void transition (char c){

        if (state.equals("AC")){
            stateAC(c);
        }
        else if (state.equals("BC")){
            stateBC(c);
        }
        else if (state.equals("AD")){
            stateAD(c);
        }
        else if (state.equals("BD")){
            stateBD(c);
        }
        else{
            System.out.println("ERROR!!!! unknown state: " + state);
            System.exit(2);
        }


    }


    // if the current state is AC
    public void stateAC (char c){

        if ( c == '1'){
            state = "BC";
            accept = true;
        }
        else if( c == '0'){
            state = "AD";
            accept = false;
        }
        else{
            outOfLanInput(c);
        }

    }


    // if the current state is BC
    public void stateBC (char c){

        if ( c == '1'){
            state = "AC";
            accept = false;
        }
        else if( c == '0'){
            state = "BD";
            accept = false;
        }
        else{
            outOfLanInput(c);
        }

    }


    // if the current state is AD
    public void stateAD (char c){

        if ( c == '1'){
            state = "BD";
            accept = false;
        }
        else if( c == '0'){
            state = "AC";
            accept = false;
        }
        else{
            outOfLanInput(c);
        }

    }


    // if the current state is BD
    public void stateBD (char c){

        if ( c == '1'){
            state = "AD";
            accept = false;
        }
        else if( c == '0'){
            state = "BC";
            accept = true;
        }
        else{
            outOfLanInput(c);
        }

    }

    // if the character happens to be outside of the current laguage. error handling method
    public void outOfLanInput(char c) {
        System.out.println("ERROR!!!!! The current character " + c + " is outside of the current language. Please correct this error");
        System.exit(1);
    }


    // runs all the tests
    public static void main(String...args){

        String[] tests = {"1", "0000111", "100", "0", "00", "01", "11", "0011"};
        boolean[] expected = {true, true, true, false, false, false, false, false};

        System.out.println("RUNNING TESTS FOR ASSIGMENT 1");

        for (int test = 0; test < tests.length; test++){
            System.out.println("\n\ntest \'" + tests[test] + "\' expected result is " + expected[test] + " starting...");
            DFA machine = new DFA(tests[test]);
        }

        System.out.println("\n\nEND OF PROGRAM!!!");
    }


}
