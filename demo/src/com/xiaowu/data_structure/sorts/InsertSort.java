package com.xiaowu.data_structure.sorts;

public class InsertSort {

    public static void sort(int[] source) {
        int i, j, k;
        for (i = 1; i < source.length; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (source[i] > source[j])
                    break;
            }
            if (j != i - 1) {
                int temp = source[i];
                for (k = i - 1; k > j; k--) {
                    source[k + 1] = source[k];
                }
                source[j + 1] = temp;
            }
        }

    }
}
