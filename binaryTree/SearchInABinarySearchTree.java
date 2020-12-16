import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class SearchInABinarySearchTree {
    public static void main(String[] arg) {
        TreeNode newNode1 = new TreeNode(1);
        TreeNode newNode3 = new TreeNode(3);

        TreeNode newNode2 = new TreeNode(2,newNode1,newNode3);
        TreeNode newNode7 = new TreeNode(7);

        TreeNode root  = new TreeNode(4,newNode2,newNode7);

        root = insertIntoBST(root, 8);
        root = insertIntoBST(root, 9);
        root = insertIntoBST(root, 5);
        root = insertIntoBST(root, 6);
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        System.out.println(res);
        
        TreeNode c = search(root, 33);
        ArrayList<Integer> cs = new ArrayList<Integer>();
        preorder(c, cs);
        System.out.println(cs);

    }

    public static TreeNode search(TreeNode root, int k) {
        if(root == null) {
            return null;
        }
        if(root.val == k) {
            return root; 
        }else if(root.val < k) {
            return search(root.right, k);
        }else{
            return search(root.left, k);
        }

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
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