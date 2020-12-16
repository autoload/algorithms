import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTreeIterator {

    public static void main(String[] arg) {
        TreeNode newNode9 = new TreeNode(9);
        TreeNode newNode20 = new TreeNode(20);

        TreeNode newNode15 = new TreeNode(15,newNode9,newNode20);
        TreeNode newNode3 = new TreeNode(3);

        TreeNode root  = new TreeNode(7,newNode3,newNode15);


        BSTIterator iterator = new BSTIterator(root);
        iterator.next();    // 返回 3
        iterator.next();    // 返回 7
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 9
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 15
        iterator.hasNext(); // 返回 true
        iterator.next();    // 返回 20
        iterator.hasNext(); // 返回 false

        ArrayList<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        System.out.println(res);

        

    }

    public static void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    } 
}