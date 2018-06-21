package com.xiaowu.data_structure.sorts;

public class QuickSort {
    public static void sort(int[] source, int left, int right){
        int i, j, x;
        if (left < right) {
            i = left;
            j = right;
            x = source[left];
            while (i < j) {
                while (i < j && source[j] > x) {
                    j--;
                }
                if (i < j) {
                    source[i++] = source[j];
                }
                while (i < j && source[i] < x) {
                    i++;
                }
                if (i < j) {
                    source[j--] = source[i];
                }
            }
            source[i] = x;
            sort(source, left, i - 1);
            sort(source, i + 1, right);
        }
    }
}
