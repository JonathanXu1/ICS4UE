public class Stack {
  private Node<Integer> head = new Node<Integer>();
  Stack(){}

  public void push(int value){
    Node<Integer> newNode = new Node<Integer>(value);
    newNode.setNext(head);
    head = newNode;
  }

  public int pop(){
    if(isEmpty()){
      return -1;
    }

    int value = head.getValue();
    head = head.getNext();
    return value;
  }

  public boolean isEmpty(){
    return head.getNext() == null;
  }
}
