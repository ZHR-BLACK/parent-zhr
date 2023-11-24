package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CreateTreeUtil
 * @Date 2023-08-02 16:53
 * @description 数组转二叉树
 **/
public class CreateTreeUtil {

    public static List<TreeNode> list = new ArrayList<>();      //用一个集合来存放每一个Node

    public static TreeNode createTree(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(arr[0]); // 建立根节点

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 先左后右
        boolean isleft = true;
        for (int i = 1; i < arr.length; i++) {
            TreeNode peek = queue.getFirst();
            if (isleft) {
                if (arr[i] != null) {
                    peek.left = new TreeNode(arr[i]);
                    queue.add(peek.left);
                }
                isleft = false;
            } else {
                if (arr[i] != null) {
                    peek.right = new TreeNode(arr[i]);
                    queue.add(peek.right);
                }
                queue.removeFirst();
                isleft = true;
            }
        }
        return root;
    }
}