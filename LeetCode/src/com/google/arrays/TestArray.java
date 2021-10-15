package com.google.arrays;

import java.io.IOException;
import java.util.Scanner;

public class TestArray {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int a;
        int[] yadu = new int[10];
        Student[] vijay = new Student[5];
        // index will start from 0 and end at 9. Index will range from 0 to 9
        for (int i = 0; i<5; i++) {
            yadu[i] = scanner.nextInt();
        }

        // 1, 22, 33
        // 0, 1,  2

        // int array - float, char array
        // int array - sum of all numbers
        // char array - number of vowels and consonants
        // char array - number of capital and small letters
        // int array - sum of odd and even
        // int array - count of odd and even numbers

        yadu[3] = 32;
        for (int i = 0; i < 5; i++) {
            System.out.println("Value = " + yadu[i]);
        }
        int [] test = new int[] {1, 2, 3};
        int size = test.length;
    }

    private class Student {
        private String name;
        private int age;
    }
}


