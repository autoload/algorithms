import java.util.List;
import java.util.ArrayList;

public class BinaryTreePreorderTraversal {

    public static void main(String[] args) {

        TreeNode newNode2 = new TreeNode(2,new TreeNode(3),null);
        TreeNode root  = new TreeNode(1,null,newNode2);

        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        System.out.println(res);
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
