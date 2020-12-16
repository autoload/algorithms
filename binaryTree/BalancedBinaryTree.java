import java.util.List;
import java.util.ArrayList;

public class BalancedBinaryTree {
    public static void main(String[] arg) {
        TreeNode newNode1 = new TreeNode(1);
        TreeNode newNode2 = new TreeNode(2);

        TreeNode newNode7 = new TreeNode(7,newNode1,newNode2);
        TreeNode newNode15 = new TreeNode(15);

        TreeNode newNode20 = new TreeNode(20,newNode15,newNode7);
        TreeNode newNode9 = new TreeNode(9);

        TreeNode root  = new TreeNode(3,newNode9,newNode20);
        List<Integer> res = new ArrayList<Integer>();
        int h = maxDepth(root);
        System.out.println(h);
        preorder(root, res);
        System.out.println(res);

        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        return getTreeDepth(root) != -1;
    }

    public static int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getTreeDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = getTreeDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        } else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
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