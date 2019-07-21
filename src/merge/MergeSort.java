package merge;

// Java sort for objects...
// Divide array into two halves
// Recursively** sort each half
// Merge two halves

// Prototype for dividing and conquer

// Efficiency analyze:
//  Insertion sort: N^2 (n-1 for best case)
//  Selection sort: N^2 (n in best case)
//  Mergesort: nlgn
//        at most NlgN compares and 6NlgN array accesses

// Memory:
//  Extra space for aux[] need to be of size N for the last merge

// Chanllenge: in place merge


import insertion.InsertionSort;

public class MergeSort {
    private static final int CUTOFF = 7;
    private static Comparable[] aux;


    //what is private static method?
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        // assertions:
        // Helps detect bugs
        // Documentation
        // begining: what to expect
        // end: testing also tells people what to expect

        // java -ea MyProgram  //enable
        // java -da MyProgram //disable (default)

        // best practices:
        // assume it is not there
        assert isSorted(a, lo, mid); //precondition: a[lo..mid] sorted
        assert isSorted(a, mid+1, hi); //precondition: a[mid+1..hi] sorted

        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid || less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

            /*
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else a[k] = aux[i++];

             */

        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;

        // Approvement 1: too much overhead for tiny subarrays
        if (hi <= lo + CUTOFF) {
            InsertionSort.sort(a);
            return;
        }



        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        // Approvemnet 2:
        // biggest item in first half is already smaller in second half,
        // no need to merge again
        if (!less(a[mid + 1], a[mid])) return;
        merge(a, aux, lo, mid, hi);

    }



    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public static void sortBottomUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static boolean isSorted(Comparable[] a, int start, int end) {
        return true;
    }
}
