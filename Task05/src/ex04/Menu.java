package ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Calculation and display of results<br>
 * Includes an implementation of the static method main()
 *
 */
public class Menu implements Command {

    /**
     * An object implementing the {@linkplain View} interface; maintains a
     * collection of objects {@linkplain ex02.Item2d}
     */
    private final List<ConsoleCommand> menu = new ArrayList<>();

    public ConsoleCommand add(ConsoleCommand command) {
        menu.add(command);
        return command;
    }

    @Override
    public String toString() {
        String s = "Enter command...\n";
        for (ConsoleCommand c : menu) {
            s += c + ", ";
        }
        s += "'q'uit: ";
        return s;
    }

    @Override
	public void execute() {
		String s = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		menu: while (true) {
			do {
				System.out.print(this);
				try {
					s = in.readLine();
				} catch (IOException e) {
					System.err.println("Error: " + e);
					System.exit(0);
				}
			} while (s.length() != 1);
			char key = s.charAt(0);
			if (key == 'q') {
				System.out.println("Exit.");
				break menu;
			}
			for (ConsoleCommand c : menu) {
				if (s.charAt(0) == c.getKey()) {
					c.execute();
					continue menu;
				}
			}
			System.out.println("Wrong command.");
			continue menu;
		}
	}
}
