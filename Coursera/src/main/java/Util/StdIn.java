package Util;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StdIn {

    private static Scanner scanner;

    private static final String CHARSET_NAME = "UTF-8";

    public static int readInt() {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, "
                    + "but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attemps to read an 'int' value from standard input, "
                    + "but no more tokens are available");
        }
    }

    static {
        resync();
    }

    /**
     * If StdIn changes, use this to reinitialize the scanner.
     */
    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }

    public static void setScanner(Scanner scanner) {
        StdIn.scanner = scanner;
    }
}
