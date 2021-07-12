package geekbrains.lesson_3;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int range = 100;
        int number = (int)(Math.random()*range);

        System.out.println("Guess Number Game");
        playLevel(number, range);

        scanner.close();
    }

    private static void playLevel(int number, int range){
        System.out.println("Guess number between 0 and "+range);
        while(true){

            int x = scanner.nextInt();

            if (x == number){
                System.out.println("you guessed right");
                break;
            } else if (x > number){
                System.out.println("your guess is too high");
            } else {
                System.out.println("your guess is too low");
            }
        }
    }
}
