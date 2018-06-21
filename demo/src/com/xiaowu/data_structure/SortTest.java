package com.xiaowu.data_structure;

import com.xiaowu.data_structure.sorts.BubbleSort;

import java.util.Random;

public class SortTest {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.print("before sort : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println("");
        System.out.print("after sort : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + ",");
        }
    }


}
