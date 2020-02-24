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

    /**
     *取出栈底元素
     */
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
    //利用一个辅助栈给一个栈元素排序 顶为最大
    //思路： 取出元素放入辅助栈中，使得辅助栈的元素一直保持有序， 每次迭代都将curr放到正确的位置
    public static void sortInStack(Stack<Integer> s){
        Stack<Integer> aux = new Stack<>();
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!aux.isEmpty() && curr>aux.peek()){
                int w = aux.peek();
                s.push(aux.pop());
            }
            aux.push(curr);
        }
        while(!aux.isEmpty())  s.push(aux.pop());
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(){{
            push(3); push(2); push(7); push(12); push(5);
        }};
        System.out.println(s);
        reverse(s);
        System.out.println(s);
        sortInStack(s);
        System.out.println(s);
    }
}
