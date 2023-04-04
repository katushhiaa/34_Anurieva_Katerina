package ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Calculation and display of results<br>
 * Includes an implementation of the static method main()
 * 
 */
public class Main {
	/**
	 * An object implementing the {@linkplain View} interface; maintains a collection of objects
	 * {@linkplain ex02.Item2d}
	 */
	private final View view;

	/** Initializes the {@linkplain Main#view view} field.
     * @param view */
	public Main(View view) {
		this.view = view;
	}

	/** Displays the menu. */
	protected void menu() {
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
                            view.viewShow();
                        }
			case 'g' -> {
                            System.out.println("Random generation.");
                            view.viewInit();
                            view.viewShow();
                        }
			case 's' -> {
                            System.out.println("Save current.");
                            try {
                                view.viewSave();
                            } catch (IOException e) {
                                System.out.println("Serialization error: " + e);
                            }
                            view.viewShow();
                        }
			case 'r' -> {
                            System.out.println("Restore last saved.");
                            try {
                                view.viewRestore();
                            } catch (Exception e) {
                                System.out.println("Serialization error: " + e);
                            }
                            view.viewShow();
                        }
			default -> System.out.println("Wrong command.");
			}
		} while (s.charAt(0) != 'q');
	}

	/**
	 * Executed when the program starts; calls the {@linkplain Main#menu() method
	 * menu()}
	 * 
	 * @param args - параметри запуску програми.
	 */
	public static void main(String[] args) {
		Main main = new Main(new ViewableResult().getView());
		main.menu();
	}
}
