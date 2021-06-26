import java.lang.Thread.State;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Vector;

class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Age: ");
        scan.nextInt();
        String hello = "hello";
        char h = hello.charAt(0);
        System.out.println(h);
        scan.close();
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
        scan.close();
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
        scan.close();
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
        scan.close();
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
        scan.close();
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
        scan.close();
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
        scan.close();
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
        scan.close();
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

/**
 *
 * @Description Singleton
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 8, 2021 11:28:03 AM
 *
 */
class SingletonTest1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        // bank1 == bank2
    }
}

// 饿汉式
class Bank {
    private Bank() {
    }

    private static Bank instance = new Bank();

    public static Bank getInstance() {
        return instance;
    }
}

// 懒汉式
class Bank1 {
    private Bank1() {
    }

    private static Bank1 instance = null;

    public static Bank1 getInstance() {
        if (instance == null) {
            instance = new Bank1();
        }
        return instance;
    }
}

/**
 *
 * @Description 接口测试
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 10, 2021 4:27:57 PM
 *
 */
class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MAX_SPEED);
        System.out.println(Flyable.MIN_SPEED);
        Plane plane = new Plane();
        plane.fly();
    }
}

interface Flyable {
    // 全局常量
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;// 省略了public static final

    // 抽象方法
    public abstract void fly();

    void stop();// 省略了public abstract

    // no constructors in interface
}

interface Attackable {
    void attack();
}

class Plane implements Flyable {

    @Override
    public void fly() {
        System.out.println("通过引擎起飞");
    }

    @Override
    public void stop() {
        System.out.println("驾驶员减速停止");
    }
}

class Bullet extends Object implements Flyable, Attackable {

    @Override
    public void fly() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void attack() {
    }

}

/**
 *
 * @Description String面试题
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 19, 2021 10:35:49 AM
 *
 */
class StringTest {
    String str = new String("good");
    char[] ch = { 't', 'e', 's', 't' };

    public void change(String str, char ch[]) {
        System.out.println(str == this.str);// true
        str = "good";// 直接指常量池了
        System.out.println(str == this.str.intern());// true
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);// good
        System.out.println(ex.ch);// best

    }
}

/**
 *
 * @Description 一些String相关的算法题
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 20, 2021 8:00:13 PM
 *
 */
class StringExer {
    public static void main(String[] args) {
        StringExer stringExer = new StringExer();
        String str = "abcdefg";
        int beginIdx = 2;
        int endIdx = 5;
        System.out.println(stringExer.reverse(str, beginIdx, endIdx));
        System.out.println("***********************");
        str = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        System.out.println(stringExer.appear(str, subStr));
        System.out.println("***********************");
        String str1 = "abcwerthelloyuiodef";
        String str2 = "cvhellobnm";
        System.out.println(stringExer.common(str1, str2));
        System.out.println("***********************");
        str1 = "abcwerthelloyuiodef";
        str2 = "cvhellobnmiodef";
        System.out.println(stringExer.commonMulti(str1, str2).toString());
    }

    /**
     * "abcdefg"->"abfedcg" 15min
     * 
     * @param str
     * @param beginIdx
     * @param endIdx
     * @return
     */
    public String reverse(String str, int beginIdx, int endIdx) {
        if (str != null) {
            // 我的方法 15min...好菜
            // char[] part = str.substring(beginIdx, endIdx + 1).toCharArray();
            // StringBuffer reversed = new StringBuffer(part.length);
            // for (int i = part.length - 1; i >= 0; i--) {
            // reversed.append(part[i]);
            // }
            // return (str.substring(0, beginIdx) + reversed + str.substring(endIdx + 1));
            // 优化
            StringBuffer result = new StringBuffer(str.length());
            result.append(str.substring(0, beginIdx));
            for (int i = endIdx; i >= beginIdx; i--) {
                result.append(str.charAt(i));
            }
            result.append(str.substring(endIdx + 1));
            return result.toString();
            // 老师的方法
            // char[] arr = str.toCharArray();
            // for (int x = beginIdx, y = endIdx; x < y; x++, y--) {
            // char temp = arr[x];
            // arr[x] = arr[y];
            // arr[y] = temp;
            // }
            // return new String(arr);
        }
        return str;
    }

    /**
     * 获取subStr在str中出现的次数 9min
     * 
     * @param str
     * @param subStr
     * @return
     */
    public int appear(String str, String subStr) {
        int fromIdx = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((fromIdx = str.indexOf(subStr, i)) != -1) {
                result++;
                i = fromIdx;
            }
        }
        return result;
    }

    /**
     * 获取str1和str2中(第一个出现的)最大相同子串 KMP/Boyer-Moore 40min
     * 
     * @param str1
     * @param str2
     * @return
     */
    public String common(String str1, String str2) {
        if (str1 == null || str2 == null)
            return null;
        String shorter;
        String longer;
        String result = null;
        if (str1.length() > str2.length()) {
            longer = str1;
            shorter = str2;
        } else {
            longer = str2;
            shorter = str1;
        }
        int num = 1;
        for (int i = shorter.length(); i > 0; i--) {
            for (int a = 0; a < num; a++) {
                result = shorter.substring(a, i + a);
                if (longer.contains(result)) {
                    return result;
                }
            }
            num++;
        }
        return null;
    }

    /**
     * 获取str1和str2中所有最大相同子串
     * 
     * @param str1
     * @param str2
     * @return
     */
    public Vector<String> commonMulti(String str1, String str2) {
        if (str1 == null || str2 == null)
            return null;
        String shorter, longer;
        Vector<String> v = new Vector<String>();
        if (str1.length() > str2.length()) {
            longer = str1;
            shorter = str2;
        } else {
            longer = str2;
            shorter = str1;
        }
        int num = 1;
        for (int i = shorter.length(); i > 0; i--) {
            for (int a = 0; a < num; a++) {
                String temp = shorter.substring(a, i + a);
                if (longer.contains(temp)) {
                    v.addElement(temp);
                }
            }
            if (v.size() > 0)
                return v;
            num++;
        }
        return null;
    }
}

/**
 *
 * @Description StringBuffer面试题
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 21, 2021 10:39:52 AM
 *
 */
class StringBufferExer {
    public static void main(String[] args) {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());// 4
        System.out.println(sb);// null(四个字符)
        StringBuffer sb1 = new StringBuffer(str);// 跑异常NullPointerException
        System.out.println(sb1);
    }
}

/**
 *
 * @Description
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 21, 2021 10:56:34 AM
 *
 */
class DateTest {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat();
        // 格式化
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);
        System.out.println();
        // 解析
        String str = "6/21/21, 11:04 AM";
        Date date1 = sdf.parse(str);
        System.out.println(date1);
        System.out.println();
        // 按pattern 参考SimpleDateFormat
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd h:mm a");
        System.out.println(sdf1.format(date));
        Date date2 = sdf1.parse("2021-06-21 11:11 AM");
        System.out.println(date2);
        System.out.println();
        // 将字符串转换为java.sql.Date
        java.sql.Date sqlDate = sqlDate("1999-01-01");
        // 打渔？晒网？
        System.out.println(dayuShaiwang("1990-01-01", "1990-01-06"));

    }

    // 将字符串转换为java.sql.Date
    public static java.sql.Date sqlDate(String birth) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sdfBirth = sdf.parse(birth);
        java.sql.Date sqlBirth = new java.sql.Date(sdfBirth.getTime());
        return sqlBirth;
    }

    // “三天打鱼两天晒网“ 1990-01-01开始 xxxx-xx-xx打渔？晒网？ 123 45 678 910
    public static String dayuShaiwang(String start, String end) throws ParseException {
        if (end.compareTo(start) < 0)
            return null;
        String result = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long day = (sdf.parse(end).getTime() - sdf.parse(start).getTime()) / (1000 * 60 * 60 * 24) + 1;
        if (day % 5 <= 3 && day % 5 > 0) {
            result = "打渔";
        } else
            result = "晒网";
        return result;
        // 总结：也可以用Calendar类来做

    }
}

/**
 *
 * @Description Calendar抽象类
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 21, 2021 11:57:27 AM
 *
 */
class calendarTest {
    public static void main(String[] args) {
        // 1.实例化
        // 方式一：创建其子类(GregorianCalendar)的对象
        // 方式二：调其静态方法getInstance()
        Calendar calendar = Calendar.getInstance(); // class就是GregorianCalendar
        // 2.常用方法
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        calendar.set(Calendar.DAY_OF_YEAR, 22);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        calendar.add(Calendar.DAY_OF_YEAR, -3);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
        // 日历类 --> Date类
        Date date = calendar.getTime();
        // Date类 --> 日历类
        calendar.setTime(new Date());
    }
}

/**
 *
 * @Description java.time API调用取代 calendar
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 21, 2021 3:18:35 PM
 *
 */
class timeTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        // 设定指定年月日时分秒无偏移量 比Date方便
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 10, 1, 13, 23, 45);
        System.out.println(localDateTime1);
        System.out.println(localDateTime.getDayOfYear());
        // 体现不可变性
        LocalDateTime localDateTime2 = localDateTime1.withDayOfYear(23);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }
}

/**
 *
 * @Description java.instant API调用取代 date
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 21, 2021 3:41:29 PM
 *
 */
class instantTest {
    public static void main(String[] args) {
        Instant instant = Instant.now();// 这是本初子午线的时间
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        long epochMilli = instant.toEpochMilli();// 从1970年1月1日开始的毫秒数
        Instant instant1 = Instant.ofEpochMilli(epochMilli);
        System.out.println(instant1);
    }
}

/**
 *
 * @Description DateTimeFormatter API调用代替 SimpleTimeFormat
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 21, 2021 3:52:32 PM
 *
 */
class formatterTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 格式化
        LocalDateTime now = LocalDateTime.now();
        String str1 = formatter.format(now);
        // 解析
        TemporalAccessor parse = formatter.parse("2021-06-21T19:45:35.508");
        System.out.println(parse);// {},ISO resolved to 2021-06-21T19:45:35.508

        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(formatter1.format(now));// Jun 21, 2021
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        System.out.println(formatter2.format(now));// 2021-06-21 11:51:41
        System.out.println(formatter2.parse("2021-06-21 11:51:41"));// {HourOfAmPm=11, NanoOfSecond=0,
                                                                    // SecondOfMinute=41, MicroOfSecond=0,
                                                                    // MilliOfSecond=0, MinuteOfHour=51},ISO resolved to
                                                                    // 2021-06-21
    }
}

/**
 *
 * @Description 枚举类举例
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 22, 2021 3:09:12 PM
 *
 */
class enumTest {
    public static void main(String[] args) {
        System.out.println(Season1.AUTUMN);// 打印的是重写过的toString
        System.out.println(Season.AUTUMN);// AUTUMN 打印的是enum自己重写的toString->对象名
        @SuppressWarnings("unused") // 注解的用法
        Season[] seasons = Season.values();// 得到四个对象名
        State[] states = Thread.State.values();
        for (State state : states) {
            System.out.println(state);
        }
        Season winter = Season.valueOf("WINTER");// 通过字符串得到枚举对象
        System.out.println(winter);
    }
}

interface Info {
    void show();
}

enum Season implements Info {
    SPRING("Spring", "春") {
        @Override
        public void show() {

        }
    },
    SUMMER("Summer", "夏") {
        @Override
        public void show() {

        }
    },
    AUTUMN("Autumn", "秋") {
        @Override
        public void show() {

        }
    },
    WINTER("Winter", "冬") {
        @Override
        public void show() {

        }
    };

    private final String SeasonName;
    private final String SeasonDesc;

    private Season(String SeasonName, String SeasonDesc) {
        this.SeasonName = SeasonName;
        this.SeasonDesc = SeasonDesc;
    }

    public String getSeasonName() {
        return this.SeasonName;
    }

    public String getSeasonDesc() {
        return this.SeasonDesc;
    }

}

class Season1 {// 自定义枚举类
    private final String SeasonName;
    private final String SeasonDesc;

    private Season1(String SeasonName, String SeasonDesc) {
        this.SeasonName = SeasonName;
        this.SeasonDesc = SeasonDesc;
    }

    public static final Season1 SPRING = new Season1("Spring", "春");

    public static final Season1 SUMMER = new Season1("Summer", "夏");

    public static final Season1 AUTUMN = new Season1("Autumn", "秋");

    public static final Season1 WINTER = new Season1("Winter", "冬");

    public String getSeasonName() {
        return this.SeasonName;
    }

    public String getSeasonDesc() {
        return this.SeasonDesc;
    }

    @Override
    public String toString() {
        return "{" + " SeasonName='" + getSeasonName() + "'" + ", SeasonDesc='" + getSeasonDesc() + "'" + "}";
    }
}

/**
 *
 * @Description TreeSet小练习
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 23, 2021 3:48:57 PM
 *
 */
class TreeSetExer {
    public static void main(String[] args) {
        Comparator<Employee> comparator = new Comparator<Employee>() {

            @Override
            public int compare(Employee o1, Employee o2) {
                MyDate b1 = o1.getBirthday();
                MyDate b2 = o2.getBirthday();
                int compBir = b1.compareTo(b2);
                if (compBir != 0)
                    return compBir;
                else
                    return o1.compareTo(o2);
            }

        };
        // TreeSet<Employee> treeSet = new TreeSet<>(); // 用Emplyee.compareTo()排序
        TreeSet<Employee> treeSet = new TreeSet<>(comparator);// 用comparator.compare()排序
        treeSet.add(new Employee("Jack", 22, new MyDate(1999, 1, 8)));
        treeSet.add(new Employee("Amy", 25, new MyDate(1989, 2, 8)));
        treeSet.add(new Employee("Serena", 22, new MyDate(1999, 1, 8)));
        treeSet.add(new Employee("Tom", 20, new MyDate(2019, 4, 4)));
        treeSet.add(new Employee("Amilia", 24, new MyDate(1949, 2, 1)));
        treeSet.forEach(System.out::println);
    }
}

class Employee implements Comparable {
    private String name;
    private int age;
    private MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return this.birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", age='" + getAge() + "'" + ", birthday='" + getBirthday() + "'"
                + "}";
    }

    @Override
    public int compareTo(Object o) {
        // 没指明泛型时：
        if (o instanceof Employee) {
            Employee e = (Employee) o;
            return getName().compareTo(e.getName());
        } else
            // return 0也可以
            throw new ClassCastException();
    }
}

class MyDate implements Comparable {
    private int year, month, day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "{" + " year='" + getYear() + "'" + ", month='" + getMonth() + "'" + ", day='" + getDay() + "'" + "}";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MyDate) {
            MyDate b = (MyDate) o;
            int compYear = ((Integer) getYear()).compareTo((Integer) (b.getYear()));
            if (compYear != 0) {
                return compYear;
            } else {
                int compMonth = ((Integer) getMonth()).compareTo((Integer) (b.getMonth()));
                if (compMonth != 0)
                    return compMonth;
                else {
                    int compDay = ((Integer) getDay()).compareTo((Integer) (b.getDay()));
                    return compDay;
                }
            }
        } else
            throw new ClassCastException();
    }
}

/**
 *
 * @Description Generic泛型小练习
 * @author xiangxiang Email: lingzhoufusang@gmail.com
 * @version v1.0
 * @CreateDate Jun 25, 2021 2:50:34 PM
 *
 */
class genericExer {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("001", new User(001, 18, "Tom"));
        dao.save("002", new User(002, 20, "Jack"));
        dao.save("003", new User(003, 17, "Jerry"));
        dao.save("004", new User(004, 18, "Rose"));
        System.out.println(dao.get("003").toString());
        dao.update("007", new User(007, 17, "Jerryupdate"));
        dao.update("003", new User(003, 17, "Jerryupdate"));
        dao.list().forEach(System.out::println);
        dao.delete("004");
        System.out.println(dao.map);
    }
}

class DAO<T> {
    Map<String, T> map = new HashMap<>();

    public void save(String id, T entity) {
        map.put(id, entity);
    }

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        // map.put(id, entity); 如果key没找到就直接加上去了
        // 方法一
        // if(map.containsKey(id)){
        // map.put(id, entity);
        // }
        // 方法二
        map.replace(id, entity);
    }

    public List<T> list() {
        ArrayList<T> arrayList = new ArrayList<>(map.values());
        return arrayList;
        // return (List<T>) map.values(); //错误 因为Collection>List,父类不能强转成子类
    }

    public void delete(String id) {
        map.remove(id);
    }
}

class User {
    private int id, age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", age='" + getAge() + "'" + ", name='" + getName() + "'" + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
