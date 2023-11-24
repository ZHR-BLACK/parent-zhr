import tree.CreateTreeUtil;
import tree.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TreeTest
 * @Date 2023-08-02 16:47
 * @description TreeTest
 **/
public class TreeTest {


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{5,4,8,11,null,13,4,7,2,null,null,null,1};
        TreeNode tree = CreateTreeUtil.createTree(arr);
        int targetSum = 22;
        boolean b = hasPathSum(tree, targetSum);
        System.out.println(b);

//        int[] inorder = new int[]{9, 3, 15, 20, 7};
//        int[] postorder = new int[]{9, 15, 7, 20, 3};
//        TreeNode treeNode = buildTree(inorder, postorder);
//        System.out.println(treeNode);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        if(root.getLeft() == null && root.getRight() == null){
            return root.getVal() == targetSum;
        }
        return hasPathSum(root.getLeft(),targetSum - root.getVal()) || hasPathSum(root.getRight(),targetSum - root.getVal());
    }


}
