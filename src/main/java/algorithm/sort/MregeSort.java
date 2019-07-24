package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：stream
 * @date ：Created in 2019/7/20 20:05
 */
public class MregeSort {
    public static void main(String[] args) {
        Comparable[] seq = createSeq(0, 100000, 65535);
//        Comparable[] seq = createSeq(0, 128, 6);
//        System.out.println("Unsort:");
//        show(seq);
//        System.out.println();
        ;
        long time1 = System.currentTimeMillis();
        sort(seq, 0, seq.length - 1, new Comparable[seq.length]);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 -time1);
//        System.out.println("Sorted:");
//        show(seq);
    }

    public static void sort(Comparable[] arr, int lo, int hi, Comparable[] temp) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(arr, lo, mid, temp);
        sort(arr, mid + 1, hi, temp);
        merge(arr, lo, mid, hi, temp);
    }

    private static void merge(Comparable[] arr, int lo, int mid, int hi, Comparable[] temp) {
        int i = lo;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= hi) {
            if (less(arr[i], arr[j])) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= hi) {
            temp[t++] = arr[j++];
        }

        t = 0;
        int tempLeft = lo;
        while (tempLeft <= hi) {
            arr[tempLeft++] = temp[t++];
        }
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
