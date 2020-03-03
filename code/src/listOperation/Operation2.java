package listOperation;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Ryan
 * @data 2020/02/14 - 周五
 * @contents 单链表翻转， 链表中环的检测， 删除链表倒数第n个节点， 求链表的中间节点
 */
public class Operation2 {
  /*
  备注：链表代码的自检
          1、链表为空null时候
          2、链表只包含一个节点的时候
          3、链表只包含两个节点的时候
          4、代码在处理头结点和尾结点的时候
          在上述情况下代码的鲁棒性
   */

  /**
   * 翻转链表 method I:迭代法
   *
   * @param x
   * @return 返回翻转后的头部
   */
  public static ListNode flipList(ListNode x) {
    ListNode curr = x, pre = null; // 三个指针 pre， curr， next
    while (curr != null) { // 用符号记录节点的引用值，使其可以对想要对特定的结点进行处理，但是当这个符号指向其他结点时候，原来指向的结点实体并不会受影响
      ListNode next = curr.next; // 调用这些结点的符号，可以想象成一个把手，指向结点后进行操作，当把手指向其他结点时候，源节点将保持其状态
      curr.next = pre;
      pre = curr;
      curr = next;
    }
    return pre;
  }

  /**
   * 翻转链表 method II:递归法
   * @param x
   */
  public static ListNode flagList_recursion(ListNode x) {
    if (x == null || x.next == null) {
      return x;
    }
    ListNode w = flagList_recursion(x.next);
    x.next.next = x;
    x.next = null;
    return w;
  }

  /**
   * 检测链表中是否存在环, method I: HashSet
   *
   * @param x
   * @return
   */
  public static boolean hasCycle(ListNode x) {
    HashSet<ListNode> set = new HashSet<>();
    set.add(x);
    while (x.next != null) {
      x = x.next;
      if (set.contains(x)) {
        return true;
      } else {
        set.add(x);
      }
    }
    return false;
  }

  /**
   * 检测环 method II: 快慢指针
   *
   * @param x
   * @return
   */
  public static boolean hasCycle2(ListNode x) {
    if (x == null) return false;
    ListNode fast = x.next;
    ListNode slow = x;
    while (fast != null && fast.next != null) {
      if (slow == fast) return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  /**
   * 删除倒数第k个节点 method： 双指针一次遍历
   *
   * @param list
   * @param k 假设k输入不会超过链表长度
   * @return
   */
  /*删除链表中节点的方法:
  1.  prev.next = prev.next.next; 删除头结点可以借助dummy节点，dummy.next=head; dummy即为prev
  2.  curr.val = curr.next.val;    curr.next=curr.next.next; 不需要找prev，但是不适用与删除最后一个节点
  特殊情况链表只有一个节点，直接返回null
  */
  public static ListNode deleteLastKth(ListNode list, int k) {
    ListNode l = new ListNode(0);
    l.next = list;
    ListNode r = list;
    for (int i = 0; i < k; i++) { // 双指针固定间距k移动，快指针到null，另一指针指倒数第k个节点
      r = r.next;
    }
    while (r != null) {
      l = l.next;
      r = r.next;
    }
    if (l.next == list) {
      list = list.next; // 考虑如何删除第一个节点,返回head的特殊情况
    } else {
      l.next = l.next.next;
    }
    return list;
  }

  /**
   * 找中间节点 method: 快慢指针
   *
   * @return
   */
  public static ListNode findMiddle(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

  // test
  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(3);
    ListNode c = new ListNode(2);
    ListNode d = new ListNode(4);
    a.next = b;
    b.next = c;
    c.next = d;
    //        System.out.println(hasCycle(a));

    d = null;
    ListNode s = deleteLastKth(a, 1);
    for (ListNode i = s; i != null; i = i.next) {
      System.out.println(i.val);
    }
  }
}
