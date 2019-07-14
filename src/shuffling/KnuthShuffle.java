package shuffling;

import edu.princeton.cs.algs4.StdRandom;

public class KnuthShuffle {
    public static void shuffle(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = StdRandom.uniform(i + 1);
            exch(a, i ,r);

        }
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
