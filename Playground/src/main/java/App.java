/*
 * This Java source file is impliment examined.
 */

import java.io.*;
import java.util.function.*;
import java.util.Optional;

public class App {

    public static void main(String[] args) throws IOException {
        App app = new App();
        Supplier<Boolean> fun = app.test(20, 10);
        System.out.println(fun.get());
    }

    public Supplier<Boolean> test(int x, int y) {
        return () -> {
            return (x <= 10 && y <= 10) ? true : false;
        };
    }
}
