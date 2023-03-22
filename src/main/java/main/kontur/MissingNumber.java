package main.kontur;

import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 1 <= oddInteger <= 99.999 только не четные
        int oddInteger = scan.nextInt();
        // 1 <= |wholeNumbers.get(x)| <= 1000 целые числа положительные или отрицательные
        int finalNumber = 0;
        for (int i = 0; i < oddInteger; i++) {
            int x = scan.nextInt();
            finalNumber += x;
        }
        System.out.println(0-finalNumber);
        scan.close();

    }
}
