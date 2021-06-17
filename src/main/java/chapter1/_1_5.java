package chapter1;

import java.util.Scanner;

/**
 * @author wss
 * @version 1.0.0
 * @describe 求数的二进制中的1的个数
 * @company 杭州车凌网络科技有限公司
 * @address 杭州市滨江区聚光中心B座705
 * @updateTime 2021-05-13 10:31
 * @since 2021-05-13 10:31
 */
public class _1_5 {

    static int ones(int num) {
        if (num < 2) {
            return num;
        }
        return num % 2 + ones(num >> 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int i = scanner.nextInt();
            System.out.println(ones(i));
        }
    }
}
