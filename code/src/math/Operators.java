package math;

/**
 * @author Ryan
 * @data 2020/02/26 - 周三
 */
public class Operators {
    public static void main(String[] args) {
        int a = 011;   //前边0表示八进制
        // a的二进制为 1001
        System.out.println(a + " " + ~a);
        System.out.println(Integer.toBinaryString(~a)); //print 1111111111111111 1111 1111 1111 0110
        //验证一个正数的相反数的二进制形式等于反码加1（补码）
    }
}
