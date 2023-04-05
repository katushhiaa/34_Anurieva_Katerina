package ex01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


 /**
 * The class Main
 */ 
public class Main {

    private final Calc calc = new Calc();


/** 
 * Menu
 */
    private void menu() throws Exception { 

        String s = null;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        do {
            do {
                System.out.println("Enter command...");
                System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
                try {
                    s = in.readLine();
                } catch (IOException e) {
                    System.out.println("Error: " + e);
                    System.exit(0);
                }
            } while (s.length() != 1);
            switch (s.charAt(0)) {
                case 'q' -> System.out.println("Exit.");
                case 'v' -> {
                    System.out.println("View current.");
                    calc.show();
                }
                case 'g' -> {
                    System.out.println("Random generation.");
                    double arg1 = Math.random()*360;
                    double arg2 = Math.random()*360;
                    double arg3 = Math.random()*360;
                    double arg4 = Math.random()*360;
                    calc.init(arg1, arg2, arg3, arg4);
                    calc.show();
                }

                case 's' -> {
                    System.out.println("Save current.");
                    try {
                        calc.save();
                    } catch (IOException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                case 'r' -> {
                    System.out.println("Restore last saved.");
                    try {
                        calc.restore();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Serialization error: " + e);
                    }
                    calc.show();
                }
                default -> System.out.print("Wrong command. ");
            }
        } while (s.charAt(0) != 'q');
    }


/** 
 * Main
 *
 * @param args  the args
     * @throws java.lang.Exception
 */
    public static void main(String[] args) throws Exception { 

        Main main = new Main();
        main.menu();
    }
}