package Exercise;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Chapter1 {

	public static void exercise1_1_1()
	{
		System.out.print((0 + 15) / 2);
		System.out.println("\n");
		
		System.out.print(2.0e-6 * 100000000.1); // 2.0e-6是科学计数法表示, 值是2 * 10的-6次方
		System.out.println("\n");
		
		System.out.print(true && false || true && true); // && 比 || 优先级高
		System.out.println("\n");
	}
	
	public static void exercise1_1_2()
	{
		System.out.print((1 + 2.236) / 2); // double
		System.out.println("\n");
		
		// float value = 1 + 2 + 3 + 4.0; // error
		System.out.print(1 + 2 + 3 + 4.0); // double
		System.out.println("\n");
		
		System.out.print(4.1 >= 4); // bool
		System.out.println("\n");
		
		System.out.print(1 + 2 + "3"); // string
		System.out.println("\n");
	}
	
	public static void exercese1_1_3()
	{
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		if(a == b && a == c)
			System.out.println("equal");
		else
			System.out.println("not equal");
	}
	
	public static void exercise1_1_4()
	{
		int a = 1;
		int b = 2;
		int c = 3;
		
		// if (a > b) then c = 0; //than 不是关键字
		// if a > b { c = 0;} // 要有括号
		if (a > b) c = 0;
		// if (a > b) c = 0 else b = 0; // c = 0后面要有;
	}
	
	public static void exercese1_1_5()
	{
		Scanner sc = new Scanner(System.in);
		
		double x = sc.nextDouble();
		double y = sc.nextDouble();
		
		boolean exp1 = x > 0 && x < 1;
		boolean exp2 = y > 0 && y < 1;
		
		if(exp1 && exp2)
			System.out.println("true");
		else
			System.out.println("false");
	}
	
	public static void exercise1_1_6()
	{
		int f = 0;
		int g = 1;
		for (int i = 0; i <= 15; i++)
		{
			System.out.println(f); // 输出一个斐波那契数列
			f = f + g;
			g = f - g;
		}
	}
	
	public static void exercise1_1_7()
	{
		// a
		double t = 9.0;
		while(Math.abs(t - 9.0 / t) > .001)
			t = (9.0 / t + t) / 2.0;
		
		System.out.printf("%.5f\n", t); // 这个没有想出来该怎么算
		
		// b 
		int sum = 0;
		for(int i = 1; i < 1000; i++)
			for(int j = 0; j < i; j++)
				sum++;
		
		System.out.println(sum);
		
		// c
		sum = 0;
		for(int i = 1; i < 1000; i *= 2)
			for(int j = 0; j < 1000; j++)
				sum++;
		
		System.out.println(sum);
		
		
	}
	
	public static void exercise1_1_8()
	{
		System.out.println('b');
		System.out.println('b' + 'c'); // 98 + 99 = 197
		System.out.println((char)('a') + 4); // 97 + 4
	}
	
	public static void exercise1_1_9()
	{
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		if (x <= 0)
		{
			System.out.println("error");
			return;
		}
		
		String s = "";
		while(x > 0)
		{
			s = Integer.toString(x % 2) + s;
			x = x / 2;
		}
		
//		for(int i = x; i > 0; i /= 2)
//			s = (i % 2) + s;
		
		System.out.println(s);
			
	}
	
	public static void exercise1_1_11()
	{
		int M = 3;
		int N = 4;
		boolean a[][];
		a = new boolean[M][N];
		
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
			{
				if (i % 2 == 0 || j % 2 == 0)
					a[i][j] = true;
				else
					a[i][j] = false;
				
				System.out.printf("M = %d, N = %d, value = %s\n", i, j, a[i][j] == true ? "*" : " ");
			}
	}
	
	public static void exercise1_1_12()
	{
		int a[] = new int[10];
		
		for(int i = 0; i < 10; i++)
			a[i] = 9 - i;
		
		for(int i = 0; i < 10; i++)
			System.out.println(a[i]);
		
		System.out.println("-----------------------");
		
		for(int i = 0; i < 10; i++)
			a[i] = a[a[i]]; // 后半段赋值的时候依赖前半段的值 此时前半段的值已经被替换成最初的后半段的值了
		
		for(int i = 0; i < 10; i++)
			System.out.println(a[i]);
	}
	
	public static void exercise1_1_13(int M, int N, int a[][])
	{
		int array[][] = new int[M][N];
		
		for(int i = 0; i < M; i++)
		{
			for(int j = 0; j < N; j++)
			{
				array[i][j] = a[j][i];
				System.out.printf("%d ", array[i][j]);
			}
			
			System.out.println();
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// exercise1_1_1();
		// exercise1_1_2();
		// exercese1_1_3();
		// exercise1_1_4();
		// exercese1_1_5();
		// exercise1_1_6();
		// exercise1_1_7();
		// exercise1_1_8();
		// exercise1_1_9();
		// exercise1_1_11();
		// exercise1_1_12();
		// int a[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		// exercise1_1_13(a[0].length, a.length, a);
		return;
	}
}
