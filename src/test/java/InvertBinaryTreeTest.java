import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    TreeNode root;
    @BeforeEach
    void setUp() {
        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
    }

    @Test
    void solution(){
        TreeNode result = invertTree(this.root);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
    }
    TreeNode invertTree(TreeNode root){
        if(root != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
            if(root.left != null) invertTree(root.left);
            if(root.right != null) invertTree(root.right);
        }
        return root;
    }
    @Test
    void run(){
//        int j = 0;
//        ArrayList list = new ArrayList<>();
//        ArrayList result = new ArrayList<>();
//
//        for (int i = 1; i < root.length + 1; i++) {
//            list.add(root[i - 1]);
//            if (list.size() == Math.pow(2,j)) {
//                Collections.reverse(list);
//                result.addAll(list);
//                list = new ArrayList<>();
//                j++;
//            }
//        }
//        System.out.println(result.toString());
    }

//    Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}