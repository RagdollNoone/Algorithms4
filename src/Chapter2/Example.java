package Chapter2;
import Utility.StdOut;

// 成本计算
// 如果需要交换, 计算比较和交换的次数
// 如果不需要交换, 计算访问次数

// 按照额外内存的分配, 又可以分为原地排序算法或是其他算法
public class Example {

	public static void sort(Comparable[] a)
	{
		Sort.ShellSort(a);
	}

	private static void show(Comparable[] a)
	{
		for(int i = 0; i < a.length; i++)
			StdOut.print(a[i] + " ");
		
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a)
	{
		for(int i = 1; i < a.length; i++)
			if (Sort.less(a[i], a[i - 1])) return false;
		
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] a = StdIn.readAllStrings();

        Integer[] a = {7, 4, 8, 5, 2, 1, 9, 3, 6, 0};
        sort(a);
//		assert isSorted(a);
		show(a);
	}
}
