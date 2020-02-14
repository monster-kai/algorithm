package listOperation;

import java.util.Stack;

/**
 * @author Ryan
 * @data 2020/02/14 - 周五
 * @contents 单链表翻转， 链表中环的检测， 删除链表倒数第n个节点， 求链表的中间节点
 */
public class Operation2 {

    /**
     * 翻转链表
     * @param x
     * @return  返回翻转后的头部
     */
    public static ListNode flipList(ListNode x){
        ListNode curr = x, pre = null;              //三个指针 pre， curr， next
        while(curr!=null){                          //用符号记录节点的引用值，使其可以对想要对特定的结点进行处理，但是当这个符号指向其他结点时候，原来指向的结点实体并不会受影响
            ListNode next = curr.next;              //调用这些结点的符号，可以想象成一个把手，指向结点后进行操作，当把手指向其他结点时候，源节点将保持其状态
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }



    public static void main(String[] args) { //测试新产生的链表，不会影响先前的链表
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = new ListNode(5);
        for (ListNode i = a; i!=null; i=i.next ) {
            System.out.println(i.val);
        }
        System.out.println("----------");
        ListNode s = flipList(a);
        for (ListNode i = s; i!=null; i=i.next ) {
            System.out.println(i.val);
        }
        System.out.println("----------");
        for (ListNode i = d; i!=null; i=i.next ) {
            System.out.println(i.val);
        }

    }

}
