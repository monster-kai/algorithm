package listOperation;

/**
 * @author Ryan
 * @data 2020/02/14 - 周五
 * @content 两个有序链表合并, 链表克隆
 */
public class Operation1 {
    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) { return l2;}
        if(l2==null) { return l1;}
        if(l1.val<=l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 两个有序链表合并到新链表，并保证原链表是可用的
     * @param l1
     * @param l2
     * @return 合并后新链表的表头
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        if(l1==null) {
            return cloneList(l2);
        }
        if(l2==null) {
            return cloneList(l1);
        }

        if(l1.val<=l2.val) {
            ans.val = l1.val;
            ans.next = mergeTwoLists1(l1.next, l2);
        }else{
            ans.val = l2.val;
            ans.next = mergeTwoLists1(l1, l2.next);
        }
        return ans;
    }

    /**
     * 链表克隆，返回新链表的表头
     * @param a the head node of the cloned list
     * @return new head node
     */
    public static ListNode cloneList(ListNode a){
        if(a==null) return null;
        ListNode ans = new ListNode(a.val);
        ans.next = cloneList(a.next);
        return ans;
    }

    //测试
    public static void main(String[] args) { //测试新产生的链表，不会影响先前的链表
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(4);
        a.next = b;
        c.next = d;
        d.next = new ListNode(5);
        for (ListNode i = a; i!=null; i=i.next ) {
            System.out.println(i.val);
        }
        System.out.println("----------");
        ListNode s = mergeTwoLists1(a, c);
        for (ListNode i = s; i!=null; i=i.next ) {
            System.out.println(i.val);
        }
        System.out.println("----------");
        for (ListNode i = a; i!=null; i=i.next ) {
            System.out.println(i.val);
        }

    }

}
