package sort;

/**
 * @author jiangjuchao
 * @create 2022/3/24
 */

/**
 * 快排 O(nlg2n) 不稳定 空间O(nlg2n~n)
 */
public class Quick {

    public static void main(String[] args) {
        BaseSort.run(100, (arr)->{
            sort(arr);
        });
    }
    
    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if(l < r) {
            BaseSort.swap(arr, l + (int)Math.random()*(r - l + 1), r);
            int[] p = partition(arr, l, r, arr[r]);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r, int num) {
        int cur = l;
        int less = l - 1;
        int more = r + 1;
        while(cur < more) {
            if(arr[cur] < num) {
                //这里在普通场景下（++less和cur指向同一个）看似交换自己没什么用，但是在出现num相等值时，
                // 也就是等于num的数量大于2，此时++less和cur的指向就不再是一个位置，遇到arr[cur] < num时就需要真正发生交换
                BaseSort.swap(arr, ++less, cur++);
            }else if(arr[cur] > num) {
                BaseSort.swap(arr, --more, cur);
            }else {
                cur++;
            }
        }
        return new int[]{less + 1, more - 1};
    }
}
