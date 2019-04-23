package Chapter2;

public class SelectionSort extends Sort{
    // 选择排序算法描述:
    // 找到最小的元素, 和第一个元素交换位置,
    // 在剩下的元素中找到最小的元素, 再和第二个元素交换位置
    // 特点:
    // 交换的次数总是N
    // 算法的时间效率取决于比较次数
    // 对数据的初始状态利用是最差的, 对随机序列和有序序列排序用时一样
    // 数据的移动是最少的

    static public void sort(Comparable[] array) {
        if (null == array || array.length == 0) return;

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[minIndex])) minIndex = j;
            }

            exch(array, i, minIndex);
        }
    }
}
