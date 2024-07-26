package com.keyin.trees.BinaryNode;

public class BinaryNode {

    public String value;
    public BinaryNode leftChild;
    public BinaryNode rightChild;

    public BinaryNode(){
        this.value = null;
        this.leftChild = null;
        this.rightChild = null;
    }

    public BinaryNode(String value){
        this.value = value;
        this.leftChild = null;
        this.rightChild = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

}
