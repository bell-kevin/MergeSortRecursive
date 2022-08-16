// This performs a recursive merge sort.
package mergesort;

import java.util.*;

public class MergeSort {

    public static int[] mergeSort(int[] array) {
        int half1 = array.length / 2;
        int half2 = array.length - half1;
        int[] sub1 = new int[half1];
        int[] sub2 = new int[half2];
        if (array.length <= 1) { // stopping condition
            return array;
        } else {
            System.arraycopy(array, 0, sub1, 0, half1);
            System.arraycopy(array, half1, sub2, 0, half2);
            sub1 = mergeSort(sub1); //recursive method call
            sub2 = mergeSort(sub2); //recursive method call
            array = merge(sub1, sub2);
            return array;
        }
    } // end mergeSort
//************************************************************************   
// pre-condition: parameters are sorted in ascending order
// post-condition: return is sorted in ascending order

    private static int[] merge(int[] sub1, int[] sub2) {
        int[] array = new int[sub1.length + sub2.length];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < array.length; i++) {
            // both subgroups have elements
            if (i1 < sub1.length && i2 < sub2.length) {
                if (sub1[i1] <= sub2[i2]) {
                    array[i] = sub1[i1];
                    i1++;
                } else // sub2[i2] < sub1[i1]
                {
                    array[i] = sub2[i2];
                    i2++;
                }
            } else { // only one subgroup has elements
                if (i1 < sub1.length) {
                    array[i] = sub1[i1];
                    i1++;
                } else // i2 < sub2.length
                {
                    array[i] = sub2[i2];
                    i2++;
                }
            } // end only one subgroup has elements
        } // end for all array elements
        return array;
    } // end merge
//********************************************************************

    private static void printArray(String msg, int[] array) {
        System.out.println(msg);
        for (int i : array) {
            System.out.printf("%3d", i);
        }
        System.out.println();
    } // end printArray
//****************************************************************************

    public static void main(String[] args) {
        Random random = new Random(0);
        int length = 19;
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(90) + 10;
        }
        printArray("initial array", array);
        printArray("final array", mergeSort(array));
    } // end Main
} // end class MergeSort
