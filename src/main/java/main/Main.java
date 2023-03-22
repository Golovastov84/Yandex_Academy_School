package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberA = scan.nextInt();
        int numberB = scan.nextInt();
        System.out.println (numberA + numberB);
        System.out.println (numberA * numberB);
        scan.close();
    }
}
