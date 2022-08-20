package Tree;

public class SumRootToLeafNumbers {
    public int sum;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    public void dfs(TreeNode root, int pathSum) {
        pathSum = pathSum*10+root.val;
        if(root.left == null && root.right == null) {
            sum = sum + pathSum;
            return;
        }
        if(root.left != null) {
            dfs(root.left, pathSum);
            // pathSum = pathSum - root.left.val;
            // pathSum /= 10;
        }
        if(root.right != null) {
            dfs(root.right, pathSum);
            // pathSum = pathSum - root.right.val;
            // pathSum /= 10;
        }
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers ins = new SumRootToLeafNumbers();
        TreeNode four = new TreeNode(4);
        TreeNode nine = new TreeNode(9);
        TreeNode zero = new TreeNode(0);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        nine.left = five;
        nine.right = one;
        four.left = nine;
        four.right = zero;
        System.out.println(ins.sumNumbers(four));
    }
}
