public class Node<T> {
  private T value = null;
  private Node<T> next = null;

  Node(){}
  Node(T value){
    this.value = value;
  }

  public Node<T> getNext(){
    return this.next;
  }

  public void setNext(Node<T> next){
    this.next = next;
  }

  public T getValue(){
    return this.value;
  }

  public void setValue(T value){
    this.value = value;
  }
}
