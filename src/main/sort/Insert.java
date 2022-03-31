package sort;

/**
 * @author jiangjuchao
 * @create 2022/3/15
 */

/**
 * 插入排序 时间复杂度为O(n^2)
 * 稳定
 */
public class Insert {

    public static void main(String[] args) {
        BaseSort.run(100, (arr)->{
            sort(arr);
        });
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for(int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                BaseSort.swap(arr, j, j + 1);
            }
        }
    }
}
