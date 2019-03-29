public class BinaryTree {
    private BinaryTreeNode root = new BinaryTreeNode(0);
    private PriorityQueue nodeQueue = new PriorityQueue();
    private String[] binaryValue = new String[256];
    private String treeLined = "";

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
        treeLined = getBinary(root.getRightNode(), "");

    }

    private String getBinary(BinaryTreeNode refNode, String prev){
        if(refNode.getLeftNode() != null && refNode.getRightNode() != null){
            String left = getBinary(refNode.getLeftNode(), "0");
            String right = getBinary(refNode.getRightNode(), "1");
            return "(" +  left + " " + right + ")";
        } else if(refNode.getLeftNode() != null){
            return getBinary(refNode.getLeftNode(), prev + "0");
        } else if(refNode.getRightNode() != null){
            return getBinary(refNode.getRightNode(), prev + "1");
        } else {
            binaryValue[refNode.getCharacter()] = prev;
            return Integer.toString((char)refNode.getCharacter());
        }
    }

    public String getLined(){
        return this.treeLined;
    }

    public String compress(int data){
        return binaryValue[data];
    }
}