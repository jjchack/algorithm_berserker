package sort;

/**
 * @author jiangjuchao
 * @create 2022/3/23
 */

/**
 * 归并排序 O(lng2n) 空间O(n) 稳定
 */
public class Merge {

    public static void main(String[] args) {
        BaseSort.run(100, (arr)->{
            sort(arr);
        });
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int l, int r) {
        if(l < r) {
            int m = l + ((r - l) >> 1);
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int help[] = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while(p1 <= m && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= m) {
            help[i++] = arr[p1++];
        }

        while(p2 <= r) {
            help[i++] = arr[p2++];
        }

        for(i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }
}
