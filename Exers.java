import java.util.Scanner;
import java.util.Arrays;

class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Age: ");
        scan.nextInt();
        String hello = "hello";
        char h = hello.charAt(0);
        System.out.println(h);
    }
}

class DogAge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("How old are your dog? ");
        int age = scan.nextInt();
        if (age < 0)
            System.out.println("wrong age");
        else if (age >= 0 && age <= 2)
            System.out.println("like human age: " + (int) (age * 10.5));
        else
            System.out.println("like human age: " + (int) (2 * 10.5 + (age - 2) * 4));

    }
}

class AriTest {
    public static void main(String[] args) {
        int num = 187;
        int a = num % 10;
        // int b = (num % 100 - a) / 10; //太繁琐了吧...
        // int b = num % 100 / 10;
        int b = num / 10 % 10;
        // int c = num % 1000 - num % 100) / 100; //太繁琐了吧...
        int c = num / 100;
        System.out.println("个位：" + a);
        System.out.println("十位：" + b);
        System.out.println("百位：" + c);
        // 总结：写之前觉得这题好简单差点没写，写完听课发现我的方法超级烂。
        // 所以每题都要写！！

        int n, x, y;
        n = x = y = 10;
        n += (n++) + (++n); // n = n + (n++) + (++n) = 10 + 10 + 12 = 32
        x += (++x) + x; // 32
        y += (++y) + (y++); // 32 ???????
        System.out.println("n = " + n);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        int n1 = 12;
        int n2 = 30;
        int n3 = -43;
        int r = (n1 > n2) ? ((n1 > n3) ? n1 : n3) : ((n2 > n3) ? n2 : n3);
        System.out.println("r = " + r);
    }
}

class EqualsTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入你是否帅：（是/否）");
        String isHandsome = scan.next();
        if (isHandsome.equals("是"))
            System.out.println("冲！");
    }
}

class YearDay {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int year = scan.nextInt();
        int month = scan.nextInt();
        int day = scan.nextInt();
        int sumDays = 0;
        switch (month) {
            case 12:
                sumDays += 30;
            case 11:
                sumDays += 31;
            case 10:
                sumDays += 30;
            case 9:
                sumDays += 31;
            case 8:
                sumDays += 31;
            case 7:
                sumDays += 30;
            case 6:
                sumDays += 31;
            case 5:
                sumDays += 30;
            case 4:
                sumDays += 31;
            case 3:
                if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
                    sumDays += 29; // 闰年
                else
                    sumDays += 28; // 平年
            case 2:
                sumDays += 31;
            case 1:
                sumDays += day;
        }
        System.out.println(sumDays);
    }
}

class BizBaz {
    public static void main(String[] args) {
        for (int i = 1; i <= 150; i++) {
            System.out.print(i);
            if (i % 3 == 0)
                System.out.print(" foo");
            if (i % 5 == 0)
                System.out.print(" biz");
            if (i % 7 == 0)
                System.out.print(" baz");
            System.out.println();
        }
    }
}

class GCDLCM {
    // 求m和n的最大公约数(Greatest Common Dividor)和最小公倍数(Least Common Multiple)
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入第一个正整数：");
        int m = scan.nextInt();
        System.out.println("请输入第二个正整数：");
        int n = scan.nextInt();
        int min = (m < n) ? m : n;
        int max = (m > n) ? m : n;
        for (int i = min; i > 0; i--) {
            if (min % i == 0 && max % i == 0) {
                System.out.println(m + "和" + n + "的最大公约数是: " + i);
                break;
            }
        }
        for (int i = max; i <= m * n; i += max) {
            if (i % min == 0) {
                System.out.println(m + "和" + n + "的最小公倍数是: " + i);
                break;
            }
        }
        // 总结：写的时候没想到求最大公倍数时候i的上限 勤思考
    }
}

class DoWhile {
    // 从键盘输入个数不确定的整数，并判断读入的正数和负数的个数， 输入为0时结束程序
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int countP = 0;
        int countN = 0;
        int n = 1;
        do {
            n = scan.nextInt();
            if (n > 0)
                countP++;
            else if (n < 0)
                countN++;
        } while (n != 0);
        System.out.println("正数：" + countP + "\n负数：" + countN);
        // 总结：还可以用for(;;)或者while(true)来写
    }
}

class PrimeNumber {
    // 10000以内质数（只能被1和它本身整除的自然数）
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        outter: for (int i = 2; i <= 10000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {// 优化：除数j可以停在根号下j的地方
                if (i % j == 0)
                    continue outter;
            }
            System.out.print(i + "\t");
        }
        long end = System.currentTimeMillis();
        System.out.println("\ntime (ms): " + (end - start));
    }
}

class ArrayExer {
    public static void main(String[] args) {
        // 一维数组的静态初始化（和赋值操作同时进行）
        int[] ids = new int[] { 1, 2, 3, 4 };
        int ids1[] = new int[] { 1, 2, 3, 4 }; // 也对
        int[] ids2 = { 1, 2, 3, 4 };// 类型推断 //也对
        // 一维数组的动态初始化（和赋值操作分开进行）
        String[] names = new String[5];
        names[0] = "xiangxiang";
        System.out.println(names.length);

        // 多维数组的静态初始化
        int[][] ar1 = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } };
        // 多维数组的动态初始化
        String[][] arr2 = new String[3][2];
        String[][] arr3 = new String[3][];
        int[] arr4[] = new int[][] { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } }; // 也对
        int arr5[][] = { { 1, 2, 3 }, { 4, 5 }, { 6, 7, 8 } }; // 也对
        arr3[1] = new String[4];
    }
}

class YangHuiTriangle {
    // 打印十行杨辉三角
    public static void main(String[] args) {
        int[][] yanghui = new int[10][];
        for (int i = 0; i < yanghui.length; i++) {
            yanghui[i] = new int[i + 1];
            yanghui[i][0] = 1;
            yanghui[i][i] = 1;
            // }
            // for (int i = 2; i < yanghui.length; i++) {//优化：并不需要这行
            for (int j = 1; j < yanghui[i].length - 1; j++) {
                yanghui[i][j] = yanghui[i - 1][j - 1] + yanghui[i - 1][j];
            }
        }
        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();
        }
        // 写了15min 好慢。。。写一步打印一下比较好
    }
}

class DiffRandomGenerator {
    // 创建一个为6的int型数组，要求元素值都在1-30之间，随机赋值，各元素值不相同。
    public static void main(String[] args) {
        int[] rand = new int[6];
        for (int i = 0; i < rand.length; i++) {
            outter: do {
                rand[i] = (int) (Math.random() * 30 + 1);
                for (int j = i - 1; j >= 0; j--) {
                    if (rand[i] == rand[j])
                        continue outter;
                }
                break;
            } while (true);
            System.out.print(rand[i] + "\t");
        }
    }
}

class DiffRandomGeneratorBetter {
    // 创建一个为6的int型数组，要求元素值都在1-30之间，随机赋值，各元素值不相同。方法二
    public static void main(String[] args) {
        int[] rand = new int[6];
        for (int i = 0; i < rand.length; i++) {
            rand[i] = (int) (Math.random() * 30 + 1);
            for (int j = 0; j < i; j++) {
                if (rand[i] == rand[j]) {
                    i--;
                    break;
                }
            }
        }
        for (int i = 0; i < rand.length; i++) {
            System.out.print(rand[i] + "\t");
        }
    }
}

class HuiXingShu {
    // 回形数版本0
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the size: ");
        int size = scan.nextInt();
        int[][] table = new int[size][size];
        // uppper triangle
        int startIdx = 0;
        int endIdx = size - 1;
        int len = size;
        int start = 1;
        for (int i = 0; i < (size + 1) / 2; i++) {
            for (int j = startIdx; j <= endIdx; j++) {
                table[i][j] = start++;
            }
            start += 2 * (--len) + (--len);
            startIdx++;
            endIdx--;
        }
        // right triangle
        startIdx = 1;
        endIdx = size - 1;
        len = size;
        start = size + 1;
        for (int i = size - 1; i >= (size + 1) / 2; i--) {
            for (int j = startIdx; j <= endIdx; j++) {
                table[j][i] = start++;
            }
            start += (--len) + 2 * (--len);
            startIdx++;
            endIdx--;
        }
        // lower triangle
        startIdx = size - 2;
        endIdx = 0;
        len = size - 1;
        start = 2 * size;
        for (int i = size - 1; i >= (size + 1) / 2; i--) {
            for (int j = startIdx; j >= endIdx; j--) {
                table[i][j] = start++;
            }
            start += 2 * (--len) + (--len);
            startIdx--;
            endIdx++;
        }
        // left triangle
        startIdx = size - 2;
        endIdx = 1;
        len = size - 1;
        start = size + 2 * (size - 1) + 1;
        for (int i = 0; i < (size + 1) / 2; i++) {
            for (int j = startIdx; j >= endIdx; j--) {
                table[j][i] = start++;
            }
            start += (--len) + 2 * (--len);
            startIdx--;
            endIdx++;
        }
        // print
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(table[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

class HuiXingShuBetter {
    // 回形数版本1: 优化了一下 版本0太复杂了
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter the size: ");
        int size = scan.nextInt();
        int[][] table = new int[size][size];
        int num = 1;
        int start = 0;
        int end = size;
        int i = 0;
        int j = -1;
        while (num <= size * size) {
            // rightward
            for (++j; j < end; j++)
                table[i][j] = num++;
            j--;
            // downward
            for (++i; i < end; i++)
                table[i][j] = num++;
            i--;
            // leftward
            for (--j; j >= start; j--)
                table[i][j] = num++;
            j++;
            // upward
            for (--i; i > start; i--)
                table[i][j] = num++;
            i++;
            start++;
            end--;
        }
        // print
        for (int ii = 0; ii < size; ii++) {
            for (int jj = 0; jj < size; jj++) {
                System.out.print(table[ii][jj] + "\t");
            }
            System.out.println();
        }
    }
}

class ShenQi {
    public static void main(String[] args) {
        int[] x = new int[3];
        int[][] y = new int[3][3];
        System.out.println(x);// [I@2f0e140b
        System.out.println(y);// [[I@7440e464
        // 除了地址还存type,所以x=y会报错

        String[] arr = { "BB", "GG", "MM", "JJ" };
        // 线性查找:
        String dest = "MM";
        boolean isFlag = true;
        for (int i = 0; i < arr.length; i++) {
            if (dest.equals(arr[i])) {
                System.out.println("Found at position: " + i);
                isFlag = false;
                break;
            }
        }
        if (isFlag)
            System.out.println("Didn't find");

        // 二分法查找:
        int[] arr1 = new int[] { -25, -4, 0, 6, 87, 89, 100 };
        int dest1 = 0;
        boolean isFlag1 = true;
        for (int i = 0, j = arr1.length - 1; i <= j;) {
            int idx = (i + j) / 2;
            if (dest1 == arr1[idx]) {
                System.out.println("Found at position: " + idx);
                isFlag1 = false;
                break;
            } else if (dest1 < arr1[idx])
                j = idx - 1;
            else
                i = idx + 1;
        }
        if (isFlag1)
            System.out.println("Didn't find");
    }
}

class BubbleSort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100);
        // int[] arr = new int[] { 43, 32, 76, -98, 0, 64, 33, -21, 32, 99 };// 0-9
        // my way (从时间上看更快) 不知道为啥
        int len = arr.length - 1;
        for (; len >= 0; len--) {
            int temp = arr[0];
            for (int j = 1; j <= len; j++) {
                if (temp > arr[j]) {
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else
                    temp = arr[j];
            }
        }
        // 老师的方法
        /*
         * for (int i = 0; i < len; i++) { for (int j = 0; j < len - i; j++) { if
         * (arr[j] > arr[j + 1]) { int temp = arr[j]; arr[j] = arr[j + 1]; arr[j + 1] =
         * temp; } } }
         */
        // for (int i = 0; i < arr.length; i++)
        // System.out.print(arr[i] + "\t");
        // System.out.println();
        long end = System.currentTimeMillis();
        System.out.println("\ntime (ms): " + (end - start));
    }
}

class QuickSort {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] arr, int pivot, int end) {
        if (pivot < end) {
            int mid = arr[pivot];
            int low = pivot;
            int high = end + 1;
            while (true) {
                while (low < end && arr[++low] < mid)
                    ;
                while (high > pivot && arr[--high] > mid)
                    ;
                if (low < high)
                    swap(arr, low, high);
                else
                    break;
            }
            swap(arr, pivot, high);
            quickSort(arr, pivot, high - 1);
            quickSort(arr, high + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 43, 32, 76, -98, 0, 64, 33, -21, 32, 99 };
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + "\t");
    }
}

class ArraysTest {
    public static void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4 };
        int[] arr2 = new int[] { 1, 3, 2, 4 };
        boolean isEquals = Arrays.equals(arr1, arr2);// 比较是否一样
        System.out.println(Arrays.toString(arr1));// 直接变成String打印
        Arrays.sort(arr2);// 排序
        int index = Arrays.binarySearch(arr1, 6);// 二分查找
        System.out.println((index >= 0) ? index : "Didn't Found");// index为负就是没找到
    }
}

/**
 *
 * @Description 微软面试题：定义一个int型的数组：int[] arr = new int[] {12,3,3,34,56,77,432}
 *              让数组的每个位置上的值去除以首位置的元素，得到的结果作为该位置上的新值。遍历新的数组。
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 2, 2021 4:08:34 PM
 *
 */
class Interview0 {
    public static void main(String[] args) {
        int[] arr = new int[] { 12, 3, 3, 34, 56, 77, 432 };
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] / arr[0];
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

class Interview1 {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        System.out.println(arr);// 地址值
        char[] arr1 = new char[] { 'a', 'b', 'c' };
        System.out.println(arr1);// abc
    }
}

