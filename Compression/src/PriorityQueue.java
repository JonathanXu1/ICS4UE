/*
Priority Queue
A basic queue that sorts items based on priority
 */

public class PriorityQueue {
  private QueueNode head = new QueueNode();
  PriorityQueue(){}

  public void enqueue(BinaryTreeNode value){
    QueueNode item = new QueueNode(value);
    if(head.getNext() == null){
      head.setNext(item);
      return;
    }
    QueueNode tempNode = head;
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
    QueueNode nextNode = head.getNext().getNext();
    head.setNext(nextNode);
    return output;
  }

  public boolean isEmpty(){
    return head.getNext() == null;
  }
}
