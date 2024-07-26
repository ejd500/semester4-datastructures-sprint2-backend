package com.keyin.trees.BinaryTreeLL;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyin.trees.BinaryNode.BinaryNode;
import com.keyin.trees.BinaryNode.BinaryNodeConverter;
import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Entity
public class BinaryTreeLL {
    @Id
    @SequenceGenerator(name = "tree_sequence", sequenceName = "tree_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "tree_sequence")
    long id;
    @Column(length = 1000)
    @Convert(converter = BinaryNodeConverter.class)
    BinaryNode root;
    @Column
    List<Integer> integerList;

    public BinaryTreeLL(){
        this.root = null;
        this.integerList = null;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BinaryNode getRoot() {
        return root;
    }

    public void setRoot(BinaryNode root) {
        this.root = root;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    //preorder traversal
    void  preOrder(BinaryNode node){
        if(node == null){
            return;
        }
        System.out.println(node.value + " ");
        preOrder(node.leftChild);
        preOrder(node.rightChild);
    }

    //InOrder Traversal
    void inOrder(BinaryNode node){
        if(node == null){
            return;
        }
       inOrder(node.leftChild);
        System.out.println(node.value + " ");
        inOrder(node.rightChild);
    }

    //Post Order Traversal
    void postOrder(BinaryNode node){
        if(node == null){
            return;
        }
        postOrder(node.leftChild);
        postOrder(node.rightChild);
        System.out.println(node.value + " ");

    }

    //Level Order traversal
    void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.println(presentNode.value = " ");
            if (presentNode.leftChild !=null){
                queue.add(presentNode.leftChild);
            }
            if(presentNode.rightChild !=null){
                queue.add(presentNode.rightChild);
            }
        }

    }

    //Search method using level order traversal
    public void search (String value) {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                System.out.println("The value-" + value + " is found in the Tree");
            } else {
                if (presentNode.leftChild != null) {
                    queue.add(presentNode.leftChild);
                }
                if (presentNode.rightChild != null) {
                    queue.add(presentNode.rightChild);
                }

            }
            System.out.println("The value-" + value + " is not found in the Tree");
        }
    }

    // Insert Method
    void insertString(String value) {
        BinaryNode newNode = new BinaryNode(value);
        if (root == null) {
            root = newNode;
            System.out.println("Inserted new node at Root");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.leftChild == null) {
                presentNode.leftChild = newNode;
                System.out.println("Successfully Inserted");
                break;
            } else if (presentNode.rightChild == null) {
                presentNode.rightChild = newNode;
                System.out.println("Successfully Inserted");
                break;
            } else {
                queue.add(presentNode.leftChild);
                queue.add(presentNode.rightChild);
            }
        }
    }

    public void insertInteger(Integer value) {
        BinaryNode newNode = new BinaryNode(value.toString()); // Create a new node with the given value

        if (root == null) {
            root = newNode; // If the tree is empty, set the new node as the root
            return;
        }

        BinaryNode currentNode = root;
        while (true) {
            if (value < Integer.parseInt(currentNode.getValue())) {
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(newNode);
                    break;
                } else {
                    currentNode = currentNode.getLeftChild();
                }
            } else {
                if (currentNode.getRightChild() == null) {
                    currentNode.setRightChild(newNode);
                    break;
                } else {
                    currentNode = currentNode.getRightChild();
                }
            }
        }
    }

    // Get Deepest node
    @JsonIgnore
    public BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.leftChild != null) {
                queue.add(presentNode.leftChild);
            }
            if (presentNode.rightChild != null) {
                queue.add(presentNode.rightChild);
            }
        }
        return presentNode;
    }

    // Delete Deepest node
    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.leftChild == null) {
                previousNode.rightChild = null;
                return;
            } else if (presentNode.rightChild == null) {
                presentNode.leftChild = null;
                return;
            }
            queue.add(presentNode.leftChild);
            queue.add(presentNode.rightChild);

        }
    }

    // Delete Given node
    void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("The node is deleted!");
                return;
            } else {
                if (presentNode.leftChild != null) queue.add(presentNode.leftChild);
                if (presentNode.rightChild != null) queue.add(presentNode.rightChild);
            }
        }
        System.out.println("The node does not exist in this BT");
    }

    // Delete Binary Tree
    void deleteBT() {
        root = null;
        System.out.println("BT has been successfully deleted!");
    }

}
/**
 * create BT
 * Insert into a BT
 * Deletion of a Node
 * Searching for a value
 * Traverse all values
 * Deletion of  BT
 *
 *
 *
 * TREE TRAVERSAL
 * 1. Depth first search
 *      1. PreOrder Traversal
 *      2. InOrder Traversal
 *      3. Post Traversal
 * 2. Breadth first search
 *      1. Level order travel
 */
