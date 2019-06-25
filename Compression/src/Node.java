/*
  Node
  A node used for the priority queue
  @author Jonathan Xu
  March 23, 2019
 */

public class Node {
  private BinaryTreeNode value = null;
  private Node next = null;

  /*
    Node
    Constructor with no arguments creates a node of value null
  */
  Node(){}

  /*
    Node
    Constructor that initializes value of node
    @param value The initial value of the node
  */
  Node(BinaryTreeNode value){
    this.value = value;
  }

  /*
    getNext
    Returns the next node
    @return The next node
   */
  public Node getNext(){
    return this.next;
  }

  /*
    setNext
    Sets the next node
    @param next The next node
   */
  public void setNext(Node next){
    this.next = next;
  }

  /*
    getValue
    Returns the BinaryTreeNode saved in the node
    @return The node's value
   */
  public BinaryTreeNode getValue(){
    return this.value;
  }
}
