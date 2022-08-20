package Tree;


import java.util.*;

public class VisibleNode {

    public static int sum = 0;

    public static int visibleTreeNode(TreeNode root) {
        // WRITE YOUR BRILLIANT CODE HERE
        dfs(root, 0);
        return sum;
    }

    public static void dfs(TreeNode node, int max) {
        if(node == null) {
            return;
        }
        if(node.val >= max) {
            sum++;
            max = node.val;
        }
        int currMax = max;
        dfs(node.left, max);
        dfs(node.right, max);
        max = currMax;
    }

    public static void main(String[] args) {
        VisibleNode ins = new VisibleNode();
        TreeNode root = TreeNode.five();
        root.left = TreeNode.four();
        root.right = TreeNode.six();
        root.left.left = TreeNode.three();
        root.left.right = TreeNode.eight();
        System.out.println(VisibleNode.visibleTreeNode(root));
        String a = "1,2,3,4";
        String[] aa = a.split(",");
        String[] bb = Arrays.copyOfRange(aa, 1, aa.length);
        System.out.println(bb);
        Integer aaa = Integer.valueOf("1");
    }
}
