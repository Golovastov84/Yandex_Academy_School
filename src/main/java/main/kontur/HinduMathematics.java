package main.kontur;

import java.util.*;

public class HinduMathematics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int greatest = 0;
        int least = 0 ;
        List<Integer> integers = new ArrayList<>();
        while(x>0) {
            integers.add(x % 10);
            x = x / 10;
        }
        Collections.sort(integers, Comparator.naturalOrder());
        for (int i = 0; i < integers.size(); i++) {
            greatest += (integers.get(i) * Math.pow(10,i));
        }
        for (int i = integers.size() - 1; i >= 0; i--) {
            least += (integers.get(i) * Math.pow(10,integers.size() - i - 1));
        }
        System.out.println(greatest - least);
        scan.close();
    }
}
