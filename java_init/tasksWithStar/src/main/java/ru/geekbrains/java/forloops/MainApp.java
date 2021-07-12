package ru.geekbrains.java.forloops;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
//        christmasTree();

//        int[] arr = new int[5];
//        for (int i = 0; i < 5; i++) {
//            arr[i] = i + 1;
//        }
        int[] arr = {1,6,-4,3,6};
        System.out.println(Arrays.toString(arr));
        boolean res = checkBalance2(arr);
        System.out.println(res);


    }

    public static boolean checkBalance2(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) sum += arr[i];

        if (sum % 2 != 0) return false;

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum * 2 == sum) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkBalance(int[] arr) {
        int leftIndex = 1, rightIndex = arr.length - 2;
        int leftSum = arr[0], rightSum = arr[arr.length - 1];

        while (true) {
            if (leftSum < rightSum && leftIndex <= rightIndex) {
                leftSum += arr[leftIndex];
                leftIndex += 1;
            } else if (leftSum > rightSum && leftIndex <= rightIndex) {
                rightSum += arr[rightIndex];
                rightIndex -= 1;
            } else if (leftSum == rightSum && Math.abs(leftIndex - rightIndex) == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void christmasTree() {
        int length = 14, width = 12;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (Math.abs(j - width / 2) < 1 + (i % 3) + i / 3 && i < 12 ||
                        Math.abs(j - width / 2) < 2 && i >= 12) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
