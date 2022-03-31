package sort;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author jiangjuchao
 * @create 2022/3/9
 */
public class SortUtils {
    public static int[] generateRandomArray(int len, int max) {
        Random random = new Random();
        //return random.ints(0, len).boxed().collect(Collectors.toList());
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = arr[i];
        }
        return a;
    }

    public static boolean checkArraySort(int[] arrOld, int[] arrNew) {
        Arrays.sort(arrOld);
        if (arrOld.length != arrNew.length) return false;
        for (int i = 0; i < arrOld.length; i++) {
            if (arrNew[i] != arrOld[i]) return false;
        }
        return true;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        printArray(generateRandomArray(10, 100));
    }
}
