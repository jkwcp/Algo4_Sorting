package insertion;

// 1/4N^2 compares and swtiches -- on average (randomly distributed array
// Best case: ascending order N - 1 compare 0 exchange
// Worst case: descending order 1/2 N^2 compares and 1/2 N^2 exchanges
// Partially sorted:
//  Example: inversion: pair of keys out of order

import java.util.Comparator;

public class InsertionSort {
    public static void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
           for (int j = i; j > 0; j--) {
               if (less(a[j], a[j - 1])) {
                   exch(a, j - 1, j);
               } else {
                   break;
               }
           }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


    //
    public static void sort(Object[] a, Comparator comparator) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(comparator, a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(Comparator c, Object v, Object w) {
        return c.compare(v, w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
