package Chapter2;

// 成本计算
// 如果需要交换, 计算比较和交换的次数
// 如果不需要交换, 计算访问次数

// 按照额外内存的分配, 又可以分为原地排序算法或是其他算法
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] a = StdIn.readAllStrings();

        Integer[] a = {7, 4, 8, 5, 2, 1, 9, 3, 6, 0};
		String[] b = {"paper", "true", "soap", "floppy", "flower"};

//        InsertionSort.sort(b); // 传递的是数组引用的拷贝
//		assert isSorted(a);
		MergeSort.Sort(a);
		Sort.show(a);
	}
}
