/*
 BinaryTree
 A binary tree used to compress files with Hoffman compression
 @author Jonathan Xu
 March 23, 2019
 */

public class BinaryTree {
    // Declaring tree root and priority queue variables
    private BinaryTreeNode root = new BinaryTreeNode(0);
    private PriorityQueue nodeQueue = new PriorityQueue();
    // Array to store binary path to each char
    private String[] binaryValue = new String[256];
    // String to store the tree in one line
    private String treeLined = "";

    /*
        BinaryTree
        Constructor for the binary tree
        @param charList An int array containing frequencies of each character
     */
    BinaryTree(int[] charList) {
        // Creating nodes for characters and their weights
        for(int i = 0; i < 256; i++){
            if(charList[i] != 0){
                BinaryTreeNode newNode = new BinaryTreeNode(i, charList[i]);
                nodeQueue.enqueue(newNode);
            }
        }
        boolean complete = false;
        do{
            // Stop if priority queue is empty
            if(nodeQueue.isEmpty()){
                complete = true;
            }
            BinaryTreeNode left = nodeQueue.dequeue();
            // Stop if there is only 1 element left
            if(nodeQueue.isEmpty()){
                nodeQueue.enqueue(left);
                complete = true;
            }
            // Dequeues the two least frequent nodes, merges them under a parent node and enqueues them
            BinaryTreeNode right = nodeQueue.dequeue();
            BinaryTreeNode parentNode = new BinaryTreeNode(left.getWeight() + right.getWeight());
            parentNode.setLeftNode(left);
            parentNode.setRightNode(right);
            if(!nodeQueue.isEmpty()){
                nodeQueue.enqueue(parentNode);
            } else {
                nodeQueue.enqueue(parentNode);
                complete = true;
            }
        } while(!complete);

        root.setRightNode(nodeQueue.dequeue());
        treeLined = lineify(root.getRightNode());
        getBinary(root.getRightNode(), "");
    }

    /*
        lineify
        Outputs the tree as a string
        @param refNode The target node
        @return A String containing leaves grouped in brackets
     */
    private String lineify(BinaryTreeNode refNode){
        if(refNode.isLeaf()){
            return Integer.toString((char)refNode.getCharacter());
        } else if(refNode.getRightNode() == null) {
            return lineify(refNode.getLeftNode());
        } else if(refNode.getLeftNode() == null) {
            return lineify(refNode.getRightNode());
        } else{
            String left = lineify(refNode.getLeftNode());
            String right = lineify(refNode.getRightNode());
            return "(" +  left + " " + right + ")";
        }
    }

    /*
        getBinary
        Outputs the binary path to a leaf
        @param refNode The target node
        @param prev The path to the current node
     */
    private void getBinary(BinaryTreeNode refNode, String prev){
        if(refNode.isLeaf()){
            binaryValue[refNode.getCharacter()] = prev;
        }
        if(refNode.getLeftNode() != null){
            getBinary(refNode.getLeftNode(), prev + "0");
        }
        if(refNode.getRightNode() != null){
            getBinary(refNode.getRightNode(), prev + "1");
        }
    }

    /*
        getLined
        Outputs the tree as a string
        @return A string containing leaves grouped in brackets
     */
    public String getLined(){
        return this.treeLined;
    }

    /*
        compress
        Outputs the binary path of a character
        @param data The integer value of a character
        @return A String containing the binary path
     */
    public String compress(int data){
        return binaryValue[data];
    }
}