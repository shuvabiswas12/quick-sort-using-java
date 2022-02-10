package quick_sort;
import java.util.Arrays;

public class QuickSort {

    private static int partition(int[] q, int left, int right) {
        int pivot = q[right];
        int start = left - 1;

        for (int j = left; j < right; j++) {
            if (q[j] < pivot) {
                start++;
                if (start != j) {
                    swap(q, start, j);
                }
            }
        }

        if ((start + 1) != right) {
            swap(q, start+1, right);
        }

        return start + 1;
    }

    private static void swap(int[] q, int left, int right) {
        int temp = q[left];
        q[left] = q[right];
        q[right] = temp;
    }

    private static void quickSort(int[] q, int left, int right) {
        if (left < right) {
            int p = partition(q, left, right);
            quickSort(q, left, p-1);
            quickSort(q, p + 1, right);
        }
    }

    public static void main(String[] args) {
        int[] q = {7, 6, 10, 5, 9, 2, 1, 15, 7};
        quickSort(q, 0, q.length-1);
        System.out.print(Arrays.toString(q));
    }
}
