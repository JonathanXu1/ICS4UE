import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {
    private BinaryTreeNode root = new BinaryTreeNode(0);
    private PriorityQueue nodeQueue = new PriorityQueue();
    private String[] binaryValue = new String[256];

    BinaryTree(int[] charList) {
        for(int i = 0; i < 256; i++){
            if(charList[i] != 0){
                BinaryTreeNode newNode = new BinaryTreeNode(i, charList[i]);
                //nodeList.add(newNode);
                nodeQueue.enqueue(newNode);
            }
        }

        boolean complete = false;
        do{
            if(nodeQueue.isEmpty()){
                complete = true;
            }
            BinaryTreeNode left = nodeQueue.dequeue();
            if(nodeQueue.isEmpty()){
                nodeQueue.enqueue(left);
                complete = true;
            }
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
        getBinary(root.getRightNode(), "");
    }

    public String lineify(){
        return lineify(root.getRightNode());
    }
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

    public String encode(char data){
        return binaryValue[data];
    }
}