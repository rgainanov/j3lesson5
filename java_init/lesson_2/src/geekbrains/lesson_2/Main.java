package geekbrains.lesson_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Chose Operation:");
        System.out.println("1. Addition:");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        System.out.println("Input first number");
        int a = scanner.nextInt();
        System.out.println("Input second number");
        int b = scanner.nextInt();
        double result;

        if (operation==1){
            result = a+b;
        } else if (operation == 2){
            result = a-b;
        } else if (operation == 3){
            result = a*b;
        } else {
            result = (double)a/b;
        }

        System.out.println("Result: "+result);

    }
}
