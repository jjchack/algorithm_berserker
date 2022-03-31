package sort;

/**
 * @author jiangjuchao
 * @create 2022/3/9
 */

/**
 *冒泡排序：重者下沉，轻者上浮
 * 时间复杂度O(n^2) 稳定
 */
public class Bubble {

    public static void main(String[] args) {
        BaseSort.run(100, (arr)->{
            sort(arr);
        });
    }

    private static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for(int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1]) {
                    BaseSort.swap(arr, j, j + 1);
                }
            }
        }
    }


}
