/*
  Priority Queue
  A basic queue that sorts items based on priority
  @author Jonathan Xu
  March 24, 2019
 */

public class PriorityQueue {
  private Node head = new Node();
  //Constructor
  PriorityQueue(){}

  /*
    enqueue
    Adds a new node to the queue based on its priority
    @param value The value to enqueue
   */
  public void enqueue(BinaryTreeNode value){
    // If queue is empty
    Node item = new Node(value);
    if(head.getNext() == null){
      head.setNext(item);
      return;
    }
    // If queue isn't empty, add the node by increasing size
    Node tempNode = head;
    while(tempNode.getNext() != null && value.compareTo(tempNode.getNext().getValue()) > 0){
      tempNode = tempNode.getNext();
    }
    item.setNext(tempNode.getNext());
    tempNode.setNext(item);
  }

  /*
    dequeue
    Outputs the first item in the queue
    @return The node at the top of the queue
   */
  public BinaryTreeNode dequeue(){
    if(isEmpty()){
      return null;
    }

    BinaryTreeNode output = head.getNext().getValue();
    Node nextNode = head.getNext().getNext();
    head.setNext(nextNode);
    return output;
  }

  /*
    isEmpty
    Outputs if the queue is empty
    @return A boolean representing whether the queue is empty
   */
  public boolean isEmpty(){
    return head.getNext() == null;
  }
}
