import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree {
    private BinaryTreeNode root = new BinaryTreeNode(0);
    private List<BinaryTreeNode> nodeList = new ArrayList<BinaryTreeNode>();
    private String[] binaryValue = new String[256];

    BinaryTree(int[] charList) {
        for(int i = 0; i < 256; i++){
            if(charList[i] != 0){
                BinaryTreeNode newNode = new BinaryTreeNode(i, charList[i]);
                nodeList.add(newNode);
            }
        }
        /*
        for(int i = 0; i < nodeList.size(); i++){
            System.out.println((char)nodeList.get(i).getCharacter() + " " + nodeList.get(i).getWeight());
        }*/

        Collections.sort(nodeList);

        while(nodeList.size() > 1){
            /*
            for(int i = 0; i < nodeList.size(); i++){
                System.out.println((char)nodeList.get(i).getCharacter() + " " + nodeList.get(i).getWeight());
            } */
            BinaryTreeNode parentNode = new BinaryTreeNode(nodeList.get(0).getWeight() + nodeList.get(1).getWeight());
            parentNode.setLeftNode(nodeList.get(0));
            parentNode.setRightNode(nodeList.get(1));
            nodeList.remove(0);
            nodeList.remove(0);

            nodeList.add(parentNode);
            Collections.sort(nodeList);
        }

        root.setRightNode(nodeList.get(0));
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