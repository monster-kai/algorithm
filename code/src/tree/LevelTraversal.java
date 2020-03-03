package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Ryan
 * @data 2020/02/29 - 周六
 */
public class LevelTraversal {
//        public static List<List<Integer>> levelOrder(TreeNode root) {
//            List<List<Integer>> res = new LinkedList<>();
//            Queue<TreeNode> q = new LinkedList<>();
//            q.add(root);
//            while (!q.isEmpty()) {
//                q = traversal(q, res);
//            }
//            return res;
//        }
//
//        private static Queue<TreeNode> traversal(Queue<TreeNode> q, LinkedList<List<Integer>> res) {
//            LinkedList<Integer> r = new LinkedList<>();
//            Queue<TreeNode> q1 = new LinkedList<>();
//            while (!q.isEmpty()) {
//                TreeNode w = q.poll();
//                r.add(w.val);
//                if (w.left != null) q1.add(w.left);
//                if (w.right != null) q1.add(w.right);
//            }
//            res.addFirst(r);
//            return q1;
//        }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(1);
    TreeNode b = new TreeNode(1);
    TreeNode c = new TreeNode(1);
    TreeNode d = new TreeNode(1);
    TreeNode e = new TreeNode(1);
    a.left = b;
    a.right = c;
    b.left = d;
    c.left = e;
//    System.out.println(levelOrder(a).toString());
    boolean[] a1 = new boolean[2];
    System.out.println(a1[1]);
  }
}
