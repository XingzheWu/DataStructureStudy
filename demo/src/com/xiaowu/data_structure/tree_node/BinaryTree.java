package com.xiaowu.data_structure.tree_node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xingzhe
 * @date 2018/6/9/0010
 */
public class BinaryTree<T extends Comparable> {
    private Node<T> rootNode;

    public BinaryTree() {
    }

    public BinaryTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    public int getDepth(){
        return getDepth(rootNode);
    }

    private int getDepth(Node<T> rootNode) {
        if (rootNode == null)
            return 0;
        int leftDepth = getDepth(rootNode.leftNode) + 1;
        int rightDepth = getDepth(rootNode.rightNode) + 1;
        return Math.max(leftDepth,rightDepth);
    }

    public List<T> postorderTraversal(){
        List<T> list = new ArrayList<>();
        postorderTraversal(rootNode,list);
        return list;
    }

    private void postorderTraversal(Node<T> node,List<T> list){
        if (node == null) {
            return;
        }
        postorderTraversal(node.leftNode,list);
        postorderTraversal(node.rightNode,list);
        list.add(node.data);
    }

    public List<T> midOrderList(){
        List<T> list = new ArrayList<>();
        midOrderList(rootNode,list);
        return list;
    }

    private  void midOrderList(Node<T> node,List<T> list){
        if (node == null) {
            return;
        }
        midOrderList(node.leftNode,list);
        list.add(node.data);
        midOrderList(node.rightNode,list);
    }

    public List<T> preorderTraversal(){
        List<T> list = new ArrayList<>();
        preorderTraversal(rootNode,list);
        return list;
    }

    private  void preorderTraversal(Node<T> node,List<T> list){
        if (node == null) {
            return;
        }
        list.add(node.data);
        preorderTraversal(node.leftNode,list);
        preorderTraversal(node.rightNode,list);
    }

    public void insert(T data) {
        Node<T> node = new Node<>(data);
        rootNode = insert(rootNode, node);
    }

    public void remove(T data) {
        rootNode = remove(rootNode, data);
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node == null)
            return null;
        int compare = node.data.compareTo(data);
        if (compare > 0){
            node.leftNode = remove(node.leftNode,data);
        } else if (compare < 0){
            node.rightNode = remove(node.rightNode,data);
        } else {
            if (node.isLeaf()){
                return null;
            } else if (node.leftNode == null || node.rightNode == null){
                node = (node.leftNode == null) ? node.rightNode : node.leftNode;
            } else {
                node.data = findMin(node.rightNode).data;
                node.rightNode = remove(node.rightNode,node.data);
            }
        }
        return node;
    }

    public T findMin() {
        return findMin(rootNode).data;
    }

    public T findMax() {
        return findMax(rootNode).data;
    }

    private Node<T> findMin(Node<T> node) {
        if (node == null)
            return null;
        if (node.leftNode == null) {
            return node;
        } else {
            return findMin(node.leftNode);
        }
    }

    private Node<T> findMax(Node<T> node) {
        if (node == null)
            return null;
        if (node.rightNode == null) {
            return node;
        } else {
            return findMax(node.rightNode);
        }
    }

    private Node findNode(Node node, T data) {
        if (node == null) {
            return null;
        }
        int compare = node.data.compareTo(data);
        if (compare == 0) {
            return node;
        } else if (compare > 0) {
            return findNode(node.leftNode, data);
        } else {
            return findNode(node.rightNode, data);
        }
    }

    private Node insert(Node parent, Node child) {
        if (parent == null) {
            parent = child;
        } else {
            int compare = parent.comprate(child);
            if (compare > 0){
                parent.leftNode = insert(parent.leftNode,child);
            } else {
                parent.rightNode = insert(parent.rightNode, child);
            }
        }
        return parent;
    }

    public void printTree() {

    }

    public boolean isEmpty() {
        return rootNode == null;
    }


    public static class Node<T extends Comparable> {
        private int index;
        private T data;
        private boolean leaf;

        public boolean isLeaf() {
            return leftNode == null && rightNode == null;
        }

        private Node(T data) {
            this.data = data;
        }

        public Node<T> leftNode;
        public Node<T> rightNode;

        private T getData() {
            return data;
        }

        private int comprate(Node<T> node) {
            return data.compareTo(node.getData());
        }
    }
}
