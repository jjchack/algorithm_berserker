package sort;

import java.util.function.Consumer;

/**
 * @author jiangjuchao
 * @create 2022/3/10
 */
public class BaseSort {

    public static boolean runOnce(Consumer<int[]> consumer) {
        int[] a = SortUtils.generateRandomArray(10,100);
        int[] b = SortUtils.copyArray(a);
        SortUtils.printArray(a);
        consumer.accept(a);
        SortUtils.printArray(a);
        boolean checkArraySort = SortUtils.checkArraySort(b, a);
        System.out.println(checkArraySort);
        return checkArraySort;
    }

    public static void run(int n, Consumer<int[]> consumer) {
        float success = 0;
        for (int i = 0; i < n; i++) {
            if(true == runOnce(consumer)) {
                success++;
            }
        }
        System.out.println(String.format("试验次数：%s， 成功次数：%s， 成功率：%s", n, (int)success, success/n*100) + "%");
    }

    /**
     * 交换算法，采用异或可以实现交换，只限于确定i和j不同时，如果i和j相同则会因为异或变为0，也就是在快排时无法使用
     * @param arr
     * @param i
     * @param j
     */
    public static void swap1(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
