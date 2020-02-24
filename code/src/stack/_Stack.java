package stack;

import java.util.Stack;

/**
 * @author Ryan
 * @data 2020/02/24 - 周一
 */
public class _Stack {
    /**
     * 用递归函数实现逆序栈,并且不能借助其他数据结构
     */
    public static void reverse(Stack<Integer> s){
        int e = removeLast(s);
        if(s.isEmpty()) {
            s.push(e);
            return;
        }
        reverse(s);
        s.push(e);
    }
    private static int removeLast(Stack<Integer> s){
        int element = s.pop();
        if(s.isEmpty()){
            return element;
        }else{
            int last = removeLast(s);
            s.push(element);
            return last;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(){{
            push(1); push(2); push(3);
        }};
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
}
