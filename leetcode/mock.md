# 蓝桥杯模拟题

##  1.进制转化
请找到一个大于 2022 的最小数，这个数转换成十六进制之后，所有的数位（不含前导 0）都为字母（A 到 F）。
请将这个数的十进制形式作为答案提交。　

- 方法一：分析

  - 2022 (十进制) -> 011111100110 (二进制) ->7E6 (十六进制)

  - 先从7入手，增加后第一个字母是：A

  - E的后一个字母虽然是F，但是7增加到A需要进位，所以E这个位置就应该是最小的：A(要求：一个大于 2022 的最小数，十六进制不含数字)

  - 6第一个字母是A，E变成A，也是进位了的，最小的也应该是：A

> 所以答案就是：A

- 方法二：代码一（自己写的进制转换）

  ```java
  public class Code1 {
      public static void main(String[] args) {
          int n = 2022;
          boolean is = false;//标记是否含有0~9数字
          while (true) {
              is = false;//每个数默认不含有
              String s = toBinary(++n);//十进制 -> 二进制
              String hex = binaryToHex(s);//二进制 -> 十六进制
              for (int i = 0; i<=9; i++) {
                  if (hex.contains(i+"")) {//如果含有
                      is = true;//修改标记为有
                      break;//退出
                  }
              }
              if (!is) {
                  System.out.println(hex);//找到一个就退出
                  break;
              }
          }
      }
  
      public static String toBinary(int n) {
          StringBuilder sb = new StringBuilder();
          while (n != 0) {
              sb.append(n % 2);
              n/=2;
          }
          int len = sb.length();
          if (len % 4 == 0) {
              return sb.reverse().toString();
          }
          for (int i = 1; i <= (4 - len%4); i++){
              sb.append(0);
          }
          return sb.reverse().toString();
      }
      public static String binaryToHex(String binary) {
          int index = 0;
          StringBuilder sb = new StringBuilder();
          while (index < binary.length()) {
              String subStr = binary.substring(index, index + 4);
              sb.append(dictionary(subStr));
              index += 4;
          }
          return sb.toString();
      }
      public static char dictionary(String s) {
          int base = 8;
          int res = 0;
          for (char c : s.toCharArray()) {
              res += base * (c - '0');
              base /= 2;
          }
          if (res < 10) {
              return (char) ('0' + res);
          }
          return (char) (65+res-10);
      }
  }
  ```

- 方法三：代码二（利用函数库）

  ```java
  import java.math.BigInteger;
  
  public class Code1_1 {
      public static void main(String[] args) {
          boolean flag = false;//标记每个数是否是不含数字
          int n = 2022;
          while(true) {
              flag = false;//初始化，这个数不含数字0~9
              BigInteger bigInteger = BigInteger.valueOf(n);//将这个整数转化为BigInteger
              String s = bigInteger.toString(16);//通过内置方法转化为16进制
              for (char c : s.toCharArray()) {//变量每个字符是否存在数字0~9
                  if (c <= '9') {//存在就标记
                      flag = true;
                      break;
                  }
              }
              if (!flag) {//不存在数字0~9，就打印结束循环
                  System.out.println(s);
                  System.out.println(n);
                  break;
              }
              n++;//存在数字就自增，进入下一个循环
          }
      }
  }
  ```

  

