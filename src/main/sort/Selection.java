package sort;

/**
 * @author jiangjuchao
 * @create 2022/3/14
 */

/**
 * 选择排序：从0-n依次与之后选出的最小值交换
 * 时间复杂度O(n^2) 不稳定
 * 举例[3,3,1]，第一轮会检测出1最小和第一个3交换，那么第一个和第二个3就发生了位置转换
 */
public class Selection {

    public static void main(String[] args) {
        BaseSort.run(100, (arr)->{
            sort(arr);
        });
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }

        for(int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                minIndex = arr[minIndex] < arr[j] ? minIndex : j;
            }
            if(minIndex != i) {
                BaseSort.swap(arr, i, minIndex);
            }
        }
    }
}
