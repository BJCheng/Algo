package Tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public String toString() {
        return this.val + "," + (this.left != null ? this.left.val : "null") + "," + (this.right != null ? this.right.val : "null");
    }

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(int val) {
        return new TreeNode(val);
    }

    public static TreeNode one() {
        return TreeNode.of(1);
    }

    public static TreeNode two() {
        return TreeNode.of(2);
    }

    public static TreeNode three() {
        return TreeNode.of(3);
    }

    public static TreeNode four() {
        return TreeNode.of(4);
    }

    public static TreeNode five() {
        return TreeNode.of(5);
    }

    public static TreeNode six() {
        return TreeNode.of(6);
    }

    public static TreeNode seven() {
        return TreeNode.of(7);
    }

    public static TreeNode eight() {
        return TreeNode.of(8);
    }
}
