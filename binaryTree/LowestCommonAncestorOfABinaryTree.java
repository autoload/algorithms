import java.util.List;
import java.util.ArrayList;

public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] arg) {
        TreeNode newNode7 = new TreeNode(7);
        TreeNode newNode4 = new TreeNode(4);

        TreeNode newNode2 = new TreeNode(2,newNode7,newNode4);
        TreeNode newNode6 = new TreeNode(6);

        TreeNode newNode0 = new TreeNode(0);
        TreeNode newNode8 = new TreeNode(8);


        TreeNode newNode5 = new TreeNode(5,newNode6,newNode2);
        TreeNode newNode1 = new TreeNode(1,newNode0,newNode8);


        TreeNode root  = new TreeNode(3,newNode5,newNode1);
        List<Integer> res = new ArrayList<Integer>();
        int h = maxDepth(root);
        //System.out.println(h);


        System.out.println(preorder(root, newNode0, newNode8).val);
        
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

    public static TreeNode preorder(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = preorder(root.left, p, q);
        TreeNode right = preorder(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)
    }

}