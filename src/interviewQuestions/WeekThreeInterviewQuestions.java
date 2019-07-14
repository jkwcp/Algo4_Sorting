package interviewQuestions;

import edu.princeton.cs.algs4.Point2D;
import shell.ShellSort;

public class WeekThreeInterviewQuestions {

    // Intersection of two sets
    // Count number of points (2D) that are in both array a and b
    // Subquadratic
    public static int countIntersectionPoints(Point2D[] a, Point2D[] b) {
        int count = 0; //should you assign value? declare? define?
        int n = a.length + b.length;
        Point2D[] temp = new Point2D[n];

        for (int i = 0; i < n; i++) {
            if (i < a.length) {
                temp[i] = a[i];
            } else {
                temp[i] = b[i - a.length];
            }
        }

        ShellSort.sort(temp);

        for (int i = 1; i < n; i++) {
            if (!temp[i].equals(temp[i - 1])) {
                count++;
            }
        }

        return count;

    }


    public static boolean permutationTest(Integer[] a, Integer[] b, int n) {
        if (a.length != n || b.length != n) {
            throw new IllegalArgumentException();
        }

        ShellSort.sort(a);
        ShellSort.sort(b);

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;

    }

    public static void DutchNationalFlag(Bucket[] buckets, int n) {
        int red = 0;
        int white = 0;
        int blue = n - 1;


        for (int i = 0; i < n; i++) {
            switch (color(i, buckets)) {
                case "red":
                    swap(i, red, buckets);
                    red++;
                    white++;
                    break;
                case "white":
                    swap(i, white, buckets);
                    white++;
                    break;
                case "blue":
                    swap(i, blue, buckets);
                    blue--;
                    break;
                default:
                    break;
            }

        }
    }

    private static void swap(int i, int j, Bucket[] a) {
        String temp = a[i].peddleColor;
        a[i].peddleColor = a[j].peddleColor;
        a[j].peddleColor = temp;
    }

    private static String color(int i, Bucket[] a) {
        return a[i].peddleColor;
    }

    private class Bucket {
        String peddleColor;
    }
}
