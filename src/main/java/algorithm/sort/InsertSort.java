package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ：stream
 * @date ：Created in 2019/7/20 20:04
 */
public class InsertSort {
    public static void main(String[] args) {
//        //        Comparable[] seq = createSeq(0, 100000, 65535);
//        Comparable[] seq = createSeq(0, 128, 4);
//        System.out.println("Unsort:");
//        show(seq);
////        long time1 = System.currentTimeMillis();
//        sort(seq);
////        long time2 = System.currentTimeMillis();
////        System.out.println(time2 -time1);
//        System.out.println("Sorted:");
//        show(seq);
    }

    public static void sort(Comparable[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j > 0 && less(arr[j], arr[j - 1]); j--) {
                exch(arr, j, j - 1);
            }
            show(arr);
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
