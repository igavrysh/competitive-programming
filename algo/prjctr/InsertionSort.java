import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] a = {100,-1,10,1,4,10};
        sort(a);
        System.out.println("a = " + Arrays.toString(a));
    }

    public static void sort(int[] a) {
        int n = a.length;
        // a[0...i-1] is sorts
        // b[i]
        for (int i = 1; i < n; ++i) {
            int j = i;
            while (j > 0 && a[j-1] > a[j]) {
                swap(a, j-1, j);
                j--;
            }
        }
    }

    public static void sort2(int[] a) {
        int n = a.length;
        // a[0...i-1] is sorts
        // b[i]
        for (int i = 1; i < n; ++i) {
            int j = i;
            int key = a[j];
            while (j > 0 && a[j-1] > key) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = key;
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

}
