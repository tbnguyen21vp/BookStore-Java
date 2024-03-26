package bookstorre;

import org.checkerframework.checker.units.qual.C;

public class Control extends Thread {

    private String url;

    Control() {
        this.url = "jdbc:mysql://localhost:3307/bookstore";
    }

    public void run() {
        System.out.println("Hello, World!" + url);
    }

}
