package com.xiaowu.data_structure.huffman_tree;

public class HuffmanTree {
    private HuffmanNode root;

    public HuffmanTree (int[] array){

    }


    public static class HuffmanNode{
        private int value;
        private HuffmanNode left;
        private HuffmanNode right;

        public HuffmanNode(int value, HuffmanNode left, HuffmanNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public HuffmanNode getLeft() {
            return left;
        }

        public void setLeft(HuffmanNode left) {
            this.left = left;
        }

        public HuffmanNode getRight() {
            return right;
        }

        public void setRight(HuffmanNode right) {
            this.right = right;
        }
    }
}
