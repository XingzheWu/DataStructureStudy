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
        if (rootNode == null) {
            rootNode = node;
            return;
        }
        insert(rootNode, node);
    }

    public void remove(T data) {
        rootNode = remove(rootNode, data);
    }

    public Node<T> remove(Node<T> node, T data) {
        if (node == null) {
            return null;
        }
        int compare = node.data.compareTo(data);
        if (compare < 0) {
            if (node.rightNode != null && node.rightNode.data.compareTo(data) == 0 && (node.rightNode.isLeaf() || (node.rightNode.leftNode == null || node.rightNode.rightNode == null))) {
                node.rightNode = node.rightNode.isLeaf() ? null : (node.rightNode.leftNode == null ? node.rightNode.rightNode : node.rightNode.leftNode);
            } else {
                remove(node.rightNode, data);
            }
        } else if (compare > 0) {
            if (node.leftNode != null && node.leftNode.data.compareTo(data) == 0 && (node.leftNode.isLeaf() || (node.leftNode.leftNode == null || node.leftNode.rightNode == null))) {
                node.leftNode = node.leftNode.isLeaf() ? null : (node.leftNode.leftNode == null ? node.leftNode.rightNode : node.leftNode.leftNode);
            } else {
                remove(node.leftNode, data);
            }
        } else if (node.rightNode != null && node.leftNode != null) {
            node.data = findMin(node.rightNode).data;
            if (node.rightNode != null && node.rightNode.data.compareTo(node.data) == 0 && (node.rightNode.isLeaf() || (node.rightNode.leftNode == null || node.rightNode.rightNode == null))) {
                node.rightNode = node.rightNode.isLeaf() ? null : (node.rightNode.leftNode == null ? node.rightNode.rightNode : node.rightNode.leftNode);
            } else {
                remove(node.rightNode, node.data);
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

    private void insert(Node parent, Node child) {
        int compare = parent.comprate(child);
        if (compare == 0) {
            return;
        }
        if (compare > 0) {
            if (parent.leftNode == null) {
                parent.leftNode = child;
                return;
            }
            insert(parent.leftNode, child);
        } else {
            if (parent.rightNode == null) {
                parent.rightNode = child;
                return;
            }
            insert(parent.rightNode, child);
        }
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
