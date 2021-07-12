package ru.geekbrains.java.algorithms;

import java.util.Arrays;

public class MainApp {
    private static int[] array = {8, 8, 9, 7, 1, 2, 5, 4, 3};

    public static void main(String[] args) {
//        System.out.println(gcd(16, 4));

//        int[] arr = {8, 8, 9, 7, 1, 2, 5, 4, 3};
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array));

        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static int gcd(int a, int b) {
        if (b == 0) return a;
        int c = a % b;
        return gcd(b, c);
    }

    public static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr) {
        int start = 0;
        int end = array.length - 1;
        sort(start, end);
    }

    public static void sort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int ce = i - (i - j) / 2;
        while (i < j) {
            while (i < ce && (array[i] <= array[ce])) {
                i++;
            }
            while (j > ce && (array[ce] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == ce)
                    ce = j;
                else if (j == ce)
                    ce = i;
            }
        }
        sort(start, ce);
        sort(ce + 1, end);
    }
}
