package InputOutput;

import java.io.Console;
import java.util.Arrays;

public class ConsoleInputOutput {
	public static void main(String[] args) {
		consoleInput();
	}

	public static void consoleInput() {
		Console console = System.console();
		if (console != null) {
			String login = console.readLine("Your login: ");
			char[] password = console.readPassword("Your password: ");
			console.printf("Login: " + login + " Password: " + Arrays.toString(password));
		}
	}
}
