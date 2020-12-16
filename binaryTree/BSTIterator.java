import java.util.Stack;

public class BSTIterator {
    public Stack<TreeNode> stack = new Stack<>();
    public TreeNode curt;

    public BSTIterator(TreeNode root) {
        curt = root;
    }

    public boolean hasNext() {
        System.out.println(curt != null || !stack.isEmpty());
        return (curt != null || !stack.isEmpty());
    }

    public TreeNode next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }

        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;

        System.out.println(node.val);
        return node;
    }
}