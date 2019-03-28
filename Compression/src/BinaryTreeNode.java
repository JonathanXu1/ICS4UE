public class BinaryTreeNode implements Comparable<BinaryTreeNode> {
    private Integer character, weight;
    private BinaryTreeNode leftNode = null;
    private BinaryTreeNode rightNode = null;

    BinaryTreeNode(int weight){
        this.character = null;
        this. weight = weight;
    }
    BinaryTreeNode(int character, int weight){
        this.character = character;
        this.weight = weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }
    public int getWeight(){
        return this.weight;
    }
    public int getCharacter(){
        return this.character;
    }

    public void setLeftNode(BinaryTreeNode left){
        this.leftNode = left;
    }
    public BinaryTreeNode getLeftNode(){
        return this.leftNode;
    }
    public void setRightNode(BinaryTreeNode right){
        this.rightNode = right;
    }
    public BinaryTreeNode getRightNode(){
        return this.rightNode;
    }

    public int compareTo(BinaryTreeNode other){
        return Integer.compare(this.weight, other.getWeight());
    }

    public boolean isLeaf(){
        return leftNode == null && rightNode == null;
    }
}
