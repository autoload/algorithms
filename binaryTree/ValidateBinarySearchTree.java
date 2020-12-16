import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class ValidateBinarySearchTree {
        public static void main(String[] arg) {
        TreeNode newNode1 = new TreeNode(1);
        TreeNode newNode2 = new TreeNode(2);

        TreeNode newNode7 = new TreeNode(7,newNode1,newNode2);
        TreeNode newNode15 = new TreeNode(15);

        TreeNode newNode20 = new TreeNode(20,newNode15,newNode7);
        TreeNode newNode9 = new TreeNode(9);

        TreeNode root  = new TreeNode(2,newNode1,newNode15);
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        System.out.println(res);
        System.out.println(isValidBST(root));

        System.out.println(isValid(root, Long.MIN_VALUE, Long.MAX_VALUE));
        
    }

    public static boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
              // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static boolean isValid(TreeNode root, long minValue, long maxValue) {
        if (root == null)  return true;
        if (root.val <= minValue || root.val >= maxValue) return false;
        return isValid(root.left, minValue, root.val)
                && isValid(root.right, root.val, maxValue);
    }


    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        preorder(root.left, res);
        preorder(root.right, res);
        res.add(root.val);
    }
}