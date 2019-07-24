package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：stream
 * @date ：Created in 2019/7/20 20:05
 */
public class QuickSort {
    public static void main(String[] args) {
        //        Comparable[] seq = createSeq(0, 100000, 65535);
        Comparable[] seq = createSeq(0, 128, 6);
        System.out.println("Unsort:");
        show(seq);
        System.out.println();;
//        long time1 = System.currentTimeMillis();
        sort(seq, 0, seq.length - 1);
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2 -time1);
        System.out.println("Sorted:");
        show(seq);
    }

    public static void sort(Comparable[] arr) {
        sort(arr,0,arr.length - 1);
    }

    public static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(arr,lo,hi);
        sort(arr,lo,j - 1);
        sort(arr,j + 1,hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = arr[lo];
        while (true) {
            while (less(arr[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, arr[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        System.out.println(j);
        show(arr);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }

    private static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i + 1])) {
                return false;
            }
        }
        return true;
    }

    private static Comparable[] createSeq(int from, int to, int count) {
        Comparable[] arr = new Comparable[count];
        for (int i = 0; i < count; i++) {
            arr[i] = new Random().nextInt(to - from + 1) + from;
        }
        return arr;
    }
}
