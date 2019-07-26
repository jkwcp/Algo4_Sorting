package quick;

// 1. Shuffle
// 2. Partition
// 3. Sort

// Advantage compare to merge -> no extra space

// Partioning in-place: using extra array easier, but not worth the cost
// Terminating the loop: testing whether the pointers cross is a bit trickier
// Staying in bounds: j == lo is redundant
// Preserving rendomness: Shuffling is needed for performance guarantee.
// Equal keys:
// Not stable


// Running time estimates:  NlogN but faster than merge (a little more comparisons but less data movement)
// Best case: Nlogn
// 1/2N^2 (if shuffled randomly, very hard to get)

// Java:
// Mergesort: objects
// Quicksort: primitives
import edu.princeton.cs.algs4.StdRandom;

public class QuickSort {

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        // use cut off to use insertion on small arrays
        // Estimated medians
        int j = Partition.partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }



    // Three way partitioning
    // let v be partitioning item a[lo]
    // Scan i from left to right
    // (a[i] < v): exchange a[lt] with a[i]; increment both lt and i
    // (a[i] > v): exchange a[gt] with a[i]; decrement gt
    // (a[i] == v): increment i;
    private static void threeWayQsort(Comparable[] a, int lo, int hi) {
        if (hi < lo) return;

        int lt = lo, gt = hi;

        Comparable v = a[lo];
        int i = lo;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt++, i++);
            } else if (cmp > 0) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }

        threeWayQsort(a, lo, lt - 1);
        threeWayQsort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


}
