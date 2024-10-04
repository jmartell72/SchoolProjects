package com.CS201;

import java.util.*;

/*BST Class Itself - provides the interface for users to interact with the tree; contains methods for insertion
deletion, searching and other operations*/
class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        this.root = null;
    }
//    End of basic skeleton
//    Insertion operation
    // not revealing the method outside of its scope
    public void insert(int data) {
        root = insertRecursive(root,data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null){
            return new Node(data);
        }
//        Checks left/right position to determine where data should go
        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if ( data > root.data){
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

//    Deletion operation
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key){
        if (root == null){
            return null;
        }
//        Basic search for the value to delete
        if (key < root.data) {
            root.left = deleteRecursive(root.left, key);
        } else if (key > root.data) {
            root.right = deleteRecursive(root.right, key);
        } else {
//            Once at the value, it determines in its logic if any values will need to move prior to the delete
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root;
            }
            // runs the logic to determine if a key needs to move
            root.data = minValue(root.right);
            root.right = deleteRecursive(root.right, key);
        }

        return root;
    }
    // can be used in actual body if required but is needed for delete
    public int findMin(Node root) {
        if (root == null) {
            throw new NoSuchElementException("The tree is empty.");
        }
//        Just scrolls left through the BST until it hits the end
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }
    // can be used in actual body if required but is needed for delete
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // determines the inorder values
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        //loops to sort and output
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);

    }
    // determines the preorder values
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        //loops to sort and output
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    // determines the postorder values
    public void postOrder() {
        preOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        //loops to sort and output
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.data + " ");
    }

    // Makes sure the BST is balanced, should be looking at a time between O(n) or O(n log n)
    public void balanceBST(){
       this.root = balanceBST(this.root);
    }

    // holder for balancer
    private void storeBSTNodes(Node root, Vector<Node> nodes)
    {
        // default Check
        if (root == null){return;}
        //Stores the nodes using Inorder
        storeBSTNodes(root.left, nodes);
        nodes.add(root);
        storeBSTNodes(root.right, nodes);
    }

    private Node buildTreeUtil(Vector<Node> nodes, int start,
                                   int end)
    {
        // default statement
        if (start > end)
            return null;

        // Get the middle element and make it root
        int mid = (start + end) / 2;
        Node node = nodes.get(mid);

        // Uses index to sort items

        node.left = buildTreeUtil(nodes, start, mid - 1);
        node.right = buildTreeUtil(nodes, mid + 1, end);

        return node;
    }


   Node balanceBST(Node root){
        //starts new nodes to hold sorted values
        Vector<Node> nodes = new Vector<>();
        storeBSTNodes(root, nodes);

        int n = nodes.size();
        // creates the balanced bst
        return buildTreeUtil(nodes, 0, n - 1);
    }
}
//End of BST

