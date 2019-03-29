/*
Priority Queue
A basic queue that sorts items based on priority
 */

public class PriorityQueue {
  private Node<BinaryTreeNode> head = new Node<BinaryTreeNode>();
  PriorityQueue(){}

  public void enqueue(BinaryTreeNode value){
    Node<BinaryTreeNode> item = new Node<BinaryTreeNode>(value);
    if(head.getNext() == null){
      head.setNext(item);
      return;
    }
    Node<BinaryTreeNode> tempNode = head;
    while(tempNode.getNext() != null && value.compareTo(tempNode.getNext().getValue()) > 0){
      tempNode = tempNode.getNext();
    }
    item.setNext(tempNode.getNext());
    tempNode.setNext(item);
  }

  public BinaryTreeNode dequeue(){
    if(isEmpty()){
      return null;
    }

    BinaryTreeNode output = head.getNext().getValue();
    Node nextNode = head.getNext().getNext();
    head.setNext(nextNode);
    return output;
  }

  public boolean isEmpty(){
    return head.getNext() == null;
  }
}
