package shell;

// h-sort array: insertion sort with h positions exchanged
// h:
//  powers of 2: 2, 4, 8.....(NO)
//  powers of 2 minus 1: maybe
//  3x + 1: ok  O(N^ (3/2)) worst case...no exact model yet
//  sedgewick: ....don't understand

// fast unless the array size is huge

public class ShellSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;

        while (h < N / 3) h = h * 3 + 1;

        while (h > 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j - h], a[j]); j = j - h)
                    exch(a, i - h, i);
            }

            h = h / 3;
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
}
