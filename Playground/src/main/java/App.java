/*
 * This Java source file is impliment examined.
 */

import java.io.*;

public class App {
    public static void main(String[] args) throws IOException {
        int x;
        do {
            x = System.in.read ();
            System.out.println ("code: " + String.valueOf (x));
            System.out.println ("char: " + String.valueOf ((char)x));
        } while (x != -1);
    }
}
