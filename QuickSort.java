package quick_sort;
import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] q, int left, int right) {
        int pivot = q[right];
        int pointer = left - 1;

        for (int j = left; j < right; j++) {
            if (q[j] < pivot) {
                pointer++;

                if (pointer != j) {
                    swap(q, pointer, j);
                }
            }
        }

        if ((pointer + 1) != right) {
            swap(q, pointer+1, right);
        }

        return pointer + 1;
    }

    private static void swap(int[] q, int left, int right) {
        int temp = q[left];
        q[left] = q[right];
        q[right] = temp;
    }

    private static void quickSort(int[] q, int left, int right) {
        if (left < right) {
            // here 'p' means partition value means an index, the position where the pivot value did swap with another value.
            int p = partition(q, left, right);
            quickSort(q, left, p-1);
            quickSort(q, p + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] q = {7, 6, 10, 5, 9, 2, 1, 15, 7};
        quickSort(q, 0, q.length-1);
        System.out.print(Arrays.toString(q));

        /**
         * Explanation:
         * ------------
         * 6, 1, 9, 3, 5
         *
         * pass: 1
         * -------
         * N.B: Here pointer is an index value. But pivot is an actual value.
         *
         * 1) i= left => 0; pointer= -1; pivot= 5;
         * after pass 1 of for loop the array will be like: 6, 1, 9, 3, 5
         *
         * 2) i= 1; pointer= 0; pivot= 5;
         * after pass 2 of for loop the array will be like: 1, 6, 9, 3, 5
         *
         * 3) i= 3; pointer= 0; pivot= 5;
         * after pass 3 of for loop the array will be like: 1, 6, 9, 3, 5
         *
         * 4) i= 4; pointer= 1; pivot= 5;
         * after pass 4 of for loop the array will be like: 1, 3, 9, 6, 5
         *
         * 5) i= 5; pointer= 1; pivot= 5;
         * loop exits.
         *
         * after exiting loop, the control of program of enters final swapping of pass 1.
         *
         * now, pointer = pointer + 1 => 1 + 1 => 2; pivot= 5
         * Now swap will happen between array[pointer] and pivot.
         * after final swapping of pass 1 the array will be like: 1, 3, 5, 6, 9
         *
         * // pass 1 finished.
         *
         */


    }
}
