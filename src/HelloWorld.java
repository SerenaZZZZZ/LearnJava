package src;//one line comment
/*
	multiple lines comments
	class文件不包含注释信息
	多行注释无法嵌套使用
*/

/**
 * 文档注释 java独有 可被javadoc解析生成网页文件
 * @author xiangxiang
 * @version v1.0
 * this is my first java file!
 */

class HelloChina{
	/**
	 * this is main(), the entry of the program
	 */
	public static void main(String[] args){
		System.out.println("Hello, World!");//先输出后换行
		System.out.print("Hello, World!中文行不行");
		System.out.println();//换行
	}
}

public class HelloWorld{

}