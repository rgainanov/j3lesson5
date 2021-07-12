package ru.geekbrains.lesson1;


import java.util.Random;
import java.util.Scanner;

public class MainApp {

    private static Scanner scanner;
    private static Random random;
    private static char[][] map;

    private static final int SIZE = 3;


    private static final char MAP_ELEMENT_EMPTY = '*';
    private static final char MAP_ELEMENT_X = 'X';
    private static final char MAP_ELEMENT_O = 'O';

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        random = new Random();
        initMap();
        printMap();

        while (true) {
            playerMove();
            printMap();
            if (checkWin(MAP_ELEMENT_X)) {
                System.out.println("Player WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Game Over, draw");
            }
            aiMove();
            printMap();
            if (checkWin(MAP_ELEMENT_O)) {
                System.out.println("AI WIN!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Game Over, draw");
            }
        }
    }

    public static boolean checkWin(char element) {
        if (map[0][0] == element && map[1][0] == element && map[2][0] == element) {
            return true;
        }
        if (map[0][1] == element && map[1][1] == element && map[2][1] == element) {
            return true;
        }
        if (map[0][2] == element && map[1][2] == element && map[2][2] == element) {
            return true;
        }
        if (map[0][0] == element && map[0][1] == element && map[0][2] == element) {
            return true;
        }
        if (map[1][0] == element && map[1][1] == element && map[1][2] == element) {
            return true;
        }
        if (map[2][0] == element && map[2][1] == element && map[2][2] == element) {
            return true;
        }
        if (map[0][0] == element && map[1][1] == element && map[2][2] == element) {
            return true;
        }
        if (map[2][0] == element && map[1][1] == element && map[0][2] == element) {
            return true;
        }
        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == MAP_ELEMENT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCellEmpty(int x, int y) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        if (map[x][y] != MAP_ELEMENT_EMPTY) {
            return false;
        }
        return true;
    }

    public static void aiMove() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellEmpty(x, y));

        System.out.println("AI made a move to [ " + (x + 1) + " , " + (y + 1) + " ]");
        map[x][y] = MAP_ELEMENT_O;
    }

    public static void playerMove() {
        int x, y;
        do {
            System.out.println("Enter Coordinates of your Move ('X Y')");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellEmpty(x, y));
        map[x][y] = MAP_ELEMENT_X;
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = MAP_ELEMENT_EMPTY;
            }
        }
    }
}
