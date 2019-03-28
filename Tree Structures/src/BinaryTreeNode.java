public class BinaryTreeNode<E extends Comparable> {
    private E item;
    BinaryTreeNode<E> leftNode = null;
    BinaryTreeNode<E> rightNode = null;

    public BinaryTreeNode(){
        item = null;
    }

    public BinaryTreeNode(E value){
        item = value;
    }

    BinaryTreeNode getLeft(){
        return leftNode;
    }

    BinaryTreeNode getRight(){
        return rightNode;
    }

    void setLeft(BinaryTreeNode node){
        leftNode = node;
    }

    void setRight(BinaryTreeNode node){
        rightNode = node;
    }

    E getItem() {
        return item;
    }

    void setItem(E value){
        item = value;
    }

    boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }

}
