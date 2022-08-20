package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SerializeDeserialize {
    public final static String NULL_CHAR = "x";
    public final static String SEPARATOR = ",";

    public static String serialize(TreeNode root) {
        // WRITE YOUR BRILLIANT CODE HERE

        return sdfs(root);
    }

    public static String sdfs(TreeNode root) {
        if(root == null) {
            return NULL_CHAR;
        }
        String left = sdfs(root.left);
        String right = sdfs(root.right);
        return root.val + SEPARATOR + left + SEPARATOR + right + SEPARATOR;
    }

    public static TreeNode deserialize(String root) {
        // AND HERE
        return ddfs(root.split(SEPARATOR));
    }

    public static TreeNode ddfs(String[] node) {
        if(node.length <= 0) {
            return null;
        }
        String currentWord = node[0];
        if(NULL_CHAR.equals(currentWord)) {
            return null;
        }
        TreeNode curr = new TreeNode(Integer.valueOf(currentWord));
        node = Arrays.copyOfRange(node, 1, node.length);
        curr.left = ddfs(node);
        node = Arrays.copyOfRange(node, 1, node.length);
        curr.right = ddfs(node);
        return curr;
    }

    public static void dfs(TreeNode node) {
        if(node.val == 0) {
            return;
        }
        node.left = new TreeNode(node.val - 1);
        dfs(node.left);
        System.out.println(node);
        Long aa = 123l;
        LinkedList<Integer> list = new LinkedList<>();
    }

    public static void main(String[] args) {
        dfs(new TreeNode(2));
        // VisibleNode ins = new VisibleNode();
        // TreeNode root = TreeNode.five();
        // root.left = TreeNode.four();
        // root.right = TreeNode.six();
        // root.left.left = TreeNode.three();
        // root.left.right = TreeNode.eight();
        TreeNode nn = deserialize("1,2,3,x,x,x,6,x,x");
        String ss = serialize(nn);
    }
}
