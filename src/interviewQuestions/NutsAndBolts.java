package interviewQuestions;

import sun.awt.image.ByteComponentRaster;

public class NutsAndBolts {

    public static void match(Comparable[]a, Comparable[]b, int lo, int hi) {
        if (hi <= lo) return;

        int j = partition(a, lo, hi, b[lo]);
        partition(b, lo, hi, a[j]);

        match(a, b, lo, j - 1);
        match(a, b,j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi, Comparable v) {
        int j = hi;
        for (int i = 0; i < hi; i++) {
            int cmp = v.compareTo(a[i]);
            if (cmp < 0) {
                exch(a, i--, j--);
            }

            if (cmp == 0) {
                exch(a, i, lo);
            }

            if (i >= j) break;
        }

        exch(a, lo, j);
        return j;
    }



    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
