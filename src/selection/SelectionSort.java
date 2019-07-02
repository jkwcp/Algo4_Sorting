package selection;

// Sample codes
// Selection sort: go through the array and select the min of the remainings, swap that with the first
// N^2 (Quartratic) compares and N (linear) swaps
// Always go through all the data, every element is put into the final position with one swap (partially sorted
// array does not matter);

public class SelectionSort  {

    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N - 1; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++){
                if (less(min, a[j]))
                    min = j;
            }

            if (i != min) {
                exch(a, i, min);
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


}
