
/**
 * Tests the Turing Machine for L = {x#x where x is in {0,1}*}
 * 
 * @author Radhouane
 * @version 4/1/2020
 */
public class Tester
{
    public static void main(String...args){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("What is the initial input string? ");
        String s = scan.nextLine();
        TM machine = new TM(s.toCharArray());
        machine.run();
        
    }
}
