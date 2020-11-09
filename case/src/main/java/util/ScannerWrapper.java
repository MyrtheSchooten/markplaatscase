package util;

import java.util.Scanner;

public class ScannerWrapper {
    private final Scanner scanner = new Scanner(System.in);
    public String read() {
        return scanner.nextLine();
    }
}
