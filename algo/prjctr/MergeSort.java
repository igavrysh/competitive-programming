import java.util.Arrays;

class MergeSort {

    private static void sort(int[] a, int l, int r) {
        if (r-l<2) {
            return;
        }
        int m = (l+r)/2;
        sort(a, l, m);
        sort(a, m, r);  
        merge(a, l, m, r);
    }

    private static void merge(int[] a, int l, int m, int r) {
        int[] c = new int[m-l];
        for (int i = l; i < m; i++) {
            c[i-l] = a[i];
        }
        int i = 0;
        int j = m;
        int k = l;
        while (i < c.length || j < r) {
            if (j == r || (i < c.length && c[i] < a[j])) {
                a[k] = c[i];
                i++;
            } else {
                a[k] = a[j];
                j++;
            }
            k++;
        }
    }

    public static void merge_sort(int[] a) {
        sort(a, 0, a.length); 
    }

    public static void main(String[] args) {
        int[] a = {1,5,3,1,-1,0};
        System.out.println("before sort, a = " + Arrays.toString(a));
        merge_sort(a);
        System.out.println("after sort, a = " + Arrays.toString(a));
    }
}