package com.xiaowu.data_structure.tree_node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzhe
 * @date 2018/6/9/0010
 */
public class BinaryTree<T extends Comparable> {
    private Node<T> root;

    public BinaryTree() {
    }

    public BinaryTree(Node<T> rootNode) {
        this.root = rootNode;
    }

    public int getDepth(){
        return getDepth(root);
    }

    private int getDepth(Node<T> rootNode) {
        if (rootNode == null)
            return 0;
        int leftDepth = getDepth(rootNode.left) + 1;
        int rightDepth = getDepth(rootNode.right) + 1;
        return Math.max(leftDepth,rightDepth);
    }

    public List<T> postorderTraversal(){
        List<T> list = new ArrayList<>();
        postorderTraversal(root,list);
        return list;
    }

    private void postorderTraversal(Node<T> node,List<T> list){
        if (node == null) {
            return;
        }
        postorderTraversal(node.left,list);
        postorderTraversal(node.right,list);
        list.add(node.element);
    }

    public List<T> midOrderList(){
        List<T> list = new ArrayList<>();
        midOrderList(root,list);
        return list;
    }

    private  void midOrderList(Node<T> node,List<T> list){
        if (node == null) {
            return;
        }
        midOrderList(node.left,list);
        list.add(node.element);
        midOrderList(node.right,list);
    }

    public List<T> preorderTraversal(){
        List<T> list = new ArrayList<>();
        preorderTraversal(root,list);
        return list;
    }

    private  void preorderTraversal(Node<T> node,List<T> list){
        if (node == null) {
            return;
        }
        list.add(node.element);
        preorderTraversal(node.left,list);
        preorderTraversal(node.right,list);
    }

    public void insert(T element) {
        Node<T> node = new Node<>(element);
        root = insert(root, node);
    }

    public void remove(T element) {
        root = remove(root, element);
    }

    private Node<T> remove(Node<T> node, T element) {
        if (node == null)
            return null;
        int compare = node.element.compareTo(element);
        if (compare > 0){
            node.left = remove(node.left,element);
        } else if (compare < 0){
            node.right = remove(node.right,element);
        } else {
            if (node.isLeaf()){
                return null;
            } else if (node.left == null || node.right == null){
                node = (node.left == null) ? node.right : node.left;
            } else {
                node.element = findMin(node.right).element;
                node.right = remove(node.right,node.element);
            }
        }
        return node;
    }

    public T findMin() {
        return findMin(root).element;
    }

    public T findMax() {
        return findMax(root).element;
    }

    private Node<T> findMin(Node<T> node) {
        if (node == null)
            return null;
        if (node.left == null) {
            return node;
        } else {
            return findMin(node.left);
        }
    }

    private Node<T> findMax(Node<T> node) {
        if (node == null)
            return null;
        if (node.right == null) {
            return node;
        } else {
            return findMax(node.right);
        }
    }

    private Node findNode(Node node, T element) {
        if (node == null) {
            return null;
        }
        int compare = node.element.compareTo(element);
        if (compare == 0) {
            return node;
        } else if (compare > 0) {
            return findNode(node.left, element);
        } else {
            return findNode(node.right, element);
        }
    }

    private Node insert(Node parent, Node child) {
        if (parent == null) {
            parent = child;
        } else {
            int compare = parent.comprate(child);
            if (compare > 0){
                parent.left = insert(parent.left,child);
            } else {
                parent.right = insert(parent.right, child);
            }
        }
        return parent;
    }

    public void printTree() {

    }

    public boolean isEmpty() {
        return root == null;
    }


    public static class Node<T extends Comparable> {
        private int index;
        private T element;
        private boolean leaf;

        public boolean isLeaf() {
            return left == null && right == null;
        }

        private Node(T element) {
            this.element = element;
        }

        public Node<T> left;
        public Node<T> right;

        private T getElement() {
            return element;
        }

        private int comprate(Node<T> node) {
            return element.compareTo(node.getElement());
        }
    }
}
