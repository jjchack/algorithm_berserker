package sort;

/**
 * @author jiangjuchao
 * @create 2022/3/29
 */
public class Heap {

    public static void main(String[] args) {
        BaseSort.run(100, (arr)->{
            sort(arr);
        });
    }

    public static void sort(int[] arr) {
        if(arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        BaseSort.swap(arr, 0, --size);
        while(size > 0) {
            heapUpdate(arr, 0, size);
            BaseSort.swap(arr, 0, --size);
        }
    }

    private static void heapUpdate(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while(left < size) {
            int bigIndex = (left + 1 < size) && arr[left + 1] > arr[left] ? left + 1 : left;
            bigIndex = arr[index] >  arr[bigIndex] ? index : bigIndex;
            if(index == bigIndex) {
                break;
            }
            BaseSort.swap(arr, index, bigIndex);
            index = bigIndex;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while(arr[index] > arr[(index - 1) / 2]) {
            BaseSort.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
