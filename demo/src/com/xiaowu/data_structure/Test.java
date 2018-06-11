package com.xiaowu.data_structure;

import com.xiaowu.data_structure.tree_node.BinaryTree;

/**
 * @author xingzhe
 * @date 2018/6/9/0011
 */
public class Test {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(21);
        tree.insert(9);
        tree.insert(15);
        tree.insert(14);
        tree.insert(18);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(3);
        tree.insert(5);
        tree.insert(4);
        tree.insert(7);
        tree.insert(61);
        tree.insert(100);
        tree.insert(1);
        tree.insert(50);

        tree.remove(15);
//        System.out.println(tree.preorderTraversal());
//        System.out.println(tree.midOrderList());
//        System.out.println(tree.postorderTraversal());
//        System.out.println(tree.getDepth());
    }
}
