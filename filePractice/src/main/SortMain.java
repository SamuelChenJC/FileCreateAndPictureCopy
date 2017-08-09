package main;

import java.util.Arrays;

/**
 * Created by Chenpi on 2017/8/7.
 */
public class SortMain {
    public static void main(String[] args) {

        System.out.println("正在使用："+SortMain.class);

        // int[] ints = {11, 66, 25, 95, 82, 3};
        // bubbleSort(ints);

        // int[] array = {1, 3, 5, 8, 9, 11, 23, 25, 48, 68, 79};
        int[] array = {1,2,3,4,5,6,7,8,9,12,454,69,87};
        System.out.println("所在下标为：" + binarySearch(array, 69));


    }


    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 针对所有的元素重复以上的步骤，除了最后一个。
     * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     * @param ints 需要排序的整型数组
     */
    private static void bubbleSort(int[] ints) {
        System.out.println("冒泡前：" + Arrays.toString(ints));

        int length = ints.length;
        int temp = 0;

        for (int i=0;i<length-1;i++) {
            for (int j = 0;j<length-1-i;j++) {//不减i也行，但是因为i次排序之后，最后i个肯定都是最大的，会进行无意义比较
                if (ints[j] > ints[j + 1]) {
                    temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                }
            }
            System.out.println("第" + (i) +"遍："+ Arrays.toString(ints));
        }
        System.out.println("冒泡后：" + Arrays.toString(ints));
    }

    /**
     * 二分查找 (必须是一个有序数列)
     * 先取中间的，如果目标数字比中间的大，则起始下标设为mid的下一个，如果比中间的小，结束下标设置为mid的前一个。
     *
     */

    private static int binarySearch(int[] array, int target) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {//一定要有等于
            int mid = (end-start)/2 + start;//
            if (target > array[mid]) {
                start = mid + 1;
            } else if (target < array[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


}
