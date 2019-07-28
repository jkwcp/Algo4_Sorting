package interviewQuestions;

import quick.Selection;

public class SelectionInTwoSortedArray {


    // Version 1:
    // n1 = n2, k = n/2
    // n = n1 + n2
    // use n for n1, and n2 in this function
    // for simplicity, use int type instead of Comparable
    public static int SelectionITSAVersionOne(int[] a, int i, int[] b, int j, int n) {
        int k = n; // k = (n + n) / 2

        if (n <= 0) return -1;
        if (n == 1) return a[0] > b[0] ? a[0] : b[0];


        int count = 0;
        int mid = median(n);

        if (a[mid] == b[mid]) {
            return a[mid];
        }

        // if a[mid] < b[mid], the median is between a[mid..n-1] and b[0...mid]
        // 1. there must be n - 1 elements smaller than median,
        // 2. there must be n elements that is greater than the median
        if (a[mid] < b[mid]) {

        }



        return count;

    }

    // Get the index of median element
    // for array with even number of elements, we pick lower median as median
    private static int median(int n) {
        return (n - 1) / 2;
    }


    public static void main(String[] args) {
        System.out.println(5/2 + 1);
    }

}
