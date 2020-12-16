import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] arg) {
        TreeNode newNode1 = new TreeNode(1);
        TreeNode newNode2 = new TreeNode(2);

        TreeNode newNode7 = new TreeNode(7,newNode1,newNode2);
        TreeNode newNode15 = new TreeNode(15);

        TreeNode newNode20 = new TreeNode(20,newNode15,newNode7);
        TreeNode newNode9 = new TreeNode(9);

        TreeNode root  = new TreeNode(3,newNode9,newNode20);
        ArrayList<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        System.out.println(res);

        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        levelOrder(root, arr);
        System.out.println(arr);
        

    }

    public static void levelOrder(TreeNode root, ArrayList<ArrayList<Integer>> arr) {
        if(root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int j = 0;
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                if(j % 2 == 0) {
                    level.add(node.val);
                } else {
                    level.add(0,node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            //arr.add(level);
            j++;
            arr.add(level);
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


