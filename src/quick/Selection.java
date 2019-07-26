package quick;


// Goal: Given an array of n items, find the kth largest
//
// NlogN upper bond
// N for small k
// Easy N lower bound:...

// Entry a[j] is in place
// No larger entry to the left of j
// No smaller entry to the right of j

// Repeat in one subarray, depending on jl finishe when j equals k

import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdRandom;

public class Selection {

    public static Comparable select(Comparable[] a, int k) {
        StdRandom.shuffle(a);

        int lo = 0, hi = a.length - 1;

        while(hi > lo) {
            int j = Partition.partition(a, lo, hi);
            if (j < k) lo = j + 1;
            else if (j > k) hi = j - 1;
            else return a[k];
        }

        return a[k];
    }


    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int i = 3;
        System.out.println(a[3]);
        System.out.println(a[--i]);
        System.out.println(a[i--]);
        System.out.println(a[3]);



    }
}
