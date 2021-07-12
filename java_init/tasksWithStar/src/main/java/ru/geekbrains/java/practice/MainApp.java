package ru.geekbrains.java.practice;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainApp {

    public static int SIZE = 3;
    public static char[][] map;

    public static Scanner scanner;
    public static Random random;

    public static char MAP_ELEMENT_EMPTY = '*';
    public static char MAP_ELEMENT_X = 'X';
    public static char MAP_ELEMENT_O = 'O';

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();

        initMap();
        printMap();

        while (true) {
            playerMove();
            printMap();
            if (checkIfFull()) {
                System.out.println("Game over!!! Draw!!!");
                break;
            }


            aiMove();
            printMap();
            if (checkIfFull()) {
                System.out.println("Game over!!! Draw!!!");
                break;
            }
        }

    }

    public static boolean checkLine(int startX, int startY, int vX, int vY, char element) {
        for (int i = 0; i < SIZE; i++) {
            if (map[startX + i * vX][startY + i * vY] != element) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == MAP_ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiMove() {
        int x, y;

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!checkIfMoveIsValid(x, y));

        map[x][y] = MAP_ELEMENT_O;
    }

    public static boolean checkIfMoveIsValid(int x, int y) {
        return x >= 0 && x <= SIZE - 1 && y >= 0 && y <= SIZE - 1 && map[x][y] == MAP_ELEMENT_EMPTY;
    }

    public static void playerMove() {
        int x, y;
        do {
            System.out.println("Please enter your move coordinates [ x  y ]:");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;

        } while (!checkIfMoveIsValid(x, y));

        map[x][y] = MAP_ELEMENT_X;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            if (i > 0) {
                System.out.print(i + " ");
            } else {
                System.out.print("  ");
            }

        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = MAP_ELEMENT_EMPTY;
            }
        }
    }

}
