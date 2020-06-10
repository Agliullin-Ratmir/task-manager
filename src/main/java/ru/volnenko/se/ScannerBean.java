package ru.volnenko.se;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerBean {

    private final Scanner scanner = new Scanner(System.in);

    public String nextLine() {
        return scanner.nextLine();
    }
}
