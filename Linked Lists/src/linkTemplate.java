//**********A template  for a simple linked list ********

class linkTemplate {
  public static void main(String[] args) {     //the main method

 
    SimpleLinkedList<String> myList = new SimpleLinkedList<String>();   //you can use your list similar to an ArrayList
    
    myList.add("Bob");
    
  }
}

// ********************** Simple Linked List class in the linked list *********
class SimpleLinkedList<E> { 
    private Node<E> head;
    
    
    public void add(E item) { 
      Node<E> tempNode = head;
      
      if (head==null) {
        head=new Node<E>(item,null);
        return;
      }
    
      while(tempNode.getNext()!=null) { 
        tempNode = tempNode.getNext();
      }
      
      tempNode.setNext(new Node<E>(item,null));
      return;
      
    }
    
    public E get(int index) {
      if(head == null){
        return null;
      }
      Node<E> tempNode = head;

      for(int i = 0; i < index; i++){
        tempNode = tempNode.getNext();
      }

      return tempNode.getItem();
    }

    public int indexOf(E item){
      Node<E> tempNode = head;
      int i = 0;

      while(tempNode != null){
        if(tempNode.getItem().equals(item)){
          return i;
        }
        tempNode = tempNode.getNext();
        i++;
      }
      return -1;
    }

    public boolean remove(int index) {
      if(head == null){
        return false;
      }
      if(index == 0){
        head = head.getNext();
        return true;
      }

      Node<E> tempNode = head;

      for(int i = 0; i < index-1; i++){
        tempNode = tempNode.getNext();
      }

      if(tempNode.getNext() != null){
        Node<E> afterNode = tempNode.getNext().getNext();

        tempNode.setNext(afterNode);
        return true;
      } else {
        return false;
      }
    }

    public boolean remove(E item) {
      if(head == null){
        return false;
      }
      if(head.getItem().equals(item)){
        head = head.getNext();
        return true;
      }

      Node<E> tempNode = head;
      boolean removed = false;

      while(!removed && tempNode.getNext() != null){
        if(tempNode.getNext().getItem().equals(item)){
          Node<E> afterNode = tempNode.getNext().getNext();
          tempNode.setNext(afterNode);
          removed = true;
        }
        tempNode = tempNode.getNext();
      }
      return removed;
    }


    public void clear() {
      head = null;
    }
    
    public int size() {
      Node<E> tempNode = head;
      int size = 0;

      while(tempNode != null){
        size ++;
        tempNode = tempNode.getNext();
      }
      return size;
    }

}



// ********************** A Node in the linked list *********
class Node<T> { 
  private T item;
  private Node<T> next;

public Node(T item) {
  this.item=item;
  this.next=null;
}

public Node(T item, Node<T> next) {
  this.item=item;
  this.next=next;
}

public Node<T> getNext(){
  return this.next;
}

public void setNext(Node<T> next){
  this.next = next;
}

public T getItem(){
  return this.item;
}

}