package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int sum = 0;
        int prevSac = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int prevSum = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            int currSum = 0;
            for(int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                currSum += node.val;
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            prevSac += currSum;
            if(prevSum > prevSac) {
                sum += prevSac;
            }
            prevSac = prevSum;
            prevSum = currSum;
            System.out.println(' ');
        }
        return sum;
    }

    public static void main(String[] args) {
        HouseRobberIII ins = new HouseRobberIII();
        TreeNode root = TreeNode.four();
        root.left = TreeNode.one();
        root.left.left = TreeNode.two();
        root.left.left.left = TreeNode.three();
        root.left.left.left.left = TreeNode.two();
        System.out.println(ins.rob(root));
    }
}
