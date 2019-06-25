/*
    BinaryTreeNode
    A node used in the binary tree
    @author Jonathan Xu
    March 24, 2019
 */

public class BinaryTreeNode implements Comparable<BinaryTreeNode> {
    private Integer character, weight;
    private BinaryTreeNode leftNode = null;
    private BinaryTreeNode rightNode = null;

    /*
        BinaryTreeNode
        Constructor for a node with character value
        @param weight The frequency/weight of the node
     */
    BinaryTreeNode(int weight){
        this.character = null;
        this. weight = weight;
    }

    /*
      BinaryTreeNode
      Constructor for a node with a character value
      @param character The character within the node
      @param weight The frequency/weight of the node
    */
    BinaryTreeNode(int character, int weight){
        this.character = character;
        this.weight = weight;
    }

    /*
      getWeight
      Outputs the weight of the node
      @return weight The weight of the node
    */
    public int getWeight(){
        return this.weight;
    }

    /*
      getCharacter
      Outputs the character stored in the node
      @return character The character stored in the node
    */
    public int getCharacter(){
        return this.character;
    }

    /*
      setLeftNode
      Sets the left child of the node
      @param left The left child
    */
    public void setLeftNode(BinaryTreeNode left){
        this.leftNode = left;
    }

    /*
      getLeftNode
      Returns the left child of the node
      @return The left node
    */
    public BinaryTreeNode getLeftNode(){
        return this.leftNode;
    }

    /*
        setRightNode
        Sets the right child of the node
        @param right The right child
    */
    public void setRightNode(BinaryTreeNode right){
        this.rightNode = right;
    }

    /*
      getRightNode
      Returns the right child of the node
      @return The right node
    */
    public BinaryTreeNode getRightNode(){
        return this.rightNode;
    }

    /*
     compareTo
     Compares the weight of the node with another node
     @param other The other node
     @return An integer. -1 if less than, 0 if equals, 1 if greater than.
    */
    public int compareTo(BinaryTreeNode other){
        return Integer.compare(this.weight, other.getWeight());
    }

    /*
      isLeaf
      Outputs if the node is a leaf
      @return A boolean representing if the node has no children
    */
    public boolean isLeaf(){
        return leftNode == null && rightNode == null;
    }
}
